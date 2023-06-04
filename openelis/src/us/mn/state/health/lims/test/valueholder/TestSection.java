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
package us.mn.state.health.lims.test.valueholder;

import java.sql.Timestamp;

import us.mn.state.health.lims.common.valueholder.EnumValueItemImpl;
import us.mn.state.health.lims.organization.valueholder.Organization;
import us.mn.state.health.lims.common.valueholder.ValueHolder;
import us.mn.state.health.lims.common.valueholder.ValueHolderInterface;

public class TestSection extends EnumValueItemImpl {

	private static final long serialVersionUID = -1574344492809195601L;

	private String id;

    private String uuid;

    private String isExternal;

	private Timestamp lastupdated;

	private String testSectionName;

	private String description;

	private ValueHolderInterface organization;
	
	private String selectedOrganizationId;
	
	private int sortOrderInt;

	private String selectedParentTestSectionId;
	
	private ValueHolderInterface parentTestSection;
	
	private String isActive;
	
	
	public TestSection() {
		super();
		this.organization = new ValueHolder();
		this.parentTestSection = new ValueHolder();
	}

	public String getId() {
		return this.id;
	}

	public String getIsExternal() {
		return this.isExternal;
	}



	public String getTestSectionName() {
		return this.testSectionName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setIsExternal(String isExternal) {
		this.isExternal = isExternal;
	}


	public void setTestSectionName(String testSectionName) {
		this.testSectionName = testSectionName;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Organization getOrganization() {
		return (Organization) this.organization.getValue();
	}

	protected ValueHolderInterface getOrganizationHolder() {
		return this.organization;
	}

	public void setOrganization(Organization organization) {
		this.organization.setValue(organization);
	}

	protected void setOrganizationHolder(ValueHolderInterface organization) {
		this.organization = organization;
	}

	public void setSelectedOrganizationId(String selectedOrganizationId) {
		this.selectedOrganizationId = selectedOrganizationId;
	}

	public String getSelectedOrganizationId() {
		return this.selectedOrganizationId;
	}
	
	public void setLastupdated(Timestamp lastupdated) {
		this.lastupdated = lastupdated;
	}
	
	public Timestamp getLastupdated() {
		return this.lastupdated;
	}
	
	//bugzilla 2025
	public TestSection getParentTestSection() {
	    return (TestSection) this.parentTestSection.getValue();
	}
    
	public void setParentTestSection(TestSection parentTestSection) {
		this.parentTestSection.setValue(parentTestSection);
	}
	
	protected ValueHolderInterface getTestSectionHolder() {
		return this.parentTestSection;
	}
	protected void setTestSectionHolder(ValueHolderInterface parentTestSection) {
		this.parentTestSection = parentTestSection;
	}
	
	public void setSelectedParentTestSectionId (String selectedParentTestSectionId) {
		this.selectedParentTestSectionId = selectedParentTestSectionId;
	}

	public String getSelectedParentTestSectionId () {
		return this.selectedParentTestSectionId;
	}

	@Override
	protected String getDefaultLocalizedName() {
		return getTestSectionName();
	}


	public int getSortOrderInt() {
		return sortOrderInt;
	}

	public void setSortOrderInt(int sortOrderInt) {
		this.sortOrderInt = sortOrderInt;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

    public String getUUID() {
        return uuid;
    }

    public void setUUID(String uuid) {
        this.uuid = uuid;
    }

}
