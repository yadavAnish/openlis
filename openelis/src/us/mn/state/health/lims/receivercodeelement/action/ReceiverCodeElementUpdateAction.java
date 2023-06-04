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
package us.mn.state.health.lims.receivercodeelement.action;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.Globals;
import org.apache.struts.action.*;
import us.mn.state.health.lims.codeelementtype.dao.CodeElementTypeDAO;
import us.mn.state.health.lims.codeelementtype.daoimpl.CodeElementTypeDAOImpl;
import us.mn.state.health.lims.codeelementtype.valueholder.CodeElementType;
import us.mn.state.health.lims.common.action.BaseAction;
import us.mn.state.health.lims.common.action.BaseActionForm;
import us.mn.state.health.lims.common.action.IActionConstants;
import us.mn.state.health.lims.common.exception.LIMSDuplicateRecordException;
import us.mn.state.health.lims.common.exception.LIMSRuntimeException;
import us.mn.state.health.lims.common.log.LogEvent;
import us.mn.state.health.lims.common.util.StringUtil;
import us.mn.state.health.lims.common.util.resources.ResourceLocator;
import us.mn.state.health.lims.common.util.validator.ActionError;
import us.mn.state.health.lims.login.valueholder.UserSessionData;
import us.mn.state.health.lims.messageorganization.dao.MessageOrganizationDAO;
import us.mn.state.health.lims.messageorganization.daoimpl.MessageOrganizationDAOImpl;
import us.mn.state.health.lims.messageorganization.valueholder.MessageOrganization;
import us.mn.state.health.lims.receivercodeelement.dao.ReceiverCodeElementDAO;
import us.mn.state.health.lims.receivercodeelement.daoimpl.ReceiverCodeElementDAOImpl;
import us.mn.state.health.lims.receivercodeelement.valueholder.ReceiverCodeElement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author diane benz
 * 
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates. To enable and disable the creation of type
 * comments go to Window>Preferences>Java>Code Generation.
 */
public class ReceiverCodeElementUpdateAction extends BaseAction {
	
	private boolean isNew = false;

	protected ActionForward performAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// The first job is to determine if we are coming to this action with an
		// ID parameter in the request. If there is no parameter, we are
		// creating a new ReceiverCodeElement.
		// If there is a parameter present, we should bring up an existing
		// ReceiverCodeElement to edit.

		String forward = FWD_SUCCESS;
		request.setAttribute(ALLOW_EDITS_KEY, "true");
		request.setAttribute(PREVIOUS_DISABLED, "false");
		request.setAttribute(NEXT_DISABLED, "false");
		
		String id = request.getParameter(ID);
		
		if (StringUtil.isNullorNill(id) || "0".equals(id)) {
			isNew = true;
		} else {
			isNew = false;
		}

		BaseActionForm dynaForm = (BaseActionForm) form;

		// server-side validation (validation.xml)
		ActionMessages errors = dynaForm.validate(mapping, request);		
		if (errors != null && errors.size() > 0) {
			// System.out.println("Server side validation errors "
			// + errors.toString());
			saveErrors(request, errors);
			// since we forward to jsp - not Action we don't need to repopulate
			// the lists here
			return mapping.findForward(FWD_FAIL);
		}

		String start = (String) request.getParameter("startingRecNo");
		String direction = (String) request.getParameter("direction");

		// System.out.println("This is ID from request " + id);
		ReceiverCodeElement receiverCodeElement = new ReceiverCodeElement();
		//get sysUserId from login module
		UserSessionData usd = (UserSessionData)request.getSession().getAttribute(USER_SESSION_DATA);
		String sysUserId = String.valueOf(usd.getSystemUserId());	
		receiverCodeElement.setSysUserId(sysUserId);

		// populate valueholder from form
		PropertyUtils.copyProperties(receiverCodeElement, dynaForm);

		// get messageOrganization valueholder to be set in receiverCodeElement
		String messageOrganizationId = (String) dynaForm.get("selectedMessageOrganizationId");
		List messageOrganizations = new ArrayList();
		if (dynaForm.get("messageOrganizations") != null) {
			messageOrganizations = (List) dynaForm.get("messageOrganizations");
		} else {
			MessageOrganizationDAO messageOrganizationDAO = new MessageOrganizationDAOImpl();
			messageOrganizations = messageOrganizationDAO.getAllMessageOrganizations();
		}
		MessageOrganization messageOrganization = null;
		for (int i = 0; i < messageOrganizations.size(); i++) {
			MessageOrganization refTbl = (MessageOrganization) messageOrganizations.get(i);
			if (refTbl.getId().equals(messageOrganizationId)) {
				messageOrganization = refTbl;
				break;
			}
		}
		receiverCodeElement.setMessageOrganization(messageOrganization);
		
		
		// get codeElementType valueholder to be set in codeElementXref
		String codeElementTypeId = (String) dynaForm.get("selectedCodeElementTypeId");
		List codeElementTypes = new ArrayList();
		if (dynaForm.get("codeElementTypes") != null) {
			codeElementTypes = (List) dynaForm.get("codeElementTypes");
		} else {
			CodeElementTypeDAO codeElementTypeDAO = new CodeElementTypeDAOImpl();
			codeElementTypes = codeElementTypeDAO.getAllCodeElementTypes();
		}
		CodeElementType codeElementType = null;
		for (int i = 0; i < codeElementTypes.size(); i++) {
			CodeElementType cet = (CodeElementType) codeElementTypes.get(i);
			if (cet.getId().equals(codeElementTypeId)) {
				codeElementType = cet;
				break;
			}
		}
		receiverCodeElement.setCodeElementType(codeElementType);
		

		try {

			ReceiverCodeElementDAO receiverCodeElementDAO = new ReceiverCodeElementDAOImpl();

			if (!isNew) {
				// UPDATE

				receiverCodeElementDAO.updateData(receiverCodeElement);

			} else {
				// INSERT

				receiverCodeElementDAO.insertData(receiverCodeElement);
			}
		} catch (LIMSRuntimeException lre) {
    		//bugzilla 2154
			LogEvent.logError("ReceiverCodeElementDeleteAction","performAction()",lre.toString());
            request.setAttribute(IActionConstants.REQUEST_FAILED, true);
			errors = new ActionMessages();
			java.util.Locale locale = (java.util.Locale) request.getSession()
			.getAttribute("org.apache.struts.action.LOCALE");
			ActionError error = null;
			if (lre.getException() instanceof org.hibernate.StaleObjectStateException) {
				// how can I get popup instead of struts error at the top of
				// page?
				// ActionMessages errors = dynaForm.validate(mapping, request);
				error = new ActionError("errors.OptimisticLockException", null,
						null);

			} else {
				// bugzilla 1482
				if (lre.getException() instanceof LIMSDuplicateRecordException) {
					String messageKey = "receiverCodeElement.receiverCodeElement";
					String msg = ResourceLocator.getInstance()
							.getMessageResources().getMessage(locale,
									messageKey);
					error = new ActionError("errors.DuplicateRecord",
							msg, null);

				} else {
					error = new ActionError("errors.UpdateException", null,
							null);
				}
			}

			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			saveErrors(request, errors);
			request.setAttribute(Globals.ERROR_KEY, errors);
			//bugzilla 1485: allow change and try updating again (enable save button)
			//request.setAttribute(IActionConstants.ALLOW_EDITS_KEY, "false");
			// disable previous and next
			request.setAttribute(PREVIOUS_DISABLED, "true");
			request.setAttribute(NEXT_DISABLED, "true");
			forward = FWD_FAIL;
        }
		if (forward.equals(FWD_FAIL))
			return mapping.findForward(forward);

		// initialize the form
		dynaForm.initialize(mapping);
		// repopulate the form from valueholder
		PropertyUtils.copyProperties(dynaForm, receiverCodeElement);

		if ("true".equalsIgnoreCase(request.getParameter("close"))) {
			forward = FWD_CLOSE;
		}

		if (receiverCodeElement.getId() != null && !receiverCodeElement.getId().equals("0")) {
			request.setAttribute(ID, receiverCodeElement.getId());

		}

		//bugzilla 1400
		if (isNew) forward = FWD_SUCCESS_INSERT;
		//bugzilla 1467 added direction for redirect to NextPreviousAction
		return getForward(mapping.findForward(forward), receiverCodeElement.getId(), start, direction, messageOrganizationId, codeElementTypeId);

	}

	protected String getPageTitleKey() {
		if (isNew) {
			return "receivercodeelement.add.title";
		} else {
			return "receivercodeelement.edit.title";
		}
	}

	protected String getPageSubtitleKey() {
		if (isNew) {
			return "receivercodeelement.add.title";
		} else {
			return "receivercodeelement.edit.title";
		}
	}
	
	//added for bugzilla 1467
	protected ActionForward getForward(ActionForward forward, String id,
			String startingRecNo, String direction, String selectedMessageOrganizationId, String selectedCodeElementTypeId) {
		ActionRedirect redirect = new ActionRedirect(forward);
		//System.out.println("This is forward " + forward.getRedirect() + " "
		//		+ forward.getPath());

		if (id != null)
			redirect.addParameter(ID, id);
		if (startingRecNo != null)
			redirect.addParameter("startingRecNo", startingRecNo);
		if (direction != null)
			redirect.addParameter("direction", direction);
		if (selectedMessageOrganizationId != null)
			redirect.addParameter("selectedMessageOrganizationId", selectedMessageOrganizationId);
		if (selectedCodeElementTypeId != null)
			redirect.addParameter("selectedCodeElementTypeId", selectedCodeElementTypeId);
		//System.out.println("This is redirect " + redirect.getPath());
		return redirect;
	}

}
