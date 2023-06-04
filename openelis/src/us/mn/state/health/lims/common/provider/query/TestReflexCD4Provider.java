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
package us.mn.state.health.lims.common.provider.query;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.GenericValidator;

import us.mn.state.health.lims.common.servlet.validation.AjaxServlet;
import us.mn.state.health.lims.common.util.XMLUtil;
import us.mn.state.health.lims.result.dao.ResultDAO;
import us.mn.state.health.lims.result.daoimpl.ResultDAOImpl;
import us.mn.state.health.lims.result.valueholder.Result;
import us.mn.state.health.lims.sample.valueholder.Sample;
import us.mn.state.health.lims.test.dao.TestDAO;
import us.mn.state.health.lims.test.daoimpl.TestDAOImpl;
import us.mn.state.health.lims.test.valueholder.Test;
import us.mn.state.health.lims.testreflex.valueholder.TestReflex;

public class TestReflexCD4Provider extends BaseQueryProvider {

	private static String CD4_TEST_ID;
	private static String GB_TEST_ID;
	private static String LYMPH_TEST_ID;

	
	private ResultDAO resultDAO = new ResultDAOImpl();
	private static final String VALUE_SEPERATOR = ",";
	protected AjaxServlet ajaxServlet = null;

	static{
		TestDAO testDAO = new TestDAOImpl();
		
		Test test = testDAO.getTestByName("CD4 percentage count");
		if( test != null){
			CD4_TEST_ID = test.getId();
		}
		
		test = testDAO.getTestByName("Lymph %");
		if( test != null){
			LYMPH_TEST_ID = test.getId();
		}
		
		test = testDAO.getTestByName("GB");
		if( test != null){
			GB_TEST_ID = test.getId();
		}
		
	}
	
	@Override
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String resultIds = request.getParameter("results");
		String values = request.getParameter("values");
		String childRow = request.getParameter("childRow");

		

		StringBuilder xml = new StringBuilder();

		String result = VALID;

		if (initialConditionsSatisfied(resultIds, values, childRow) ) {
			result = INVALID;
			xml.append("Internal error, please contact Admin and file bug report");
		} else {
			result = createTestReflexXML(resultIds, values, childRow, xml);
		}

		
		ajaxServlet.sendData(xml.toString(), result, request, response);

	}


	private boolean initialConditionsSatisfied(String resultIds, String values, String childRow) {
		return GenericValidator.isBlankOrNull(resultIds) || 
			   GenericValidator.isBlankOrNull(values) || 
			   GenericValidator.isBlankOrNull(childRow) ||
			   GenericValidator.isBlankOrNull(CD4_TEST_ID) ||
			   GenericValidator.isBlankOrNull(GB_TEST_ID) ||
			   GenericValidator.isBlankOrNull(LYMPH_TEST_ID);
	}


	private String createTestReflexXML(String resultIds, String values, String childRow, StringBuilder xml) {
		String[] resultIdSeries = resultIds.split(VALUE_SEPERATOR);

		String CD4Result = "";
		String GBResult = "";
		String LymphResult = "";
		
		if( resultIdSeries.length > 0){
			String[] valueSeries = values.split(VALUE_SEPERATOR);
			
			for( int i = 0; i < resultIdSeries.length; i++){
				Result result = resultDAO.getResultById(resultIdSeries[i]);
				
				if( result != null){
					String testId = result.getAnalysis().getTest().getId();
					
					if( CD4_TEST_ID.equals(testId)){
						CD4Result = valueSeries[i];
					}else if( LYMPH_TEST_ID.equals(testId)){
						LymphResult = valueSeries[i];
					}else if( GB_TEST_ID.equals(testId)){
						GBResult = valueSeries[i];
					} 
				}
			}
			
			CD4Result = fetchIfNeeded(CD4_TEST_ID, CD4Result, resultIdSeries[0]);
			LymphResult = fetchIfNeeded(LYMPH_TEST_ID, LymphResult, resultIdSeries[0]);
			GBResult = fetchIfNeeded(GB_TEST_ID, GBResult, resultIdSeries[0]);
			
			double result = 0;
			try {
				result = Double.parseDouble(CD4Result) * 
						Double.parseDouble(GBResult) * 
						Double.parseDouble(LymphResult) * 0.1;
				result = Math.rint(result);	
			} catch (NumberFormatException e) {
				return INVALID;
			}
			
			XMLUtil.appendKeyValue("childRow", childRow, xml);
			XMLUtil.appendKeyValue("value", String.valueOf(result), xml);
			return VALID;
		}

		return INVALID;
	}


	private String fetchIfNeeded(String testId, String currentResult, String validResultId) {
		if( !GenericValidator.isBlankOrNull(currentResult)){
			return currentResult;
		}
		
		Result result = resultDAO.getResultById(validResultId);

		Sample sample = result.getAnalysis().getSampleItem().getSample();
		
		List<Result> resultList = resultDAO.getResultsForTestAndSample(sample.getId(), testId);
		
		if( resultList.isEmpty()){
			return null;
		}else{
			return resultList.get(0).getValue();
		}
	}


	private void createChoiceElement(TestReflex testReflex, StringBuilder xml) {

		XMLUtil.appendKeyValue("conclusionText", testReflex.getActionScriptlet().getScriptletName(), xml);
		XMLUtil.appendKeyValue("conclusionId", testReflex.getActionScriptletId(), xml);
		XMLUtil.appendKeyValue("testText", testReflex.getAddedTest().getLocalizedName(), xml);
		XMLUtil.appendKeyValue("testId", testReflex.getAddedTestId(), xml);
	}

	@Override
	public void setServlet(AjaxServlet as) {
		this.ajaxServlet = as;
	}

	@Override
	public AjaxServlet getServlet() {
		return this.ajaxServlet;
	}

}
