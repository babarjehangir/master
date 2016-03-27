/**
 * 
 */
package com.dexter.labs.app.direct.notifications.handlers.rest;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.restlet.Client;
import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.Protocol;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import com.dexter.labs.app.direct.common.IGlobals;
import com.dexter.labs.communication.EventType;

/**
 * 
 * This class will have all the common methods that are needed by the
 * subscription restful services
 * 
 * @author Babar Jehangir Khan
 *
 */
public abstract class AbstractSubscriptionResource extends AbstractResponse {

	protected ChallengeResponse getOAuthChallenge() {
		return new ChallengeResponse(ChallengeScheme.HTTP_OAUTH,
				IGlobals.appDirectKey, IGlobals.appDirectSecret);

	}

	protected EventType extractEventType(String url) throws IOException,
			JAXBException {
		// Setup the Restlet client resource to perform a HTTP Get
		Client client = new Client(getContext(), Protocol.HTTPS);
		ClientResource clientResource = new ClientResource(url);
		clientResource.setNext(client);

		// set up OAuth Challenge
		clientResource.setChallengeResponse(getOAuthChallenge());

		Representation res = clientResource.get();

		StringReader reader = new StringReader(res.getText());

		JAXBContext context = JAXBContext.newInstance(EventType.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();

		return (EventType) unmarshaller.unmarshal(reader);
	}

}
