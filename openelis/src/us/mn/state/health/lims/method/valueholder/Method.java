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
package us.mn.state.health.lims.method.valueholder;

import java.sql.Date;

import us.mn.state.health.lims.common.util.DateUtil;
import us.mn.state.health.lims.common.util.SystemConfiguration;
import us.mn.state.health.lims.common.valueholder.BaseObject;

public class Method extends BaseObject {

	private String id;

	private String methodName;

	private String description;

	private String reportingDescription;

	private Date activeBeginDate = null;

	private String activeBeginDateForDisplay = null;

	private Date activeEndDate = null;

	private String activeEndDateForDisplay = null;

	private String isActive;

	public Method() {
		super();
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setReportingDescription(String reportingDescription) {
		this.reportingDescription = reportingDescription;
	}

	public String getReportingDescription() {
		return reportingDescription;
	}

	public void setActiveBeginDate(Date activeBeginDate) {
		this.activeBeginDate = activeBeginDate;
		// also update String date
		String locale = SystemConfiguration.getInstance().getDefaultLocale()
				.toString();
		this.activeBeginDateForDisplay = DateUtil.convertSqlDateToStringDate(
				activeBeginDate, locale);
	}

	public Date getActiveBeginDate() {
		return activeBeginDate;
	}

	public void setActiveEndDate(Date activeEndDate) {
		this.activeEndDate = activeEndDate;
		// also update String date
		String locale = SystemConfiguration.getInstance().getDefaultLocale()
				.toString();
		this.activeEndDateForDisplay = DateUtil.convertSqlDateToStringDate(
				activeEndDate, locale);
	}

	public Date getActiveEndDate() {
		return activeEndDate;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setActiveBeginDateForDisplay(String activeBeginDateForDisplay) {
		this.activeBeginDateForDisplay = activeBeginDateForDisplay;
		// also update the java.sql.Date
		String locale = SystemConfiguration.getInstance().getDefaultLocale()
				.toString();
		this.activeBeginDate = DateUtil.convertStringDateToSqlDate(
				this.activeBeginDateForDisplay, locale);
	}

	public String getActiveBeginDateForDisplay() {
		return activeBeginDateForDisplay;
	}

	public void setActiveEndDateForDisplay(String activeEndDateForDisplay) {
		this.activeEndDateForDisplay = activeEndDateForDisplay;
		// also update the java.sql.Date
		String locale = SystemConfiguration.getInstance().getDefaultLocale()
				.toString();
		this.activeEndDate = DateUtil.convertStringDateToSqlDate(
				activeEndDateForDisplay, locale);
	}

	public String getActiveEndDateForDisplay() {
		return activeEndDateForDisplay;
	}

}
