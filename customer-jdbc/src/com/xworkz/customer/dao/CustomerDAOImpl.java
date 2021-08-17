package com.xworkz.customer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

import com.xworkz.customer.constants.Education;
import com.xworkz.customer.dto.CustomerDTO;
import static com.xworkz.customer.constants.JdbcConstant.*;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public int save(CustomerDTO dto) {

		Connection tempConnection = null;
		int temp = 0;
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, SECRET)) {
			tempConnection = connection;
			connection.setAutoCommit(false);
			String query = "insert into customer_table(c_name,c_from,c_to,c_address,c_married,c_passportNo,c_education)values(?,?,?,?,?,?,?)";
			PreparedStatement prepare = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			prepare.setString(1, dto.getName());
			prepare.setString(2, dto.getFrom());
			prepare.setString(3, dto.getTo());
			prepare.setString(4, dto.getAddress());
			prepare.setBoolean(5, dto.isMarried());
			prepare.setString(6, dto.getPassportNo());
			prepare.setString(7, dto.getEducation().toString());
			prepare.execute();
			ResultSet result = prepare.getGeneratedKeys();
			if (result.next()) {

				temp = result.getInt(1);
			}
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				tempConnection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return temp;
	}

	@Override
	public void saveAll(Collection<CustomerDTO> collection) {
		collection.forEach((d)->this.save(d));
	}

	@Override
	public Optional<CustomerDTO> findOne(Predicate<CustomerDTO> predicate) {
		Optional<CustomerDTO> optional = Optional.empty();
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, SECRET)) {
			String query = "select * from customer_table";
			ResultSet result = createdFromPreparedStatement(connection, query);
			if (result.next()) {
				CustomerDTO dto = createdValuesFromResultSet(result);
				if (predicate.test(dto)) {
					optional = Optional.of(dto);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return optional;
	}

	@Override
	public Collection<CustomerDTO> findAll() {
		Collection<CustomerDTO> collection = new ArrayList<CustomerDTO>();
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, SECRET)) {
			String query = "select * from customer_table";
			ResultSet result = createdFromPreparedStatement(connection, query);
			while (result.next()) {
				CustomerDTO dto = createdValuesFromResultSet(result);
				collection.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collection;
	}

	private CustomerDTO createdValuesFromResultSet(ResultSet result) throws SQLException {
		int id = result.getInt("c_id");
		String name = result.getString("c_name");
		String from = result.getString("c_from");
		String to = result.getString("c_to");
		String address = result.getString("c_address");
		boolean married = result.getBoolean("c_married");
		String passportNO = result.getString("c_passportno");
		String education = result.getString("c_education");

		CustomerDTO dto = new CustomerDTO(name, from, to, address, married, passportNO,
				Education.valueOf(education));
		dto.setId(id);
		return dto;
	}

	@Override
	public Collection<CustomerDTO> findAll(Predicate<CustomerDTO> predicate) {
		Collection<CustomerDTO> collection = new ArrayList<CustomerDTO>();
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, SECRET)) {
			String query = "select * from customer_table";
			ResultSet result = createdFromPreparedStatement(connection, query);
			while (result.next()) {
				CustomerDTO dto = createdValuesFromResultSet(result);
				if (predicate.test(dto)) {
					collection.add(dto);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collection;
	}

	@Override
	public Collection<CustomerDTO> findAllSortByNameDesc() {
		Collection<CustomerDTO> collection = new ArrayList<CustomerDTO>();
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, SECRET)) {
			String query = "select * from customer_table order by c_name desc";
			ResultSet result = createdFromPreparedStatement(connection, query);
			while (result.next()) {
				CustomerDTO dto = createdValuesFromResultSet(result);
				collection.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collection;
	}

	@Override
	public int total() {
		int temp = 0;
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, SECRET)) {
			String query = "select count(c_id) from customer_table";
			ResultSet result = createdFromPreparedStatement(connection, query);
			if (result.next()) {
				temp = result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}

	private ResultSet createdFromPreparedStatement(Connection connection, String query) throws SQLException {
		PreparedStatement prepare = connection.prepareStatement(query);
		prepare.execute();
		ResultSet result = prepare.getResultSet();
		return result;
	}
}
