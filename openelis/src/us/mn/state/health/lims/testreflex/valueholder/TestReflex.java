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
package us.mn.state.health.lims.testreflex.valueholder;

import us.mn.state.health.lims.common.valueholder.EnumValueItemImpl;
import us.mn.state.health.lims.common.valueholder.ValueHolder;
import us.mn.state.health.lims.common.valueholder.ValueHolderInterface;
import us.mn.state.health.lims.scriptlet.valueholder.Scriptlet;
import us.mn.state.health.lims.test.valueholder.Test;
import us.mn.state.health.lims.testanalyte.valueholder.TestAnalyte;
import us.mn.state.health.lims.testresult.valueholder.TestResult;

public class TestReflex extends EnumValueItemImpl {

	private static final long serialVersionUID = 1L;

	private String id;

	private ValueHolderInterface testResult;

	private String testResultId;

	private ValueHolderInterface testAnalyte;

	private String testAnalyteId;

	private ValueHolderInterface test;

	private String testId;

	private ValueHolderInterface addedTest;

	private String addedTestId;

	private ValueHolderInterface actionScriptlet;

	private String actionScriptletId;

	private String flags;

	private String siblingReflexId;

	//This is solely for display and a different approach should be used
	private boolean passiveSibling;

	public TestReflex() {
		super();
		this.testResult = new ValueHolder();
		this.testAnalyte = new ValueHolder();
		this.test = new ValueHolder();
		this.addedTest = new ValueHolder();
		actionScriptlet = new ValueHolder();
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFlags() {
		return flags;
	}

	public void setFlags(String flags) {
		this.flags = flags;
	}

	public String getTestAnalyteId() {
		return testAnalyteId;
	}

	public void setTestAnalyteId(String testAnalyteId) {
		this.testAnalyteId = testAnalyteId;
	}

	public String getTestResultId() {
		if( testResultId == null){
			if( getTestResult() != null){
				testResultId = getTestResult().getId();
			}
		}
		return testResultId;
	}

	public void setTestResultId(String testResultId) {
		this.testResultId = testResultId;
	}

	// test result object
	public void setTestResult(TestResult testResult) {
		this.testResult.setValue(testResult);
	}

	protected void setTestResultHolder(ValueHolderInterface testResult) {
		this.testResult = testResult;
	}

	public TestResult getTestResult() {
		return (TestResult) this.testResult.getValue();
	}

	protected ValueHolderInterface getTestResultHolder() {
		return this.testResult;
	}

	// test analyte object
	public void setTestAnalyte(TestAnalyte testAnalyte) {
		testAnalyteId = testAnalyte.getId();
		this.testAnalyte.setValue(testAnalyte);
	}

	protected void setTestAnalyteHolder(ValueHolderInterface testAnalyte) {
		this.testAnalyte = testAnalyte;
	}

	public TestAnalyte getTestAnalyte() {
		return (TestAnalyte) this.testAnalyte.getValue();
	}

	protected ValueHolderInterface getTestAnalyteHolder() {
		return this.testAnalyte;
	}

	public String getAddedTestId() {
		if( addedTestId == null){
			if( getAddedTest() != null){
				addedTestId = getAddedTest().getId();
			}
		}
		return addedTestId;
	}

	public void setAddedTestId(String addedTestId) {
		this.addedTestId = addedTestId;
	}

	public String getTestId() {
		if( testId == null){
			if( getTest() != null){
				testId = getTest().getId();
			}
		}
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	// test object
	public void setTest(Test test) {
		this.test.setValue(test);
	}

	protected void setTestHolder(ValueHolderInterface test) {
		this.test = test;
	}

	public Test getTest() {
		return (Test) this.test.getValue();
	}

	protected ValueHolderInterface getTestHolder() {
		return this.test;
	}

	// addedAddedTest object
	public void setAddedTest(Test addedTest) {
		this.addedTest.setValue(addedTest);
	}

	protected void setAddedTestHolder(ValueHolderInterface addedTest) {
		this.addedTest = addedTest;
	}

	public Test getAddedTest() {
		return (Test) this.addedTest.getValue();
	}

	protected ValueHolderInterface getAddedTestHolder() {
		return this.addedTest;
	}

	public String getActionScriptletId() {
		if( actionScriptletId == null){
			if( getActionScriptlet() != null){
				actionScriptletId = getActionScriptlet().getId();
			}
		}
		return actionScriptletId;
	}

	public void setActionScriptletId(String actionScriptletId) {
		this.actionScriptletId = actionScriptletId;
	}

	public ValueHolderInterface getActionScriptletHolder() {
		return actionScriptlet;
	}

	public void setActionScriptletHolder(ValueHolderInterface actionScriptlet) {
		this.actionScriptlet = actionScriptlet;
	}
	public Scriptlet getActionScriptlet(){
		return (Scriptlet)actionScriptlet.getValue();
	}

	public void setActionScriptlet(Scriptlet scriptlet){
		this.actionScriptlet.setValue(scriptlet);
	}

	public void setSiblingReflexId(String siblingReflexId) {
		this.siblingReflexId = siblingReflexId;
	}

	public String getSiblingReflexId() {
		return siblingReflexId;
	}

	public void setPassiveSibling(boolean isPassiveSibling) {
		this.passiveSibling = isPassiveSibling;
	}

	public boolean isPassiveSibling() {
		return passiveSibling;
	}

}
