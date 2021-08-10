package com.xworkz.restaurant;

import com.xworkz.restaurant.constants.RestaurantType;
import com.xworkz.restaurant.dao.RestaurantDAO;
import com.xworkz.restaurant.dao.RestaurantDAOImpl;
import com.xworkz.restaurant.dto.RestaurantDTO;

public class RestaurantTester {

	public static void main(String[] args) {

		RestaurantDTO dto = new RestaurantDTO("Ground Zero Hub", "Nandhi Hills", "Chicken Kabab", true,
				RestaurantType.FAMILY);

		RestaurantDAO dao = new RestaurantDAOImpl();

		dao.save(dto);
	}

}
