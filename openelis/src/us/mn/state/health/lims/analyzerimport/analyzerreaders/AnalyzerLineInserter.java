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
package us.mn.state.health.lims.analyzerimport.analyzerreaders;

import java.util.List;

import us.mn.state.health.lims.analyzerresults.dao.AnalyzerResultsDAO;
import us.mn.state.health.lims.analyzerresults.daoimpl.AnalyzerResultsDAOImpl;
import us.mn.state.health.lims.analyzerresults.valueholder.AnalyzerResults;

public abstract class AnalyzerLineInserter {
	private static AnalyzerResultsDAO analyzerResultDAO = null;

	protected void persistResults(List<AnalyzerResults> results, String systemUserId) {
		getAnalyzerResultDAO().insertAnalyzerResults(results, systemUserId);
	}

	private AnalyzerResultsDAO getAnalyzerResultDAO() {
		if( analyzerResultDAO == null){
			analyzerResultDAO = new AnalyzerResultsDAOImpl();
		}
		
		return analyzerResultDAO;
	}

	public static void setAnalyzerResultDAO(AnalyzerResultsDAO analyzerResultDAO) {
		AnalyzerLineInserter.analyzerResultDAO = analyzerResultDAO;
	}
	
	public abstract boolean insert(List<String> lines, String currentUserId);

	public abstract String getError();
	
}
