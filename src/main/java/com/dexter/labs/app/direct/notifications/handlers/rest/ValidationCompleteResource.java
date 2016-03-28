/**
 * 
 */
package com.dexter.labs.app.direct.notifications.handlers.rest;

import java.util.HashMap;
import java.util.Map;

import org.openid4java.consumer.VerificationResult;
import org.openid4java.discovery.DiscoveryInformation;
import org.openid4java.discovery.Identifier;
import org.openid4java.message.ParameterList;
import org.restlet.data.Form;
import org.restlet.data.Parameter;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import com.dexter.labs.app.direct.common.IGlobals;
import com.dexter.labs.app.direct.openid.RegistrationService;

/**
 * @author Babar Jehangir Khan
 *
 */
public class ValidationCompleteResource extends ServerResource {

	@Get("json")
	public Representation represent() {

		DiscoveryInformation discovered = (DiscoveryInformation) IGlobals.disInfoMap
				.get("https://me.yahoo.com");

		Form form = getRequest().getResourceRef().getQueryAsForm();

		Map<String, String> queryParams = new HashMap<String, String>();
		for (Parameter parameter : form) {
			queryParams.put(parameter.getName(), parameter.getValue());
			System.out
					.println(parameter.getName() + ":" + parameter.getValue());
		}

		ParameterList params = new ParameterList(queryParams);

		try {
			VerificationResult result = RegistrationService.consumerManager
					.verify(getReference().toString(), params, discovered);

			Identifier verifiedId = null;
			if (result != null) {
				System.out.println("RESULT IS NOT NULL");
				verifiedId = result.getVerifiedId();
			}

			if (verifiedId != null) {
				String openIdReturned = getQueryValue("openid.identity");
				getResponse().redirectSeeOther("/web/index.html#!/home");
			} else {
				// login failed
				getResponse().redirectSeeOther("/web/index.html#!/login");
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: log exceptions
		}
		return null;

	}
}
