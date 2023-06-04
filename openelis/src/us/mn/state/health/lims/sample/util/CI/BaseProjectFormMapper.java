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
package us.mn.state.health.lims.sample.util.CI;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.DynaBean;

import us.mn.state.health.lims.common.action.BaseActionForm;
import us.mn.state.health.lims.common.exception.LIMSRuntimeException;
import us.mn.state.health.lims.common.util.validator.GenericValidator;
import us.mn.state.health.lims.dictionary.ObservationHistoryList;
import us.mn.state.health.lims.observationhistory.valueholder.ObservationHistory;
import us.mn.state.health.lims.observationhistory.valueholder.ObservationHistory.ValueType;
import us.mn.state.health.lims.observationhistorytype.ObservationHistoryTypeMap;
import us.mn.state.health.lims.patient.valueholder.AdverseEffect;
import us.mn.state.health.lims.patient.valueholder.ObservationData;
import us.mn.state.health.lims.sample.form.ProjectData;
import us.mn.state.health.lims.test.dao.TestDAO;
import us.mn.state.health.lims.test.daoimpl.TestDAOImpl;
import us.mn.state.health.lims.test.valueholder.Test;
import us.mn.state.health.lims.typeofsample.dao.TypeOfSampleDAO;
import us.mn.state.health.lims.typeofsample.daoimpl.TypeOfSampleDAOImpl;
import us.mn.state.health.lims.typeofsample.valueholder.TypeOfSample;

public abstract class BaseProjectFormMapper implements IProjectFormMapper {

    /**
     * In the question which controls the use of "any" of a group of repeated questions ("Any diseases? Any Treatment?), there are several possible Yes answers each from a different list.
     */
    public static final List<String> YES_ANSWERS = Arrays.asList(ObservationHistoryList.YES_NO.getList().get(0).getId(), ObservationHistoryList.YES_NO_NA.getList().get(0).getId(), ObservationHistoryList.YES_NO_UNKNOWN.getList().get(0).getId());
    
    public static final String ORGANIZATION_ID_NONE = "0";

    protected ProjectData projectData;
    
    protected String organizationId;

    protected BaseActionForm dynaForm;

    protected String projectFormId;

    protected boolean patientForm;
    
    public ProjectForm getProjectForm() {
        return ProjectForm.findProjectFormByFormId(projectFormId);
    }
    
    public BaseProjectFormMapper(String projectFormId, BaseActionForm dynaForm) {
		    this.dynaForm = dynaForm;
		    this.projectFormId = projectFormId;
			initProjectData(dynaForm);
	}

	protected Test createTest(String testName){
		Test test = new Test();
		test.setTestName(testName);
		TestDAO testDAO = new TestDAOImpl();
		test = testDAO.getTestByName(test);
		if (test == null) {
		    throw new LIMSRuntimeException("Unable to find test '" + testName +"'");
		}
		return test;
	}


	public final class TypeOfSampleTests {
		public TypeOfSample typeOfSample;
		public List<Test> tests;


		public TypeOfSampleTests(TypeOfSample typeOfSample, List<Test> tests) {
			this.typeOfSample = typeOfSample;
			this.tests = tests;

		}
	}

	public TypeOfSample getTypeOfSample(String typeName) {
		return getTypeOfSampleByDescription(typeName);
	}

	// TODO PAHill Maybe should move to some utility class
	public static TypeOfSample getTypeOfSampleByDescription(String typeName) {
        TypeOfSampleDAO typeofsampleDAO = new TypeOfSampleDAOImpl();
		TypeOfSample typeofsample = new TypeOfSample();
		typeofsample.setDescription(typeName);
		typeofsample = typeofsampleDAO.getTypeOfSampleByDescriptionAndDomain(typeofsample, true); //true = ignoreCase

		return typeofsample;
    }

	private void initProjectData(BaseActionForm dynaForm) {
	    if ( dynaForm != null) {
	        projectData = (ProjectData)dynaForm.get("ProjectData");
	    }
	}
    public List<ObservationHistory> readObservationHistories(ObservationData od) {
        List<ObservationHistory> histories = new ArrayList<ObservationHistory>();
        addHistory(histories, "projectFormName",          od.getProjectFormName()         ,ValueType.LITERAL);
        addHistory(histories, "educationLevel",           od.getEducationLevel()          ,ValueType.DICTIONARY);
        addHistory(histories, "maritalStatus",            od.getMaritalStatus()           ,ValueType.DICTIONARY);
        
        addHistory(histories, "nationality",              od.getNationality()             ,ValueType.DICTIONARY);
        addHistory(histories, "nationality",              od.getNationalityOther()        ,ValueType.LITERAL);
        
        addHistory(histories, "legalResidence",           od.getLegalResidence()          ,ValueType.LITERAL);
        addHistory(histories, "nameOfDoctor",             od.getNameOfDoctor()            ,ValueType.LITERAL);
        addHistory(histories, "anyPriorDiseases",         od.getAnyPriorDiseases()        ,ValueType.DICTIONARY);
        addHistory(histories, "arvProphylaxisBenefit",    od.getArvProphylaxisBenefit()   ,ValueType.DICTIONARY);
        addHistory(histories, "arvProphylaxis",           od.getArvProphylaxis()          ,ValueType.DICTIONARY);
        addHistory(histories, "currentARVTreatment",      od.getCurrentARVTreatment()     ,ValueType.DICTIONARY);
        addHistory(histories, "priorARVTreatment",        od.getPriorARVTreatment()       ,ValueType.DICTIONARY);
        addHistory(histories, "cotrimoxazoleTreatment",   od.getCotrimoxazoleTreatment()  ,ValueType.DICTIONARY);
        addHistory(histories, "aidsStage",                od.getAidsStage()               ,ValueType.DICTIONARY);
        addHistory(histories, "anyCurrentDiseases",       od.getAnyCurrentDiseases()       ,ValueType.DICTIONARY);
        addHistory(histories, "currentOITreatment",       od.getCurrentOITreatment()      ,ValueType.DICTIONARY);
        addHistory(histories, "patientWeight",            od.getPatientWeight()           ,ValueType.LITERAL);
        addHistory(histories, "karnofskyScore",           od.getKarnofskyScore()          ,ValueType.LITERAL);
        // ARV followup fields not listed above
        // hivStatus is not a survey question, but something verified from previous information.  Further note, the business rules need
        // clarification.  For now what is entered will be saved.
        addHistory(histories, "hivStatus",                od.getHivStatus()               ,ValueType.DICTIONARY);
        addHistory(histories, "cd4Count",                 od.getCd4Count()                ,ValueType.LITERAL);
        addHistory(histories, "cd4Percent",               od.getCd4Percent()              ,ValueType.LITERAL);
        addHistory(histories, "priorCd4Date",             od.getPriorCd4Date()            ,ValueType.LITERAL);
        addHistory(histories, "antiTbTreatment",          od.getAntiTbTreatment()         ,ValueType.DICTIONARY);
        addHistory(histories, "interruptedARVTreatment",  od.getInterruptedARVTreatment() ,ValueType.DICTIONARY);
        addHistory(histories,"arvTreatmentAnyAdverseEffects"          ,od.getArvTreatmentAnyAdverseEffects(), ValueType.DICTIONARY);
        addHistory(histories,"arvTreatmentChange"                     ,od.getArvTreatmentChange(), ValueType.DICTIONARY);
        addHistory(histories,"arvTreatmentNew"                        ,od.getArvTreatmentNew(), ValueType.DICTIONARY);
        addHistory(histories,"arvTreatmentRegime"                     ,od.getArvTreatmentRegime(), ValueType.DICTIONARY);
        addHistory(histories,"cotrimoxazoleTreatAnyAdvEff", od.getCotrimoxazoleTreatmentAnyAdverseEffects(), ValueType.DICTIONARY);
        addHistory(histories,"anySecondaryTreatment"                  ,od.getAnySecondaryTreatment(), ValueType.DICTIONARY);
        addHistory(histories,"secondaryTreatment"                     ,od.getSecondaryTreatment(), ValueType.DICTIONARY);
        addHistory(histories,"clinicVisits"                           ,od.getClinicVisits(), ValueType.LITERAL);
        // RTN Study fields not listed above
        addHistory(histories, "hospital"        ,od.getHospital()       ,ValueType.DICTIONARY);
        addHistory(histories, "service"         ,od.getService()        ,ValueType.DICTIONARY);
        addHistory(histories, "hospitalPatient" ,od.getHospitalPatient(),ValueType.DICTIONARY);
        addHistory(histories, "reason"          ,od.getReason()         ,ValueType.LITERAL);
        // EID Study fields not listed above
        addHistory(histories, "whichPCR"               , od.getWhichPCR()               , ValueType.DICTIONARY);
        addHistory(histories, "reasonForSecondPCRTest" , od.getReasonForSecondPCRTest() , ValueType.DICTIONARY);
        addHistory(histories, "indFirstTestName"       , od.getIndFirstTestName()       , ValueType.LITERAL   );
        addHistory(histories, "indSecondTestName"      , od.getIndSecondTestName()      , ValueType.LITERAL   );
        addHistory(histories, "indFirstTestDate"       , od.getIndFirstTestDate()       , ValueType.LITERAL   );
        addHistory(histories, "indSecondTestDate"      , od.getIndSecondTestDate()      , ValueType.LITERAL   );
        addHistory(histories, "indFirstTestResult"     , od.getIndFirstTestResult()     , ValueType.LITERAL   );
        addHistory(histories, "indSecondTestResult"    , od.getIndSecondTestResult()    , ValueType.LITERAL   );
        addHistory(histories, "indSiteFinalResult"     , od.getIndSiteFinalResult()     , ValueType.LITERAL   );
        // Patient fields on the EID Sample Form
        addHistory(histories, "eidInfantPTME"          , od.getEidInfantPTME()          , ValueType.DICTIONARY);
        addHistory(histories, "eidTypeOfClinic"        , od.getEidTypeOfClinic()        , ValueType.DICTIONARY);
        
        addHistory(histories, "eidTypeOfClinicOther"   , od.getEidTypeOfClinicOther()   , ValueType.LITERAL);
        addHistory(histories, "eidHowChildFed"         , od.getEidHowChildFed()         , ValueType.DICTIONARY);
        addHistory(histories, "eidStoppedBreastfeeding", od.getEidStoppedBreastfeeding(), ValueType.DICTIONARY);        
        addHistory(histories, "eidInfantSymptomatic"   , od.getEidInfantSymptomatic()   , ValueType.DICTIONARY);
        addHistory(histories, "eidMothersHIVStatus"    , od.getEidMothersHIVStatus()    , ValueType.DICTIONARY);
        addHistory(histories, "eidMothersARV"          , od.getEidMothersARV()          , ValueType.DICTIONARY);
        addHistory(histories, "eidInfantsARV"          , od.getEidInfantsARV()          , ValueType.DICTIONARY);
        addHistory(histories, "eidInfantCotrimoxazole" , od.getEidInfantCotrimoxazole() , ValueType.DICTIONARY);
        addHistory(histories, "nameOfSampler"          ,od.getNameOfSampler()           , ValueType.LITERAL);
        addHistory(histories, "nameOfRequestor"        , od.getNameOfRequestor()        , ValueType.LITERAL);
        // Sample Special Request Form
        addHistory(histories, "reason"        , od.getReasonForRequest()      , ValueType.DICTIONARY);
        addHistory(histories, "underInvestigation"      ,od.getUnderInvestigation(), ValueType.DICTIONARY);
        
        // all of lists of diseases which had not been explicitly separately named before.
        addHistory(histories ,"CTBPul"      ,od.getCTBPul() ,ValueType.DICTIONARY);     
        addHistory(histories ,"CTBExpul"    ,od.getCTBExpul() ,ValueType.DICTIONARY);   
        addHistory(histories ,"CCrblToxo"   ,od.getCCrblToxo() ,ValueType.DICTIONARY);  
        addHistory(histories ,"CCryptoMen"  ,od.getCCryptoMen() ,ValueType.DICTIONARY); 
        addHistory(histories ,"CGenPrurigo" ,od.getCGenPrurigo() ,ValueType.DICTIONARY);
        addHistory(histories ,"CIST"        ,od.getCIST() ,ValueType.DICTIONARY);       
        addHistory(histories ,"CCervCancer" ,od.getCCervCancer() ,ValueType.DICTIONARY);
        addHistory(histories ,"COpharCand"  ,od.getCOpharCand() ,ValueType.DICTIONARY); 
        addHistory(histories ,"CKaposiSarc" ,od.getCKaposiSarc() ,ValueType.DICTIONARY);
        addHistory(histories ,"CShingles"   ,od.getCShingles() ,ValueType.DICTIONARY);  
        addHistory(histories ,"CDiarrheaC"  ,od.getCDiarrheaC() ,ValueType.DICTIONARY); 
        addHistory(histories ,"PTBPul"      ,od.getPTBPul() ,ValueType.DICTIONARY);     
        addHistory(histories ,"PTBExpul"    ,od.getPTBExpul() ,ValueType.DICTIONARY);   
        addHistory(histories ,"PCrblToxo"   ,od.getPCrblToxo() ,ValueType.DICTIONARY);  
        addHistory(histories ,"PCryptoMen"  ,od.getPCryptoMen() ,ValueType.DICTIONARY); 
        addHistory(histories ,"PGenPrurigo" ,od.getPGenPrurigo() ,ValueType.DICTIONARY);
        addHistory(histories ,"PIST"        ,od.getPIST() ,ValueType.DICTIONARY);       
        addHistory(histories ,"PCervCancer" ,od.getPCervCancer() ,ValueType.DICTIONARY);
        addHistory(histories ,"POpharCand"  ,od.getPOpharCand() ,ValueType.DICTIONARY); 
        addHistory(histories ,"PKaposiSarc" ,od.getPKaposiSarc() ,ValueType.DICTIONARY);
        addHistory(histories ,"PShingles"   ,od.getPShingles() ,ValueType.DICTIONARY);  
        addHistory(histories ,"PDiarrheaC"  ,od.getPDiarrheaC() ,ValueType.DICTIONARY); 
        addHistory(histories ,"weightLoss"  ,od.getWeightLoss() ,ValueType.DICTIONARY); 
        addHistory(histories ,"diarrhea"    ,od.getDiarrhea() ,ValueType.DICTIONARY);   
        addHistory(histories ,"fever"       ,od.getFever() ,ValueType.DICTIONARY);      
        addHistory(histories ,"cough"       ,od.getCough() ,ValueType.DICTIONARY);      
        addHistory(histories ,"pulTB"       ,od.getPulTB() ,ValueType.DICTIONARY);      
        addHistory(histories ,"expulTB"     ,od.getExpulTB() ,ValueType.DICTIONARY);    
        addHistory(histories ,"swallPaint"  ,od.getSwallPaint() ,ValueType.DICTIONARY); 
        addHistory(histories ,"cryptoMen"   ,od.getCryptoMen() ,ValueType.DICTIONARY);  
        addHistory(histories ,"recPneumon"  ,od.getRecPneumon() ,ValueType.DICTIONARY); 
        addHistory(histories ,"sespis"      ,od.getSespis() ,ValueType.DICTIONARY);     
        addHistory(histories ,"recInfect"   ,od.getRecInfect() ,ValueType.DICTIONARY);  
        addHistory(histories ,"curvixC"     ,od.getCurvixC() ,ValueType.DICTIONARY);    
        addHistory(histories ,"matHIV"      ,od.getMatHIV() ,ValueType.DICTIONARY);     
        addHistory(histories ,"cachexie"    ,od.getCachexie() ,ValueType.DICTIONARY);   
        addHistory(histories ,"thrush"      ,od.getThrush() ,ValueType.DICTIONARY);     
        addHistory(histories ,"dermPruip"   ,od.getDermPruip() ,ValueType.DICTIONARY);  
        addHistory(histories ,"herpes"      ,od.getHerpes() ,ValueType.DICTIONARY);     
        addHistory(histories ,"zona"        ,od.getZona() ,ValueType.DICTIONARY);       
        addHistory(histories ,"sarcKapo"    ,od.getSarcKapo() ,ValueType.DICTIONARY);   
        addHistory(histories ,"xIngPadenp"  ,od.getxIngPadenp() ,ValueType.DICTIONARY); 
        addHistory(histories ,"HIVDement"   ,od.getHIVDement() ,ValueType.DICTIONARY);
        
        addHistory(histories ,"priorDiseases", od.getPriorDiseases(), ValueType.DICTIONARY);
        addHistory(histories ,"priorDiseases", od.getPriorDiseasesValue(), ValueType.LITERAL);
        
        addHistory(histories ,"currentDiseases", od.getCurrentDiseases(), ValueType.DICTIONARY);
        addHistory(histories ,"currentDiseases", od.getCurrentDiseasesValue(), ValueType.LITERAL);
        return histories;
    }
    /**
     * @param histories
     * @param string
     * @param educationLevel
     * @param dictionary
     */
    protected void addHistory(List<ObservationHistory> histories, String ohNameKey, String value, ValueType type) {
        if (!GenericValidator.isBlankOrNull(value)) {
            histories.add(buildObservationHistory(ohNameKey, value, type));
        }
    }

    /**
     * Do all lists for all forms.
     * This could be separated out into each mapper, so only the right lists for the right list are processed at any one time.
     * @see us.mn.state.health.lims.sample.util.CI.IProjectFormMapper#readObservationHistoryLists(us.mn.state.health.lims.patient.valueholder.ObservationData)
     */
    public Map<String, List<ObservationHistory>> readObservationHistoryLists(ObservationData od) {
        Map<String, List<ObservationHistory>> historiesLists = new HashMap<String, List<ObservationHistory>>();
        historiesLists.put("priorARVTreatmentINNs", buildObservationHistoryList("priorARVTreatmentINNs", od.getPriorARVTreatment(), od.getPriorARVTreatmentINNsList(), ValueType.LITERAL));
        // ARV Follow-up lists
        historiesLists.put("futureARVTreatmentINNs", buildObservationHistoryList("futureARVTreatmentINNs", od.getArvTreatmentNew(), od.getFutureARVTreatmentINNsList(), ValueType.LITERAL));
        historiesLists.put("arvTreatmentAdvEffGrd",        readAdverseEffectGrades("arvTreatmentAdvEffGrd", od.getArvTreatmentAnyAdverseEffects(), od.getArvTreatmentAdverseEffects() ));
        historiesLists.put("arvTreatmentAdvEffType",       readAdverseEffectType("arvTreatmentAdvEffType", od.getArvTreatmentAnyAdverseEffects(), od.getArvTreatmentAdverseEffects() ));
        historiesLists.put("cotrimoxazoleTreatAdvEffGrd",  readAdverseEffectGrades("cotrimoxazoleTreatAdvEffGrd", od.getCotrimoxazoleTreatmentAnyAdverseEffects(), od.getCotrimoxazoleTreatmentAdverseEffects()));
        historiesLists.put("cotrimoxazoleTreatAdvEffType", readAdverseEffectType("cotrimoxazoleTreatAdvEffType", od.getCotrimoxazoleTreatmentAnyAdverseEffects(), od.getCotrimoxazoleTreatmentAdverseEffects()));
        return historiesLists;
    }

    /**
     *
     */
    private List<ObservationHistory> readAdverseEffectGrades(String historyType, String controlAnswer, List<AdverseEffect> adverseEffects) {
        List<ObservationHistory> histories = new ArrayList<ObservationHistory>();
        if (YES_ANSWERS.contains(controlAnswer)) {
            for (AdverseEffect ae : adverseEffects) {
                String value = ae.getGrade();
                if (!GenericValidator.isBlankOrNull(value)) {
                    histories.add(buildObservationHistory(historyType, value, ValueType.LITERAL));
                }
            }
        }
        return histories;
    }

    private List<ObservationHistory> readAdverseEffectType(String historyType, String controlAnswer, List<AdverseEffect> adverseEffects) {
        List<ObservationHistory> histories = new ArrayList<ObservationHistory>();
        if (YES_ANSWERS.contains(controlAnswer)) {
            for (AdverseEffect ae : adverseEffects) {
                String value = ae.getType();
                if (!GenericValidator.isBlankOrNull(value)) {
                    histories.add(buildObservationHistory(historyType, value, ValueType.LITERAL));
                }
            }
        }
        return histories;
    }

    /**
     * Add a whole bunch of answers all for the same observation history type (eg. list of drugs, symptoms, treatments etc.).
     * defined values.
     * @param observationHistoryTypeName
     * @param answers
     * @param valueType
     * @param answer in some field
     */
    protected List<ObservationHistory> buildObservationHistoryList(String observationHistoryTypeName, String controlField, List<String> answers, ValueType valueType) {
        List<ObservationHistory> histories = new ArrayList<ObservationHistory>();
        if (YES_ANSWERS.contains(controlField)) {
            for (String answer : answers) {
                if (!GenericValidator.isBlankOrNull(answer)) {
                    ObservationHistory newHistory = buildObservationHistory(observationHistoryTypeName, answer, valueType);
                    histories.add(newHistory);
                }
            }
        }
        return histories;
    }
    
    /**
     * create a observation history from the values given
     * @param nameKey
     * @param value
     * @param valueType
     * @param observationHistories
     * @param observationHistoryTypeId
     */
    protected ObservationHistory buildObservationHistory(String nameKey, String value, ValueType valueType) {
        String ohTypeId = ObservationHistoryTypeMap.getInstance().getIDForType(nameKey);
        if (null == ohTypeId) {
            throw new LIMSRuntimeException("ObservationTypeId.nameKey = " + nameKey + " not found in database. You may need to run a database update." );
        }

        ObservationHistory history = new ObservationHistory();
        history.setObservationHistoryTypeId(ohTypeId);
        history.setValue(value);
        history.setValueType(valueType);
        return history;
    }

    /**
     * Sometimes we want to push things into the patient record (and its children), but sometimes we don't.
     * Override this to change that behavior.
     * @return true => take everything from the submission and put it in the patient entities.
     */
    public boolean getShouldPopulatePatient() {
        return true;
    }

    /**
     * ?type=xxxxx specifies how we are using a study form.
     * @see us.mn.state.health.lims.sample.util.CI.IProjectFormMapper#isSecondEntry(javax.servlet.http.HttpServletRequest)
     */
    public boolean isSecondEntry(HttpServletRequest request) {
        String verify = request.getParameter("type");
        return "verify".equals(verify);
    }

    public String getCollectionDate() {
        return dynaForm.getString("interviewDate");
    }

    public String getReceivedDate() {
        return dynaForm.getString("receivedDateForDisplay");
    }
    
    public String getCollectionTime() {
        return dynaForm.getString("interviewTime");
    }

    public String getReceivedTime() {
        return dynaForm.getString("receivedTimeForDisplay");
    }
    
    /**
     * @see us.mn.state.health.lims.sample.util.CI.IProjectFormMapper#setPatientForm(boolean)
     */

    public void setPatientForm(boolean b) {
        this.patientForm = b;
    }

    public void setProjectData(ProjectData projectData) {
        this.projectData = projectData;
    }

    public ProjectData getProjectData() {
        return projectData;
    }
    
    public String getSiteSubjectNumber() {
        return dynaForm.getString("siteSubjectNumber");
    }
    
    // the forms have the organization ID in "centerCode", but sample forms have them in various projectData property.  
    public String getOrganizationId() {
        if (patientForm) {
            return dynaForm.get("centerCode").toString();
        } else {
            return getSampleCenterCode();
        }
    }
    
    public ObservationData getObservationData() { 
        return (ObservationData) (this.getDynaBean().get("observations"));
    }
    
    /**
     * This is the database key of patient loaded when editing and submitted in the form data
     * @return
     */
    public String getPatientId() {
        return dynaForm.getString("patientPK");
    }

    /**
     * This is the database key of sample loaded when editing and submitted in the form data
     * @return
     */
    public String getSampleId() {
        return dynaForm.getString("samplePK");
    }
    
    /**
     * @return center code from the form
     */
    public abstract String getSampleCenterCode();
    
    public DynaBean getDynaBean() {
        return dynaForm;
    }
}
