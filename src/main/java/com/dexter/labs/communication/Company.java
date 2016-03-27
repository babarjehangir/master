package com.dexter.labs.communication;

import java.util.HashMap;
import java.util.Map;

public class Company {

	private String country;
	private String name;
	private String uuid;
	private String website;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * 
	 * @param country
	 *            The country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * 
	 * @return The name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 *            The name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return The uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * 
	 * @param uuid
	 *            The uuid
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * 
	 * @return The website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * 
	 * @param website
	 *            The website
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
