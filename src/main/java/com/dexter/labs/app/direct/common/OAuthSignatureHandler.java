/**
 * 
 */
package com.dexter.labs.app.direct.common;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;

/**
 * 
 * This class will act as a helper to deal with OAuth two legged authorizations
 * and url signing
 * 
 * @author Babar Jehangir Khan
 *
 */
public class OAuthSignatureHandler {

	private static OAuthSignatureHandler INSTANCE = null;

	public static OAuthSignatureHandler getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new OAuthSignatureHandler();
		}

		return INSTANCE;
	}

	public String sign(String url) {

		// consumer.si
		ChallengeResponse challenge = new ChallengeResponse(
				ChallengeScheme.HTTP_OAUTH, IGlobals.appDirectKey,
				IGlobals.appDirectSecret);

		// challenge.set
		return null;
	}
}
