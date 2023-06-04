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
package us.mn.state.health.lims.test.daoimpl;

import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import us.mn.state.health.lims.audittrail.dao.AuditTrailDAO;
import us.mn.state.health.lims.audittrail.daoimpl.AuditTrailDAOImpl;
import us.mn.state.health.lims.common.action.IActionConstants;
import us.mn.state.health.lims.common.daoimpl.BaseDAOImpl;
import us.mn.state.health.lims.common.exception.LIMSDuplicateRecordException;
import us.mn.state.health.lims.common.exception.LIMSRuntimeException;
import us.mn.state.health.lims.common.log.LogEvent;
import us.mn.state.health.lims.common.util.IdValuePair;
import us.mn.state.health.lims.common.util.StringUtil;
import us.mn.state.health.lims.common.util.SystemConfiguration;
import us.mn.state.health.lims.hibernate.HibernateUtil;
import us.mn.state.health.lims.login.dao.UserModuleDAO;
import us.mn.state.health.lims.login.daoimpl.UserModuleDAOImpl;
import us.mn.state.health.lims.login.valueholder.UserSessionData;
import us.mn.state.health.lims.method.valueholder.Method;
import us.mn.state.health.lims.systemusersection.dao.SystemUserSectionDAO;
import us.mn.state.health.lims.systemusersection.daoimpl.SystemUserSectionDAOImpl;
import us.mn.state.health.lims.systemusersection.valueholder.SystemUserSection;
import us.mn.state.health.lims.test.dao.TestDAO;
import us.mn.state.health.lims.test.valueholder.NonNumericTests;
import us.mn.state.health.lims.test.valueholder.Test;
import us.mn.state.health.lims.testanalyte.dao.TestAnalyteDAO;
import us.mn.state.health.lims.testanalyte.daoimpl.TestAnalyteDAOImpl;
import us.mn.state.health.lims.testanalyte.valueholder.TestAnalyte;
import us.mn.state.health.lims.typeofsample.util.TypeOfSampleUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * @author diane benz
 */
public class TestDAOImpl extends BaseDAOImpl implements TestDAO {

	private static final Object LOCK_OBJECT = new Object();
    private static Map<String, String> ID_NAME_MAP = null;
	private static Map<String, String> ID_DESCRIPTION_MAP = null;

	public boolean insertData(Test test) throws LIMSRuntimeException {

		try {
			// bugzilla 1417 throw Exception if active record already exists
			if (test.getIsActive().equals(IActionConstants.YES) && duplicateTestExists(test)) {
				throw new LIMSDuplicateRecordException(
						"Duplicate record exists for " + test.getTestName());
			}
			String id = (String) HibernateUtil.getSession().save(test);
			test.setId(id);

            //bugzilla 1824 inserts will be logged in history table
			AuditTrailDAO auditDAO = new AuditTrailDAOImpl();
			String sysUserId = test.getSysUserId();
			String tableName = "TEST";
			auditDAO.saveNewHistory(test,sysUserId,tableName);

			HibernateUtil.getSession().flush();
			HibernateUtil.getSession().clear();

			TypeOfSampleUtil.clearTestCache();
		} catch (Exception e) {
			//bugzilla 2154
			LogEvent.logError("TestDAOImpl","insertData()",e.toString());
			throw new LIMSRuntimeException("Error in Test insertData()", e);
		}
		clearIDMaps();
		return true;
	}

	public void updateData(Test test) throws LIMSRuntimeException {

		// bugzilla 1417 throw Exception if active record already exists
		try {
			if (test.getIsActive().equals(IActionConstants.YES) && duplicateTestExists(test)) {
				throw new LIMSDuplicateRecordException(
						"Duplicate record exists for " + test.getTestName());
			}
		} catch (Exception e) {
    		//bugzilla 2154
			LogEvent.logError("TestDAOImpl","updateData()",e.toString());
			throw new LIMSRuntimeException("Error in Test updateData()", e);
		}
		Test oldData = (Test) readTest(test.getId());
		Test newData = test;

		// add to audit trail
		try {
			AuditTrailDAO auditDAO = new AuditTrailDAOImpl();
			String sysUserId = test.getSysUserId();
			String event = IActionConstants.AUDIT_TRAIL_UPDATE;
			String tableName = "TEST";
			auditDAO.saveHistory(newData, oldData, sysUserId, event, tableName);
		} catch (Exception e) {
			//bugzilla 2154
			LogEvent.logError("TestDAOImpl","AuditTrail updateData()",e.toString());
			throw new LIMSRuntimeException("Error in Test AuditTrail updateData()", e);
		}

		try {
			HibernateUtil.getSession().merge(test);
			HibernateUtil.getSession().flush();
			HibernateUtil.getSession().clear();
			HibernateUtil.getSession().evict(test);
			HibernateUtil.getSession().refresh(test);
		} catch (Exception e) {
			//bugzilla 2154
			LogEvent.logError("TestDAOImpl","updateData()",e.toString());
			throw new LIMSRuntimeException("Error in Test updateData()", e);
		}
		clearIDMaps();
	}

	public void getData(Test test) throws LIMSRuntimeException {
		try {
			Test testClone = (Test)HibernateUtil.getSession().get(Test.class, test.getId());
			HibernateUtil.getSession().flush();
			HibernateUtil.getSession().clear();
			if (testClone != null) {
				PropertyUtils.copyProperties(test, testClone);
			} else {
				test.setId(null);
			}
		} catch (Exception e) {
			//bugzilla 2154
			LogEvent.logError("TestDAOImpl","getData()",e.toString());
			throw new LIMSRuntimeException("Error in Test getData()", e);
		}
	}

	@SuppressWarnings("unchecked")
    public List<Test> getAllTests(boolean onlyTestsFullySetup) throws LIMSRuntimeException {
		List<Test> list = new Vector<Test>();
		try {
			String sql = "from Test Order by description";
			Query query = HibernateUtil.getSession().createQuery(sql);
			list = query.list();
			list = filterOnlyFullSetup(onlyTestsFullySetup, list);

			HibernateUtil.getSession().flush();
			HibernateUtil.getSession().clear();
		} catch (Exception e) {
		    handleException(e, "getAllTests()");
		}

		return list;
	}


    @SuppressWarnings("unchecked")
    public List<Test> getAllActiveTests(boolean onlyTestsFullySetup) throws LIMSRuntimeException {
        List<Test> list = new Vector<Test>();
        try {
            String sql = "from Test WHERE is_Active = 'Y' Order by description";
            Query query = HibernateUtil.getSession().createQuery(sql);
            list = query.list();
            list = filterOnlyFullSetup(onlyTestsFullySetup, list);

            HibernateUtil.getSession().flush();
            HibernateUtil.getSession().clear();
        } catch (Exception e) {
            handleException(e, "getAllActiveTests()");
        }

        return list;
    }

    private List<Test> filterOnlyFullSetup(boolean onlyTestsFullySetup, List<Test> list) {
        if (onlyTestsFullySetup && list != null && list.size() > 0) {
        	Iterator<Test> testIterator = list.iterator();
        	list = new Vector<Test>();
        	while(testIterator.hasNext())	{
        		Test test = testIterator.next();
        		if (isTestFullySetup(test)) {
        			list.add(test);
        		}
        	}
        }
        return list;
    }

	/**
	 * Get all the tests assigned to this user
	 * @param sysUserId the user system id
	 * @return list of test section
	 * bugzilla 2291 added onlyTestsFullySetup
	 */
	public List getAllTestsBySysUserId(int sysUserId, boolean onlyTestsFullySetup) throws LIMSRuntimeException {
		List list = new Vector();
		String sectionIdList = "";
		String sql = "";

		try {
			SystemUserSectionDAO systemUserSectionDao = new SystemUserSectionDAOImpl();
			List userTestSectionList= systemUserSectionDao.getAllSystemUserSectionsBySystemUserId(sysUserId);
			for ( int i=0; i<userTestSectionList.size(); i++ ) {
				SystemUserSection sus = (SystemUserSection)userTestSectionList.get(i);
				sectionIdList += sus.getTestSection().getId() + ",";
			}

			if ( !(sectionIdList.equals("")) && (sectionIdList.length() > 0) ) {
				sectionIdList = sectionIdList.substring(0,sectionIdList.length()-1);
				sql = "from Test t where t.testSection.id  in ("+sectionIdList+") Order by description";
			} else {
				return list;
			}

			Query query = HibernateUtil.getSession().createQuery(sql);
			list = query.list();

			list = filterOnlyFullSetup(onlyTestsFullySetup, list);

			HibernateUtil.getSession().flush();
			HibernateUtil.getSession().clear();
		} catch (Exception e) {
			//bugzilla 2154
			LogEvent.logError("TestDAOImpl","getAllTestsBySysUserId()",e.toString());
			throw new LIMSRuntimeException("Error in Test getAllTestsBySysUserId()", e);
		}
		return list;
	}

	public List getPageOfTests(int startingRecNo) throws LIMSRuntimeException {
		List list = new Vector();
		try {
			// calculate maxRow to be one more than the page size
			int endingRecNo = startingRecNo + (SystemConfiguration.getInstance().getDefaultPageSize() + 1);

			// bugzilla 1399
			String sql = "from Test t order by t.testSection.testSectionName, t.testName";
    		Query query = HibernateUtil.getSession().createQuery(sql);
			query.setFirstResult(startingRecNo - 1);
			query.setMaxResults(endingRecNo - 1);

			list = query.list();
			HibernateUtil.getSession().flush();
			HibernateUtil.getSession().clear();
		} catch (Exception e) {
			//bugzilla 2154
			LogEvent.logError("TestDAOImpl","getPageOfTests()",e.toString());
			throw new LIMSRuntimeException("Error in Test getPageOfTests()", e);
		}

		return list;
	}

//	 bugzilla 2371
	public List getPageOfSearchedTests(int startingRecNo, String searchString)
	throws LIMSRuntimeException {
         List list = new Vector();
         String wildCard = "*";
         String newSearchStr;
         String sql;

         try {
        	  int endingRecNo = startingRecNo
  			                    + (SystemConfiguration.getInstance().getDefaultPageSize() + 1);
        	  int wCdPosition = searchString.indexOf (wildCard);

              if (wCdPosition == -1)  // no wild card looking for exact match
              {
            	  newSearchStr = searchString.toLowerCase().trim();
                  sql = "from Test t  where trim(lower (t.description)) = :param  order by t.testSection.testSectionName, t.testName";
              }
	          else
	          {
	             newSearchStr = searchString.replace(wildCard, "%").toLowerCase().trim();
	             sql = "from Test t where trim(lower (t.description)) like :param  order by t.testSection.testSectionName, t.testName";
	          }
	          Query query = HibernateUtil.getSession().createQuery(sql);
	          query.setParameter("param", newSearchStr);
	          query.setFirstResult(startingRecNo - 1);
	          query.setMaxResults(endingRecNo - 1);

	          list = query.list();
	          HibernateUtil.getSession().flush();
	          HibernateUtil.getSession().clear();
             }       catch (Exception e) {
	                 e.printStackTrace();
	                 throw new LIMSRuntimeException(
			             "Error in Test getPageOfSearchedTests()", e);
       }

        return list;
    }
	//end bugzilla 2371

	/**
	 * Get all the tests assigned to this user
	 * @param startingRecNo the start record
	 * @param sysUserId is the user system id
	 * @return list of test section
	 */
	public List getPageOfTestsBySysUserId(int startingRecNo, int sysUserId) throws LIMSRuntimeException {
		List list = new Vector();
		try {
			// calculate maxRow to be one more than the page size
			int endingRecNo = startingRecNo + (SystemConfiguration.getInstance().getDefaultPageSize() + 1);

			String sectionIdList = "";
			String sql = "";

			SystemUserSectionDAO systemUserSectionDao = new SystemUserSectionDAOImpl();
			List userTestSectionList= systemUserSectionDao.getAllSystemUserSectionsBySystemUserId(sysUserId);
			for ( int i=0; i<userTestSectionList.size(); i++ ) {
				SystemUserSection sus = (SystemUserSection)userTestSectionList.get(i);
				sectionIdList += sus.getTestSection().getId() + ",";
			}

			if ( !(sectionIdList.equals("")) && (sectionIdList.length() > 0) ) {
				sectionIdList = sectionIdList.substring(0,sectionIdList.length()-1);
				sql = "from Test t where t.testSection.id in ("+sectionIdList+") order by t.testSection.testSectionName, t.testName";
			} else {
				return list;
			}

    		Query query = HibernateUtil.getSession().createQuery(sql);
			query.setFirstResult(startingRecNo - 1);
			query.setMaxResults(endingRecNo - 1);

			list = query.list();
			HibernateUtil.getSession().flush();
			HibernateUtil.getSession().clear();
		} catch (Exception e) {
			//bugzilla 2154
			LogEvent.logError("TestDAOImpl","getPageOfTestsBySysUserId()",e.toString());
			throw new LIMSRuntimeException("Error in Test getPageOfTestsBySysUserId()", e);
		}

		return list;
	}


	// bugzilla 2371
	/**
	 * Get all the tests assigned to this user
	 * @param startingRecNo the start record
	 * @param sysUserId is the user system id
	 * @return list of test section
	 */
	public List getPageOfSearchedTestsBySysUserId(int startingRecNo, int sysUserId, String searchString) throws LIMSRuntimeException {
		List list = new Vector();
		String wildCard = "*";
		String newSearchStr;
		String sql;

		try {
		   int endingRecNo = startingRecNo
		  		+ (SystemConfiguration.getInstance().getDefaultPageSize() + 1);

		   String sectionIdList = "";
		   SystemUserSectionDAO systemUserSectionDao = new SystemUserSectionDAOImpl();

		   List userTestSectionList= systemUserSectionDao.getAllSystemUserSectionsBySystemUserId(sysUserId);

		   for ( int i=0; i<userTestSectionList.size(); i++ ) {
		      SystemUserSection sus = (SystemUserSection)userTestSectionList.get(i);
		  	  sectionIdList += sus.getTestSection().getId() + ",";
		  }

		  if ( !(sectionIdList.equals("")) && (sectionIdList.length() > 0) ) {
			  sectionIdList = sectionIdList.substring(0,sectionIdList.length()-1);
		  	  int wCdPosition = searchString.indexOf (wildCard);

		      if (wCdPosition == -1)  // no wild card looking for exact match
		      {
		         newSearchStr = searchString.toLowerCase().trim();
		         sql = "from Test t  where t.testSection.id in ("+sectionIdList+" ) and  trim(lower (t.description)) = :param  order by t.testSection.testSectionName, t.testName";
		      }
		      else
		      {
		          newSearchStr = searchString.replace(wildCard, "%").toLowerCase().trim();
		          sql = "from Test t where t.testSection.id in ("+sectionIdList+") and trim(lower (t.description)) like :param  order by t.testSection.testSectionName, t.testName";
		      }
		  }
		  else
		   	  return list;

		  Query query = HibernateUtil.getSession().createQuery(sql);
		  query.setParameter("param", newSearchStr);
          query.setFirstResult(startingRecNo - 1);
          query.setMaxResults(endingRecNo - 1);

          list = query.list();
        	HibernateUtil.getSession().flush();
		 HibernateUtil.getSession().clear();
	 } catch (Exception e) {
		e.printStackTrace();
		throw new LIMSRuntimeException("Error in Test getPageOfTestsBySysUserId()", e);
	}

	return list;
	}
	// end of bugzilla 2371

	public Test readTest(String idString) {
		Test test = null;
		try {
			test = (Test) HibernateUtil.getSession().get(Test.class, idString);
			HibernateUtil.getSession().flush();
			HibernateUtil.getSession().clear();
		} catch (Exception e) {
			//bugzilla 2154
			LogEvent.logError("TestDAOImpl","readTest()",e.toString());
			throw new LIMSRuntimeException("Error in Test readTest()", e);
		}

		return test;
	}

	public List getNextTestRecord(String id) throws LIMSRuntimeException {

		return getNextRecord(id, "Test", Test.class);

	}

	public List getPreviousTestRecord(String id) throws LIMSRuntimeException {

		return getPreviousRecord(id, "Test", Test.class);
	}

	// this is for autocomplete
	//bugzilla 2291 added onlyTestsFullySetup
	public List getTests(String filter, boolean onlyTestsFullySetup) throws LIMSRuntimeException {
		List list = new Vector();
		try {
			String sql = "from Test t where upper(t.testName) like upper(:param) and t.isActive='Y' order by upper(t.testName)";
			Query query = HibernateUtil.getSession().createQuery(sql);
			query.setParameter("param", filter + "%");
			list = query.list();

			list = filterOnlyFullSetup(onlyTestsFullySetup, list);
			HibernateUtil.getSession().flush();
			HibernateUtil.getSession().clear();
		} catch (Exception e) {
			//bugzilla 2154
			LogEvent.logError("TestDAOImpl","getTests()",e.toString());
			throw new LIMSRuntimeException("Error in Test getTests(String filter)", e);
		}

		return list;
	}

	public Test getTestByName(Test test) throws LIMSRuntimeException {
		return getTestByName(test.getTestName());
	}

	public Test getTestByName(String testName) throws LIMSRuntimeException {
		try {
			String sql = "from Test t where lower(t.testName) = :testName and t.isActive='Y'";
			Query query = HibernateUtil.getSession().createQuery(sql);
			query.setParameter("testName", testName.toLowerCase());


			@SuppressWarnings("unchecked")
			List<Test> list = query.list();
			HibernateUtil.getSession().flush();
			HibernateUtil.getSession().clear();
			Test t = null;
			
			if (!list.isEmpty()){
				t = list.get(0);
			}
			
			return t;

		} catch (Exception e) {
			//bugzilla 2154
			LogEvent.logError("TestDAOImpl","getTestByName()",e.toString());
			throw new LIMSRuntimeException("Error in Test getTestByName()", e);
		}
	}
	@SuppressWarnings("unchecked")
	public Test getActiveTestByName(String testName) throws LIMSRuntimeException {
		List<Test> list = null;

		try {
			String sql = "from Test t where t.testName = :testName and t.isActive='Y'";
			Query query = HibernateUtil.getSession().createQuery(sql);
			query.setParameter("testName", testName);

			list = query.list();

			closeSession();
		} catch (HibernateException e) {
			handleException(e, "getActiveTestByName");
		}

		return list.size() > 0 ? list.get(0) : null;
	}

   @SuppressWarnings("unchecked")
    public Test getActiveTestById(Integer testId) throws LIMSRuntimeException {
        List<Test> list = null;

        try {
            String sql = "from Test t where t.id = :testId and t.isActive='Y'";
            Query query = HibernateUtil.getSession().createQuery(sql);
            query.setParameter("testId", testId);

            list = query.list();

            closeSession();
        } catch (HibernateException e) {
            handleException(e, "getActiveTestById");
        }

        return list.size() > 0 ? list.get(0) : null;
    }

	public Test getTestById(Test test) throws LIMSRuntimeException {
		Test returnTest = null;
		try {
			returnTest = (Test)HibernateUtil.getSession().get(Test.class, test.getId());
			HibernateUtil.getSession().flush();
			HibernateUtil.getSession().clear();
		} catch (Exception e) {
			//bugzilla 2154
			LogEvent.logError("TestDAOImpl","getTestById()",e.toString());
			throw new LIMSRuntimeException("Error in Test getTestById()", e);
		}

		return returnTest;
	}

	// this is for selectdropdown
	public List getMethodsByTestSection(String filter) throws LIMSRuntimeException {
		try {
			String sql = "from Test t where t.testSection = :param";
			Query query = HibernateUtil.getSession().createQuery(sql);
			query.setParameter("param", filter);

			List list = query.list();
			HibernateUtil.getSession().flush();
			HibernateUtil.getSession().clear();
			List methods = new ArrayList();

			for (int i = 0; i < list.size(); i++) {
				Test t = (Test) list.get(i);
			/*	System.out.println("This is test " + t.getId() + " "
						+ t.getTestName());*/
				Method method = t.getMethod();
				if (!methods.contains(method)) {
					methods.add(method);
				}
			/*	System.out.println("Adding this method to list "
						+ method.getId() + " " + method.getMethodName());*/
			}

			return methods;

		} catch (Exception e) {
			//bugzilla 2154
			LogEvent.logError("TestDAOImpl","getMethodsByTestSection()",e.toString());
			throw new LIMSRuntimeException("Error in Method getMethodsByTestSection(String filter)",e);
		}
	}

	// this is for selectdropdown
	public List getTestsByTestSection(String filter) throws LIMSRuntimeException {
		try {
			String sql = "from Test t where t.testSection = :param";
			Query query = HibernateUtil.getSession().createQuery(sql);
			query.setInteger("param", Integer.parseInt(filter));

			List list = query.list();
			HibernateUtil.getSession().flush();
			HibernateUtil.getSession().clear();
			return list;

		} catch (Exception e) {
			//bugzilla 2154
			LogEvent.logError("TestDAOImpl","getTestsByTestSection()",e.toString());
			throw new LIMSRuntimeException("Error in Method getTestsByTestSection(String filter)",e);
		}
	}

	// this is for selectdropdown
	public List getTestsByMethod(String filter) throws LIMSRuntimeException {
		try {
			String sql = "from Test t where t.method = :param";
			Query query = HibernateUtil.getSession().createQuery(sql);
			query.setParameter("param", filter);

			List list = query.list();
			HibernateUtil.getSession().flush();
			HibernateUtil.getSession().clear();
			return list;

		} catch (Exception e) {
			//bugzilla 2154
			LogEvent.logError("TestDAOImpl","getTestsByMethod()",e.toString());
			throw new LIMSRuntimeException("Error in Method getTestsByMethod(String filter)",e);
		}
	}

	// this is for selectdropdown
	public List getTestsByTestSectionAndMethod(String filter, String filter2) throws LIMSRuntimeException {
		try {
			String sql = "from Test t where t.testSection = :param1 and t.method = :param2";
			Query query = HibernateUtil.getSession().createQuery(sql);
			query.setParameter("param1", filter);
			query.setParameter("param2", filter2);

			List list = query.list();
			HibernateUtil.getSession().flush();
			HibernateUtil.getSession().clear();
			return list;

		} catch (Exception e) {
			//bugzilla 2154
			LogEvent.logError("TestDAOImpl","getTestsByMethod()",e.toString());
			throw new LIMSRuntimeException("Error in Method getTestsByMethod(String filter)",e);
		}
	}

	// bugzilla 1411
	public Integer getTotalTestCount() throws LIMSRuntimeException {
		return getTotalCount("Test", Test.class);
	}

	// bugzilla 2371
	public Integer getTotalSearchedTestCount (String searchString)
	throws LIMSRuntimeException {
        String wildCard = "*";
	    String newSearchStr;
	    String sql;
	    Integer count = null;

	    try {
	       int wCdPosition = searchString.indexOf (wildCard);
	       if (wCdPosition == -1)  // no wild card looking for exact match
	          {
	           	  newSearchStr = searchString.toLowerCase().trim();
                  sql = "select count (*) from Test t  where trim(lower (t.description)) = :param  ";
	          }
		   else
		      {
			      newSearchStr = searchString.replace(wildCard, "%").toLowerCase().trim();
		          sql = "select count (*) from Test t where trim(lower (t.description)) like :param ";
		      }
		      Query query = HibernateUtil.getSession().createQuery(sql);
		      query.setParameter("param", newSearchStr);

		      List results  = query.list();
		      HibernateUtil.getSession().flush();
		      HibernateUtil.getSession().clear();

		      if (results != null && results.get(0) != null) {
				  if (results.get(0) != null) {
					 count = (Integer)results.get(0);
	        	   }
			   }

	        }       catch (Exception e) {
		                 e.printStackTrace();
		                 throw new LIMSRuntimeException(
				             "Error in TestDaoImpl getTotalSearchedTestCount()", e);
	       }

	       return count;

	}
	// end bugzilla 2371

	//bugzilla 2371
	public Integer getTotalSearchedTestCountBySysUserId(int sysUserId, String searchString)
	throws LIMSRuntimeException {
	   List list = new Vector();
	   String wildCard = "*";
	   String newSearchStr;
	   String sql;
	   Integer count = null;

	   try {
	      String sectionIdList = "";
	      SystemUserSectionDAO systemUserSectionDao = new SystemUserSectionDAOImpl();

	      List userTestSectionList= systemUserSectionDao.getAllSystemUserSectionsBySystemUserId(sysUserId);

	      for ( int i=0; i<userTestSectionList.size(); i++ ) {
	         SystemUserSection sus = (SystemUserSection)userTestSectionList.get(i);
	     	  sectionIdList += sus.getTestSection().getId() + ",";
	      }
	      System.out.println(sectionIdList);
	      if ( !(sectionIdList.equals("")) && (sectionIdList.length() > 0) ) {
	         sectionIdList = sectionIdList.substring(0,sectionIdList.length()-1);
	   		 int wCdPosition = searchString.indexOf (wildCard);

	   		 if (wCdPosition == -1)  // no wild card looking for exact match
	   		 {
	   		    newSearchStr = searchString.toLowerCase().trim();
	   		    sql = "select count (*) from Test t  where t.testSection.id in ("+sectionIdList+") and trim(lower (t.description)) = :param ";
	   		 }
	   		 else
	   		 {
	   		    newSearchStr = searchString.replace(wildCard, "%").toLowerCase().trim();
	   		    sql = "select count (*) from Test t where t.testSection.id in ("+sectionIdList+") and trim(lower (t.description)) like :param ";
	   		  }
	       }
	   	   else
	   	   	  return count;

	      Query query = HibernateUtil.getSession().createQuery(sql);
	      query.setParameter("param", newSearchStr);

	      List results  = query.list();

	      HibernateUtil.getSession().flush();
	      HibernateUtil.getSession().clear();

	      if (results != null && results.get(0) != null) {
		     if (results.get(0) != null) {
			    count = (Integer)results.get(0);
			  }
		  }

       }       catch (Exception e) {
	                 e.printStackTrace();
	                 throw new LIMSRuntimeException(
			             "Error in TestDaoImpl getTotalSearchedTestCountBySysUserId()", e);
                     }

        return count;
	}
	// end bugzilla 2371

	// bugzilla 2371
     public Integer getAllSearchedTotalTestCount (HttpServletRequest request, String searchString)
	 throws LIMSRuntimeException {
	    Integer count = null;
	    TestDAO testDAO = new TestDAOImpl();

    	try {
		   if ( SystemConfiguration.getInstance().getEnableUserTestSection().equals(NO) ) {
		       count = testDAO.getTotalSearchedTestCount (searchString);
		   } else {
			    UserSessionData usd = (UserSessionData)request.getSession().getAttribute(USER_SESSION_DATA);

			    UserModuleDAO userModuleDAO = new UserModuleDAOImpl();
			    if ( !userModuleDAO.isUserAdmin(request) )
		        {
			       count = testDAO.getTotalSearchedTestCountBySysUserId(usd.getSystemUserId(), searchString);
			    }
			    else {
			       count = testDAO.getTotalSearchedTestCount(searchString);

		        }
		   }
	    } catch (Exception e) {
		   e.printStackTrace();
		   throw new LIMSRuntimeException("Error in testDAOImpl getAllSearchedTotalTestCount()", e);
	       }
         return count;
	}
//end if bugzilla 2371


	// bugzilla 1427
	public List getNextRecord(String id, String table, Class clazz) throws LIMSRuntimeException {
		int currentId = (Integer.valueOf(id)).intValue();
		String tablePrefix = getTablePrefix(table);

		List list = new Vector();
		//bugzilla 1908
		int rrn = 0;
		try {
			//bugzilla 1908 cannot use named query for postgres because of oracle ROWNUM
			//instead get the list in this sortorder and determine the index of record with id = currentId
    		String sql = "select t.id from Test t " +
					" order by t.testSection.testSectionName, t.testName";

 			Query query = HibernateUtil.getSession().createQuery(sql);
			list = query.list();
			HibernateUtil.getSession().flush();
			HibernateUtil.getSession().clear();
			rrn = list.indexOf(String.valueOf(currentId));

			list = HibernateUtil.getSession().getNamedQuery(
					tablePrefix + "getNext").setFirstResult(
					rrn + 1).setMaxResults(2).list();

		} catch (Exception e) {
			//bugzilla 2154
			LogEvent.logError("TestDAOImpl","getNextRecord()",e.toString());
			throw new LIMSRuntimeException("Error in getNextRecord() for "
					+ table, e);
		}

		return list;
	}

	// bugzilla 1427
	public List getPreviousRecord(String id, String table, Class clazz) throws LIMSRuntimeException {
		int currentId = (Integer.valueOf(id)).intValue();
		String tablePrefix = getTablePrefix(table);

		List list = new Vector();
		//bugzilla 1908
		int rrn = 0;
		try {
			//bugzilla 1908 cannot use named query for postgres because of oracle ROWNUM
			//instead get the list in this sortorder and determine the index of record with id = currentId
    		String sql = "select t.id from Test t " +
					" order by t.testSection.testSectionName desc, t.testName desc";

 			Query query = HibernateUtil.getSession().createQuery(sql);
			list = query.list();
			HibernateUtil.getSession().flush();
			HibernateUtil.getSession().clear();
			rrn = list.indexOf(String.valueOf(currentId));

			list = HibernateUtil.getSession().getNamedQuery(tablePrefix + "getPrevious")
			.setFirstResult(rrn + 1)
			.setMaxResults(2)
			.list();

		} catch (Exception e) {
			//bugzilla 2154
			LogEvent.logError("TestDAOImpl","getPreviousRecord()",e.toString());
			throw new LIMSRuntimeException("Error in getPreviousRecord() for " + table, e);
		}

		return list;
	}

	//bugzilla 2459 added check for duplicate test.description
	private boolean duplicateTestExists(Test test) throws LIMSRuntimeException {
		try {

            List list = new ArrayList();

            //only check if the test to be inserted/updated is active
            if (test.getIsActive().equalsIgnoreCase("Y")) {
                // not case sensitive hemolysis and Hemolysis are considered
                // duplicates
                String sql = "from Test t where ((trim(lower(t.testName)) = :param and t.isActive='Y' and t.id != :param2) or (trim(lower(t.description)) = :param3 and t.isActive='Y' and t.id != :param2))";
                Query query = HibernateUtil.getSession().createQuery(
                        sql);
                query.setParameter("param", test.getTestName().toLowerCase().trim());

                //initialize with 0 (for new records where no id has been generated yet
                String testId = "0";
                if (!StringUtil.isNullorNill(test.getId())) {
                    testId = test.getId();
                }
                query.setInteger("param2", Integer.parseInt(testId));
                query.setParameter("param3", test.getDescription().toLowerCase().trim());

                list = query.list();
            }

            return list.size() > 0;

        } catch (Exception e) {
			//bugzilla 2154
			LogEvent.logError("TestDAOImpl","duplicateTestExists()",e.toString());
			throw new LIMSRuntimeException("Error in duplicateTestExists()", e);
		}
	}

	//bugzilla 2236
	public boolean isTestFullySetup(Test test) throws LIMSRuntimeException {
		try {
			TestAnalyteDAO testAnalyteDAO = new TestAnalyteDAOImpl();
			List testAnalytesByTest = testAnalyteDAO.getAllTestAnalytesPerTest(test);
			boolean result = true;
			if (testAnalytesByTest == null || testAnalytesByTest.size() == 0) {
               result = false;
			} else {
				//bugzilla 2291 make sure none of the components has a null result group
				boolean atLeastOneResultGroupFound = false;
				for (int j = 0; j < testAnalytesByTest.size(); j++) {
					TestAnalyte testAnalyte = (TestAnalyte)testAnalytesByTest.get(j);
					if (testAnalyte.getResultGroup() == null) {
						atLeastOneResultGroupFound = true;
						break;
					}
				}
				if (atLeastOneResultGroupFound) {
                       result = false;
				}
			}
		return result;
		} catch (Exception e) {
			//bugzilla 2154
			LogEvent.logError("TestDAOImpl","isTestFullySetup()",e.toString());
			throw new LIMSRuntimeException("Error in isTestFullySetup()", e);
		}
	}

	//bugzilla 2443
	public Integer getNextAvailableSortOrderByTestSection(Test test) throws LIMSRuntimeException {
		Integer result = null;

		try {

			List list = new ArrayList();
			Test testWithHighestSortOrder = null;

			String sql = "from Test t where t.testSection = :param and t.sortOrder is not null order by t.sortOrder desc";
			Query query = HibernateUtil.getSession().createQuery(
					sql);
			query.setParameter("param", test.getTestSection());

			list = query.list();
			HibernateUtil.getSession().flush();
			HibernateUtil.getSession().clear();

			if (list.size() > 0) {
			  testWithHighestSortOrder = (Test)list.get(0);
			  if (testWithHighestSortOrder != null && !StringUtil.isNullorNill(testWithHighestSortOrder.getSortOrder())) {
				  result = new Integer ((Integer.parseInt(testWithHighestSortOrder.getSortOrder()) +1));
			  }
			}

		} catch (Exception e) {
			//bugzilla 2154
			LogEvent.logError("TestDAOImpl","getNextAvailableSortOrderByTestSection()",e.toString());
			throw new LIMSRuntimeException("Error in getNextAvailableSortOrderByTestSection()", e);
		}
		return result;
	}

	public String getNameForTestId(String id) {
        loadMapsSynchronized(ID_NAME_MAP);
        return ID_NAME_MAP != null ? ID_NAME_MAP.get(id) : id;
	}

	public String getDescriptionForTestId(String id) {
        loadMapsSynchronized(ID_DESCRIPTION_MAP);
		return ID_DESCRIPTION_MAP != null ? ID_DESCRIPTION_MAP.get(id) : id;
	}

    private void loadMapsSynchronized(Object description) {
        if (description == null) {
            synchronized (LOCK_OBJECT) {
                if (description == null) {
                    loadMaps();
                }
            }
        }
    }

	private void loadMaps(){
		List allTests = getAllTests(false);

		if( allTests != null){
			ID_NAME_MAP = new HashMap<String, String>();
			ID_DESCRIPTION_MAP = new HashMap<String, String>();

			for( Object testObj : allTests){
				Test test = (Test)testObj;

				ID_NAME_MAP.put( test.getId(), test.getName());
				ID_DESCRIPTION_MAP.put( test.getId(), test.getTestName());
			}
		}
	}

	private void clearIDMaps(){
        synchronized (LOCK_OBJECT) {
            ID_NAME_MAP = null;
            ID_DESCRIPTION_MAP = null;
        }
	}

    /**
     * @see us.mn.state.health.lims.test.dao.TestDAO#getAllOrderBy(java.lang.String)
     * Read all entities from the database sorted by an appropriate property
     */
    @SuppressWarnings("unchecked")
    public List<Test> getAllOrderBy(String columnName) throws LIMSRuntimeException {
        List<Test> entities;
        try {
            if (!StringUtil.isJavaIdentifier(columnName)) {
                throw new IllegalArgumentException("\"" + columnName + "\" is not valid syntax for a column name");
            }
            // I didn't manage to get a query parameter to be used as a column name to sort by (because ORDER BY "my_column" is not valid SQL).
            // so I had to generate the HQL manually, but only after the above check.
            String hql = "from Test t where t.isActive='Y' ORDER BY " + columnName;
            Query query = HibernateUtil.getSession().createQuery(hql);
            hql = query.getQueryString();
            entities = query.list();
            closeSession();
        } catch (Exception e) {
            LogEvent.logError("TestDAOImpl","getAllOrderBy()",e.toString());
            throw new LIMSRuntimeException("Error in getAllOrderBy()", e);
        }

        return entities;
    }

	@Override
	public Test getTestById(String testId) throws LIMSRuntimeException {
		String sql = "From Test t where t.id = :id";
		try{
			Query query = HibernateUtil.getSession().createQuery(sql);
			query.setInteger("id", Integer.parseInt(testId));

			Test test = (Test)query.uniqueResult();
			closeSession();
			return test;
		}catch(HibernateException e){
			handleException(e, "getTesById");
		}

		return null;
	}

    @Override
    public List<NonNumericTests> getAllNonNumericTests(List<Integer> testIds) {
        if(testIds != null && !testIds.isEmpty()) {
            String sql = "Select t.id, tr.testResultType, tr.value, d.dictEntry From Test t, TestResult tr, Dictionary d where t.id in (:ids) and tr.test = t and tr.value is not null and (tr.testResultType = 'D' or tr.testResultType = 'M') and cast(tr.value as integer) = d.id";
            try{
                Query query = HibernateUtil.getSession().createQuery(sql);
                query.setParameterList("ids", testIds);
                List<Object[]> list = query.list();
                Map<String, NonNumericTests> tests = new HashMap<String, NonNumericTests>();
                for (Object[] objects : list) {
                    String testId = (String) objects[0];
                    String testResultType = (String) objects[1];
                    String testResultValue = (String) objects[2];
                    String dictEntry = (String) objects[3];

                    if(tests.get(testId) != null) {
                        tests.get(testId).dictionaryValues.add(new IdValuePair(testResultValue, dictEntry));
                    } else {
                        NonNumericTests nonNumericTests = new NonNumericTests(testId, testResultType, new IdValuePair(testResultValue, dictEntry));
                        tests.put(testId, nonNumericTests);
                    }
                }
                closeSession();
                return new ArrayList<>(tests.values());
            }catch(HibernateException e){
                handleException(e, "getAllNonNumericTests");
            }
        }
        return new ArrayList<NonNumericTests>();
    }

    @Override
	public Test getTestByDescription(String description) {
		String sql = "From Test t where t.description = :description";
		try{
			Query query = HibernateUtil.getSession().createQuery(sql);
			query.setString("description", description);

			Test test = (Test)query.uniqueResult();
			closeSession();
			return test;
		}catch(HibernateException e){
			handleException(e, "getTestByDescription");
		}

		return null;
	}

    public void deleteData(List tests) throws LIMSRuntimeException {
        // add to audit trail
        try {
            AuditTrailDAO auditDAO = new AuditTrailDAOImpl();
            for (int i = 0; i < tests.size(); i++) {
                Test data = (Test) tests.get(i);

                Test oldData = readTest(data.getId());
                Test newData = new Test();

                String sysUserId = data.getSysUserId();
                String event = IActionConstants.AUDIT_TRAIL_DELETE;
                String tableName = "TEST";
                auditDAO.saveHistory(newData, oldData, sysUserId, event, tableName);
			}
        } catch (Exception e) {
            //bugzilla 2154
            LogEvent.logError("TestDAOImpl","AuditTrail deleteData()",e.toString());
            throw new LIMSRuntimeException("Error in Test AuditTrail deleteData()", e);
        }

        try {
            for (int i = 0; i < tests.size(); i++) {
                Test data = (Test) tests.get(i);
                Test cloneData = readTest(data.getId());

                cloneData.setIsActive(IActionConstants.NO);
                HibernateUtil.getSession().merge(cloneData);
                HibernateUtil.getSession().flush();
                HibernateUtil.getSession().clear();
                HibernateUtil.getSession().evict(cloneData);
                HibernateUtil.getSession().refresh(cloneData);
            }
        } catch (Exception e) {
            //bugzilla 2154
            LogEvent.logError("TestDAOImpl","deleteData()",e.toString());
            throw new LIMSRuntimeException("Error in Test deleteData()", e);
        }
		TypeOfSampleUtil.clearTestCache();

        clearIDMaps();
    }

    @Override
    public void deleteById(String testId, String sysUserId) {
        try {
            AuditTrailDAO auditDAO = new AuditTrailDAOImpl();
            Test testFromDB = readTest(testId);
            Test newData = (Test) testFromDB.clone();
            newData.setIsActive(IActionConstants.NO);

            String event = IActionConstants.AUDIT_TRAIL_DELETE;
            String tableName = "TEST";
            auditDAO.saveHistory(newData,testFromDB,sysUserId,event,tableName);

            HibernateUtil.getSession().merge(newData);
            HibernateUtil.getSession().flush();
            HibernateUtil.getSession().clear();
            HibernateUtil.getSession().evict(newData);
            HibernateUtil.getSession().refresh(newData);
        } catch (Exception e) {
            LogEvent.logErrorStack("TestDAOImpl", "deleteData()", e);
            throw new LIMSRuntimeException("Error in Test deleteData()", e);
        }
        clearIDMaps();
    }
}
