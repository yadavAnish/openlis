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

package us.mn.state.health.lims.patienttype.valueholder;

import us.mn.state.health.lims.common.valueholder.BaseObject;

public class PatientPatientType extends BaseObject {

	private static final long serialVersionUID = 1L;

	private String id;
	
	private String patientId;
	
	private String patientTypeId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getPatientTypeId() {
		return patientTypeId;
	}

	public void setPatientTypeId(String patientTypeId) {
		this.patientTypeId = patientTypeId;
	}
	
	
}
