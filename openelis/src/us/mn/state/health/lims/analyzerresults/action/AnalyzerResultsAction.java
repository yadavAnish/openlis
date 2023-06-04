/*
 * The contents of this file are subject to the Mozilla Public License
 * Version 1.1 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations under
 * the License.
 *
 * The Original Code is OpenELIS code.
 *
 * Copyright (C) The Minnesota Department of Health.  All Rights Reserved.
 *
 * Contributor(s): CIRG, University of Washington, Seattle WA.
 */
package us.mn.state.health.lims.analyzerresults.action;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.validator.GenericValidator;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import us.mn.state.health.lims.analysis.dao.AnalysisDAO;
import us.mn.state.health.lims.analysis.daoimpl.AnalysisDAOImpl;
import us.mn.state.health.lims.analysis.valueholder.Analysis;
import us.mn.state.health.lims.analyzerimport.util.AnalyzerTestNameCache;
import us.mn.state.health.lims.analyzerimport.util.AnalyzerTestNameCache.AnalyzerType;
import us.mn.state.health.lims.analyzerimport.util.MappedTestName;
import us.mn.state.health.lims.analyzerresults.action.beanitems.AnalyzerResultItem;
import us.mn.state.health.lims.analyzerresults.dao.AnalyzerResultsDAO;
import us.mn.state.health.lims.analyzerresults.daoimpl.AnalyzerResultsDAOImpl;
import us.mn.state.health.lims.analyzerresults.valueholder.AnalyzerResults;
import us.mn.state.health.lims.common.action.BaseAction;
import us.mn.state.health.lims.common.action.IActionConstants;
import us.mn.state.health.lims.common.exception.LIMSRuntimeException;
import us.mn.state.health.lims.common.services.QAService;
import us.mn.state.health.lims.common.util.StringUtil;
import us.mn.state.health.lims.dictionary.dao.DictionaryDAO;
import us.mn.state.health.lims.dictionary.daoimpl.DictionaryDAOImpl;
import us.mn.state.health.lims.dictionary.valueholder.Dictionary;
import us.mn.state.health.lims.result.dao.ResultDAO;
import us.mn.state.health.lims.result.daoimpl.ResultDAOImpl;
import us.mn.state.health.lims.result.valueholder.Result;
import us.mn.state.health.lims.sample.dao.SampleDAO;
import us.mn.state.health.lims.sample.daoimpl.SampleDAOImpl;
import us.mn.state.health.lims.sample.valueholder.Sample;
import us.mn.state.health.lims.sampleitem.valueholder.SampleItem;
import us.mn.state.health.lims.test.valueholder.Test;
import us.mn.state.health.lims.testreflex.action.util.TestReflexUtil;
import us.mn.state.health.lims.testreflex.dao.TestReflexDAO;
import us.mn.state.health.lims.testreflex.daoimpl.TestReflexDAOImpl;
import us.mn.state.health.lims.testreflex.valueholder.TestReflex;
import us.mn.state.health.lims.testresult.dao.TestResultDAO;
import us.mn.state.health.lims.testresult.daoimpl.TestResultDAOImpl;
import us.mn.state.health.lims.testresult.valueholder.TestResult;
import us.mn.state.health.lims.typeofsample.dao.TypeOfSampleTestDAO;
import us.mn.state.health.lims.typeofsample.daoimpl.TypeOfSampleTestDAOImpl;
import us.mn.state.health.lims.typeofsample.valueholder.TypeOfSampleTest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

public class AnalyzerResultsAction extends BaseAction {

	protected AnalyzerType analyzerType;
	private AnalyzerResultsDAO analyzerResultsDAO = new AnalyzerResultsDAOImpl();
	private DictionaryDAO dictionaryDAO = new DictionaryDAOImpl();
	private TestResultDAO testResultDAO = new TestResultDAOImpl();
	private SampleDAO sampleDAO = new SampleDAOImpl();
	private TypeOfSampleTestDAO sampleTypeTestDAO = new TypeOfSampleTestDAOImpl();
	private AnalysisDAO analysisDAO = new AnalysisDAOImpl();
	private TestReflexUtil reflexUtil = new TestReflexUtil();
	private TestReflexDAO testReflexDAO = new TestReflexDAOImpl();
	private ResultDAO resultDAO = new ResultDAOImpl();

	protected ActionForward performAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String forward = FWD_SUCCESS;

		request.getSession().setAttribute(SAVE_DISABLED, TRUE);

		String analyzer = request.getParameter("type");
		String page = request.getParameter("page");
		setAnalyzerRequest(analyzer);

		DynaActionForm dynaForm = (DynaActionForm) form;
		PropertyUtils.setProperty(dynaForm, "analyzerType", analyzer);

		AnalyzerResultsPaging paging = new AnalyzerResultsPaging();
		if (GenericValidator.isBlankOrNull(page)) {
			// get list of AnalyzerData from table based on analyzer type
			List<AnalyzerResults> analyzerResultsList = getAnalyzerResults();

			if (analyzerResultsList.isEmpty()) {
				PropertyUtils.setProperty(dynaForm, "resultList", new ArrayList<AnalyzerResultItem>());
				String msg = StringUtil.getMessageForKey("result.noResultsFound");
				PropertyUtils.setProperty(dynaForm, "notFoundMsg", msg);
				paging.setEmptyPageBean(request,dynaForm);

			} else {

				/*
				 * The problem we are solving is that the accession numbers may
				 * not be consecutive but we still want to maintain the order So
				 * we will form the groups (by analyzer runs) by going in order
				 * but if the accession number is in another group it will be
				 * boosted to the first group
				 */
				boolean missingTest = false;

				resolveMissingTests(analyzerResultsList, request);

				List<List<AnalyzerResultItem>> accessionGroupedResultsList = groupAnalyzerResults(analyzerResultsList);

				List<AnalyzerResultItem> analyzerResultItemList = new ArrayList<AnalyzerResultItem>();

				int sampleGroupingNumber = 0;
				for (List<AnalyzerResultItem> group : accessionGroupedResultsList) {
					sampleGroupingNumber++;
					AnalyzerResultItem groupHeader = null;
					for (AnalyzerResultItem resultItem : group) {
						if (groupHeader == null) {
							groupHeader = resultItem;
							setNonConformityStateForResultItem(resultItem);
						}
						resultItem.setSampleGroupingNumber(sampleGroupingNumber);

						// There are two reasons there may not be a test id,
						// 1. it could not be found due to missing mapping
						// 2. it may not be looked for if the results are read
						// only
						// we only want to capture 1.
						if (GenericValidator.isBlankOrNull(resultItem.getTestId()) && !resultItem.isReadOnly()) {
							groupHeader.setGroupIsReadOnly(true);
							missingTest = true;
						} else if (resultItem.getIsControl()) {
							groupHeader.setGroupIsReadOnly(true);
						}

						analyzerResultItemList.add(resultItem);
					}
				}

				PropertyUtils.setProperty(dynaForm, "missingTestMsg", new Boolean(missingTest));

				paging.setDatabaseResults(request, dynaForm, analyzerResultItemList);
			}
		} else {
			paging.page(request, dynaForm, page);
		}

		return mapping.findForward(forward);
	}

	private void setNonConformityStateForResultItem(AnalyzerResultItem resultItem) {
		boolean nonconforming = false;
		
		Sample sample = sampleDAO.getSampleByAccessionNumber(resultItem.getAccessionNumber());
		if( sample!= null){
			nonconforming = QAService.isOrderNonConforming(sample);
			//The sample is nonconforming, now we have to check if any sample items are non_conforming and 
			// if they are are they for this test
			//Note we only have to check one test since the sample item is the same for all the tests

			if( nonconforming ){
				List<SampleItem> nonConformingSampleItems = QAService.getNonConformingSampleItems(sample);
				//If there is a nonconforming sample item then we need to check if it is the one for this
				//test if it is then it is nonconforming if not then it is not nonconforming
				if( !nonConformingSampleItems.isEmpty()){					
					TypeOfSampleTest typeOfSample = sampleTypeTestDAO.getTypeOfSampleTestForTest(resultItem.getTestId());
					if( typeOfSample != null){
						String sampleTypeId = typeOfSample.getTypeOfSampleId();
						nonconforming = false;	
						for( SampleItem sampleItem : nonConformingSampleItems ){
							if( sampleTypeId.equals(sampleItem.getTypeOfSample().getId() )){
								nonconforming = true;
								break;
							}
						}
					
					}
				}
				
			}
			
		}
		
		resultItem.setNonconforming(nonconforming);
		
	}

	private List<List<AnalyzerResultItem>> groupAnalyzerResults(List<AnalyzerResults> analyzerResultsList) {
		Map<String, Integer> accessionToAccessionGroupMap = new HashMap<String, Integer>();
		List<List<AnalyzerResultItem>> accessionGroupedResultsList = new ArrayList<List<AnalyzerResultItem>>();

		for (AnalyzerResults analyzerResult : analyzerResultsList) {
			AnalyzerResultItem resultItem = analyzerResultsToAnalyzerResultItem(analyzerResult);
			Integer groupIndex = accessionToAccessionGroupMap.get(resultItem.getAccessionNumber());
			List<AnalyzerResultItem> group;
			if (groupIndex == null) {
				group = new ArrayList<AnalyzerResultItem>();
				accessionGroupedResultsList.add(group);
				accessionToAccessionGroupMap.put(resultItem.getAccessionNumber(), accessionGroupedResultsList.size() - 1);
			} else {
				group = accessionGroupedResultsList.get(groupIndex.intValue());
			}

			group.add(resultItem);
		}
		return accessionGroupedResultsList;
	}

	private void resolveMissingTests(List<AnalyzerResults> analyzerResultsList, HttpServletRequest request) {
		boolean reloadCache = true;
		List<AnalyzerResults> resolvedResults = new ArrayList<AnalyzerResults>();

		for (AnalyzerResults analyzerResult : analyzerResultsList) {
			if (GenericValidator.isBlankOrNull(analyzerResult.getTestId())) {
				if (reloadCache) {
					AnalyzerTestNameCache.instance().reloadCache();
					reloadCache = false;
				}
			}

			String analyzerTestName = analyzerResult.getTestName();
			MappedTestName mappedTestName = AnalyzerTestNameCache.instance().getMappedTest(analyzerType, analyzerTestName);
			if (mappedTestName != null) {
				analyzerResult.setTestName(mappedTestName.getOpenElisTestName());
				analyzerResult.setTestId(mappedTestName.getTestId());
				resolvedResults.add(analyzerResult);
			}
		}

		if (resolvedResults.size() > 0) {

			try {
				for (AnalyzerResults analyzerResult : resolvedResults) {
					analyzerResult.setSysUserId(currentUserId);
					analyzerResultsDAO.updateData(analyzerResult);
				}
			} catch (LIMSRuntimeException lre) {
                request.setAttribute(IActionConstants.REQUEST_FAILED, true);
			}

		}

	}

	private List<AnalyzerResults> getAnalyzerResults() {
		return analyzerResultsDAO.getResultsbyAnalyzer(AnalyzerTestNameCache.instance().getAnalyzerId(analyzerType));
	}

	protected AnalyzerResultItem analyzerResultsToAnalyzerResultItem(AnalyzerResults result) {

		AnalyzerResultItem resultItem = new AnalyzerResultItem();
		resultItem.setAccessionNumber(result.getAccessionNumber());
		resultItem.setAnalyzerId(result.getAnalyzerId());
		resultItem.setIsControl(result.getIsControl());
		resultItem.setTestName(result.getTestName());
		resultItem.setUnits(getUnits(result.getUnits()));
		resultItem.setId(result.getId());
		resultItem.setTestId(result.getTestId());
		resultItem.setCompleteDate(result.getCompleteDateForDisplay());
		resultItem.setLastUpdated(result.getLastupdated());
		resultItem.setReadOnly((result.isReadOnly() || result.getTestId() == null));
		resultItem.setResult(getResultForItem(result));
		resultItem.setTestResultType(result.getResultType());
		resultItem.setDictionaryResultList(getDictionaryResultList(result));
		resultItem.setIsHighlighted(!GenericValidator.isBlankOrNull(result.getDuplicateAnalyzerResultId())
				|| GenericValidator.isBlankOrNull(result.getTestId()));
		resultItem.setUserChoiceReflex(giveUserChoice(result));
		resultItem.setUserChoicePending(false);

		if (resultItem.isUserChoiceReflex()) {
			setChoiceForCurrentValue(resultItem, result);
			resultItem.setUserChoicePending(!GenericValidator.isBlankOrNull(resultItem.getSelectionOneText()) );
		}
		return resultItem;
	}

	private boolean giveUserChoice(AnalyzerResults result) {
		/*
		 * This is how we figure out if the user will be able to select 
		 * 1. Is the test involved with triggering a user selection 
		 *    reflex 
		 * 2. If the reflex has sibs has the sample been entered yet 
		 * 3. If the sample has been entered have all of the sibling 
		 *    tests been ordered
		 */
		if (!TestReflexUtil.isTriggeringUserChoiceReflexTestId(result.getTestId())) {
			return false;
		}

		if (!TestReflexUtil.testIsTriggeringReflexWithSibs(result.getTestId())) {
			return false;
		}

		Sample sample = getSampleForAnalyzerResult(result);
		if (sample == null) {
			return false;
		}

		List<TestReflex> reflexes = reflexUtil.getPossibleUserChoiceTestReflexsForTest(result.getTestId());

		List<Analysis> analysisList = analysisDAO.getAnalysesBySampleId(sample.getId());
		Set<String> analysisTestIds = new HashSet<String>();

		for (Analysis analysis : analysisList) {
			analysisTestIds.add(analysis.getTest().getId());
		}

		for (TestReflex reflex : reflexes) {
			if (!analysisTestIds.contains(reflex.getTest().getId())) {
				return false;
			}
		}
		return true;
	}

	private Sample getSampleForAnalyzerResult(AnalyzerResults result) {
		Sample sample = sampleDAO.getSampleByAccessionNumber(result.getAccessionNumber());
		return sample;
	}

	private void setChoiceForCurrentValue(AnalyzerResultItem resultItem, AnalyzerResults analyzerResult) {
		/*
		 * If there are no siblings for the reflex then we just need to find if
		 * there are choices for the current value
		 * 
		 * If there are siblings then we need to find if they are currently
		 * satisfied
		 */
		TestReflex selectionOne = null;
		TestReflex selectionTwo = null;
		
		if (!TestReflexUtil.testIsTriggeringReflexWithSibs(analyzerResult.getTestId())) {
			List<TestReflex> reflexes = reflexUtil.getTestReflexsForDictioanryResultTestId(analyzerResult.getResult(), analyzerResult.getTestId(), true);
			resultItem.setReflexSelectionId(null);
			for (TestReflex reflex : reflexes) {
					if (selectionOne == null) {
						selectionOne = reflex;
					} else {
						selectionTwo = reflex;
					}
			}

		} else {
			
			Sample sample = getSampleForAnalyzerResult(analyzerResult);

			List<Analysis> analysisList = analysisDAO.getAnalysesBySampleId(sample.getId());
			
			List<TestReflex> reflexesForDisplayedTest = reflexUtil.getTestReflexsForDictioanryResultTestId(analyzerResult.getResult(), analyzerResult.getTestId(), true);
			
			for (TestReflex possibleTestReflex : reflexesForDisplayedTest) {
				if (TestReflexUtil.USER_CHOOSE_FLAG.equals(possibleTestReflex.getFlags())) {
					if (GenericValidator.isBlankOrNull(possibleTestReflex.getSiblingReflexId())) {
						if (possibleTestReflex.getActionScriptlet() != null) {
							selectionOne = possibleTestReflex;
							break;
						} else if (selectionOne == null) {
							selectionOne = possibleTestReflex;
						} else {
							selectionTwo = possibleTestReflex;
							break;
						}
					} else {
						// find if the sibling reflex is satisfied
						TestReflex sibTestReflex = new TestReflex();
						sibTestReflex.setId(possibleTestReflex.getSiblingReflexId());

						testReflexDAO.getData(sibTestReflex);

						TestResult sibTestResult = new TestResult();
						sibTestResult.setId(sibTestReflex.getTestResultId());
						testResultDAO.getData(sibTestResult);

						for (Analysis analysis : analysisList) {
							@SuppressWarnings("unchecked")
							List<Result> resultList = resultDAO.getResultsByAnalysis(analysis);
							Test test = analysis.getTest();

							for (Result result : resultList) {
								TestResult testResult = testResultDAO.getTestResultsByTestAndDictonaryResult(test.getId(),
										result.getValue());
								if (testResult != null && testResult.getId().equals(sibTestReflex.getTestResultId())) {	
									if (possibleTestReflex.getActionScriptlet() != null) {
										selectionOne = possibleTestReflex;
										break;
									} else if (selectionOne == null) {
										selectionOne = possibleTestReflex;
									} else {
										selectionTwo = possibleTestReflex;
										break;
									}
								}
							}
						}
					}
				}
			}
		}
		populateAnalyzerResultItemWithReflexes(resultItem, selectionOne, selectionTwo);
	}

	private void populateAnalyzerResultItemWithReflexes(AnalyzerResultItem resultItem, TestReflex selectionOne, TestReflex selectionTwo) {
		if (selectionOne != null) {
			if (selectionTwo == null && !GenericValidator.isBlankOrNull(selectionOne.getActionScriptletId())
					&& !GenericValidator.isBlankOrNull(selectionOne.getTestId())) {

				resultItem.setSelectionOneText(TestReflexUtil.makeReflexTestName(selectionOne));
				resultItem.setSelectionOneValue(TestReflexUtil.makeReflexTestValue(selectionOne));
				resultItem.setSelectionTwoText(TestReflexUtil.makeReflexScriptName(selectionTwo));
				resultItem.setSelectionTwoValue(TestReflexUtil.makeReflexScriptValue(selectionOne));
			} else if (selectionTwo != null) {
				if (selectionOne.getTest() != null) {
					resultItem.setSelectionOneText(TestReflexUtil.makeReflexTestName(selectionOne));
					resultItem.setSelectionOneValue(TestReflexUtil.makeReflexTestValue(selectionOne));
				} else {
					resultItem.setSelectionOneText(TestReflexUtil.makeReflexScriptName(selectionOne));
					resultItem.setSelectionOneValue(TestReflexUtil.makeReflexScriptValue(selectionOne));
				}

				if (selectionTwo.getTest() != null) {
					resultItem.setSelectionTwoText(TestReflexUtil.makeReflexTestName(selectionTwo));
					resultItem.setSelectionTwoValue(TestReflexUtil.makeReflexTestValue(selectionOne));
				} else {
					resultItem.setSelectionTwoText(TestReflexUtil.makeReflexScriptName(selectionTwo));
					resultItem.setSelectionTwoValue(TestReflexUtil.makeReflexScriptValue(selectionOne));
				}					
			}
		}
	}

	private String getResultForItem(AnalyzerResults result) {

		if ("N".equals(result.getResultType()) || "A".equals(result.getResultType()) || "R".equals(result.getResultType())
				|| GenericValidator.isBlankOrNull(result.getResultType()) || GenericValidator.isBlankOrNull(result.getResult())) {

			return result.getResult();
		}

		//If it's readonly or the selectlist can not be gotten then we want the result
		//otherwise we want the id so the correct selection will be choosen
		if( result.isReadOnly() || result.getTestId() == null || result.getIsControl()){
			return dictionaryDAO.getDictionaryById(result.getResult()).getDictEntry() ;
		}else{
			return result.getResult();
		}
	}

	private String getUnits(String units) {
		if (GenericValidator.isBlankOrNull(units) || "null".equals(units)) {
			return "";
		}
		return units;
	}

	private List<Dictionary> getDictionaryResultList(AnalyzerResults result) {
		if ("N".equals(result.getResultType()) || "A".equals(result.getResultType()) || "R".equals(result.getResultType())
				|| GenericValidator.isBlankOrNull(result.getResultType()) || result.getTestId() == null) {
			return null;
		}

		List<Dictionary> dictionaryList = new ArrayList<Dictionary>();

		List<TestResult> testResults = testResultDAO.getTestResultsByTest(result.getTestId());

		for (TestResult testResult : testResults) {
			dictionaryList.add(dictionaryDAO.getDictionaryById(testResult.getValue()));
		}

		return dictionaryList;
	}

	protected String getPageTitleKey() {
		return "banner.menu.results.analyzer";
	}

	protected String getPageSubtitleKey() {
		String key = null;

		switch (analyzerType) {
		case COBAS_INTEGRA400: {
			key = "banner.menu.results.cobas.integra";
			break;
		}
		case SYSMEX_XT_2000: {
			key = "banner.menu.results.sysmex";
			break;
		}
		case FACSCALIBUR: {
			key = "banner.menu.results.facscalibur";
			break;
		}
        case FACSCANTO: {
			key = "banner.menu.results.facscanto";
			break;
		}
		case EVOLIS: {
			key = "banner.menu.results.evolis";
			break;
		}
		case COBAS_TAQMAN: {
			key = "banner.menu.results.cobas.taqman";
			break;
		}
		case COBAS_DBS: {
			key = "banner.menu.results.cobasDBS";
			break;
		}
		case COBAS_C311: {
			key = "banner.menu.results.cobasc311";
			break;
		}
		default: {
			key = "banner.menu.results.analyzer";
		}
		}

		return key;
	}

	protected void setAnalyzerRequest(String requestType) {
		if (!GenericValidator.isBlankOrNull(requestType)) {

			if (requestType.equals("sysmex")) {
				analyzerType = AnalyzerType.SYSMEX_XT_2000;
			} else if (requestType.equals("cobas_integra")) {
				analyzerType = AnalyzerType.COBAS_INTEGRA400;
			} else if (requestType.equals("facscalibur")) {
				analyzerType = AnalyzerType.FACSCALIBUR;
			} else if (requestType.equals("evolis")) {
				analyzerType = AnalyzerType.EVOLIS;
			} else if (requestType.equals("cobas_taqman")) {
				analyzerType = AnalyzerType.COBAS_TAQMAN;
			} else if (requestType.equals("facscanto")) {
				analyzerType = AnalyzerType.FACSCANTO;
			}else if (requestType.equals("cobasDBS")) {
				analyzerType = AnalyzerType.COBAS_DBS;
			}else if (requestType.equals("cobasc311")) {
				analyzerType = AnalyzerType.COBAS_C311;
			}
		}
	}
}
