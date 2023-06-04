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
package us.mn.state.health.lims.menu.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import us.mn.state.health.lims.common.exception.LIMSRuntimeException;
import us.mn.state.health.lims.common.log.LogEvent;
import us.mn.state.health.lims.hibernate.HibernateUtil;
import us.mn.state.health.lims.menu.dao.MenuDAO;
import us.mn.state.health.lims.menu.valueholder.Menu;

public class MenuDAOImpl implements MenuDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> getAllMenus() throws LIMSRuntimeException {

		try {
			String sql = "from Menu";
			Query query = HibernateUtil.getSession().createQuery(sql);
			List<Menu> menus = query.list();
			HibernateUtil.getSession().flush();
			HibernateUtil.getSession().clear();
			
			return menus;
		} catch(HibernateException e) {
			LogEvent.logError("MenuDAOImpl","getAllMenus()",e.toString());
			throw new LIMSRuntimeException("Error in Menu getAllMenus()", e);
		} 
	}

}
