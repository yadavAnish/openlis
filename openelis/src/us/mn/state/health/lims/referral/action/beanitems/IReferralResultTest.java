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
package us.mn.state.health.lims.referral.action.beanitems;

import org.apache.struts.upload.FormFile;

public interface IReferralResultTest {

	public abstract void setReferredTestId(String referredTestId);

	public abstract String getReferredTestId();

	public abstract String getReferredResult();

	public abstract void setReferredResult(String referredResult);

	public abstract String getReferredResultType();

	public abstract void setReferredResultType(String referredResultType);

	public abstract String getReferredReportDate();

	public abstract void setReferredReportDate(String referredReportDate);

	public abstract String getReferralResultId();

	public abstract void setReferralResultId(String id);
	
	public abstract void setReferredDictionaryResult(String id);
	public abstract String getReferredDictionaryResult();

    public abstract String getReferredMultiDictionaryResult();
    public abstract void setReferredMultiDictionaryResult(String multiResultValue);

    public abstract String getReferralId();
    public abstract void setReferralId(String referralId);

    public abstract boolean isAbnormal();

    public abstract void setAbnormal(boolean abnormal);

    public abstract void setUploadedFileName(String fileName);
    public abstract String getUploadedFileName();
    public abstract FormFile getUploadedFile();
}
