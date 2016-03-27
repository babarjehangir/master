/**
 * 
 */
package com.dexter.labs.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dexter.labs.communication.OrderType;
import com.dexter.labs.communication.UserType;

/**
 * This class will provide static (in memory) data access which can used for
 * testing the API.
 * 
 * @author Babar Jehangir Khan
 *
 */
public class DaoTest implements IDao {

	public static List<UserType> userTypes = new ArrayList<UserType>();

	public static Map<UserType, OrderType> orderTypesMap = new HashMap<UserType, OrderType>();

	public UserType getUser(UserType userType) {

		for (UserType u : userTypes) {
			if (userType.getUuid().equals(u.getUuid())) {
				return u;
			}
		}
		return null;
	}

	public int addUser(UserType userType) {
		if (userType != null)
			userTypes.add(userType);
		print();
		return 1;
	}

	public OrderType getOrderType(OrderType orderType) {
		return orderTypesMap.get(orderType);
	}

	public int addOrderType(UserType userType, OrderType orderType) {
		if (orderType != null)
			orderTypesMap.put(userType, orderType);
		print();
		return 1;
	}

	private void print() {
		System.out.println("TOTAL USERS: " + userTypes.size());
		System.out.println("TOTAL SUBSCRIPTIONS"
				+ orderTypesMap.values().size());
	}
}
