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
package us.mn.state.health.lims.testresult.valueholder;

import us.mn.state.health.lims.common.valueholder.EnumValueItemImpl;
import us.mn.state.health.lims.scriptlet.valueholder.Scriptlet;
import us.mn.state.health.lims.test.valueholder.Test;
import us.mn.state.health.lims.common.valueholder.ValueHolder;
import us.mn.state.health.lims.common.valueholder.ValueHolderInterface;

public class TestResult extends EnumValueItemImpl {

	private static final long serialVersionUID = 1L;

	private String id;

	private Test test;

	private String testName;

	private String resultGroup;
	
	private String sortOrder;

	private String flags;

	private String testResultType;

	private String value;

	private String significantDigits;

	private String quantLimit;

	private String contLevel;
	
	private String scriptletName;

	private ValueHolderInterface scriptlet;

    private Boolean abnormal;

	private Boolean active = true;

    public static final String MULTI_RESULT_TYPE = "M";

    public TestResult() {
		super();
		this.scriptlet = new ValueHolder();
	}

	public String getId() {
		return this.id;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public String getTestName() {
		return this.testName;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getContLevel() {
		return contLevel;
	}

	public void setContLevel(String contLevel) {
		this.contLevel = contLevel;
	}

	public String getFlags() {
		return flags;
	}

	public void setFlags(String flags) {
		this.flags = flags;
	}

	public String getQuantLimit() {
		return quantLimit;
	}

	public void setQuantLimit(String quantLimit) {
		this.quantLimit = quantLimit;
	}

	public String getResultGroup() {
		return resultGroup;
	}

	public void setResultGroup(String resultGroup) {
		this.resultGroup = resultGroup;
	}

	public String getSignificantDigits() {
		return significantDigits;
	}

	public void setSignificantDigits(String significantDigits) {
		this.significantDigits = significantDigits;
	}

	public String getTestResultType() {
		return testResultType;
	}

	public void setTestResultType(String testResultType) {
		this.testResultType = testResultType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getScriptletName() {
		return scriptletName;
	}

	public void setScriptletName(String scriptletName) {
		this.scriptletName = scriptletName;
	}
	
	public void setScriptlet(Scriptlet scriptlet) {
		this.scriptlet.setValue(scriptlet);
	}

	protected void setScriptletHolder(ValueHolderInterface scriptlet) {
		this.scriptlet = scriptlet;
	}

	public Scriptlet getScriptlet() {
		return (Scriptlet) this.scriptlet.getValue();
	}

	protected ValueHolderInterface getScriptletHolder() {
		return this.scriptlet;
	}

	//bugzilla 1845 added testResult sortOrder
	public String getSortOrder() {
		return sortOrder;
	}
	//bugzilla 1845 added testResult sortOrder
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

    public Boolean getAbnormal() {
        return abnormal;
    }

    public void setAbnormal(Boolean abnormal) {
        this.abnormal = abnormal;
    }

    public boolean canHaveMultipleValues() {
        return testResultType.equalsIgnoreCase(MULTI_RESULT_TYPE);
    }

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
}
