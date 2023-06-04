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

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.validator.GenericValidator;

import us.mn.state.health.lims.common.action.BaseActionForm;
import us.mn.state.health.lims.common.services.SampleService;
import us.mn.state.health.lims.common.util.ConfigurationProperties;
import us.mn.state.health.lims.common.util.DateUtil;
import us.mn.state.health.lims.common.util.ConfigurationProperties.Property;
import us.mn.state.health.lims.common.util.StringUtil;
import us.mn.state.health.lims.organization.dao.OrganizationDAO;
import us.mn.state.health.lims.organization.daoimpl.OrganizationDAOImpl;
import us.mn.state.health.lims.organization.valueholder.Organization;
import us.mn.state.health.lims.referral.valueholder.Referral;
import us.mn.state.health.lims.referral.valueholder.ReferralReason;
import us.mn.state.health.lims.referral.valueholder.ReferralResult;
import us.mn.state.health.lims.reports.action.implementation.reportBeans.HaitiClinicalPatientData;
import us.mn.state.health.lims.result.valueholder.Result;
import us.mn.state.health.lims.test.valueholder.Test;
/**
 * @author Paul A. Hill (pahill@uw.edu)
 * @since Feb 18, 2011
 */

public class ReferredOutHaitiReport extends HaitiPatientReport implements IReportParameterSetter, IReportCreator {

    private String lowDateStr;
    private String highDateStr;
    private String locationId;
    private DateRange dateRange;

    OrganizationDAO organizationDAO = new OrganizationDAOImpl();
    private Organization reportLocation;

    @Override
    protected String reportFileName(){
    	return "ReferredOutBySite";
    }
    /**
     * @see us.mn.state.health.lims.reports.action.implementation.IReportParameterSetter#setRequestParameters(us.mn.state.health.lims.common.action.BaseActionForm)
     */
    @Override
    public void setRequestParameters(BaseActionForm dynaForm) {
        try {
            List<Organization> list = organizationDAO.getOrganizationsByTypeName("organizationName", "referralLab");
            PropertyUtils.setProperty(dynaForm, "reportName", getReportNameForParameterPage());
            PropertyUtils.setProperty(dynaForm, "useLocationCode", true);
            PropertyUtils.setProperty(dynaForm, "locationCodeList", list);
            PropertyUtils.setProperty(dynaForm, "useLowerDateRange", true);
            PropertyUtils.setProperty(dynaForm, "useUpperDateRange", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @see us.mn.state.health.lims.reports.action.implementation.IReportCreator#initializeReport(us.mn.state.health.lims.common.action.BaseActionForm)
     */
    @Override
    public void initializeReport(BaseActionForm dynaForm) {
        super.initializeReport();
        lowDateStr = dynaForm.getString("lowerDateRange");
        highDateStr = dynaForm.getString("upperDateRange");
        locationId = dynaForm.getString("locationCode");
        dateRange = new DateRange(lowDateStr, highDateStr);
        reportLocation = getValidOrganization(locationId);
        
        errorFound = !validateSubmitParameters();

        createReportParameters();

        if ( errorFound ) {
            return;
        }

        initializeReportItems();
        createReportItems();
        if ( this.reportItems.size() == 0 ) {
            add1LineErrorMessage("report.error.message.noPrintableItems");
        }
        Collections.sort(reportItems, new ReportItemsComparator() );
        return;
    }
    
    static class ReportItemsComparator implements Comparator<HaitiClinicalPatientData>{
        /**
         * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
         * left.get().compareTo(right.get());
         */
        @Override
        public int compare(HaitiClinicalPatientData left, HaitiClinicalPatientData right) {
            int compare = left.getAccessionNumber().compareTo(right.getAccessionNumber());
            if (compare != 0) return compare;
            compare = left.getTestName().compareTo(right.getTestName());
            if (compare != 0) return compare;
            compare = left.getResult().compareTo(right.getResult());
            if (compare != 0) return compare;
            compare = left.getReferralTestName().compareTo(right.getReferralTestName());
            if (compare != 0) return compare;
            compare = left.getReferralResult().compareTo(right.getReferralResult());
            return compare;
        }
    }

    /**
     * check everything
     */
    private boolean validateSubmitParameters() {
        return (dateRange.validateHighLowDate("report.error.message.date.received.missing") && reportLocation != null );
    }

    protected void createReportParameters() {
        super.createReportParameters();
        reportParameters.put("reportPeriod", StringUtil.getMessageForKey("reports.label.referral.title")
             + " " + lowDateStr + " - " + highDateStr);
        reportParameters.put("reportTitle", reportLocation == null ? "" : "Renvoy� �: " + reportLocation.getOrganizationName());
        reportParameters.put("referralSiteName", reportLocation == null ? "" : reportLocation.getOrganizationName());
    	reportParameters.put("directorName", ConfigurationProperties.getInstance().getPropertyValue(Property.labDirectorName));
		reportParameters.put("labName1", StringUtil.getContextualMessageForKey("report.labName.one"));
		reportParameters.put("labName2", StringUtil.getContextualMessageForKey("report.labName.two"));
		reportParameters.put("siteLogo", useLogo ? "HaitiLNSP.jpg" : null );
    }

    @Override
    protected void createReportItems() {
        List<Referral> referrals =  referralDao.getAllReferralsByOrganization(locationId,
        																	  dateRange.getLowDate(),
        		                                                              dateRange.getHighDateAtEndOfDay());
        for (Referral referral : referrals) {
            reportReferral(referral);
        }
    }

    /**
	 * Report the local and the referralResults for the given referral.
	 * 
	 * @param referral
	 */
	private void reportReferral(Referral referral) {
		reportAnalysis = referral.getAnalysis();
		reportSample = referralDao.getReferralById(referral.getId()).getAnalysis().getSampleItem().getSample();
		currentSampleService = new SampleService(reportSample);
		findPatientFromSample();

		List<ReferralResult> referralResults = referralResultDAO.getReferralResultsForReferral(referral.getId());
		for (int i = 0; i < referralResults.size(); i++) {
			// pick up note from 1st of possible multiple results
			String referralNote = getResultNote(referralResults.get(i).getResult());

			i = reportReferralResultValue(referralResults, i);
			ReferralResult referralResult = referralResults.get(i);
			HaitiClinicalPatientData data = reportAnalysisResults();
			data.setReferralSentDate((referral != null && referral.getSentDate() != null) ? DateUtil.formatDateAsText(referral.getSentDate()) : "");
			data.setReferralResult(reportReferralResultValue);
			data.setReferralNote(referralNote);
			String testId = referralResult.getTestId();
			if (!GenericValidator.isBlankOrNull(testId)) {
				Test test = new Test();
				test.setId(testId);
				testDAO.getData(test);
				data.setReferralTestName(test.getReportingDescription());
				
				String uom = getUnitOfMeasure(referralResult.getResult(), test);
				if (reportReferralResultValue != null) {
					data.setReferralResult(addIfNotEmpty(reportReferralResultValue, uom));
				}
				data.setReferralRefRange(addIfNotEmpty(getRange(referralResult.getResult()), uom));
				data.setTestSortOrder(GenericValidator.isBlankOrNull(test.getSortOrder()) ? Integer.MAX_VALUE : Integer.parseInt(test.getSortOrder()));
				data.setSectionSortOrder(reportAnalysis.getTestSection().getSortOrderInt());
				data.setTestSection(reportAnalysis.getTestSection().getLocalizedName());
			}
			Timestamp referralReportDate = referralResult.getReferralReportDate();
			data.setReferralResultReportDate((referralReportDate == null) ? null : DateUtil.formatDateAsText(referralReportDate));
			ReferralReason reason = new ReferralReason();
			reason.setId(referral.getReferralReasonId());
			referralReasonDAO.getData(reason);
			data.setReferralReason(reason.getLocalizedName());

			reportItems.add(data);
		}
	}

    /**
     * @see us.mn.state.health.lims.reports.action.implementation.HaitiPatientReport#getReportNameForParameterPage()
     */
    @Override
    protected String getReportNameForParameterPage() {
        return StringUtil.getMessageForKey("openreports.referredOutHaitiReport");
    }

    public JRDataSource getReportDataSource() throws IllegalStateException {
        if (!initialized) {
            throw new IllegalStateException("initializeReport not called first");
        }

         return errorFound ? new JRBeanCollectionDataSource(errorMsgs) : new JRBeanCollectionDataSource(reportItems);
    }
	@Override
	protected String getSiteLogo() {
		return "labLogo.jpg";
	}
	@Override
	protected void postSampleBuild() {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void setReferredResult(HaitiClinicalPatientData data, Result result) {
		data.setResult(data.getResult() );
	}
}
