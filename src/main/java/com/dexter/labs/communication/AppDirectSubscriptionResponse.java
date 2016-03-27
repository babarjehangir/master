package com.dexter.labs.communication;

import java.util.HashMap;
import java.util.Map;

public class AppDirectSubscriptionResponse {

	private String type;
	private Marketplace marketplace;
	private Creator creator;
	private Payload payload;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The type
	 */
	public String getType() {
		return type;
	}

	/**
	 * 
	 * @param type
	 *            The type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 
	 * @return The marketplace
	 */
	public Marketplace getMarketplace() {
		return marketplace;
	}

	/**
	 * 
	 * @param marketplace
	 *            The marketplace
	 */
	public void setMarketplace(Marketplace marketplace) {
		this.marketplace = marketplace;
	}

	/**
	 * 
	 * @return The creator
	 */
	public Creator getCreator() {
		return creator;
	}

	/**
	 * 
	 * @param creator
	 *            The creator
	 */
	public void setCreator(Creator creator) {
		this.creator = creator;
	}

	/**
	 * 
	 * @return The payload
	 */
	public Payload getPayload() {
		return payload;
	}

	/**
	 * 
	 * @param payload
	 *            The payload
	 */
	public void setPayload(Payload payload) {
		this.payload = payload;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
