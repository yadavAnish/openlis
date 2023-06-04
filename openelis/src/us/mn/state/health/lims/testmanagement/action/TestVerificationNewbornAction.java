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

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import us.mn.state.health.lims.common.action.BaseAction;
import us.mn.state.health.lims.common.action.BaseActionForm;
import us.mn.state.health.lims.testmanagement.valueholder.TestManagementRoutingSwitchSessionHandler;

public class TestVerificationNewbornAction extends BaseAction {	

	protected ActionForward performAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		request.setAttribute(ALLOW_EDITS_KEY, "true");
		request.setAttribute(PREVIOUS_DISABLED, "true");
		request.setAttribute(NEXT_DISABLED, "true");

		
		BaseActionForm testManagementForm = (BaseActionForm)form;
		
		if (request.getParameter(ID) == null) {		
			testManagementForm.initialize(mapping);		
		}
		
		HttpSession session = request.getSession();
		TestManagementRoutingSwitchSessionHandler.switchAllOff(session);	
		testManagementForm.initialize(mapping);	

		PropertyUtils.setProperty(form, "tests", new ArrayList());		
		
		return mapping.findForward(FWD_SUCCESS);	
	}
	
	protected String getPageTitleKey() {
		return "testmanagement.newborn.title";
	}

	protected String getPageSubtitleKey() {
		return "testmanagement.newborn.subtitle";
	}
}
