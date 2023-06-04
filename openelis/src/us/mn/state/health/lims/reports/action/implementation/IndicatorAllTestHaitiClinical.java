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

import us.mn.state.health.lims.common.util.ConfigurationProperties;
import us.mn.state.health.lims.common.util.ConfigurationProperties.Property;

public class IndicatorAllTestHaitiClinical extends IndicatorAllTestHaiti implements IReportCreator, IReportParameterSetter {

	@Override
	protected String getLabNameLine1() {
		return  ConfigurationProperties.getInstance().getPropertyValue(Property.SiteName);
	}

	@Override
	protected String getLabNameLine2() {
		return "";
	}

	@Override
	protected String getSiteLogo() {
		return "labLogo.jpg";
	}



}
