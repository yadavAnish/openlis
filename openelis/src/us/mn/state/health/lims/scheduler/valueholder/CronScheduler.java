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
package us.mn.state.health.lims.scheduler.valueholder;

import java.sql.Timestamp;

import us.mn.state.health.lims.common.util.StringUtil;
import us.mn.state.health.lims.common.valueholder.BaseObject;

public class CronScheduler extends BaseObject{

	private static final long serialVersionUID = 1L;

	private String id;
	private String  cronStatement;
	private Timestamp lastRun;
	private Boolean active;
	private Boolean runIfPast;
	private String name;
	private String  jobName;
	private String displayKey;
	private String  descriptionKey;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCronStatement() {
		return cronStatement;
	}
	public void setCronStatement(String cronStatement) {
		this.cronStatement = cronStatement;
	}
	public Timestamp getLastRun() {
		return lastRun;
	}
	public void setLastRun(Timestamp lastRun) {
		this.lastRun = lastRun;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Boolean getRunIfPast() {
		return runIfPast;
	}
	public void setRunIfPast(Boolean runIfPast) {
		this.runIfPast = runIfPast;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getDisplayKey() {
		return displayKey;
	}
	public void setDisplayKey(String displayKey) {
		this.displayKey = displayKey;
	}
	public String getDescriptionKey() {
		return descriptionKey;
	}
	public void setDescriptionKey(String descriptionKey) {
		this.descriptionKey = descriptionKey;
	}
	
	public String getLocalizedName(){
		if( getDisplayKey() != null){
			return StringUtil.getMessageForKey(getDisplayKey());
		}
		
		return null;
	}
	
	public String getLocalizedDescription(){
		if( getDescriptionKey() != null){
			return StringUtil.getMessageForKey(getDescriptionKey());
		}
		
		return null;
	}
}
