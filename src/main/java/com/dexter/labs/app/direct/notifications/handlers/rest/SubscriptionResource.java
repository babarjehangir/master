/**
 * 
 */
package com.dexter.labs.app.direct.notifications.handlers.rest;

import javax.ws.rs.Path;

import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import com.dexter.labs.HelloMessage;

/**
 * @author Babar Jehangir Khan
 *
 */
public class SubscriptionResource extends ServerResource {

	@Get("json")
	public Representation represent() {

		return new JacksonRepresentation<HelloMessage>(new HelloMessage(
				"App Direct Subscription Handler!)"));
		// return "Hello Worldd";
	}
}
