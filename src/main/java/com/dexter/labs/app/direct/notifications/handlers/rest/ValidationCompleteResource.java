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
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import com.dexter.labs.HelloMessage;
import com.dexter.labs.app.direct.common.IGlobals;
import com.dexter.labs.app.direct.openid.RegistrationService;

/**
 * @author Babar Jehangir Khan
 *
 */
public class ValidationCompleteResource extends ServerResource {

	@Get("json")
	public Representation represent() {

		String openId = getQueryValue("openId");
		String accountId = getQueryValue("accountId");

		String claimedId = getQueryValue("openid.claimed_id");

		System.out.println("Claimed ID: " + claimedId);

		DiscoveryInformation discovered = (DiscoveryInformation) IGlobals.disInfoMap
				.get("https://me.yahoo.com");

		if (discovered != null) {
			System.out.println("DISCOVERY INFO: " + discovered.toString());
		}

		System.out.println("recieving URL:" + getReference());

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
				System.out.println("VERIFIED USER: " + openIdReturned);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new JacksonRepresentation<HelloMessage>(
				new HelloMessage("App Direct Subscription Handler!) openId:"
						+ openId + "accountId:" + accountId + " claimedId: "
						+ claimedId));
	}
}
