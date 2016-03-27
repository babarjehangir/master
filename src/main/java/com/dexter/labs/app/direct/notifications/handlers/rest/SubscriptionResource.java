/**
 * 
 */
package com.dexter.labs.app.direct.notifications.handlers.rest;

import java.io.IOException;
import java.util.Optional;

import javax.xml.bind.JAXBException;

import org.restlet.representation.Representation;
import org.restlet.resource.Get;

import com.dexter.labs.app.direct.common.IGlobals;
import com.dexter.labs.communication.EventType;
import com.dexter.labs.communication.UserType;
import com.dexter.labs.data.IDao;
import com.mysql.jdbc.StringUtils;

/**
 * @author Babar Jehangir Khan
 *
 */
public class SubscriptionResource extends AbstractSubscriptionResource {

	private IDao dao;

	@Get("json")
	public Representation represent() throws IOException, JAXBException {

		String url = getQueryValue(IGlobals.EVENT_URL);

		if (StringUtils.isNullOrEmpty(url)) {
			// cannot continue without the a valid Event URL provided.
			return badRequest();
		}

		EventType eventType = extractEventType(url);

		UserType user = dao.getUser(eventType.getCreator());
		if (user != null) {
			return userAlreadyExists();
		} else {
			dao.addUser(user);
			return userCreated();
		}

	}

	public IDao getDao() {
		return dao;
	}

	public void setDao(IDao dao) {
		this.dao = dao;
	}
}
