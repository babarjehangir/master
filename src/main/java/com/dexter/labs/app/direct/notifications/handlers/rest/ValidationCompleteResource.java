/**
 * 
 */
package com.dexter.labs.app.direct.notifications.handlers.rest;

import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import com.dexter.labs.HelloMessage;

/**
 * @author Babar Jehangir Khan
 *
 */
public class ValidationCompleteResource extends ServerResource {

	@Get("json")
	public Representation represent() {

		String openId = getQueryValue("openId");
		String accountId = getQueryValue("accountId");

		return new JacksonRepresentation<HelloMessage>(new HelloMessage(
				"App Direct Subscription Handler!)"));
	}
}
