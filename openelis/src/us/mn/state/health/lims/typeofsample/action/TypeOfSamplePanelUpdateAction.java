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
package us.mn.state.health.lims.typeofsample.action;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import us.mn.state.health.lims.common.action.BaseAction;
import us.mn.state.health.lims.common.action.BaseActionForm;
import us.mn.state.health.lims.common.action.IActionConstants;
import us.mn.state.health.lims.common.exception.LIMSRuntimeException;
import us.mn.state.health.lims.typeofsample.dao.TypeOfSamplePanelDAO;
import us.mn.state.health.lims.typeofsample.daoimpl.TypeOfSamplePanelDAOImpl;
import us.mn.state.health.lims.typeofsample.valueholder.TypeOfSamplePanel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author diane benz
 * 
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates. To enable and disable the creation of type
 * comments go to Window>Preferences>Java>Code Generation.
 */
public class TypeOfSamplePanelUpdateAction extends BaseAction {

	protected ActionForward performAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String forward = FWD_SUCCESS;
		request.setAttribute(ALLOW_EDITS_KEY, "true");
		request.setAttribute(PREVIOUS_DISABLED, "false");
		request.setAttribute(NEXT_DISABLED, "false");

		String id = request.getParameter(ID);

		BaseActionForm dynaForm = (BaseActionForm) form;

		// server-side validation (validation.xml)
//		ActionMessages errors = dynaForm.validate(mapping, request);
//		if (errors != null && errors.size() > 0) {
//			saveErrors(request, errors);
	
//			return mapping.findForward(FWD_FAIL);
//		}

		String start = (String) request.getParameter("startingRecNo");
		String direction = (String) request.getParameter("direction");
		String typeOfSampleId = (String)dynaForm.get("sample");	
		String panelId = (String)dynaForm.get("panel");	
		
		TypeOfSamplePanel samplePanel = new TypeOfSamplePanel();
		samplePanel.setPanelId(panelId);
		samplePanel.setTypeOfSampleId(typeOfSampleId);
		samplePanel.setSysUserId(currentUserId);
		
		TypeOfSamplePanelDAO samplePanelDAO = new TypeOfSamplePanelDAOImpl();
		try{
			samplePanelDAO.insertData(samplePanel);
            forward = FWD_SUCCESS_INSERT;
        } catch (LIMSRuntimeException lre) {
            //bugzilla 2154
            request.setAttribute(IActionConstants.REQUEST_FAILED, true);
            forward = FWD_FAIL;
        }


		return getForward(mapping.findForward(forward), samplePanel.getId(), start, direction);

	}

	protected String getPageTitleKey() {
		return "typeofsample.add.title";
	}

	protected String getPageSubtitleKey() {
		return "typeofsample.add.title";
	}
}
