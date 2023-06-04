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
package us.mn.state.health.lims.testmanagement.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionRedirect;
import org.apache.struts.action.DynaActionForm;

import us.mn.state.health.lims.common.action.BaseAction;
import us.mn.state.health.lims.common.util.StringUtil;
import us.mn.state.health.lims.testmanagement.valueholder.TestManagementRoutingSwitchSessionHandler;

/**
 * @author diane benz
 * bugzilla 2053
 */
public class TestManagementCancelToQaEventsEntryAction extends BaseAction {

	protected ActionForward performAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DynaActionForm dynaForm = (DynaActionForm) form;
		
		HttpSession session = request.getSession();
		
		String multipleSampleModeInQaEventsEntry = (String)session.getAttribute(QAEVENTS_ENTRY_PARAM_MULTIPLE_SAMPLE_MODE);

		TestManagementRoutingSwitchSessionHandler.switchAllOff(session);
		
		String forward = FWD_SUCCESS;
		
	
		String accessionNumber = (String)request.getParameter(ACCESSION_NUMBER);
		if (StringUtil.isNullorNill(accessionNumber)) {
				accessionNumber = (String)dynaForm.get("accessionNumber");
		}

		if (!StringUtil.isNullorNill(multipleSampleModeInQaEventsEntry)) {
            forward = FWD_SUCCESS_MULTIPLE_SAMPLE_MODE;
		} 
		//pass back the accession number
        return getForward(mapping.findForward(forward), accessionNumber);

	}

	protected String getPageTitleKey() {
		return "qaeventsentry.browse.title";
	}

	protected String getPageSubtitleKey() {
		return "qaeventsentry.browse.title";
	}
	
	protected ActionForward getForward(ActionForward forward, String accessionNumber) {
		ActionRedirect redirect = new ActionRedirect(forward);

		if (accessionNumber != null)
			redirect.addParameter(ACCESSION_NUMBER, accessionNumber);

		return redirect;
	}
	

}
