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
*
* Contributor(s): CIRG, University of Washington, Seattle WA.
*/
package us.mn.state.health.lims.common.formfields;

import java.util.HashMap;
import us.mn.state.health.lims.common.formfields.FormFields.Field;

public class RETROCIFormFields implements IFormFieldsForImplementation {

	public HashMap<FormFields.Field, Boolean> getImplementationAttributes() {
		HashMap<FormFields.Field, Boolean> settings = new HashMap<FormFields.Field, Boolean>();

		settings.put(Field.StNumber,  Boolean.FALSE);
		settings.put(Field.AKA, Boolean.FALSE);
		settings.put(Field.MothersName, Boolean.FALSE);
		settings.put(Field.PatientType, Boolean.TRUE);
		settings.put(Field.InsuranceNumber, Boolean.FALSE);
		settings.put(Field.CollectionDate, Boolean.TRUE);
		settings.put(Field.OrgLocalAbrev, Boolean.FALSE);
		settings.put(Field.OrgState, Boolean.FALSE);
		settings.put(Field.ZipCode, Boolean.FALSE);
		settings.put(Field.MLS, Boolean.FALSE);
		settings.put(Field.InlineOrganizationTypes, Boolean.TRUE);
		settings.put(Field.SubjectNumber, Boolean.FALSE);
		settings.put(Field.ProviderInfo, Boolean.FALSE);
		settings.put(Field.NationalID,  Boolean.TRUE);
		settings.put(Field.ResultsAccept,  Boolean.TRUE);
		settings.put(Field.SearchSampleStatus,  Boolean.TRUE);
		settings.put(Field.OrgLocalAbrev, Boolean.FALSE);
		settings.put(Field.OrganizationAddressInfo, Boolean.FALSE);
		settings.put(Field.OrganizationCLIA, Boolean.FALSE);
		settings.put(Field.OrganizationParent, Boolean.FALSE);
		settings.put(Field.DepersonalizedResults, Boolean.TRUE);
		settings.put(Field.SearchPatientWithLabNo, Boolean.TRUE);
		settings.put(Field.Project, Boolean.TRUE);
		settings.put(Field.QAFullProviderInfo, Boolean.FALSE);
		settings.put(Field.QASubjectNumber, Boolean.TRUE);

		return settings;
	}

}
