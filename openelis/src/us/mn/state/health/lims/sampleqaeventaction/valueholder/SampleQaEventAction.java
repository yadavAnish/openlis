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
package us.mn.state.health.lims.sampleqaeventaction.valueholder;

import java.sql.Date;

import us.mn.state.health.lims.action.valueholder.Action;
import us.mn.state.health.lims.common.util.DateUtil;
import us.mn.state.health.lims.common.util.SystemConfiguration;
import us.mn.state.health.lims.common.valueholder.BaseObject;
import us.mn.state.health.lims.common.valueholder.ValueHolder;
import us.mn.state.health.lims.common.valueholder.ValueHolderInterface;
import us.mn.state.health.lims.sampleqaevent.valueholder.SampleQaEvent;
import us.mn.state.health.lims.systemuser.valueholder.SystemUser;

/**
 * @author benzd1
 * bugzilla 2510
 */
public class SampleQaEventAction extends BaseObject {

	private String id;

	private String sampleQaEventId;

	private ValueHolderInterface sampleQaEvent;

	private String actionId;

	private ValueHolderInterface action;

	private Date createdDate;

	private String createdDateForDisplay;
	
	//bugzilla 2481
	private SystemUser systemUser;
	    
	private String systemUserId;

	public SampleQaEventAction() {
		super();
		this.action = new ValueHolder();
		this.sampleQaEvent = new ValueHolder();
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	// Action
	public Action getAction() {
		return (Action) this.action.getValue();
	}

	public void setAction(ValueHolderInterface action) {
		this.action = action;
	}

	public void setAction(Action action) {
		this.action.setValue(action);
	}

	protected ValueHolderInterface getActionHolder() {
		return this.action;
	}

	protected void setActionHolder(ValueHolderInterface action) {
		this.action = action;
	}

	// SAMPLE_QA_EVENT
	public SampleQaEvent getSampleQaEvent() {
		return (SampleQaEvent) this.sampleQaEvent.getValue();
	}

	public void setSampleQaEvent(ValueHolderInterface sampleQaEvent) {
		this.sampleQaEvent = sampleQaEvent;
	}

	public void setSampleQaEvent(SampleQaEvent sampleQaEvent) {
		this.sampleQaEvent.setValue(sampleQaEvent);
	}

	protected ValueHolderInterface getSampleQaEventHolder() {
		return this.sampleQaEvent;
	}

	protected void setSampleQaEventHolder(ValueHolderInterface sampleQaEvent) {
		this.sampleQaEvent = sampleQaEvent;
	}

	public String getActionId() {
		return actionId;
	}

	public void setActionId(String actionId) {
		this.actionId = actionId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
		// also update String date
		String locale = SystemConfiguration.getInstance().getDefaultLocale()
				.toString();
		this.createdDateForDisplay = DateUtil.convertSqlDateToStringDate(
				createdDate, locale);
	}

	public String getCreatedDateForDisplay() {
		return this.createdDateForDisplay;
	}

	public void setCreatedDateForDisplay(String createdDateForDisplay) {
		this.createdDateForDisplay = createdDateForDisplay;
		// also update the java.sql.Date
		String locale = SystemConfiguration.getInstance().getDefaultLocale()
				.toString();
		this.createdDate = DateUtil.convertStringDateToSqlDate(
				createdDateForDisplay, locale);
	}

	public String getSampleQaEventId() {
		return sampleQaEventId;
	}

	public void setSampleQaEventId(String sampleQaEventId) {
		this.sampleQaEventId = sampleQaEventId;
	}

	public void setSystemUser(SystemUser systemUser) {
		this.systemUser = systemUser;
	}
	
	public SystemUser getSystemUser() {
		return this.systemUser;
	}
	
	public String getSystemUserId() {
		return systemUserId;
	}
	
	public void setSystemUserId(String systemUserId) {
		this.systemUserId = systemUserId;
	}

}
