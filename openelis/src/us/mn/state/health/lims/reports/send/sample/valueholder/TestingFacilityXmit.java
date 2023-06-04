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
package us.mn.state.health.lims.reports.send.sample.valueholder;

public class TestingFacilityXmit extends
		us.mn.state.health.lims.provider.valueholder.Provider {

	private String organizationName;

	private String universalId;

	private String universalIdType;

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getUniversalId() {
		return universalId;
	}

	public void setUniversalId(String universalId) {
		this.universalId = universalId;
	}

	public String getUniversalIdType() {
		return universalIdType;
	}

	public void setUniversalIdType(String universalIdType) {
		this.universalIdType = universalIdType;
	}

}
