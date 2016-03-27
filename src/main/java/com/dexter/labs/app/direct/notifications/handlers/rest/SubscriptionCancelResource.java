/**
 * 
 */
package com.dexter.labs.app.direct.notifications.handlers.rest;

import com.dexter.labs.data.IDao;

/**
 * @author Babar Jehangir Khan
 *
 */
public class SubscriptionCancelResource extends AbstractSubscriptionResource {

	private IDao dao;

	public IDao getDao() {
		return dao;
	}

	public void setDao(IDao dao) {
		this.dao = dao;
	}
}
