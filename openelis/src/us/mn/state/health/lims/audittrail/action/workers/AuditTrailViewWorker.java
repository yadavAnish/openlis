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
package us.mn.state.health.lims.audittrail.action.workers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.validator.GenericValidator;

import us.mn.state.health.lims.analysis.dao.AnalysisDAO;
import us.mn.state.health.lims.analysis.daoimpl.AnalysisDAOImpl;
import us.mn.state.health.lims.analysis.valueholder.Analysis;
import us.mn.state.health.lims.common.services.historyservices.AnalysisHistoryService;
import us.mn.state.health.lims.common.services.historyservices.HistoryService;
import us.mn.state.health.lims.common.services.historyservices.NoteHistoryService;
import us.mn.state.health.lims.common.services.historyservices.OrderHistoryService;
import us.mn.state.health.lims.common.services.historyservices.PatientHistoryHistoryService;
import us.mn.state.health.lims.common.services.historyservices.PatientHistoryService;
import us.mn.state.health.lims.common.services.historyservices.QaHistoryService;
import us.mn.state.health.lims.common.services.historyservices.ReportHistoryService;
import us.mn.state.health.lims.common.services.historyservices.ResultHistoryService;
import us.mn.state.health.lims.common.services.historyservices.SampleHistoryService;
import us.mn.state.health.lims.common.util.StringUtil;
import us.mn.state.health.lims.patient.util.PatientUtil;
import us.mn.state.health.lims.patient.valueholder.Patient;
import us.mn.state.health.lims.result.dao.ResultDAO;
import us.mn.state.health.lims.result.daoimpl.ResultDAOImpl;
import us.mn.state.health.lims.result.valueholder.Result;
import us.mn.state.health.lims.sample.daoimpl.SampleDAOImpl;
import us.mn.state.health.lims.sample.valueholder.Sample;

public class AuditTrailViewWorker {

	private AnalysisDAO analysisDAO = new AnalysisDAOImpl();
	private ResultDAO resultDAO = new ResultDAOImpl();
	private String accessionNumber = null;
	private Sample sample;


	public AuditTrailViewWorker(String accessionNumber) {
		this.accessionNumber = accessionNumber;
		sample = null;
	}

	public List<AuditTrailItem> getAuditTrail() throws IllegalStateException {
		if (GenericValidator.isBlankOrNull(accessionNumber)) {
			throw new IllegalStateException("AuditTrialViewWorker is not iniitialized");
		}

		if( sample == null ){
			sample = new SampleDAOImpl().getSampleByAccessionNumber(accessionNumber);
		}
		
		List<AuditTrailItem> items = new ArrayList<AuditTrailItem>();

		if (sample != null) {
			items.addAll(addOrders());	
			items.addAll(addSamples());	
			items.addAll(addTestsAndResults());
			items.addAll(addReports());
			items.addAll(addPatientHistory());
			items.addAll(addNotes());
			items.addAll(addQAEvents());
		}
		
		sortItemsByTime(items);
		return items;
	}

	
	public List<AuditTrailItem> getPatientHistoryAuditTrail() throws IllegalStateException{
		if (GenericValidator.isBlankOrNull(accessionNumber)) {
			throw new IllegalStateException("AuditTrialViewWirker is not iniitialized");
		}

		if( sample == null ){
			sample = new SampleDAOImpl().getSampleByAccessionNumber(accessionNumber);
		}
		
		List<AuditTrailItem> items = new ArrayList<AuditTrailItem>();

		if (sample != null) {
			items.addAll(addPatientHistory());
		}
		return items;

	}
	
	
	

	private Collection<AuditTrailItem> addReports() {
		List<AuditTrailItem> items = new ArrayList<AuditTrailItem>();
		
		if (sample != null) {
			HistoryService historyService = new ReportHistoryService(sample);
			items.addAll(historyService.getAuditTrailItems());

			//sortItemsByTime(items);
		}
		
		for( AuditTrailItem auditTrailItem : items){
			auditTrailItem.setClassName("reportAudit");
			setAttributeNewIfInsert(auditTrailItem);
		}
		return items;
	}

	private Collection<AuditTrailItem> addSamples() {
		List<AuditTrailItem> sampleItems = new ArrayList<AuditTrailItem>();
		if (sample != null) {
			HistoryService historyService = new SampleHistoryService(sample);
			sampleItems.addAll(historyService.getAuditTrailItems());

			//sortItems(sampleItems);
			
			for( AuditTrailItem auditTrailItem : sampleItems){
				auditTrailItem.setClassName("sampleAudit");
				setAttributeNewIfInsert(auditTrailItem);
			}
		}
		
		return sampleItems;
	}

	private Collection<AuditTrailItem> addOrders() {
		List<AuditTrailItem> orderItems = new ArrayList<AuditTrailItem>();
		if (sample != null) {
			HistoryService historyService = new OrderHistoryService(sample);
			orderItems.addAll(historyService.getAuditTrailItems());

			//sortItems(orderItems);
			
			for( AuditTrailItem auditTrailItem : orderItems){
				auditTrailItem.setClassName("orderAudit");
				setAttributeNewIfInsert(auditTrailItem);
			}
		}
		
		return orderItems;
	}

	private void setAttributeNewIfInsert(AuditTrailItem auditTrailItem) {
		if( auditTrailItem.getAction().equals("I")){
			auditTrailItem.setAttribute(StringUtil.getMessageForKey("auditTrail.action.new"));
		}
	}
	@SuppressWarnings("unchecked")
	private List<AuditTrailItem> addTestsAndResults() {
		List<AuditTrailItem> items = new ArrayList<AuditTrailItem>();

		List<Analysis> analysisList = analysisDAO.getAnalysesBySampleId(sample.getId());

		for (Analysis analysis : analysisList) {
			List<Result> resultList = resultDAO.getResultsByAnalysis(analysis);
			HistoryService historyService = new AnalysisHistoryService(analysis);
			List<AuditTrailItem> resultItems = historyService.getAuditTrailItems();
			items.addAll(resultItems);
			
			for (Result result : resultList) {
				historyService = new ResultHistoryService(result, analysis);
				resultItems = historyService.getAuditTrailItems();
				
				items.addAll(resultItems);
			}
		}

		//sortItems(items);
		for( AuditTrailItem auditTrailItem : items){
			auditTrailItem.setClassName("testResultAudit");
			setAttributeNewIfInsert(auditTrailItem);
		}
		return items;
	}

	private Collection<AuditTrailItem> addPatientHistory() {	
		List<AuditTrailItem> items = new ArrayList<AuditTrailItem>();
		Patient patient = PatientUtil.getPatientForSample(sample);
		
		HistoryService historyService = new PatientHistoryService(patient);
		items.addAll(historyService.getAuditTrailItems());
		
//		historyService = new HistoryService(sample, HistoryType.PERSON);
//		items.addAll(historyService.getAuditTrailItems());
		
		historyService = new PatientHistoryHistoryService(sample);
		items.addAll(historyService.getAuditTrailItems());
		
		//sortItems(items);
		
		for( AuditTrailItem auditTrailItem : items){
			auditTrailItem.setClassName("patientHistoryAudit");
			setAttributeNewIfInsert(auditTrailItem);
		}

		return items;
	}
	
	private Collection<AuditTrailItem> addNotes() {
		List<AuditTrailItem> notes = new ArrayList<AuditTrailItem>();
		if (sample != null) {
			HistoryService historyService = new NoteHistoryService(sample);
			notes.addAll(historyService.getAuditTrailItems());

			//sortItems(notes);
			
			for( AuditTrailItem auditTrailItem : notes){
				auditTrailItem.setClassName("noteAudit");
				setAttributeNewIfInsert(auditTrailItem);
			}
		}
		
		return notes;
	}
	
	private Collection<AuditTrailItem> addQAEvents() {
		List<AuditTrailItem> qaEvents = new ArrayList<AuditTrailItem>();
		if (sample != null) {
			QaHistoryService qaService = new QaHistoryService(sample);
			qaEvents = qaService.getAuditTrailItems();
			
			for( AuditTrailItem auditTrailItem : qaEvents){
				auditTrailItem.setClassName("qaEvent");
				setAttributeNewIfInsert(auditTrailItem);
			}
		}
		
		return qaEvents;
	}

	private void sortItems(List<AuditTrailItem> items) {
		Collections.sort(items, new Comparator<AuditTrailItem>() {
			@Override
			public int compare(AuditTrailItem o1, AuditTrailItem o2) {
				int sort = o1.getIdentifier().compareTo(o2.getIdentifier());
				if (sort != 0) {
					return sort;
				}

				sort = o1.getTimeStamp().compareTo(o2.getTimeStamp());
				if (sort != 0) {
					return sort;
				}
				
				return o1.getAction().compareTo(o2.getAction());
			}
		});
	}
	
	private void sortItemsByTime(List<AuditTrailItem> items) {
		Collections.sort(items, new Comparator<AuditTrailItem>() {
			@Override
			public int compare(AuditTrailItem o1, AuditTrailItem o2) {
				return o1.getTimeStamp().compareTo(o2.getTimeStamp());
			}
		});
	}

}
