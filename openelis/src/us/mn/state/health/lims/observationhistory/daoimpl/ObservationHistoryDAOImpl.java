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

package us.mn.state.health.lims.observationhistory.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import us.mn.state.health.lims.common.daoimpl.GenericDAOImpl;
import us.mn.state.health.lims.common.exception.LIMSRuntimeException;
import us.mn.state.health.lims.hibernate.HibernateUtil;
import us.mn.state.health.lims.observationhistory.dao.ObservationHistoryDAO;
import us.mn.state.health.lims.observationhistory.valueholder.ObservationHistory;
import us.mn.state.health.lims.patient.valueholder.Patient;
import us.mn.state.health.lims.sample.valueholder.Sample;

public class ObservationHistoryDAOImpl extends GenericDAOImpl<String, ObservationHistory> implements ObservationHistoryDAO {

	public ObservationHistoryDAOImpl() {
		super(ObservationHistory.class, "observation_history");
	}


	public void delete(List<ObservationHistory> entities)
			throws LIMSRuntimeException {
		delete(entities, new ObservationHistory());
	}


	public List<ObservationHistory> getAll(Patient patient, Sample sample) {
		ObservationHistory dh = new ObservationHistory();
		dh.setPatientId(patient.getId());
		dh.setSampleId(sample.getId());
		return this.readByExample(dh);
	}

	public List<ObservationHistory> getAll(Patient patient, Sample sample, String observationHistoryTypeId) {
	    ObservationHistory history = new ObservationHistory();
	    if (patient != null) {
	        history.setPatientId(patient.getId());
	    }
	    if (sample != null) {
	        history.setSampleId(sample.getId());
	    }
	    history.setObservationHistoryTypeId(observationHistoryTypeId);
	    return this.readByExample(history);
	}


	@SuppressWarnings("unchecked")
	public List<ObservationHistory> getObservationHistoryByDictonaryValues(String dictionaryValue) throws LIMSRuntimeException {
		List<ObservationHistory> observationList;
		String sql = "From ObservationHistory oh where oh.valueType = 'D' and oh.value = :value";

		try {

			Query query = HibernateUtil.getSession().createQuery(sql);
			query.setParameter("value", dictionaryValue);

			observationList = query.list();

			closeSession();
			return observationList;
		} catch (Exception e) {
			handleException(e, "getObservationHistoryByDictonaryValues");
		}

		return null;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<ObservationHistory> getObservationHistoriesBySampleItemId(String sampleItemId) throws LIMSRuntimeException {
		String sql = "from ObservationHistory oh where oh.sampleItemId = :sampleItemId";

		try{
			Query query = HibernateUtil.getSession().createQuery(sql);
			query.setInteger("sampleItemId", Integer.parseInt(sampleItemId));

			List<ObservationHistory> observationList = query.list();

			closeSession();

			return observationList;
		}catch( HibernateException e){
			handleException(e, "getObservationHistoriesBySampleItemId");
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ObservationHistory> getObservationHistoriesBySampleId(String sampleId) throws LIMSRuntimeException {
		String sql = "from ObservationHistory oh where oh.sampleId = :sampleId";

		try{
			Query query = HibernateUtil.getSession().createQuery(sql);
			query.setInteger("sampleId", Integer.parseInt(sampleId));

			List<ObservationHistory> observationList = query.list();

			closeSession();

			return observationList;
		}catch( HibernateException e){
			handleException(e, "getObservationHistoriesBySampleId");
		}
		return null;
	}

	

	@Override
	public ObservationHistory getObservationHistoriesBySampleIdAndType(String sampleId, String observationHistoryTypeId)
			throws LIMSRuntimeException {
		
		String sql = "from ObservationHistory oh where oh.sampleId = :sampleId and oh.observationHistoryTypeId = :ohTypeId";
		
		try{
			Query query = HibernateUtil.getSession().createQuery(sql);
			query.setInteger("sampleId", Integer.parseInt(sampleId));
			query.setInteger("ohTypeId", Integer.parseInt(observationHistoryTypeId));
			
			ObservationHistory oh = (ObservationHistory)query.setMaxResults(1).uniqueResult();
			
			closeSession();
			
			return oh;
		}catch(HibernateException e){
			handleException(e, "getObservationHistoriesBySampleIdAndType");
		}
		
		return null;
	}
}
