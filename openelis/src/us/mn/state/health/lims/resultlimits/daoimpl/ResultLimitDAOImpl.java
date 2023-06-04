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
package us.mn.state.health.lims.resultlimits.daoimpl;

import java.util.List;
import java.util.Vector;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.validator.GenericValidator;

import org.hibernate.Query;
import us.mn.state.health.lims.audittrail.dao.AuditTrailDAO;
import us.mn.state.health.lims.audittrail.daoimpl.AuditTrailDAOImpl;
import us.mn.state.health.lims.common.action.IActionConstants;
import us.mn.state.health.lims.common.daoimpl.BaseDAOImpl;
import us.mn.state.health.lims.common.exception.LIMSRuntimeException;
import us.mn.state.health.lims.common.log.LogEvent;
import us.mn.state.health.lims.common.util.SystemConfiguration;
import us.mn.state.health.lims.hibernate.HibernateUtil;
import us.mn.state.health.lims.resultlimits.dao.ResultLimitDAO;
import us.mn.state.health.lims.resultlimits.valueholder.ResultLimit;
import us.mn.state.health.lims.test.valueholder.Test;

public class ResultLimitDAOImpl extends BaseDAOImpl implements ResultLimitDAO {

	public void deleteData(List resultLimits) throws LIMSRuntimeException {
		// add to audit trail
		try {
			AuditTrailDAO auditDAO = new AuditTrailDAOImpl();

			for (Object limitObj : resultLimits) {
				ResultLimit data = (ResultLimit) limitObj;

				ResultLimit oldData = (ResultLimit) readResultLimit(data.getId());
				ResultLimit newData = new ResultLimit();

				String sysUserId = data.getSysUserId();
				String event = IActionConstants.AUDIT_TRAIL_DELETE;
				String tableName = "RESULT_LIMITS";
				auditDAO.saveHistory(newData, oldData, sysUserId, event, tableName);
			}
		} catch (Exception e) {
			LogEvent.logError("ResultLimitsDAOImpl", "AuditTrail deleteData()", e.toString());
			throw new LIMSRuntimeException("Error in ResultLimit AuditTrail deleteData()", e);
		}

		try {
			for (int i = 0; i < resultLimits.size(); i++) {
				ResultLimit data = (ResultLimit) resultLimits.get(i);
				data = (ResultLimit) readResultLimit(data.getId());
				HibernateUtil.getSession().delete(data);
				HibernateUtil.getSession().flush();
				HibernateUtil.getSession().clear();
			}
		} catch (Exception e) {
			LogEvent.logError("ResultLimitsDAOImpl", "deleteData()", e.toString());
			throw new LIMSRuntimeException("Error in ResultLimit deleteData()", e);
		}
	}

	public boolean insertData(ResultLimit resultLimit) throws LIMSRuntimeException {

		try {
			String id = (String) HibernateUtil.getSession().save(resultLimit);
			resultLimit.setId(id);

			AuditTrailDAO auditDAO = new AuditTrailDAOImpl();
			String sysUserId = resultLimit.getSysUserId();
			String tableName = "RESULT_LIMITS";
			auditDAO.saveNewHistory(resultLimit, sysUserId, tableName);

			HibernateUtil.getSession().flush();
			HibernateUtil.getSession().clear();

		} catch (Exception e) {
			LogEvent.logError("ResultLimitsDAOImpl", "insertData()", e.toString());
			throw new LIMSRuntimeException("Error in ResultLimit insertData()", e);
		}

		return true;
	}

	public void updateData(ResultLimit resultLimit) throws LIMSRuntimeException {

		ResultLimit oldData = readResultLimit(resultLimit.getId());
		ResultLimit newData = resultLimit;

		try {
			AuditTrailDAO auditDAO = new AuditTrailDAOImpl();
			String sysUserId = resultLimit.getSysUserId();
			String event = IActionConstants.AUDIT_TRAIL_UPDATE;
			String tableName = "RESULT_LIMITS";
			auditDAO.saveHistory(newData, oldData, sysUserId, event, tableName);
		} catch (Exception e) {
			LogEvent.logError("ResultLimitsDAOImpl", "AuditTrail updateData()", e.toString());
			throw new LIMSRuntimeException("Error in ResultLimit AuditTrail updateData()", e);
		}

		try {
			HibernateUtil.getSession().merge(resultLimit);
			HibernateUtil.getSession().flush();
			HibernateUtil.getSession().clear();
			HibernateUtil.getSession().evict(resultLimit);
			HibernateUtil.getSession().refresh(resultLimit);
		} catch (Exception e) {
			LogEvent.logError("ResultLimitsDAOImpl", "updateData()", e.toString());
			throw new LIMSRuntimeException("Error in ResultLimit updateData()", e);
		}
	}

	public void getData(ResultLimit resultLimit) throws LIMSRuntimeException {
		try {
			ResultLimit tmpLimit = (ResultLimit) HibernateUtil.getSession().get(ResultLimit.class, resultLimit.getId());
			HibernateUtil.getSession().flush();
			HibernateUtil.getSession().clear();
			if (tmpLimit != null) {
				PropertyUtils.copyProperties(resultLimit, tmpLimit);
			} else {
				resultLimit.setId(null);
			}
		} catch (Exception e) {
			LogEvent.logError("ResultLimitsDAOImpl", "getData()", e.toString());
			throw new LIMSRuntimeException("Error in ResultLimit getData()", e);
		}
	}

	public List getAllResultLimits() throws LIMSRuntimeException {
		List list = new Vector();
		try {
			String sql = "from ResultLimit";
			org.hibernate.Query query = HibernateUtil.getSession().createQuery(sql);
			list = query.list();
			HibernateUtil.getSession().flush();
			HibernateUtil.getSession().clear();
		} catch (Exception e) {
			LogEvent.logError("ResultLimitsDAOImpl", "getAllResultLimits()", e.toString());
			throw new LIMSRuntimeException("Error in ResultLimit getAllResultLimits()", e);
		}

		return list;
	}

	public List getPageOfResultLimits(int startingRecNo) throws LIMSRuntimeException {
		List list = new Vector();
		try {
			// calculate maxRow to be one more than the page size
			int endingRecNo = startingRecNo + (SystemConfiguration.getInstance().getDefaultPageSize() + 1);

			String sql = "from ResultLimit t order by t.id";
			org.hibernate.Query query = HibernateUtil.getSession().createQuery(sql);
			query.setFirstResult(startingRecNo - 1);
			query.setMaxResults(endingRecNo - 1);

			list = query.list();
			HibernateUtil.getSession().flush();
			HibernateUtil.getSession().clear();
		} catch (Exception e) {
			LogEvent.logError("ResultLimitsDAOImpl", "getPageOfResultLimits()", e.toString());
			throw new LIMSRuntimeException("Error in ResultLimit getPageOfResultLimits()", e);
		}

		return list;
	}

	public ResultLimit readResultLimit(String idString) {
		ResultLimit recoveredLimit = null;
		try {
			recoveredLimit = (ResultLimit) HibernateUtil.getSession().get(ResultLimit.class, idString);
			HibernateUtil.getSession().flush();
			HibernateUtil.getSession().clear();
		} catch (Exception e) {
			LogEvent.logError("ResultLimitDAOImpl", "readResultLimit()", e.toString());
			throw new LIMSRuntimeException("Error in ResultLimit readResultLimit()", e);
		}

		return recoveredLimit;
	}

	public List getNextResultLimitRecord(String id) throws LIMSRuntimeException {
		return getNextRecord(id, "ResultLimit", ResultLimit.class);
	}

	public List getPreviousResultLimitRecord(String id) throws LIMSRuntimeException {
		return getPreviousRecord(id, "ResultLimit", ResultLimit.class);
	}

	public List getAllResultLimitsForTest(Test test) throws LIMSRuntimeException {

		if (test == null || GenericValidator.isBlankOrNull(test.getId()))
			return null;

		List list = new Vector();
		try {
			String sql = "from ResultLimit rl where rl.testId = :test_id";
			org.hibernate.Query query = HibernateUtil.getSession().createQuery(sql);
			query.setInteger("test_id", Integer.parseInt(test.getId()));

			list = query.list();
			HibernateUtil.getSession().flush();
			HibernateUtil.getSession().clear();
		} catch (Exception e) {
			LogEvent.logError("ResultLimitDAOImpl", "getAllResultLimitsPerTest()", e.toString());
			throw new LIMSRuntimeException("Error in ResultLimitDAOImpl getAllResultLimitsForTest()", e);
		}

		return list;
	}

    public List getAllResultLimitsForTest(String testId) throws LIMSRuntimeException {

        if (GenericValidator.isBlankOrNull(testId))
            return null;

        List list = new Vector();
        try {
            String sql = "from ResultLimit rl where rl.testId = :test_id";
            Query query = HibernateUtil.getSession().createQuery(sql);
            query.setInteger("test_id", Integer.parseInt(testId));

            list = query.list();
            HibernateUtil.getSession().flush();
            HibernateUtil.getSession().clear();
        } catch (Exception e) {
            LogEvent.logErrorStack("ResultLimitDAOImpl", "getAllResultLimitsPerTest(String testId)", e);
            throw new LIMSRuntimeException("Error in ResultLimitDAOImpl getAllResultLimitsForTest(String testId)", e);
        }

        return list;
    }

	@Override
	public ResultLimit getResultLimitById(String resultLimitId) throws LIMSRuntimeException {
		try {
			ResultLimit resultLimit = (ResultLimit) HibernateUtil.getSession().get(ResultLimit.class, resultLimitId);
			closeSession();
			return resultLimit;
		} catch (Exception e) {
			handleException(e, "getResultLimitById");
		}
		
		return null;
	}
}
