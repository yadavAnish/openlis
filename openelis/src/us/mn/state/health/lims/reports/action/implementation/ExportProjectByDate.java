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
 * Copyright (C) CIRG, University of Washington, Seattle WA.  All Rights Reserved.
 *
 */
package us.mn.state.health.lims.reports.action.implementation;

import static org.apache.commons.validator.GenericValidator.isBlankOrNull;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.validator.GenericValidator;
import org.jfree.util.Log;

import us.mn.state.health.lims.common.action.BaseActionForm;
import us.mn.state.health.lims.common.util.StringUtil;
import us.mn.state.health.lims.project.dao.ProjectDAO;
import us.mn.state.health.lims.project.daoimpl.ProjectDAOImpl;
import us.mn.state.health.lims.project.valueholder.Project;
import us.mn.state.health.lims.reports.action.implementation.reportBeans.ARVFollowupColumnBuilder;
import us.mn.state.health.lims.reports.action.implementation.reportBeans.ARVInitialColumnBuilder;
import us.mn.state.health.lims.reports.action.implementation.reportBeans.CIColumnBuilder;
import us.mn.state.health.lims.reports.action.implementation.reportBeans.CSVColumnBuilder;
import us.mn.state.health.lims.reports.action.implementation.reportBeans.EIDColumnBuilder;
import us.mn.state.health.lims.reports.action.implementation.reportBeans.RTNColumnBuilder;

/**
 * @author Paul A. Hill (pahill@uw.edu)
 * @since Jan 26, 2011
 */
public class ExportProjectByDate extends CSVSampleExportReport implements IReportParameterSetter, IReportCreator {
	protected final ProjectDAO projectDAO = new ProjectDAOImpl();
	private String projectStr;
	private Project project;

	@Override
	protected String errorReportFileName(){
		return CI_ERROR_REPORT;
	}
	
	@Override
	protected String reportFileName(){
		return "ExportProjectByDate";
	}

	public void setRequestParameters(BaseActionForm dynaForm) {
		try {
			PropertyUtils.setProperty(dynaForm, "reportName", getReportNameForParameterPage());
			PropertyUtils.setProperty(dynaForm, "useLowerDateRange", Boolean.TRUE);
			PropertyUtils.setProperty(dynaForm, "useUpperDateRange", Boolean.TRUE);
			PropertyUtils.setProperty(dynaForm, "useProjectCode", Boolean.TRUE);
			PropertyUtils.setProperty(dynaForm, "projectCodeList", getProjectList());
			PropertyUtils.setProperty(dynaForm, "exportOptions", getExportOptions());
		} catch (Exception e) {
			Log.error("Error in ExportProjectByDate.setRequestParemeters: ", e);
		}
	}

	protected String getReportNameForParameterPage() {
		return StringUtil.getMessageForKey("reports.label.project.export") + " "
				+ StringUtil.getContextualMessageForKey("sample.collectionDate");
	}

	protected void createReportParameters() {
		super.createReportParameters();
		reportParameters.put("studyName", (project == null) ? null : project.getLocalizedName());
	}

	public void initializeReport(BaseActionForm dynaForm) {
		super.initializeReport();
		errorFound = false;

		lowDateStr = dynaForm.getString("lowerDateRange");
		highDateStr = dynaForm.getString("upperDateRange");
		projectStr = dynaForm.getString("projectCode");
		dateRange = new DateRange(lowDateStr, highDateStr);
		
		createReportParameters();
		
		errorFound = !validateSubmitParameters();
		if (errorFound) {
			return;
		}
		
		createReportItems();
	}

	/**
	 * check everything
	 */
	private boolean validateSubmitParameters() {
		return dateRange.validateHighLowDate("report.error.message.date.received.missing") && validateProject();
	}

	/**
	 * @return true, if location is not blank or "0" is is found in the DB;
	 *         false otherwise
	 */
	private boolean validateProject() {
		if (isBlankOrNull(projectStr) || "0".equals(Integer.getInteger(projectStr))) {
			add1LineErrorMessage("report.error.message.project.missing");
			return false;
		}
		ProjectDAO dao = new ProjectDAOImpl();
		project = dao.getProjectById(projectStr);
		if (project == null) {
			add1LineErrorMessage("report.error.message.project.missing");
			return false;
		}
		return true;
	}

	/**
	 * creating the list for generation to the report
	 */
	private void createReportItems() {
		try {
			csvColumnBuilder = getColumnBuilder(projectStr);
			csvColumnBuilder.buildDataSource();
		} catch (Exception e) {
			Log.error("Error in " + this.getClass().getSimpleName() + ".createReportItems: ", e);
			add1LineErrorMessage("report.error.message.general.error");
		}
	}

	protected void writeResultsToBuffer(ByteArrayOutputStream buffer) throws Exception, IOException, UnsupportedEncodingException {
	
		String currentAccessionNumber = null;
		String[] splitBase = null;
		while (csvColumnBuilder.next()) {
			String line = csvColumnBuilder.nextLine();
			String[] splitLine = line.split(",");

			if (splitLine[0].equals(currentAccessionNumber)) {
				merge( splitBase, splitLine);
			} else {
				if (currentAccessionNumber != null) {
					writeConsolidatedBaseToBuffer(buffer, splitBase);
				}
				splitBase = splitLine;
				currentAccessionNumber = splitBase[0];
			}
		}
		
		writeConsolidatedBaseToBuffer(buffer, splitBase);
	}

	private void merge(String[] base, String[] line) {
		for( int i = 0; i < base.length; ++i){
			if( GenericValidator.isBlankOrNull(base[i])){
				base[i] = line[i];
			}
		}
	}

	protected void writeConsolidatedBaseToBuffer(ByteArrayOutputStream buffer, String[] splitBase) throws IOException,
			UnsupportedEncodingException {

		if (splitBase != null) {
			StringBuffer consolidatedLine = new StringBuffer();
			for (String value : splitBase) {
				consolidatedLine.append(value);
				consolidatedLine.append(",");
			}

			consolidatedLine.deleteCharAt(consolidatedLine.lastIndexOf(","));
			buffer.write(consolidatedLine.toString().getBytes("windows-1252"));
		}
	}

	private CSVColumnBuilder getColumnBuilder(String projectId) {
		String projectTag = CIColumnBuilder.translateProjectId(projectId);
		if (projectTag.equals("ARVB")) {
			return new ARVInitialColumnBuilder(dateRange, projectStr);
		} else if (projectTag.equals("ARVS")) {
			return new ARVFollowupColumnBuilder(dateRange, projectStr);
		} else if (projectTag.equalsIgnoreCase("DBS")) {
			return new EIDColumnBuilder(dateRange, projectStr);
		} else if (projectTag.equalsIgnoreCase("RTN")) {
			return new RTNColumnBuilder(dateRange, projectStr);
		} else if (projectTag.equalsIgnoreCase("IND")) {
			return new RTNColumnBuilder(dateRange, projectStr);
		}
		throw new IllegalArgumentException();
	}

	/**
	 * @return a list of the correct projects for display
	 */
	protected List<Project> getProjectList() {
		List<Project> projects = new ArrayList<Project>();
		Project project = new Project();
		project.setProjectName("Antiretroviral Study");
		projects.add(projectDAO.getProjectByName(project, false, false));
		project.setProjectName("Antiretroviral Followup Study");
		projects.add(projectDAO.getProjectByName(project, false, false));
		project.setProjectName("Routine HIV Testing");
		projects.add(projectDAO.getProjectByName(project, false, false));
		project.setProjectName("Early Infant Diagnosis for HIV Study");
		projects.add(projectDAO.getProjectByName(project, false, false));
		project.setProjectName("Indeterminate Results");
		projects.add(projectDAO.getProjectByName(project, false, false));
		return projects;
	}
}
