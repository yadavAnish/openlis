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
package us.mn.state.health.lims.referral.dao;

import us.mn.state.health.lims.common.exception.LIMSRuntimeException;
import us.mn.state.health.lims.referral.valueholder.Referral;

import java.sql.Date;
import java.util.List;


public interface ReferralDAO{

	public boolean insertData(Referral referral) throws LIMSRuntimeException;

	public Referral getReferralById(String referralId) throws LIMSRuntimeException;

	public Referral getReferralByAnalysisId(String analysisId) throws LIMSRuntimeException;

	public List<Referral> getAllUncanceledOpenReferrals(int resultPageSize,int resultPageNumber) throws LIMSRuntimeException;

    long getAllUncanceledOpenReferralsCount() throws LIMSRuntimeException;

    public List<Referral> getAllUncanceledOpenReferralsByPatientSTNumber(String patientSTNumber) throws LIMSRuntimeException;

    public void updateData(Referral referral) throws LIMSRuntimeException;

	public List<Referral> getAllReferralsBySampleId(String id) throws LIMSRuntimeException;

    /**
     * @param organizationId - the PK of an organization 
     * @param lowDate  - referral request date low
     * @param highDate - referral request date high
     * @return a list in the of referrals
     */
    public List<Referral> getAllReferralsByOrganization(String organizationId, Date lowDate, Date highDate);
}
