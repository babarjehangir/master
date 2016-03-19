package com.dexter.labs.college.book.rest;

import org.restlet.resource.Get;

public interface RootResource {

	@Get("txt")
	public String represent();
}
