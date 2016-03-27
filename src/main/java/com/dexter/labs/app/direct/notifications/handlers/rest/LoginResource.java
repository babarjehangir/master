/**
 * 
 */
package com.dexter.labs.app.direct.notifications.handlers.rest;

import java.net.URLDecoder;

import org.openid4java.discovery.DiscoveryInformation;
import org.openid4java.message.AuthRequest;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import com.dexter.labs.app.direct.common.IGlobals;
import com.dexter.labs.app.direct.openid.RegistrationService;
import com.dexter.labs.communication.AppResponse;

/**
 * This restful resource will serve app direct open id authentication
 * 
 * @author Babar Jehangir Khan
 *
 */
public class LoginResource extends ServerResource {

	@Get("json")
	public Representation represent() {

		String openid = getOpenIdUrl();// "https://me.yahoo.com";//
										// getOpenIdUrl();

		DiscoveryInformation discoveryInfo = null;

		if (IGlobals.disInfoMap.containsKey(openid)) {
			discoveryInfo = IGlobals.disInfoMap.get(openid);
		} else {
			discoveryInfo = RegistrationService
					.performDiscoveryOnUserSuppliedIdentifier(openid);
		}

		if (discoveryInfo != null) {
			IGlobals.disInfoMap.put(openid, discoveryInfo);
		} else {
			// raise an exception
		}

		AuthRequest authRequest = RegistrationService.createOpenIdAuthRequest(
				discoveryInfo, IGlobals.VALIDATION_RETURN_URL);

		return new JacksonRepresentation<AppResponse>(
				AppResponse.buildLoginResponse(authRequest
						.getDestinationUrl(true)));
	}

	private String getOpenIdUrl() {
		return URLDecoder.decode(this.getAttribute(IGlobals.OPEN_ID_URL));
	}
}
