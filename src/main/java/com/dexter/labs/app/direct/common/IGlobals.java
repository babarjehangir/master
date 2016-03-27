package com.dexter.labs.app.direct.common;

import java.util.HashMap;
import java.util.Map;

import org.openid4java.discovery.DiscoveryInformation;

public interface IGlobals {

	public static Map<String, DiscoveryInformation> disInfoMap = new HashMap<String, DiscoveryInformation>();

	public static String OPEN_ID_URL = "openid_url";

	public static String EVENT_URL = "url";

	public static String appDirectKey = "movie-reservation-96332"; // TODO:
																	// should
																	// really be
																	// in a
																	// configuration
																	// file.

	public static String appDirectSecret = "GRkzuCdYDsG1VUFY";

	// public static String VALIDATION_RETURN_URL =
	// "http://boiling-eyrie-13823.herokuapp.com/login/validate/openid";

	public static String VALIDATION_RETURN_URL = "http://boiling-eyrie-13823.herokuapp.com/login/validate/openid";
}
