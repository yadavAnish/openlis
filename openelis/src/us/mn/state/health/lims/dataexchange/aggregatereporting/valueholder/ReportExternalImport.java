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
package us.mn.state.health.lims.dataexchange.aggregatereporting.valueholder;

import java.sql.Timestamp;

import us.mn.state.health.lims.common.valueholder.BaseObject;

public class ReportExternalImport extends BaseObject{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String sendingSite;
	private Timestamp eventDate;
	private Timestamp recievedDate;
	private String reportType;
	private String data;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Timestamp getEventDate() {
		return eventDate;
	}
	public void setEventDate(Timestamp eventDate) {
		this.eventDate = eventDate;
	}
	public Timestamp getRecievedDate() {
		return recievedDate;
	}
	public void setRecievedDate(Timestamp recievedDate) {
		this.recievedDate = recievedDate;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public void setSendingSite(String sendingSite) {
		this.sendingSite = sendingSite;
	}
	public String getSendingSite() {
		return sendingSite;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	public String getReportType() {
		return reportType;
	}
	
	
}

