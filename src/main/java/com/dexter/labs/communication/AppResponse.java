/**
 * 
 */
package com.dexter.labs.communication;

/**
 * @author Babar Jehangir Khan
 *
 */
public class AppResponse {

	private String redirectURL;

	public String getRedirectURL() {
		return redirectURL;
	}

	public void setRedirectURL(String redirectURL) {
		this.redirectURL = redirectURL;
	}

	public static AppResponse buildLoginResponse(String redirectURL) {
		AppResponse r = new AppResponse();
		r.redirectURL = redirectURL;
		return r;
	}
}
