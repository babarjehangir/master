/**
 * 
 */
package com.dexter.labs.app.direct.notifications.handlers.rest;

import org.restlet.ext.jaxb.JaxbRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ServerResource;

import com.dexter.labs.app.direct.common.types.EErrorCodes;
import com.dexter.labs.communication.Result;

/**
 * @author Babar Jehangir Khan
 *
 */
public class AbstractResponse extends ServerResource {

	protected Representation userAlreadyExists() {
		return new JaxbRepresentation<Result>(Result.buildResult(
				EErrorCodes.USER_ALREADY_EXISTS,
				"the user is already registered", Boolean.FALSE));
	}

	protected Representation userCreated() {
		return new JaxbRepresentation<Result>(Result.buildResult(null,
				"the user is created successfully", Boolean.TRUE));
	}

	protected Representation badRequest() {
		return new JaxbRepresentation<Result>(Result.buildResult(
				EErrorCodes.UNAUTHORIZED, "invalid request", Boolean.FALSE));
	}

}
