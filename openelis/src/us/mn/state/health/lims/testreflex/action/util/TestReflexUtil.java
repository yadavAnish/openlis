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
 * Copyright (C) ITECH, University of Washington, Seattle WA.  All Rights Reserved.
 *
 */
package us.mn.state.health.lims.testreflex.action.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.validator.GenericValidator;

import us.mn.state.health.lims.analysis.dao.AnalysisDAO;
import us.mn.state.health.lims.analysis.daoimpl.AnalysisDAOImpl;
import us.mn.state.health.lims.analysis.valueholder.Analysis;
import us.mn.state.health.lims.analyte.dao.AnalyteDAO;
import us.mn.state.health.lims.analyte.daoimpl.AnalyteDAOImpl;
import us.mn.state.health.lims.analyte.valueholder.Analyte;
import us.mn.state.health.lims.common.util.StringUtil;
import us.mn.state.health.lims.observationhistory.dao.ObservationHistoryDAO;
import us.mn.state.health.lims.observationhistory.daoimpl.ObservationHistoryDAOImpl;
import us.mn.state.health.lims.observationhistory.valueholder.ObservationHistory;
import us.mn.state.health.lims.result.dao.ResultDAO;
import us.mn.state.health.lims.result.daoimpl.ResultDAOImpl;
import us.mn.state.health.lims.result.valueholder.Result;
import us.mn.state.health.lims.sample.valueholder.Sample;
import us.mn.state.health.lims.scriptlet.dao.ScriptletDAO;
import us.mn.state.health.lims.scriptlet.daoimpl.ScriptletDAOImpl;
import us.mn.state.health.lims.scriptlet.valueholder.Scriptlet;
import us.mn.state.health.lims.testreflex.dao.TestReflexDAO;
import us.mn.state.health.lims.testreflex.daoimpl.TestReflexDAOImpl;
import us.mn.state.health.lims.testreflex.valueholder.TestReflex;
import us.mn.state.health.lims.testresult.dao.TestResultDAO;
import us.mn.state.health.lims.testresult.daoimpl.TestResultDAOImpl;
import us.mn.state.health.lims.testresult.valueholder.TestResult;

public class TestReflexUtil {
	public static final String USER_CHOOSE_FLAG = "UC";
	
	private static String CONCLUSION_ANAYLETE_ID = null;
	private static Analyte CD4_ANAYLETE = null;
	private static String CD4_SCRIPTLET_ID = null;
	private static Set<String> 	TRIGGERING_REFLEX_TEST_IDS;
	private static Set<String> 	TRIGGERING_UC_REFLEX_TEST_IDS;
	private static Map<String, List<TestReflex>> TEST_TO_REFLEX_MAP;

	private static ObservationHistoryDAO observationDAO = new ObservationHistoryDAOImpl();
	private static ResultDAO resultDAO = new ResultDAOImpl();
	private static TestResultDAO testResultDAO = new TestResultDAOImpl();
	private static AnalysisDAO analysisDAO = new AnalysisDAOImpl();
	private TestReflexDAO testReflexDAO = new TestReflexDAOImpl();

	private TestReflexResolver reflexResolver = new TestReflexResolver();

	private String currentUserId;

	static {
		AnalyteDAO analyteDAO = new AnalyteDAOImpl();
		Analyte analyte = new Analyte();
		analyte.setAnalyteName("Conclusion");
		CONCLUSION_ANAYLETE_ID = analyteDAO.getAnalyteByName(analyte, false).getId();
		analyte.setAnalyteName("generated CD4 Count");
		CD4_ANAYLETE = analyteDAO.getAnalyteByName(analyte, false);

		ScriptletDAO scriptletDAO = new ScriptletDAOImpl();
		Scriptlet scriptlet = new Scriptlet();
		scriptlet.setScriptletName("Calculate CD4");
		scriptlet = scriptletDAO.getScriptletByName(scriptlet);
		if (!(scriptlet == null || scriptlet.getId() == null)) {
			CD4_SCRIPTLET_ID = scriptletDAO.getScriptletByName(scriptlet).getId();
		}

		TRIGGERING_REFLEX_TEST_IDS = new HashSet<String>();
		TRIGGERING_UC_REFLEX_TEST_IDS = new HashSet<String>();
		TEST_TO_REFLEX_MAP = new HashMap<String, List<TestReflex>>();
		
		@SuppressWarnings("unchecked")
		List<TestReflex> reflexes = new TestReflexDAOImpl().getAllTestReflexs();
		
		for( TestReflex reflex : reflexes){
			String testId = reflex.getTest().getId();
			List<TestReflex> reflexValues = TEST_TO_REFLEX_MAP.get(testId);
			if( reflexValues == null){
				reflexValues = new ArrayList<TestReflex>();
				TEST_TO_REFLEX_MAP.put(testId, reflexValues);
			}
			
			reflexValues.add(reflex);
			TRIGGERING_REFLEX_TEST_IDS.add(testId);
			if( USER_CHOOSE_FLAG.equals(reflex.getFlags())){
				TRIGGERING_UC_REFLEX_TEST_IDS.add(reflex.getTest().getId());
			}
		}
	}

	public static boolean isTriggeringReflexTestId(String testId){
		return TRIGGERING_REFLEX_TEST_IDS.contains(testId);
	}
	
	public static boolean isTriggeringUserChoiceReflexTestId(String testId){
		return TRIGGERING_UC_REFLEX_TEST_IDS.contains(testId);
	}
	
	public static boolean testIsTriggeringReflexWithSibs(String testId){
		if( isTriggeringReflexTestId(testId)){
			List<TestReflex> reflexes = TEST_TO_REFLEX_MAP.get(testId);
			
			for( TestReflex reflex : reflexes){
				if( !GenericValidator.isBlankOrNull(reflex.getSiblingReflexId() )){
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static String makeReflexTestName(TestReflex testReflex) {
		return StringUtil.getMessageForKey("reflexTest.test") + " -- " + testReflex.getAddedTest().getLocalizedName();
	}

	public static String makeReflexScriptName(TestReflex testReflex) {
		return StringUtil.getMessageForKey("reflexTest.conclusion") + " -- " + testReflex.getActionScriptlet().getScriptletName();
	}

	public static String makeReflexTestValue(TestReflex testReflex) {
		return "test_" + testReflex.getAddedTest().getId();
	}

	public static String makeReflexScriptValue(TestReflex testReflex) {
		return "script_" + testReflex.getActionScriptletId();
	}
	
	public List<TestReflex> getSiblings(TestReflex reflex) {
		List<TestReflex> siblingList = new ArrayList<TestReflex>();

		if (reflex.getSiblingReflexId() != null) {
			List<String> visitedReflexIdList = new ArrayList<String>();
			visitedReflexIdList.add(reflex.getId());

			TestReflex currentReflex = reflex;

			while (true) {
				String siblingId = currentReflex.getSiblingReflexId();

				if (siblingId == null || visitedReflexIdList.contains(siblingId)) {
					break;
				}

				currentReflex = new TestReflex();
				currentReflex.setId(siblingId);
				testReflexDAO.getData(currentReflex);

				if (GenericValidator.isBlankOrNull(currentReflex.getId())) {
					break;
				} else {
					siblingList.add(currentReflex);
					visitedReflexIdList.add(siblingId);
				}
			}

		}
		return siblingList;
	}

	/*
	 * This will find all the possible reflexes for a test. The intended use is
	 * to mark a results row as possibly generating a reflex for which the user
	 * will have to select the reflex action (either a conclusion or another
	 * test)
	 */
	public List<TestReflex> getPossibleUserChoiceTestReflexsForTest(String testId) {
		return testReflexDAO.getTestReflexsByTestAndFlag(testId, USER_CHOOSE_FLAG);
	}

	/*
	 * Gets the test reflex associated with this test and result.
	 */
	@SuppressWarnings("unchecked")
	public List<TestReflex> getTestReflexsForDictioanryResultTestId(String dictionaryId, String testId, boolean userChoiceOnly) {
		if (GenericValidator.isBlankOrNull(dictionaryId) || GenericValidator.isBlankOrNull(testId)) {
			return new ArrayList<TestReflex>();
		}

		TestResult testResult = testResultDAO.getTestResultsByTestAndDictonaryResult(testId, dictionaryId);

		if (testResult == null) {
			return new ArrayList<TestReflex>();
		}

		return userChoiceOnly ? testReflexDAO.getFlaggedTestReflexesByTestResult(testResult, USER_CHOOSE_FLAG) 
				               : testReflexDAO.getTestReflexesByTestResult(testResult);
	}
	
	public void setCurrentUserId(String currentUserId) {
		this.currentUserId = currentUserId;
	}

	
	/**
	 * 
	 * @param newResults
	 * @throws IllegalStateException
	 */
	public void addNewTestsToDBForReflexTests(List<TestReflexBean> newResults) throws IllegalStateException {
		if (currentUserId == null) {
			throw new IllegalStateException("currentUserId not set");
		}

		/*
		 * There are several use cases 1. A single result triggers a single
		 * reflex 2. A single result triggers more than one reflex 3. Multiple
		 * new results triggers a single reflex 4. A mixture of new result and a
		 * previous results triggers a single reflex 5. Multiple new results
		 * trigger a more than one reflex 6. A mixture of new and previous
		 * results trigger more than one reflex 7. A single result forced the
		 * user to select the reflex 8. A mixture of new and previous results
		 * forced the user to select the reflex
		 */

		/*
		 * We want to handle results with user selections first
		 */
		Collections.sort(newResults, new Comparator<TestReflexBean>(){

			public int compare(TestReflexBean o1, TestReflexBean o2) {
				if( GenericValidator.isBlankOrNull(o1.getReflexSelectionId())){
					return GenericValidator.isBlankOrNull(o2.getReflexSelectionId()) ? 0 : 1;
				}else{
					return GenericValidator.isBlankOrNull(o2.getReflexSelectionId()) ? -1 : 0;
				}
			}});
		
		/*
		 * For each sample we want to track which test reflexes have already
		 * been evaluated. If we don't track them and two parents are being
		 * updated then we would trigger the same reflex twice
		 */
		Map<String, List<String>> handledReflexsBySample = new HashMap<String, List<String>>();

		// keep track of analysis which have triggered reflexes
		List<Analysis> parentAnalysisList = new ArrayList<Analysis>();

		for (TestReflexBean reflexBean : newResults) {

			// list may be empty or have previous handled reflexes
			List<String> handledReflexIdList = getHandledReflexesForSample(handledReflexsBySample, reflexBean);

			// use cases 1-6
			if (GenericValidator.isBlankOrNull(reflexBean.getReflexSelectionId())) {
				// More than one reflex may be returned if more than one action
				// should be taken by the result
				List<TestReflex> reflexsForResult = reflexResolver.getTestReflexsForResult(reflexBean.getResult());

				for (TestReflex reflexForResult : reflexsForResult) {
					// filter out handled reflexes
					if (handledReflexIdList.contains(reflexForResult.getId())) {
						continue;
					}

					handledReflexIdList.add(reflexForResult.getId());

					List<TestReflex> siblingsOfResultReflex = getSiblings(reflexForResult);

					// no reflexes triggered so no parents
					parentAnalysisList.clear();

					boolean siblingsSatisfied = true;

					// side effect of populating parent list and
					// handledRefleIdList
					siblingsSatisfied = checkIfSiblingsSatisfiedAndPopulateParentList(parentAnalysisList, reflexBean, handledReflexIdList,
							siblingsOfResultReflex);

					// All the conditions are satisfied so we can handle the
					// reflexes
					if (siblingsSatisfied) {
						boolean allSibAnalysisCausedReflex = doAllAnalysisHaveReflex(parentAnalysisList, reflexBean);

						addReflexTest(reflexForResult, reflexBean.getResult(), reflexBean.getPatient().getId(), reflexBean.getSample(),
								true, true, null, allSibAnalysisCausedReflex);
						// there may be multiple reflexes
						for (TestReflex siblingReflex : siblingsOfResultReflex) {
							// we want to make sure we don't add the same test
							// or observation twice
							boolean addTest = siblingReflex.getAddedTestId() != null
									&& !siblingReflex.getAddedTestId().equals(reflexForResult.getAddedTestId());
							boolean handleAction = siblingReflex.getActionScriptletId() != null
									&& !siblingReflex.getActionScriptletId().equals(reflexForResult.getActionScriptletId());

							addReflexTest(siblingReflex, reflexBean.getResult(), reflexBean.getPatient().getId(), reflexBean.getSample(),
									addTest, handleAction, null, allSibAnalysisCausedReflex);

						}

						if (reflexBean.getResult().getAnalysis() != null) {
							parentAnalysisList.add(reflexBean.getResult().getAnalysis());
						}

						markSibAnalysisAsParent(parentAnalysisList);
					}
				}

			} else { // use cases 7,8
				// There will be several reflexes which satisfied the result,
				// they should all be marked as handled
				List<TestReflex> reflexsForResult = reflexResolver.getTestReflexsForResult(reflexBean.getResult());
				boolean choiceAdded = false;
				for (TestReflex reflexForResult : reflexsForResult) {
					// filter out handled reflexes
					if (handledReflexIdList.contains(reflexForResult.getId())) {
						continue;
					}

					handledReflexIdList.add(reflexForResult.getId());

					List<TestReflex> siblingsOfResultReflex = getSiblings(reflexForResult);

					// no reflexes triggered so no parents
					parentAnalysisList.clear();

					// side effect of populating parent list and
					// handledRefleIdList
					checkIfSiblingsSatisfiedAndPopulateParentList(parentAnalysisList, reflexBean, handledReflexIdList,
							siblingsOfResultReflex);

					//this comes after checkIfSib..... because of the side effects of PopulatingParentList
					if( !USER_CHOOSE_FLAG.equals(reflexForResult.getFlags())){
						continue;
					}
					
					boolean allSibAnalysisCausedReflex = doAllAnalysisHaveReflex(parentAnalysisList, reflexBean);

					if (!choiceAdded) {
						addReflexTest(reflexForResult, reflexBean.getResult(), reflexBean.getPatient().getId(), reflexBean.getSample(),
								true, true, reflexBean.getReflexSelectionId(), allSibAnalysisCausedReflex);
						choiceAdded = true;
					}

					if (reflexBean.getResult().getAnalysis() != null) {
						parentAnalysisList.add(reflexBean.getResult().getAnalysis());
					}

					markSibAnalysisAsParent(parentAnalysisList);
				}
			}
		}
	}

	private boolean doAllAnalysisHaveReflex(List<Analysis> parentAnalysisList, TestReflexBean reflexBean) {
		if (reflexBean.getResult().getAnalysis() == null || !reflexBean.getResult().getAnalysis().getTriggeredReflex()) {
			return false;
		}

		for (Analysis analysis : parentAnalysisList) {
			if (!analysis.getTriggeredReflex()) {
				return false;
			}
		}
		return true;
	}

	protected boolean checkIfSiblingsSatisfiedAndPopulateParentList(List<Analysis> parentAnalysisList, TestReflexBean resultSet,
			List<String> handledReflexIdList, List<TestReflex> siblingsOfResultReflex) {
		boolean siblingsSatisfied = true;

		for (TestReflex siblingReflex : siblingsOfResultReflex) {
			// mark the sibling as being handled, it may also be on the
			// list
			handledReflexIdList.add(siblingReflex.getId());

			if (siblingsSatisfied) {
				if (!reflexResolver.isSatisfied(siblingReflex, resultSet.getSample())) {
					siblingsSatisfied = false;
					parentAnalysisList.clear();
					// we're not breaking out of the loop to let the rest of the
					// siblings be added to the handled list
				} else if (reflexResolver.getLastValidAnalysis() != null) {
					parentAnalysisList.add(reflexResolver.getLastValidAnalysis());
				}
			}
		}

		return siblingsSatisfied;
	}

	protected List<String> getHandledReflexesForSample(Map<String, List<String>> handledReflexsBySample, TestReflexBean resultSet) {
		List<String> handledReflexIdList = handledReflexsBySample.get(resultSet.getSample().getId());
		if (handledReflexIdList == null) {
			handledReflexIdList = new ArrayList<String>();
			handledReflexsBySample.put(resultSet.getSample().getId(), handledReflexIdList);
		}
		return handledReflexIdList;
	}

	private void addReflexTest(TestReflex reflex, Result result, String patientId, Sample sample, boolean addTest, boolean handleAction,
			String actionSelectionId, boolean failOnDuplicateTest) {

		if (addTest || handleAction) {

			ReflexAction reflexAction = reflexResolver.getReflexAction();
			reflexAction.handleReflex(reflex, result, actionSelectionId);

			ObservationHistory observation = reflexAction.getObservation();
			Analysis newAnalysis = reflexAction.getNewAnalysis();

			if (observation != null && handleAction) {
				observation.setPatientId(patientId);
				observation.setSampleId(sample.getId());
				observation.setSysUserId(currentUserId);
				observationDAO.insertData(observation);
			}

			Result finalResult = reflexAction.getFinalResult();

			/*******
			 * This is allowing duplicate tests to be added for CD4 absolute. If
			 * the previous CD4 absolute was attached to a different analysis
			 * from the CD4 % then this fails. This also precludes updates
			 */
			if (failOnDuplicateTest && testDoneForSample(newAnalysis)) {
				return;
			}

			if (finalResult != null) {
				finalResult.setAnalysis(result.getAnalysis());
				finalResult.setSysUserId(currentUserId);
				if (finalResult.getId() == null) {
					resultDAO.insertData(finalResult);
				} else {
					resultDAO.updateData(finalResult);
				}
			}

			if (newAnalysis != null && addTest) {
				Analysis currentAnalysis = result.getAnalysis();

				newAnalysis.setSysUserId(currentUserId);
				currentAnalysis.setSysUserId(currentUserId);
				currentAnalysis.setTriggeredReflex(Boolean.TRUE);

				analysisDAO.insertData(newAnalysis, false);
				analysisDAO.updateData(currentAnalysis);
			}
		}
	}

	private boolean testDoneForSample(Analysis newAnalysis) {
		if (newAnalysis == null) {
			return false;
		}

		String newTestId = newAnalysis.getTest().getId();

		Sample sample = newAnalysis.getSampleItem().getSample();

		List<Analysis> analysisList = analysisDAO.getAnalysesBySampleId(sample.getId());

		for (Analysis analysis : analysisList) {
			if (newTestId.equals(analysis.getTest().getId())) {
				return true;
			}
		}

		return false;
	}

	private void markSibAnalysisAsParent(List<Analysis> parentAnalysisList) {
		for (Analysis analysis : parentAnalysisList) {
			analysis.setSysUserId(currentUserId);
			analysis.setTriggeredReflex(Boolean.TRUE);
			analysisDAO.updateData(analysis);
		}

	}

	public void updateModifiedReflexes(List<TestReflexBean> reflexBeanList) throws IllegalStateException {
		if (currentUserId == null) {
			throw new IllegalStateException("currentUserId not set");
		}
		/*
		 * N.B. currently we are only updating calculated values and conclusions
		 * This means only reflexes which have scriptlets as their action.
		 */

		/*
		 * The scenarios we need to support 1. The conclusion does not yet exist
		 * 2. The conclusion does exist but one of the determining results has
		 * changed 3. The conclusion does exist and has been changed by the user
		 * 
		 * If both 2 and 3 exist then 3 wins
		 */

		/*
		 * the general processing flow will be to; 1. create groups of results
		 * by sample 2. go through each group and ignore groups in which none of
		 * the results have scriptlet reflexes 3. Ignore the group if one of the
		 * results is a conclusion 4. find if there is an existing conclusion
		 * for the reflex 5. Either update or modify the conclusion if the
		 * reflex is satisfied
		 */

		Map<Sample, List<TestReflexBean>> groupedResults = groupBySample(reflexBeanList);

		for (List<TestReflexBean> reflexList : groupedResults.values()) {
			TestReflex scriptletReflex = getScriptletReflex(reflexList);

			if (scriptletReflex != null) {
				if (noConclusionInModifiedResult(reflexList)) {
					List<Result> resultList = resultDAO.getResultsForSample(reflexList.get(0).getSample());

					// We're Unfortunately hard coding some business rules here
					if (CD4_SCRIPTLET_ID.equals(scriptletReflex.getActionScriptlet().getId())) {
						RetroCIReflexActions reflexAction = new RetroCIReflexActions();
						Result calculatedResults = reflexAction.getCD4CalculationResult(reflexList.get(0).getSample());

						if (calculatedResults != null) {

							Result cd4Result = null;
							for (Result result : resultList) {
								if (result.getAnalyte() != null && CD4_ANAYLETE.getId().equals(result.getAnalyte().getId())) {
									cd4Result = result;
									cd4Result.setValue(calculatedResults.getValue());
									break;
								}
							}

							if (cd4Result == null) {
								cd4Result = calculatedResults;
							}

							cd4Result.setSysUserId(currentUserId);

							if (cd4Result.getId() == null) {
								resultDAO.insertData(cd4Result);
							} else {
								resultDAO.updateData(cd4Result);
							}
						}
					} else { // It is a HIV conclusion

					}
				}
			}
		}

	}

	private Map<Sample, List<TestReflexBean>> groupBySample(List<TestReflexBean> reflexBeanList) {
		Map<Sample, List<TestReflexBean>> groupedBeans = new HashMap<Sample, List<TestReflexBean>>();

		for (TestReflexBean bean : reflexBeanList) {
			List<TestReflexBean> beanList;
			if (groupedBeans.containsKey(bean.getSample())) {
				beanList = groupedBeans.get(bean.getSample());
			} else {
				beanList = new ArrayList<TestReflexBean>();
				groupedBeans.put(bean.getSample(), beanList);
			}

			beanList.add(bean);
		}

		return groupedBeans;
	}

	private TestReflex getScriptletReflex(List<TestReflexBean> reflexBeanList) {
		for (TestReflexBean bean : reflexBeanList) {
			List<TestReflex> reflexList = reflexResolver.getTestReflexsForResult(bean.getResult());

			if (!reflexList.isEmpty()) {
				for (TestReflex testReflex : reflexList) {
					if (testReflex.getActionScriptlet() != null) {
						return testReflex;
					}
				}
			}
		}

		return null;
	}

	private boolean noConclusionInModifiedResult(List<TestReflexBean> reflexBeanList) {

		for (TestReflexBean bean : reflexBeanList) {
			if (isConclusion(bean.getResult())) {
				return true;
			}
		}
		return true;
	}

	private boolean isConclusion(Result result) {
		Analyte analyte = result.getAnalyte();

		if (analyte == null) {
			return false;
		}

		return CONCLUSION_ANAYLETE_ID.equals(analyte.getId()) || CD4_ANAYLETE.getId().equals(analyte.getId());

	}

}
