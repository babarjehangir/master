/**
 * 
 */
package com.dexter.labs.app.direct.notifications.handlers.rest;

import java.util.concurrent.ConcurrentMap;

import org.openid4java.discovery.DiscoveryInformation;
import org.openid4java.message.AuthRequest;
import org.restlet.Message;
import org.restlet.engine.header.Header;
import org.restlet.engine.header.HeaderConstants;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import org.restlet.util.Series;

import com.dexter.labs.HelloMessage;
import com.dexter.labs.app.direct.common.IConstants;
import com.dexter.labs.app.direct.openid.RegistrationService;

/**
 * This restful resource will serve app direct open id authentication
 * 
 * @author Babar Jehangir Khan
 *
 */
public class LoginResource extends ServerResource {

	private static final String HEADERS_KEY = "org.restlet.http.headers";

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Get("json")
	public Representation represent() {

		String openid = getOpenIdUrl();

		DiscoveryInformation discoveryInfo = RegistrationService
				.performDiscoveryOnUserSuppliedIdentifier(openid);

		AuthRequest authRequest = RegistrationService.createOpenIdAuthRequest(
				discoveryInfo, IConstants.VALIDATION_RETURN_URL);

		Series<Header> responseHeaders = (Series<Header>) getResponseAttributes()
				.get(HeaderConstants.ATTRIBUTE_HEADERS);
		if (responseHeaders == null) {
			responseHeaders = new Series(Header.class);
			getResponseAttributes().put(HeaderConstants.ATTRIBUTE_HEADERS,
					responseHeaders);
		}
		responseHeaders.add(new Header("Access-Control-Allow-Origin", "*"));
		getResponse().redirectSeeOther("https://www.google.com");
		return new JacksonRepresentation<HelloMessage>(new HelloMessage(
				(discoveryInfo != null ? "DISCOVERED"
						+ discoveryInfo.toString() + "DESTINATION URL "
						+ authRequest.getDestinationUrl(true)
						: " discovery failed")));
		// return "Hello Worldd";
	}

	private String getOpenIdUrl() {
		return this.getAttribute(IConstants.OPEN_ID_URL);
	}
}
