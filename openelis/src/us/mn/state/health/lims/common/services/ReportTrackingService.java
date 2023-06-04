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
 * Copyright (C) ITECH, University of Washington, Seattle WA.  All Rights Reserved.
 *
 */
package us.mn.state.health.lims.common.services;

import us.mn.state.health.lims.common.util.DateUtil;
import us.mn.state.health.lims.referencetables.daoimpl.ReferenceTablesDAOImpl;
import us.mn.state.health.lims.reports.dao.DocumentTrackDAO;
import us.mn.state.health.lims.reports.daoimpl.DocumentTrackDAOImpl;
import us.mn.state.health.lims.reports.daoimpl.DocumentTypeDAOImpl;
import us.mn.state.health.lims.reports.valueholder.DocumentTrack;
import us.mn.state.health.lims.reports.valueholder.DocumentType;
import us.mn.state.health.lims.sample.valueholder.Sample;

import java.util.List;

public class ReportTrackingService {
	private static DocumentTrackDAO docTrackDAO = new DocumentTrackDAOImpl();
	private static String PATIENT_DOCUMENT_TYPE_ID = null;
	public enum ReportType {
		PATIENT
	}

	static{
		DocumentType patient = new DocumentTypeDAOImpl().getDocumentTypeByName("patientReport");
		if( patient != null){
			PATIENT_DOCUMENT_TYPE_ID  = patient.getId();
		}
	}	
	public void addReports(List<String> refIds, ReportType type, String name, String currentSystemUserId) {
        String refTableId = getReferenceTable(type);
        DocumentTrackDAO rtDAO = new DocumentTrackDAOImpl();

        for (String id : refIds) {
            DocumentTrack docTrack = new DocumentTrack();
            docTrack.setDocumentTypeId(getReportTypeId(type));
            docTrack.setRecordId(id);
            docTrack.setReportTime(DateUtil.getNowAsTimestamp());
            docTrack.setDocumentName(name);
            docTrack.setTableId(refTableId);
            docTrack.setSysUserId(currentSystemUserId);
            DocumentTrack parent = getParent(id, refTableId, docTrack.getDocumentTypeId());
            if (parent != null) {
                docTrack.setParent(parent);
            }
            rtDAO.insertData(docTrack);

        }
    }

	private DocumentTrack getParent(String id, String refTableId, String documentTypeId) {
		List<DocumentTrack> docs = docTrackDAO.getByTypeRecordAndTable(documentTypeId, refTableId, id);
		return docs.isEmpty() ? null : docs.get(docs.size() - 1);
	}

	private String getReferenceTable(ReportType type) {
		switch (type) {
		case PATIENT: {
			return new ReferenceTablesDAOImpl().getReferenceTableByName("SAMPLE").getId();
		}
		}

		return null;
	}

	private String getReportTypeId(ReportType type) {
		switch (type) {
		case PATIENT: {
			return PATIENT_DOCUMENT_TYPE_ID;
		}
		}

		return null;
	}

	public List<DocumentTrack> getReportsForSample(Sample sample,  ReportType type) {
		return docTrackDAO.getByTypeRecordAndTable(getReportTypeId(type), getReferenceTable(type), sample.getId());
	}
	
	public DocumentTrack getDocumentForId(String id){
		return docTrackDAO.readEntity(id);
	}
}
