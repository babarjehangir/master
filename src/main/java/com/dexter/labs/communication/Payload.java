package com.dexter.labs.communication;

import java.util.HashMap;
import java.util.Map;

public class Payload {

	private Company company;
	private Order order;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The company
	 */
	public Company getCompany() {
		return company;
	}

	/**
	 * 
	 * @param company
	 *            The company
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	/**
	 * 
	 * @return The order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * 
	 * @param order
	 *            The order
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
