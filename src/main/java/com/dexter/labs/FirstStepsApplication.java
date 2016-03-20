package com.dexter.labs;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.resource.Directory;
import org.restlet.routing.Route;
import org.restlet.routing.Router;

public class FirstStepsApplication extends Application {

	/**
	 * Creates a root Restlet that will receive all incoming calls.
	 */
	private Router root;

	@Override
	public Restlet createInboundRoot() {

		Directory directory = new Directory(getContext(),
				"clap://class/static/");
		directory.setDeeplyAccessible(true);

		root.attach("/web", directory);

		for (Route route : root.getRoutes()) {
			System.out.println(route.toString());
		}

		return root;
	}

	public Router getRoot() {
		return root;
	}

	public void setRoot(Router root) {
		this.root = root;
	}
}