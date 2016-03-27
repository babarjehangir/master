package com.dexter.labs.communication;

import java.util.HashMap;
import java.util.Map;

public class Order {

	private String editionCode;
	private String pricingDuration;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The editionCode
	 */
	public String getEditionCode() {
		return editionCode;
	}

	/**
	 * 
	 * @param editionCode
	 *            The editionCode
	 */
	public void setEditionCode(String editionCode) {
		this.editionCode = editionCode;
	}

	/**
	 * 
	 * @return The pricingDuration
	 */
	public String getPricingDuration() {
		return pricingDuration;
	}

	/**
	 * 
	 * @param pricingDuration
	 *            The pricingDuration
	 */
	public void setPricingDuration(String pricingDuration) {
		this.pricingDuration = pricingDuration;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
