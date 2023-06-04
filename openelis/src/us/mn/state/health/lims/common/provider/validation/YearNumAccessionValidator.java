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
package us.mn.state.health.lims.common.provider.validation;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import us.mn.state.health.lims.common.util.DateUtil;
import us.mn.state.health.lims.common.util.SystemConfiguration;
import us.mn.state.health.lims.common.util.resources.ResourceLocator;
import us.mn.state.health.lims.sample.dao.SampleDAO;
import us.mn.state.health.lims.sample.daoimpl.SampleDAOImpl;

public class YearNumAccessionValidator implements IAccessionNumberValidator {

	private String incrementStartingValue = "000001";
	private static int upperIncrementValue = 999999;
	private static final int INCREMENT_START = 2;
	private static final int YEAR_START = 0;
	private static final int YEAR_END = 2;
	private int acccessionLength = 8;
	private static final boolean NEED_PROGRAM_CODE = false;
	private static Set<String> REQUESTED_NUMBERS = new HashSet<String>();
	private final boolean useSeparator;
	private final String separator;
	private final int separatorLength;
	private String incrementFormat;

	public YearNumAccessionValidator( int length, Character separator){
		useSeparator = separator != null;
		this.separator = useSeparator ? separator.toString() : "";
		separatorLength = useSeparator ? 1 : 0;
		incrementFormat = "%0" + String.valueOf(length) + "d";
		incrementStartingValue = String.format(incrementFormat, 1);
		String upper = incrementStartingValue.replace("0", "9").replace("1", "9");
		upperIncrementValue = Integer.parseInt(upper);	
		acccessionLength = length + YEAR_END + (useSeparator ? 1 : 0);
	}
	
	public boolean needProgramCode() {
		return NEED_PROGRAM_CODE;
	}

	public String createFirstAccessionNumber(String programCode) {
		return DateUtil.getTwoDigitYear() + separator + incrementStartingValue;
	}

	public String incrementAccessionNumber(String currentHighAccessionNumber) {

		int increment = Integer.parseInt(currentHighAccessionNumber.substring(INCREMENT_START + separatorLength));
		String incrementAsString = incrementStartingValue;
		String year = DateUtil.getTwoDigitYear();

		if (year.equals(currentHighAccessionNumber.substring(YEAR_START, YEAR_END))) {
			if (increment < upperIncrementValue) {
				increment++;
				incrementAsString = String.format(incrementFormat, increment);
			} else {
				throw new IllegalArgumentException("AccessionNumber has no next value");
			}
		}

		StringBuilder builder = new StringBuilder(year);
		builder.append(separator);
		builder.append(incrementAsString);

		return builder.toString();
	}

	public ValidationResults validFormat(String accessionNumber, boolean checkDate) {
		// The rule is 2 digit year code and incremented numbers
		if (accessionNumber.length() != acccessionLength) {
			return ValidationResults.LENGTH_FAIL;
		}

		if(checkDate){
			if( !DateUtil.getTwoDigitYear().equals(accessionNumber.substring(YEAR_START, YEAR_END))){
				return ValidationResults.YEAR_FAIL;
			}
		}

		try {
			Integer.parseInt(accessionNumber.substring(INCREMENT_START + separatorLength));
		} catch (NumberFormatException e) {
			return ValidationResults.FORMAT_FAIL;
		}

		return ValidationResults.SUCCESS;
	}

	public String getInvalidMessage(ValidationResults results) {
		String configLocale = SystemConfiguration.getInstance().getDefaultLocale().toString();
		Locale locale = new Locale(configLocale);

		switch (results) {
		case LENGTH_FAIL:
			return ResourceLocator.getInstance().getMessageResources().getMessage(locale, "sample.entry.invalid.accession.number.length");
		case USED_FAIL:
			return ResourceLocator.getInstance().getMessageResources().getMessage(locale, "sample.entry.invalid.accession.number.used");
		case PROGRAM_FAIL:
			return ResourceLocator.getInstance().getMessageResources().getMessage(locale, "sample.entry.invalid.accession.number.program");
		case FORMAT_FAIL:
			return ResourceLocator.getInstance().getMessageResources().getMessage(locale, "sample.entry.invalid.accession.number.format");
		default:
			return ResourceLocator.getInstance().getMessageResources().getMessage(locale, "sample.entry.invalid.accession.number");

		}

	}

	public String getNextAvailableAccessionNumber(String prefix) {
		String nextAccessionNumber = null;

		SampleDAO accessionNumberDAO = new SampleDAOImpl();

		String curLargestAccessionNumber = accessionNumberDAO.getLargestAccessionNumberWithPrefix(prefix);

		if (curLargestAccessionNumber == null) {
			nextAccessionNumber = createFirstAccessionNumber(prefix);
		} else {
			nextAccessionNumber = incrementAccessionNumber(curLargestAccessionNumber);
		}

		while( REQUESTED_NUMBERS.contains(nextAccessionNumber) ){
			nextAccessionNumber = incrementAccessionNumber(nextAccessionNumber);
		}
		
		REQUESTED_NUMBERS.add(nextAccessionNumber);
		
		return nextAccessionNumber;
	}

	public int getMaxAccessionLength() {
		return acccessionLength;
	}

	// recordType parameter is not used in this case
	public boolean accessionNumberIsUsed(String accessionNumber, String recordType) {

		SampleDAO sampleDAO = new SampleDAOImpl();

		return sampleDAO.getSampleByAccessionNumber(accessionNumber) != null;
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

	@Override
	public int getInvarientLength() {
		return YEAR_END + separatorLength;
	}

	@Override
	public int getChangeableLength() {
		return getMaxAccessionLength() - getInvarientLength();
	}
}
