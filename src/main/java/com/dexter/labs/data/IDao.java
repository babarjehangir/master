/**
 * 
 */
package com.dexter.labs.data;

import java.util.Optional;

import com.dexter.labs.communication.OrderType;
import com.dexter.labs.communication.UserType;

/**
 * Interface to handle communication with data and rest services.
 * 
 * @author Babar Jehangir Khan
 *
 */
public interface IDao {

	public Optional<UserType> getUser(UserType userType);

	public int addUser(UserType userType);

	public OrderType getOrderType(OrderType orderType);

	public int addOrderType(UserType userType, OrderType orderType);
}
