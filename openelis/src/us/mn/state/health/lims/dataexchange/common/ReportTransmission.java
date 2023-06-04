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
package us.mn.state.health.lims.dataexchange.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;

import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.xml.Marshaller;
import org.xml.sax.InputSource;

import us.mn.state.health.lims.common.exception.LIMSRuntimeException;
import us.mn.state.health.lims.common.log.LogEvent;
import us.mn.state.health.lims.common.util.resources.ResourceLocator;

public class ReportTransmission {
	public enum HTTP_TYPE{
		GET,
		POST
	}
	
	public void sendReport(Object reportObject, String castorPropertyName, String url, boolean sendAsychronously,
			ITransmissionResponseHandler responseHandler) {
		
		String xmlString = null;
		String castorMappingName = getCastorMappingName(castorPropertyName);

		InputSource source = getSource(castorMappingName);

		Mapping castorMapping = new Mapping();
		try {
			castorMapping.loadMapping(source);

			Marshaller marshaller = new Marshaller();
			marshaller.setMapping(castorMapping);
			Writer writer = new StringWriter();
			marshaller.setWriter(writer);
			marshaller.marshal(reportObject);
			xmlString = writer.toString();
			 
			sendRawReport(xmlString, url, sendAsychronously, responseHandler, HTTP_TYPE.POST);
			
		}catch (UnknownHostException he) {
			List<String> errors = new ArrayList<String>();
			errors.add(he.toString());
			responseHandler.handleResponse(HttpServletResponse.SC_BAD_REQUEST, errors, xmlString);
		} catch (Exception e) {
			LogEvent.logError("ReportTransmission ", "sendResults()", e.toString());
		}

	}

	public void sendRawReport(String contents, String url, boolean sendAsychronously, ITransmissionResponseHandler responseHandler, HTTP_TYPE httpType) {
		try {
			IExternalSender sender;
			 //System.out.println(contents );
			switch (httpType) {
			case GET:
				sender = new HttpGetSender();
				break;
			case POST:
				sender = new HttpPostSender();
				sender.setMessage(contents);
			default:
				sender = new HttpPostSender();
				break;
			}
			
			sender.setURI(url);

			if (sendAsychronously) {
				AsynchronousExternalSender asynchSender = new AsynchronousExternalSender(sender, responseHandler, contents);
				asynchSender.sendMessage();
			} else {
				sender.sendMessage();
				if (responseHandler != null) {
					responseHandler.handleResponse(sender.getSendResponse(), sender.getErrors(), contents);
				}
			}
		} catch (Exception e) {
			LogEvent.logError("ReportTransmission ", "sendResults()", e.toString());
		}

	}

	private String getCastorMappingName(String mapping) {
		InputStream propertyStream = null;

		ResourceLocator resourceLocator = ResourceLocator.getInstance();

		Properties transmissionMap = new Properties();
		try {
			propertyStream = resourceLocator.getNamedResourceAsInputStream(ResourceLocator.XMIT_PROPERTIES);

			transmissionMap.load(propertyStream);
		} catch (IOException e) {
			LogEvent.logError("ReportTransmission ", "sendResults()", e.toString());
			throw new LIMSRuntimeException("Unable to load transmission resource mappings.", e);
		} finally {
			if (null != propertyStream) {
				try {
					propertyStream.close();
					propertyStream = null;
				} catch (Exception e) {
					LogEvent.logError("ReportTransmission ", "sendResults()", e.toString());
				}
			}
		}

		String castorMappingName = transmissionMap.getProperty(mapping);
		return castorMappingName;
	}

	protected InputSource getSource(String castorMappingName) {
		InputStream mappingXml = Thread.currentThread().getContextClassLoader().getResourceAsStream(castorMappingName);

		return new InputSource(mappingXml);
	}
}
