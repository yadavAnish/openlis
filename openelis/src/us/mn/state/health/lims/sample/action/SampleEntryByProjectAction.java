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

package us.mn.state.health.lims.sample.action;


import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import us.mn.state.health.lims.common.action.BaseActionForm;
import us.mn.state.health.lims.common.action.IActionConstants;
import us.mn.state.health.lims.common.exception.LIMSRuntimeException;
import us.mn.state.health.lims.common.util.DateUtil;
import us.mn.state.health.lims.dictionary.ObservationHistoryList;
import us.mn.state.health.lims.organization.util.OrganizationTypeList;
import us.mn.state.health.lims.patient.saving.Accessioner;
import us.mn.state.health.lims.sample.util.CI.ProjectForm;


/**
 * The SampleEntryByProjectAction class represents the initial Action for the SampleEntry
 * form of the application for the Retro-CI workflow
 *
 */
public class SampleEntryByProjectAction extends BaseSampleEntryAction {

	protected ActionForward performAction(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {


		request.getSession().setAttribute(IActionConstants.SAVE_DISABLED, IActionConstants.TRUE);

		BaseActionForm dynaForm = (BaseActionForm) form;

        // retrieve the current project, before clearing, so that we can set it on later.
        String projectFormId = Accessioner.findProjectFormName(dynaForm);
        // Initialize the form.
        dynaForm.initialize(mapping);
        updateRequestType(request);

		// Set received date and entered date to today's date
		Date today = Calendar.getInstance().getTime();
		String dateAsText = DateUtil.formatDateAsText(today );
		PropertyUtils.setProperty(form, "currentDate", dateAsText);
		PropertyUtils.setProperty(dynaForm, "receivedDateForDisplay", dateAsText);
		PropertyUtils.setProperty(dynaForm, "interviewDate", dateAsText);
		PropertyUtils.setProperty(dynaForm, "labNo", "");

		addGenderList(dynaForm);
		addProjectList(dynaForm);

		addOrganizationLists(dynaForm);
		addAllPatientFormLists(dynaForm);

        setProjectFormName(form, projectFormId);

        String forward = findForward(projectFormId);
		return mapping.findForward(forward);
	}


	/**
	 * One form ID at this time is actually on another JSP page, someday maybe others
     * @param projectFormId
     * @return
     */
    private String findForward(String projectFormId) {
        ProjectForm projectForm = ProjectForm.findProjectFormByFormId(projectFormId);
        if (projectForm == null) {
            return FWD_SUCCESS;
        }
        switch (projectForm) {
        case EID:
            return FWD_EID_ENTRY;
        default:
            return FWD_SUCCESS;
        }
    }

    protected String getPageSubtitleKey() {
		String key = null;

		switch (requestType) {
			case INITIAL: {
				key = "banner.menu.createSample.Initial";
				break;
			}
			case VERIFY: {
				key = "banner.menu.createSample.Verify";
				break;
			}

			default: {
				key = "banner.menu.sampleCreate";
			}
		}

		return key;
	}


	protected void addOrganizationLists(BaseActionForm dynaForm) throws LIMSRuntimeException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {

		//Get ARV Centers
		PropertyUtils.setProperty(dynaForm, "ProjectData.ARVCenters", OrganizationTypeList.ARV_ORGS.getList());
		PropertyUtils.setProperty(dynaForm, "organizationTypeLists", OrganizationTypeList.MAP);

		//Get EID Sites
		PropertyUtils.setProperty(dynaForm, "ProjectData.EIDSites", OrganizationTypeList.EID_ORGS.getList());
		PropertyUtils.setProperty(dynaForm, "ProjectData.EIDSitesByName", OrganizationTypeList.EID_ORGS_BY_NAME.getList());

		//Get EID whichPCR List
		//PropertyUtils.setProperty(dynaForm, "ProjectData.eidWhichPCRList", ObservationHistoryList.EID_WHICH_PCR.getList());

		//Get EID secondTestReason List
		PropertyUtils.setProperty(dynaForm, "ProjectData.eidSecondPCRReasonList", ObservationHistoryList.EID_SECOND_PCR_REASON.getList());

		//Get SPE Request Reasons
		PropertyUtils.setProperty(dynaForm, "ProjectData.requestReasons", ObservationHistoryList.SPECIAL_REQUEST_REASONS.getList());

		PropertyUtils.setProperty(dynaForm, "ProjectData.isUnderInvestigationList", ObservationHistoryList.YES_NO.getList());
	}
}
