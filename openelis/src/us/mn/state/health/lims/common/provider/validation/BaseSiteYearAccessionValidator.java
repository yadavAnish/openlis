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
package us.mn.state.health.lims.common.provider.validation;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import us.mn.state.health.lims.common.provider.validation.IAccessionNumberValidator.ValidationResults;
import us.mn.state.health.lims.common.util.ConfigurationProperties;
import us.mn.state.health.lims.common.util.DateUtil;
import us.mn.state.health.lims.common.util.SystemConfiguration;
import us.mn.state.health.lims.common.util.ConfigurationProperties.Property;
import us.mn.state.health.lims.common.util.resources.ResourceLocator;
import us.mn.state.health.lims.sample.dao.SampleDAO;
import us.mn.state.health.lims.sample.daoimpl.SampleDAOImpl;

public abstract class BaseSiteYearAccessionValidator {

	protected static final String INCREMENT_STARTING_VALUE = "000001";
	protected static final int UPPER_INC_RANGE = 999999;
	protected static final int SITE_START = 0;
	protected int SITE_END = getSiteEndIndex();
	protected int YEAR_START = getYearStartIndex();
	protected int YEAR_END = getYearEndIndex();
	protected int INCREMENT_START = getIncrementStartIndex();
	protected int INCREMENT_END = getMaxAccessionLength();
	protected int LENGTH = getMaxAccessionLength();
	protected static final boolean NEED_PROGRAM_CODE = false;
	private static Set<String> REQUESTED_NUMBERS = new HashSet<String>();
	private static String siteCode =  null;

	public boolean needProgramCode() {
		return NEED_PROGRAM_CODE;
	}

	// input parameter is not used in this case
	public String createFirstAccessionNumber(String nullPrefix) {
		StringBuilder builder = new StringBuilder(getSiteCode());

		builder.append(DateUtil.getTwoDigitYear());
		builder.append(INCREMENT_STARTING_VALUE);
		return builder.toString();
	}

	public String getInvalidMessage(ValidationResults results) {
		String suggestedAccessionNumber = getNextAvailableAccessionNumber(null);

		StringBuilder builder = new StringBuilder();

		String configLocale = SystemConfiguration.getInstance().getDefaultLocale().toString();
		Locale locale = new Locale(configLocale);

		String message = ResourceLocator.getInstance().getMessageResources().getMessage(locale,
				"sample.entry.invalid.accession.number.suggestion");

		builder.append(message);
		builder.append(" ");
		builder.append(suggestedAccessionNumber);

		return builder.toString();

	}

	// input parameter is not used in this case
	public String getNextAvailableAccessionNumber(String nullPrefix) {

		String nextAccessionNumber = null;

		SampleDAO sampleDAO = new SampleDAOImpl();

		String curLargestAccessionNumber = sampleDAO.getLargestAccessionNumberMatchingPattern(ConfigurationProperties.getInstance().getPropertyValue(Property.SiteCode),
				                                                                               getMaxAccessionLength());

		if (curLargestAccessionNumber == null) {
			nextAccessionNumber = createFirstAccessionNumber(null);
		} else {
			nextAccessionNumber = incrementAccessionNumber(curLargestAccessionNumber);
			
			while( REQUESTED_NUMBERS.contains(nextAccessionNumber) ){
				nextAccessionNumber = incrementAccessionNumber(nextAccessionNumber);
			}
			
			REQUESTED_NUMBERS.add(nextAccessionNumber);
		}

		return nextAccessionNumber;
	}

	public String incrementAccessionNumber(String currentHighAccessionNumber) throws IllegalArgumentException {
		// if the year differs then start the sequence again. If not then
		// increment but check for overflow into year
		int year = new GregorianCalendar().get(Calendar.YEAR) - 2000;

		try {
			if (year != Integer.parseInt(currentHighAccessionNumber.substring(YEAR_START, YEAR_END))) {
				return createFirstAccessionNumber(null);
			}
		} catch (NumberFormatException nfe) {
			return createFirstAccessionNumber(null);
		}

		int increment = Integer.parseInt(currentHighAccessionNumber.substring(INCREMENT_START));
		String incrementAsString = INCREMENT_STARTING_VALUE;

		if (increment < UPPER_INC_RANGE) {
			increment++;
			incrementAsString = String.format("%06d", increment);
		} else {
			throw new IllegalArgumentException("AccessionNumber has no next value");
		}

		StringBuilder builder = new StringBuilder(currentHighAccessionNumber.substring(SITE_START, YEAR_END));
		builder.append(incrementAsString);

		return builder.toString();
	}

	// recordType parameter is not used in this case
	public boolean accessionNumberIsUsed(String accessionNumber, String recordType) {

		SampleDAO SampleDAO = new SampleDAOImpl();

		return SampleDAO.getSampleByAccessionNumber(accessionNumber) != null;
	}

	public ValidationResults checkAccessionNumberValidity(String accessionNumber, String recordType, String isRequired,
			String projectFormName) {

			ValidationResults results = validFormat(accessionNumber, true);
			//TODO refactor accessionNumberIsUsed into two methods so the null isn't needed. (Its only used for program accession number)
			if (results == ValidationResults.SUCCESS && accessionNumberIsUsed(accessionNumber, null)) {
				results = ValidationResults.USED_FAIL;
			}

			return results;
	}

	public ValidationResults validFormat(String accessionNumber, boolean checkDate) {
		// The rule is 4 digit site code, 2 digit year and 6 incremented numbers
		if (accessionNumber.length() != LENGTH) {
			return ValidationResults.LENGTH_FAIL;
		}

		if (!accessionNumber.substring(SITE_START, SITE_END).equals( getSiteCode())) {
			return ValidationResults.SITE_FAIL;
		}

		int year = new GregorianCalendar().get(Calendar.YEAR);

		if (checkDate) {
			try {
				if ((year - 2000) != Integer.parseInt(accessionNumber.substring(YEAR_START, YEAR_END))) {
					return ValidationResults.YEAR_FAIL;
				}
			} catch (NumberFormatException nfe) {
				return ValidationResults.YEAR_FAIL;
			}
		}

		try {
			Integer.parseInt(accessionNumber.substring(INCREMENT_START));
		} catch (NumberFormatException e) {
			return ValidationResults.FORMAT_FAIL;
		}

		return ValidationResults.SUCCESS;
	}
	//protected abstract ValidationResults validFormat( String accessionNumber, boolean checkDate);

	protected abstract int getIncrementStartIndex();

	protected abstract int getYearEndIndex();

	protected abstract int getYearStartIndex();

	protected abstract int getSiteEndIndex();

	protected abstract int getMaxAccessionLength();

	private static String getSiteCode() {
		if( siteCode == null){
			siteCode = ConfigurationProperties.getInstance().getPropertyValue(Property.SiteCode);
		}
		return siteCode;
	}

	public static void setSiteCode(String siteCode) {
		BaseSiteYearAccessionValidator.siteCode = siteCode;
	}
}
