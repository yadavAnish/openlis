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
package us.mn.state.health.lims.systemusermodule.action;

import org.apache.struts.Globals;
import org.apache.struts.action.*;
import us.mn.state.health.lims.common.action.BaseAction;
import us.mn.state.health.lims.common.action.IActionConstants;
import us.mn.state.health.lims.common.exception.LIMSRuntimeException;
import us.mn.state.health.lims.common.log.LogEvent;
import us.mn.state.health.lims.common.util.SystemConfiguration;
import us.mn.state.health.lims.common.util.validator.ActionError;
import us.mn.state.health.lims.systemusermodule.dao.PermissionAgentModuleDAO;
import us.mn.state.health.lims.systemusermodule.daoimpl.RoleModuleDAOImpl;
import us.mn.state.health.lims.systemusermodule.daoimpl.SystemUserModuleDAOImpl;
import us.mn.state.health.lims.systemusermodule.valueholder.PermissionModule;
import us.mn.state.health.lims.systemusermodule.valueholder.RoleModule;
import us.mn.state.health.lims.systemusermodule.valueholder.SystemUserModule;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *  @author     Hung Nguyen (Hung.Nguyen@health.state.mn.us)
 */
public class SystemUserModuleDeleteAction extends BaseAction {
	static private String FWD_CLOSE = "close";

	protected ActionForward performAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String forward = "success";

		DynaActionForm dynaForm = (DynaActionForm) form;

		String[] selectedIDs = (String[]) dynaForm.get("selectedIDs");

		String sysUserId = getSysUserId(request);

		boolean permisionAgentIsUser = SystemConfiguration.getInstance().getPermissionAgent().equals("USER");
		List permissionAgentModules = new ArrayList();

		for (int i = 0; i < selectedIDs.length; i++) {
			PermissionModule permissionAgentModule = permisionAgentIsUser ? new SystemUserModule() : new RoleModule();
			permissionAgentModule.setId(selectedIDs[i]);
			permissionAgentModule.setSysUserId(sysUserId);
			permissionAgentModules.add(permissionAgentModule);
		}
		ActionMessages errors = null;
		try {
			PermissionAgentModuleDAO permissionAgentModuleDAO = permisionAgentIsUser ? new SystemUserModuleDAOImpl() : new RoleModuleDAOImpl();
			permissionAgentModuleDAO.deleteData(permissionAgentModules);
			// initialize the form
			dynaForm.initialize(mapping);
		} catch (LIMSRuntimeException lre) {
    		//bugzilla 2154
			LogEvent.logError("SystemUserModuleDeleteAction","performAction()",lre.toString());
            request.setAttribute(IActionConstants.REQUEST_FAILED, true);
			
			errors = new ActionMessages();
			ActionError error = null;
			if (lre.getException() instanceof org.hibernate.StaleObjectStateException) {
				error = new ActionError("errors.OptimisticLockException", null,	null);
			} else {
				error = new ActionError("errors.DeleteException", null, null);
			}
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			saveErrors(request, errors);
			request.setAttribute(Globals.ERROR_KEY, errors);
			forward = FWD_FAIL;
        }	
		if (forward.equals(FWD_FAIL))
			return mapping.findForward(forward);
			
		if ("true".equalsIgnoreCase(request.getParameter("close"))) {
			forward = FWD_CLOSE;
		}

		request.setAttribute("menuDefinition", "SystemUserModuleMenuDefinition");

		return mapping.findForward(forward);
	}

	protected String getPageTitleKey() {
		return null;
	}

	protected String getPageSubtitleKey() {
		return null;
	}
}
