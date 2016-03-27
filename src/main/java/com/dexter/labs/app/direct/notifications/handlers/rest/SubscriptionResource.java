/**
 * 
 */
package com.dexter.labs.app.direct.notifications.handlers.rest;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.restlet.representation.Representation;
import org.restlet.resource.Get;

import com.dexter.labs.app.direct.common.IGlobals;
import com.dexter.labs.communication.EventType;
import com.mysql.jdbc.StringUtils;

/**
 * @author Babar Jehangir Khan
 *
 */
public class SubscriptionResource extends AbstractSubscriptionResource {

	@Get("json")
	public Representation represent() throws IOException, JAXBException {

		String url = getQueryValue(IGlobals.EVENT_URL);

		if (StringUtils.isNullOrEmpty(url)) {
			// cannot continue without the a valid Event URL provided.
			return badRequest();
		}

		EventType eventType = extractEventType(url);

		if (eventType != null) {
			System.out.println("TYPE OF EVENT: " + eventType.getType());
		}

		return userAlreadyExists();
	}
}
