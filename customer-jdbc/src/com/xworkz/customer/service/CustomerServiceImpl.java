package com.xworkz.customer.service;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

import com.xworkz.customer.constants.Education;
import com.xworkz.customer.dao.CustomerDAO;
import com.xworkz.customer.dao.CustomerDAOImpl;
import com.xworkz.customer.dto.CustomerDTO;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDAO dao = new CustomerDAOImpl();

	@Override
	public int validateAndSave(CustomerDTO dto) {
		boolean validateName = false;
		boolean validateFrom = false;
		boolean validateTo = false;
		boolean validateAddress = false;
		boolean validateMarried = false;
		boolean validatePassportNo = false;
		boolean validateEducation = false;
		System.out.println(dto);
		if (dto != null) {
			System.out.println(" dto is not null,can validate data");
			String name = dto.getName();
			if (name != null && !name.isEmpty() && name.length() > 3 && name.length() < 10) {
				System.out.println("name is valid");
				validateName = true;
			} else {
				System.out.println("name is invalid");
				validateName = false;
			}
			String from = dto.getFrom();
			if (from != null && !from.isEmpty() && from.length() > 3 && from.length() < 15) {
				System.out.println("from is valid");
				validateFrom = true;
			} else {
				System.out.println("from is invalid");
				validateFrom = false;
			}

			String to = dto.getTo();
			if (to != null && !to.isEmpty() && to.length() > 3 && to.length() < 15) {
				System.out.println("to is valid");
				validateTo = true;
			} else {
				System.out.println("to is invalid");
				validateTo = false;
			}
			String address = dto.getAddress();
			if (address != null && !address.isEmpty() && address.length() > 3 && address.length() < 25) {
				System.out.println("address is valid");
				validateAddress = true;
			} else {
				System.out.println("address is invalid");
				validateAddress = false;
			}
			Boolean married = dto.isMarried();
			if (married != null) {
				System.out.println("married is valid");
				validateMarried = true;
			} else {
				System.out.println("married is invalid");
				validateMarried = false;
			}
			String passportNo = dto.getPassportNo();
			if (passportNo != null && !passportNo.isEmpty() && passportNo.length() > 3 && passportNo.length() < 20) {
				System.out.println("passportNo is valid");
				validatePassportNo = true;
			} else {
				System.out.println("passportNo is invalid");
				validatePassportNo = false;
			}
			Education education = dto.getEducation();
			if (education != null) {
				System.out.println("education is valid");
				validateEducation = true;
			} else {
				System.out.println("married is invalid");
				validateEducation = false;
			}
			if (validateName && validateFrom && validateTo && validateAddress && validateMarried && validatePassportNo
					&& validateEducation) {
				dao.save(dto);
				System.out.println("data is valid ,returning success");
				return 1;
			} else {
				System.out.println("data is valid ,returning failed");
				return 0;
			}
		}
		return 0;
	}

	@Override
	public void validateAndSaveAll(Collection<CustomerDTO> collection) {
		dao.saveAll(collection);
	}

	@Override
	public Optional<CustomerDTO> findOne(Predicate<CustomerDTO> predicate) {
		return dao.findOne(predicate);
	}

	@Override
	public Collection<CustomerDTO> findAll() {

		return dao.findAll();
	}

	@Override
	public Collection<CustomerDTO> findAll(Predicate<CustomerDTO> predicate) {

		return dao.findAll(predicate);
	}

	@Override
	public Collection<CustomerDTO> findAllSortByNameDesc() {

		return dao.findAllSortByNameDesc();
	}

	@Override
	public int total() {

		return dao.total();
	}
}
