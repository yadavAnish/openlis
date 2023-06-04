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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import us.mn.state.health.lims.common.action.BaseAction;

/**
 * The QuickEntryCancelAction class represents the cancel 
 * Action for the QuickEntry form of the application.
 * 
 * @author	- Ken Rosha		08/29/2006
 */
public class QuickEntryCancelAction
	extends BaseAction 
{

	protected ActionForward performAction(ActionMapping mapping,
										  ActionForm form, 
										  HttpServletRequest request,
										  HttpServletResponse response) 
		throws Exception 
	{
		HttpSession session = request.getSession();
		session.removeAttribute("selectedTestIds");
		
		request.setAttribute("menuDefinition", DEFAULT);
		return mapping.findForward(FWD_CLOSE);
	}
	//==============================================================

	protected String getPageTitleKey()
	{
	    return "quick.entry.edit.title";
	}
	//==============================================================

	protected String getPageSubtitleKey() 
	{
	    return "quick.entry.edit.title";
	}
	//==============================================================
}
