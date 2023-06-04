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

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import us.mn.state.health.lims.common.servlet.validation.AjaxServlet;
import us.mn.state.health.lims.common.util.DateUtil;
import us.mn.state.health.lims.common.util.StringUtil;

/**
 * The QuickEntryAccessionNumberValidationProvider class is used to validate,
 * via AJAX.
 * 
 */
public class NonConformityRecordNumberValidationProvider extends BaseValidationProvider {

	public NonConformityRecordNumberValidationProvider() {
		super();
	}

	public NonConformityRecordNumberValidationProvider(AjaxServlet ajaxServlet) {
		this.ajaxServlet = ajaxServlet;
	}

	@Override
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String field = request.getParameter("fieldId");
		String recordNumber = request.getParameter("value");

		RecordValidation validator = new RecordValidation(recordNumber);
		RecordValidation.Validation result = validator.validate();

		String returnData = VALID;
		switch (result) {
		case RECORD_FOUND:
			returnData = "Record found";
			break;
		case RECORD_NOT_FOUND:
			returnData = "Record not Found";
			break;
		default:
			returnData = validator.getInvalidMessage();
		}

		response.setCharacterEncoding("UTF-8");
		ajaxServlet.sendData(field, returnData, request, response);
	}

	public static String getDocumentNumberFormat() {
		return  "ddd/LNSP-" + DateUtil.getTwoDigitYear();
	}
	
	static class RecordValidation {
		String recordNumber;
		String format;
		String displayFormat;

		enum Validation {
			FORMAT_ERROR, RECORD_FOUND, RECORD_NOT_FOUND
		};

		public RecordValidation(String recordNumber) {
			this.recordNumber = recordNumber;
		}

		Validation validate() {
			if (validFormat()) {
				return Validation.RECORD_NOT_FOUND;
			}

			return Validation.FORMAT_ERROR;
		}

		private boolean validFormat() {
			createFormatPattern();
			Pattern p = Pattern.compile(format);
			return p.matcher(recordNumber).matches();
		}

		private void createFormatPattern() {
			format = "\\d{3}/LNSP-" + DateUtil.getTwoDigitYear();
		}

		String getInvalidMessage() {
			return StringUtil.getMessageForKey("nonConformity.document.number.format.error", getDocumentNumberFormat());
		}

	}
}
