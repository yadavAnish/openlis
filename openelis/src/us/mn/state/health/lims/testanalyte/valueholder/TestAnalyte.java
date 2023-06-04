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
*/
package us.mn.state.health.lims.testanalyte.valueholder;

import java.util.ArrayList;
import java.util.List;

import us.mn.state.health.lims.common.valueholder.ValueHolder;
import us.mn.state.health.lims.common.valueholder.ValueHolderInterface;
import us.mn.state.health.lims.analyte.valueholder.Analyte;
import us.mn.state.health.lims.common.valueholder.EnumValueItemImpl;
import us.mn.state.health.lims.test.valueholder.Test;

public class TestAnalyte extends EnumValueItemImpl {

	private String id;

	private ValueHolderInterface test;

	private String testName;

	private ValueHolderInterface analyte;

	private String analyteName;

	// testing one-to-many
	private List testResults;
	
	private String resultGroup;
	
	private String testAnalyteType;

	private String sortOrder;
	
	//bugzilla 1870
	private String isReportable;

	public TestAnalyte() {
		super();
		this.test = new ValueHolder();
		this.analyte = new ValueHolder();
		this.testResults = new ArrayList();
	}

	public String getId() {
		return this.id;
	}

	public Test getTest() {
		return (Test) this.test.getValue();
	}

	public void setTest(Test test) {
		this.test.setValue(test);
	}

	protected ValueHolderInterface getTestHolder() {
		return this.test;
	}

	public String getTestName() {
		return this.testName;
	}

	public Analyte getAnalyte() {
		return (Analyte) this.analyte.getValue();
	}

	public void setAnalyte(Analyte analyte) {
		this.analyte.setValue(analyte);
	}

	protected ValueHolderInterface getAnalyteHolder() {
		return this.analyte;
	}

	public String getAnalyteName() {
		return this.analyteName;
	}

	public void setId(String id) {
		this.id = id;
	}

	protected void setTestHolder(ValueHolderInterface test) {
		this.test = test;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getTestAnalyteType() {
		return testAnalyteType;
	}

	public void setTestAnalyteType(String testAnalyteType) {
		this.testAnalyteType = testAnalyteType;
	}

	public void setTest(ValueHolderInterface test) {
		this.test = test;
	}

	public void setAnalyte(ValueHolderInterface analyte) {
		this.analyte = analyte;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public void setAnalyteName(String analyteName) {
		this.analyteName = analyteName;
	}

	public List getTestResults() {
		return testResults;
	}

	public void setTestResults(List testResults) {
		this.testResults = testResults;
	}

	public String getResultGroup() {
		return resultGroup;
	}

	public void setResultGroup(String resultGroup) {
		this.resultGroup = resultGroup;
	}

	public String getIsReportable() {
		return isReportable;
	}

	public void setIsReportable(String isReportable) {
		this.isReportable = isReportable;
	}

	
	
}
