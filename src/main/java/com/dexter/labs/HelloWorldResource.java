package com.dexter.labs;

import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import com.dexter.labs.communication.HelloMessage;

public class HelloWorldResource extends ServerResource {

	@Get("json")
	public Representation represent() {

		return new JacksonRepresentation<HelloMessage>(new HelloMessage(
				"BABAR - hello, Dexter - With JSON(from the heroku!)"));
		// return "Hello Worldd";
	}

}
