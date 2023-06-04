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
package us.mn.state.health.lims.statusofsample.util;

import java.util.Map;

import us.mn.state.health.lims.analysis.valueholder.Analysis;
import us.mn.state.health.lims.statusofsample.util.StatusOfSampleUtil.AnalysisStatus;
import us.mn.state.health.lims.statusofsample.util.StatusOfSampleUtil.RecordStatus;
import us.mn.state.health.lims.statusofsample.util.StatusOfSampleUtil.OrderStatus;

public class StatusSet {

	private OrderStatus sampleStatus;
	private Map<Analysis, AnalysisStatus> analysisStatus;
	private RecordStatus sampleRecordStatus;
	private RecordStatus patientRecordStatus;
	
	private String    patientId;
	private String    sampleId;

	public OrderStatus getSampleStatus() {
		return sampleStatus;
	}
	public void setSampleStatus(OrderStatus sampleStatus) {
		this.sampleStatus = sampleStatus;
	}
	public Map<Analysis, AnalysisStatus> getAnalysisStatus() {
		return analysisStatus;
	}
	public void setAnalysisStatus(Map<Analysis, AnalysisStatus> analysisStatus) {
		this.analysisStatus = analysisStatus;
	}
	public RecordStatus getSampleRecordStatus() {
		return sampleRecordStatus;
	}
	public void setSampleRecordStatus(RecordStatus sampleEntryStatus) {
		this.sampleRecordStatus = sampleEntryStatus;
	}
	public RecordStatus getPatientRecordStatus() {
		return patientRecordStatus;
	}
	public void setPatientRecordStatus(RecordStatus patientEntryStatus) {
		this.patientRecordStatus = patientEntryStatus;
	}
    public String getPatientId() {
        return patientId;
    }
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
    public String getSampleId() {
        return sampleId;
    }
    public void setSampleId(String sampleId) {
        this.sampleId = sampleId;
    }
}
