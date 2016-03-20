/**
 * 
 */
package com.dexter.labs.app.direct.notifications.handlers.rest;

import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import com.dexter.labs.HelloMessage;
import com.dexter.labs.app.direct.common.IConstants;

/**
 * This restful resource will serve app direct open id authentication
 * 
 * @author Babar Jehangir Khan
 *
 */
public class LoginResource extends ServerResource {

	@Get("json")
	public Representation represent() {

		String openUrl = getOpenIdUrl();
		return new JacksonRepresentation<HelloMessage>(new HelloMessage(
				"App Direct Login Handler!)" + openUrl));
		// return "Hello Worldd";
	}

	private String getOpenIdUrl() {
		return this.getAttribute(IConstants.OPEN_ID_URL);
	}
}
