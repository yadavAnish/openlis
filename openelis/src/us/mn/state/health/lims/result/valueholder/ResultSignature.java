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
package us.mn.state.health.lims.result.valueholder;

import us.mn.state.health.lims.common.valueholder.EnumValueItemImpl;
import us.mn.state.health.lims.systemuser.valueholder.SystemUser;

public class ResultSignature extends EnumValueItemImpl {

	private static final long serialVersionUID = 1L;

	private String id;
	private String resultId;
	private boolean isSupervisor;
	private String nonUserName;
    private SystemUser systemUser;
	
	public String getSystemUserId() {
		return systemUser.getId();
	}

    public String getResultId() {
		return resultId;
	}

	public void setResultId(String resultId) {
		this.resultId = resultId;
	}

	public boolean getIsSupervisor() {
		return isSupervisor;
	}

	public void setIsSupervisor(boolean isSupervisor) {
		this.isSupervisor = isSupervisor;
	}


	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setNonUserName(String nonUserName) {
		this.nonUserName = nonUserName;
	}

	public String getNonUserName() {
		return nonUserName;
	}

    public SystemUser getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(SystemUser systemUser) {
        this.systemUser = systemUser;
    }
}
