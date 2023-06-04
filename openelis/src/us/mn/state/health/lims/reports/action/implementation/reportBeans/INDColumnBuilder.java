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
package us.mn.state.health.lims.reports.action.implementation.reportBeans;

import static us.mn.state.health.lims.reports.action.implementation.reportBeans.CSVColumnBuilder.Strategy.*;
import us.mn.state.health.lims.reports.action.implementation.Report.DateRange;

/**
 * @author pahill (pahill@uw.edu)
 * @since May 19, 2011
 */
public class INDColumnBuilder extends CIColumnBuilder {

    /**
     * @param dateRange
     * @param projectStr
     */
    public INDColumnBuilder(DateRange dateRange, String projectStr) {
        super(dateRange, projectStr);
    }

    /**
     * @see us.mn.state.health.lims.reports.action.implementation.reportBeans.CIColumnBuilder#defineAllReportColumns()
     */
    @Override
    protected void defineAllReportColumns() {
        defineBasicColumns();
        add("hivStatus", "STATVIH", DICT_RAW );        
        add("indFirstTestName", "PRENOM", NONE);
        add("indSecondTestName", "NOM", NONE);
        add("indFirstTestDate"   ,"TEST1DATE",NONE);
        add("indFirstTestResult" ,"TEST1RESULT",NONE);
        add("indSecondTestDate"  ,"TEST2DATE",NONE);
        add("indSecondTestResult","TEST2RESULT",NONE);
        add("indSiteFinalResult" ,"RESULTSITE",NONE);
        addAllResultsColumns();
    }

    /**
     * @see us.mn.state.health.lims.reports.action.implementation.reportBeans.CIColumnBuilder#makeSQL()
     */
    @Override
    public void makeSQL() {
        query = new StringBuilder();
        String lowDatePostgres =  postgresDateFormat.format(dateRange.getLowDate());
        String highDatePostgres = postgresDateFormat.format(dateRange.getHighDate());
        query.append(SELECT_SAMPLE_PATIENT_ORGANIZATION );
        // all cross tab generated tables need to be listed in the SELECT column list and in the WHERE clause at the bottom
        // more cross tabulation of other columns goes where
        query.append(SELECT_ALL_DEMOGRAPHIC_AND_RESULTS);

        // FROM clause for ordinary lab (sample and patient) tables
        query.append(FROM_SAMPLE_PATIENT_ORGANIZATION );

        // all observation history from expressions
        appendObservationHistoryCrosstab(lowDatePostgres, highDatePostgres);
        
        // and finally the join that puts these all together. Each cross table should be listed here otherwise it's not in the result and you'll get a full join
        query.append(buildWhereSamplePatienOrgSQL(lowDatePostgres, highDatePostgres)
                        // insert joining of any other crosstab here.
                        + "\n AND s.id = demo.samp_id "
                        + "\n AND s.id = result.samp_id "
                        + "\n ORDER BY s.accession_number "
                        );
        // no don't insert another crosstab or table here, go up before the main WHERE clause
        return;        
    }
}
