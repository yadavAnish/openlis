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
package us.mn.state.health.lims.analyzerimport.action;

import org.apache.struts.Globals;
import org.apache.struts.action.*;
import us.mn.state.health.lims.analyzerimport.action.beans.NamedAnalyzerTestMapping;
import us.mn.state.health.lims.analyzerimport.dao.AnalyzerTestMappingDAO;
import us.mn.state.health.lims.analyzerimport.daoimpl.AnalyzerTestMappingDAOImpl;
import us.mn.state.health.lims.analyzerimport.util.AnalyzerTestNameCache;
import us.mn.state.health.lims.analyzerimport.valueholder.AnalyzerTestMapping;
import us.mn.state.health.lims.common.action.BaseAction;
import us.mn.state.health.lims.common.action.IActionConstants;
import us.mn.state.health.lims.common.exception.LIMSRuntimeException;
import us.mn.state.health.lims.common.util.validator.ActionError;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


public class AnalyzerTestNameDeleteAction extends BaseAction {

	static final private int ANALYZER_NAME = 0;
	static final private int ANALYZER_TEST = 1;


	protected ActionForward performAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String forward = "success";

		DynaActionForm dynaForm = (DynaActionForm) form;

		String[] selectedIDs = (String[]) dynaForm.get("selectedIDs");

		//String sysUserId = getSysUserId(request);
		List<AnalyzerTestMapping> testMappingList = new ArrayList<AnalyzerTestMapping>();

		for (int i = 0; i < selectedIDs.length; i++) {
			String[] ids = selectedIDs[i].split(NamedAnalyzerTestMapping.getUniqueIdSeperator());
			AnalyzerTestMapping testMapping = new AnalyzerTestMapping();
			testMapping.setAnalyzerId(AnalyzerTestNameCache.instance().getAnalyzerIdForName(ids[ANALYZER_NAME]));
			testMapping.setAnalyzerTestName(ids[ANALYZER_TEST]);
			testMappingList.add(testMapping);
		}

		ActionMessages errors = null;
		try {

			AnalyzerTestMappingDAO testMappingDAO = new AnalyzerTestMappingDAOImpl();
			testMappingDAO.deleteData(testMappingList, currentUserId);

		} catch (LIMSRuntimeException lre) {

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

		if (TRUE.equalsIgnoreCase(request.getParameter("close"))) {
			forward = FWD_CLOSE;
		}

		AnalyzerTestNameCache.instance().reloadCache();
		request.setAttribute("menuDefinition", "AnalyzerTestNameDefinition");

		return mapping.findForward(forward);
	}

	protected String getPageTitleKey() {
		return null;
	}

	protected String getPageSubtitleKey() {
		return null;
	}
}
