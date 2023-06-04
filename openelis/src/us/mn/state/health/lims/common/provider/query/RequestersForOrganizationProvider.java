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
package us.mn.state.health.lims.common.provider.query;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import us.mn.state.health.lims.common.servlet.validation.AjaxServlet;
import us.mn.state.health.lims.common.util.StringUtil;
import us.mn.state.health.lims.organization.dao.OrganizationContactDAO;
import us.mn.state.health.lims.organization.daoimpl.OrganizationContactDAOImpl;
import us.mn.state.health.lims.organization.valueholder.OrganizationContact;
import us.mn.state.health.lims.person.valueholder.Person;

public class RequestersForOrganizationProvider extends BaseQueryProvider {


	private static OrganizationContactDAO orgContactDAO = new OrganizationContactDAOImpl();
	protected AjaxServlet ajaxServlet = null;

	@Override
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String orgId = request.getParameter("orgId");

		StringBuilder xml = new StringBuilder();

		createXMLOfRequesters(orgId, xml);

		ajaxServlet.sendData(xml.toString(), VALID, request, response);

	}

	private void createXMLOfRequesters(String orgId, StringBuilder xml) {
		List<OrganizationContact> orgContactList = orgContactDAO.getListForOrganizationId(orgId);
		xml.append("<requesters>");
		for( OrganizationContact orgContact : orgContactList){
			createXMLOfRequester( orgContact.getPerson(), xml);
		}
		xml.append("</requesters>");
	}

	private void createXMLOfRequester(Person person, StringBuilder xml) {
		xml.append("<requester ");

		xml.append("id=\"");
		xml.append( StringUtil.trim(person.getId()));
		xml.append("\" ");

		xml.append("firstName=\"");
		xml.append( StringUtil.trim(person.getFirstName()));
		xml.append("\" ");

		xml.append("lastName=\"");
		xml.append( StringUtil.trim(person.getLastName()));
		xml.append("\" ");

		xml.append("phone=\"");
		xml.append( StringUtil.trim(person.getWorkPhone()));
		xml.append("\" ");

		xml.append("fax=\"");
		xml.append( StringUtil.trim(person.getFax()));
		xml.append("\" ");

		xml.append("email=\"");
		xml.append( StringUtil.trim(person.getEmail()));
		xml.append("\" ");

		xml.append(" />");
	}

	@Override
	public void setServlet(AjaxServlet as) {
		this.ajaxServlet = as;
	}

	@Override
	public AjaxServlet getServlet() {
		return this.ajaxServlet;
	}

}
