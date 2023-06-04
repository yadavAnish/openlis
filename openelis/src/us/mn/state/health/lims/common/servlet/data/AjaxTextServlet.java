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
package us.mn.state.health.lims.common.servlet.data;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import us.mn.state.health.lims.common.provider.data.BaseDataProvider;
import us.mn.state.health.lims.common.provider.data.DataProviderFactory;
import us.mn.state.health.lims.common.util.StringUtil;

/**
 * @author diane benz
 * bugzilla 2443
 */
public class AjaxTextServlet extends AjaxServlet {

	public void sendData(String field, String message,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		if (!StringUtil.isNullorNill(field)
				&& !StringUtil.isNullorNill(message)) {
			response.setContentType("text/plain");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write(message);
		} else {
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);

		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String dataProvider = request.getParameter("provider");
		BaseDataProvider provider = (BaseDataProvider) DataProviderFactory
				.getInstance().getDataProvider(dataProvider);
		provider.setServlet(this);
		provider.processRequest(request, response);
	}

}
