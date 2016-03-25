package com.dexter.labs.app.direct.common;

import java.util.HashMap;
import java.util.Map;

import org.openid4java.discovery.DiscoveryInformation;

public interface IGlobals {

	public static Map<String, DiscoveryInformation> disInfoMap = new HashMap<String, DiscoveryInformation>();

	public static String OPEN_ID_URL = "openid_url";

	public static String VALIDATION_RETURN_URL = "https://boiling-eyrie-13823.herokuapp.com/login/validate/openid";
}
