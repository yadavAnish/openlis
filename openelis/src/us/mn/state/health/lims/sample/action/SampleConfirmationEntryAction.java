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
package us.mn.state.health.lims.sample.action;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import us.mn.state.health.lims.common.action.BaseActionForm;
import us.mn.state.health.lims.common.action.IActionConstants;
import us.mn.state.health.lims.common.formfields.FormFields;
import us.mn.state.health.lims.common.services.DisplayListService;
import us.mn.state.health.lims.common.services.DisplayListService.ListType;
import us.mn.state.health.lims.common.util.DateUtil;
import us.mn.state.health.lims.common.util.StringUtil;
import us.mn.state.health.lims.organization.dao.OrganizationDAO;
import us.mn.state.health.lims.organization.daoimpl.OrganizationDAOImpl;
import us.mn.state.health.lims.organization.valueholder.Organization;
import us.mn.state.health.lims.patient.action.bean.PatientManagmentInfo;
import us.mn.state.health.lims.sample.util.SamplePropertyUtil;

/**
 * The SampleEntryAction class represents the initial Action for the SampleEntry
 * form of the application
 *
 */
public class SampleConfirmationEntryAction extends BaseSampleEntryAction {

	protected ActionForward performAction(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		boolean needSampleInitialConditionList = FormFields.getInstance().useField(FormFields.Field.InitialSampleCondition);
		String forward = "success";

		request.getSession().setAttribute(IActionConstants.SAVE_DISABLED, IActionConstants.TRUE);

		BaseActionForm dynaForm = (BaseActionForm) form;

		dynaForm.initialize(mapping);

		Date today = Calendar.getInstance().getTime();
		String dateAsText = DateUtil.formatDateAsText(today );
		PropertyUtils.setProperty(form, "currentDate", dateAsText);
		PropertyUtils.setProperty(form, "receivedDate", dateAsText);

		PropertyUtils.setProperty(dynaForm, "requestingOrganizationList", DisplayListService.getFreshList(ListType.SAMPLE_PATIENT_REFERRING_CLINIC));
		PropertyUtils.setProperty(dynaForm, "patientProperties", new PatientManagmentInfo());
		if (needSampleInitialConditionList) {
			setDictionaryList(dynaForm, "initialSampleConditionList", "reciptCond", true);
		}

		SamplePropertyUtil.loadSampleTypes(dynaForm, "sampleTypes");

		return mapping.findForward(forward);
	}


	protected String getPageTitleKey() {
		return StringUtil.getContextualKeyForKey("banner.menu.sample.confirmation.add");
	}

	protected String getPageSubtitleKey() {
		return StringUtil.getContextualKeyForKey("banner.menu.sample.confirmation.add");
	}

}
