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
* Copyright (C) CIRG, University of Washington, Seattle WA.  All Rights Reserved.
*
*/
package us.mn.state.health.lims.analyzerimport.analyzerreaders;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import org.apache.commons.validator.GenericValidator;
import org.hibernate.Transaction;

import us.mn.state.health.lims.analyzerimport.util.AnalyzerTestNameCache;
import us.mn.state.health.lims.analyzerimport.util.AnalyzerTestNameCache.AnalyzerType;
import us.mn.state.health.lims.analyzerimport.util.MappedTestName;
import us.mn.state.health.lims.analyzerresults.valueholder.AnalyzerResults;
import us.mn.state.health.lims.common.exception.LIMSRuntimeException;
import us.mn.state.health.lims.common.util.DateUtil;
import us.mn.state.health.lims.common.util.HibernateProxy;
import us.mn.state.health.lims.common.util.StringUtil;

public class FACSCantoReader extends AnalyzerLineInserter {

	private static final String CONTROL_ACCESSION_PREFIX = "IMM";

	private static final String SAMPLE_ID_HEADER = "Sample ID";
	private static final String DATE_ANALYZED_HEADER = "Date Analyzed";
	private static final String CD3_CD8_CD45_CD4_CD3_PER_LYMPHS_HEADER = "CD3/CD8/CD45/CD4 CD3+ %Lymphs";
	private static final String CD3_CD8_CD45_CD4_CD3_CD4_PER_LYMPHS_HEADER = "CD3/CD8/CD45/CD4 CD3+CD4+ %Lymphs";

	private static final String DATE_PATTERN = "MM/dd/yyyy HH:mm";

	private int Sample_ID;
	private int Date_Analyzed;
	private int CD3_CD8_CD45_CD4_CD3_perLymphs;
	private int CD3_CD8_CD45_CD4_CD3_CD4_perLymphs;
	private String[] testNameIndex;
	private String[] unitsIndex;
	private int maxViewedIndex = 0;

	public boolean insert(List<String> lines,String currentUserId) {

		boolean successful = true;

		List<AnalyzerResults> results = new ArrayList<AnalyzerResults>();
		
		manageColumns( lines.get(0));
		
		for (int i = 1; i < lines.size(); i++) {
			addAnalyzerResultFromLine(results, lines.get(i));
		}

		if (results.size() > 0) {

			Transaction tx = HibernateProxy.beginTransaction();

			try {

				persistResults(results, currentUserId);

				tx.commit();

			} catch (LIMSRuntimeException lre) {
				tx.rollback();
				successful = false;
			} finally {
				HibernateProxy.closeSession();
			}
		}

		return successful;
	}

	private void manageColumns(String line) {
		String[] fields = StringUtil.separateCSVWithEmbededQuotes(line);
		if( fields.length < 10){
			fields = line.split(",");
		}
		
		for( int i = 0; i < fields.length; i++){
			String header = fields[i].replace("\"", "");
	
			if( SAMPLE_ID_HEADER.equals(header)){
				Sample_ID = i;
				maxViewedIndex = Math.max(maxViewedIndex, i);
			}else if( DATE_ANALYZED_HEADER.equals(header)){
				Date_Analyzed = i;
				maxViewedIndex = Math.max(maxViewedIndex, i);
			}else if(CD3_CD8_CD45_CD4_CD3_CD4_PER_LYMPHS_HEADER.equals(header)){
				CD3_CD8_CD45_CD4_CD3_CD4_perLymphs = i;
				maxViewedIndex = Math.max(maxViewedIndex, i);
			}else if( CD3_CD8_CD45_CD4_CD3_PER_LYMPHS_HEADER.equals(header)){
				CD3_CD8_CD45_CD4_CD3_perLymphs = i;
				maxViewedIndex = Math.max(maxViewedIndex, i);
			}
		}
		
		testNameIndex = new String[fields.length];
		unitsIndex = new String[fields.length];
		
		testNameIndex[CD3_CD8_CD45_CD4_CD3_perLymphs] = "CD3_PER";
		testNameIndex[CD3_CD8_CD45_CD4_CD3_CD4_perLymphs] = "CD4_PER";

		unitsIndex[CD3_CD8_CD45_CD4_CD3_perLymphs] = "%";
		unitsIndex[CD3_CD8_CD45_CD4_CD3_CD4_perLymphs] = "%";

	}

	private void addAnalyzerResultFromLine(List<AnalyzerResults> results, String line) {
		String[] fields = StringUtil.separateCSVWithMixedEmbededQuotes(line);
		
		//This insures that the row has not been truncated
		if( fields.length < maxViewedIndex){
			return;
		}
		
		AnalyzerReaderUtil readerUtil = new AnalyzerReaderUtil();
		String analyzerAccessionNumber = fields[Sample_ID].replace("\"", "");
		analyzerAccessionNumber = StringUtil.strip(analyzerAccessionNumber, " ");

		
		String date = fields[Date_Analyzed].replace("\"", "");
		
		//this is sort of dumb, we have the indexes we are interested in
		for (int i = 0; i < testNameIndex.length; i++) {
			if (!GenericValidator.isBlankOrNull(testNameIndex[i])) {
				MappedTestName mappedName = AnalyzerTestNameCache.instance().getMappedTest(AnalyzerType.FACSCANTO, testNameIndex[i].replace("\"", ""));

				if( mappedName == null){
					mappedName = AnalyzerTestNameCache.instance().getEmptyMappedTestName(AnalyzerType.FACSCANTO, testNameIndex[i].replace("\"", ""));
				}

				AnalyzerResults analyzerResults = new AnalyzerResults();

				analyzerResults.setAnalyzerId(mappedName.getAnalyzerId());

				String result = fields[i].replace("\"", "");
				result = roundTwoDigits(result);
				analyzerResults.setResult(result);
				analyzerResults.setUnits(unitsIndex[i]);

				analyzerResults.setCompleteDate(DateUtil.convertStringDateToTimestampWithPatternNoLocale(date , DATE_PATTERN));
				//analyzerResults.setCompleteTime(DateUtil.convertStringDateToTimestamp(date));
				analyzerResults.setTestId(mappedName.getTestId());
				analyzerResults.setAccessionNumber(analyzerAccessionNumber);
				analyzerResults.setTestName(mappedName.getOpenElisTestName());

				if (analyzerAccessionNumber != null) {
					analyzerResults.setIsControl(analyzerAccessionNumber.startsWith(CONTROL_ACCESSION_PREFIX));
				} else {
					analyzerResults.setIsControl(false);
				}

				results.add(analyzerResults);

				AnalyzerResults resultFromDB = readerUtil.createAnalyzerResultFromDB(analyzerResults);
				if( resultFromDB != null){
					results.add(resultFromDB);
				}
			}
		}
	}

	private String roundTwoDigits(String result) {
		
		try {
			Double doubleResult = Double.parseDouble(result);
			StringBuilder sb = new StringBuilder();
			Formatter formatter = new Formatter(sb);
			formatter.format("%.2f", (Math.rint(doubleResult * 100.0)/100.0));
			return sb.toString();
		} catch (NumberFormatException e) {
			return result;
		}
	}

	@Override
	public String getError() {
		return "FacsCANTO analyzer unable to write to database";
	}

}
