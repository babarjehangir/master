/**
 * 
 */
package com.dexter.labs.app.direct.notifications.handlers.rest;

import org.restlet.Client;
import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.Form;
import org.restlet.data.Parameter;
import org.restlet.data.Protocol;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import com.dexter.labs.app.direct.common.IGlobals;
import com.dexter.labs.communication.AppDirectSubscriptionResponse;

/**
 * @author Babar Jehangir Khan
 *
 */
public class SubscriptionResource extends ServerResource {

	@Get("json")
	public Representation represent() {

		String url = getQueryValue("url");

		Form form = getRequest().getResourceRef().getQueryAsForm();

		for (Parameter parameter : form) {
			System.out
					.println(parameter.getName() + ":" + parameter.getValue());
		}
		System.out.println("TEST URL BY APP DIRECT: " + url);

		ChallengeResponse challenge = new ChallengeResponse(
				ChallengeScheme.HTTP_OAUTH, IGlobals.appDirectKey,
				IGlobals.appDirectSecret);

		Client client = new Client(getContext(), Protocol.HTTP);
		ClientResource clientResource = new ClientResource(url);
		clientResource.setNext(client);
		clientResource.setChallengeResponse(challenge);

		JacksonRepresentation<AppDirectSubscriptionResponse> response = (JacksonRepresentation<AppDirectSubscriptionResponse>) clientResource
				.get();

		return response;
		// return "Hello Worldd";
	}
}
