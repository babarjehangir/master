package com.dexter.labs.communication;

import java.util.HashMap;
import java.util.Map;

public class Marketplace {

	private String baseUrl;
	private String partner;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The baseUrl
	 */
	public String getBaseUrl() {
		return baseUrl;
	}

	/**
	 * 
	 * @param baseUrl
	 *            The baseUrl
	 */
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	/**
	 * 
	 * @return The partner
	 */
	public String getPartner() {
		return partner;
	}

	/**
	 * 
	 * @param partner
	 *            The partner
	 */
	public void setPartner(String partner) {
		this.partner = partner;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
