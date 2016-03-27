/**
 * 
 */
package com.dexter.labs.data;

import java.util.Optional;

import com.dexter.labs.communication.OrderType;
import com.dexter.labs.communication.UserType;

/**
 * This class (when implemented) will connect to the database. But with the time
 * constraint, I will implement a static test DAO in test package
 * 
 * @author Babar Jehangir Khan
 *
 */
public class Dao implements IDao {

	@Override
	public Optional<UserType> getUser(UserType userType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addUser(UserType userType) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public OrderType getOrderType(OrderType orderType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addOrderType(UserType userType, OrderType orderType) {
		// TODO Auto-generated method stub
		return 0;
	}

}
