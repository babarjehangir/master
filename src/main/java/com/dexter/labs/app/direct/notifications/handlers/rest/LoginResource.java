/**
 * 
 */
package com.dexter.labs.app.direct.notifications.handlers.rest;

import org.openid4java.discovery.DiscoveryInformation;
import org.openid4java.message.AuthRequest;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

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

	@Get("json")
	public Representation represent() {

		String openid = getOpenIdUrl();
		DiscoveryInformation discoveryInfo = RegistrationService
				.performDiscoveryOnUserSuppliedIdentifier(openid);

		AuthRequest authRequest = RegistrationService.createOpenIdAuthRequest(
				discoveryInfo, "http://www.quratknitwear.com/");
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
