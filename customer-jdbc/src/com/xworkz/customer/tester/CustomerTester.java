package com.xworkz.customer.tester;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import com.xworkz.customer.constants.Education;
import com.xworkz.customer.dto.CustomerDTO;
import com.xworkz.customer.service.CustomerService;
import com.xworkz.customer.service.CustomerServiceImpl;

public class CustomerTester {

	public static void main(String[] args) {

		CustomerDTO customer1 = new CustomerDTO("Harshitha", "Chickballapur", "Maldives", "BH Colony", false,
				"BP6754546778650", Education.BE);
		CustomerDTO customer2 = new CustomerDTO("Ranjitha", "Banglore", "Maanali", "Vivekananda road", false,
				"GR4523456789247", Education.BE);
		CustomerDTO customer3 = new CustomerDTO("Sachin", "Davangere", "Japan", "Sagar Road", false, "MG2298645670912",
				Education.MTECH);

		CustomerService service = new CustomerServiceImpl();

		service.validateAndSave(customer1);
		service.validateAndSave(customer2);
		service.validateAndSave(customer3);

		Collection<CustomerDTO> collect = Arrays.asList(customer1, customer2, customer3);
		service.validateAndSaveAll(collect);

		Optional<CustomerDTO> findOne = service.findOne((s) -> s.getAddress().equals("BH Colony"));
		if (findOne.isPresent()) {
			CustomerDTO dto = findOne.get();
			System.out.println("found one by address:" + dto);
		}

		Collection<CustomerDTO> collection = service.findAll();
		collection.forEach((c) -> System.out.println("found all:" + c));

		Collection<CustomerDTO> collection1 = service.findAll((i) -> i.getId() >= 9);
		collection1.forEach((c) -> System.out.println("found all by predicate:" + c));

		Collection<CustomerDTO> collection2 = service.findAll((i) -> i.getName().equals("Harshitha"));
		collection2.forEach((c) -> System.out.println("found all sorted by name:" + c));

		int total = service.total();
		System.out.println("total:" + total);
	}

}
