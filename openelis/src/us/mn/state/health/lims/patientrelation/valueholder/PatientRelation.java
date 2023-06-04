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
package us.mn.state.health.lims.patientrelation.valueholder;

import us.mn.state.health.lims.common.valueholder.BaseObject;

public class PatientRelation extends BaseObject {

	private String id;
	private String patientIdSource;
	private String patientId;
	private String relation;

	public PatientRelation() {
		super();
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}

	public void setPatientIdSource(String patientIdSource) {
		this.patientIdSource = patientIdSource;
	}
	public String getPatientIdSource() {
		return patientIdSource;
	}
	
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getRelation() {
		return relation;
	}
}
