package com.xworkz.flower;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FlowerTester3 {

	public static void main(String[] args) throws ClassNotFoundException {
		String username = "root";
		String password = "Harshi@248";
		String url = "jdbc:mysql://localhost:3306/harshitha_jdbc";
		String fullyQualifiedName = "com.mysql.cj.jdbc.Driver";

		Connection tempConnection = null;
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			Class.forName(fullyQualifiedName);
			tempConnection = connection;
			System.out.println(tempConnection);
			connection.setAutoCommit(false);
			String query = "insert into flower_table( F_NAME, F_COLOR, F_NOOFPETALS, F_PRICE, F_TYPE, F_FRAGRANCE, F_PEDISILATE, F_TRIMEROUS, F_WEIGHT)values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement prepare = connection.prepareStatement(query);
			prepare.setString(1, "Jasmine");
			prepare.setString(2, "White");
			prepare.setInt(3, 5);
			prepare.setInt(4, 500);
			prepare.setString(5, "Traditional");
			prepare.setString(6, "Jasmine");
			prepare.setBoolean(7, false);
			prepare.setBoolean(8, false);
			prepare.setInt(9, 1000);

			prepare.execute();

			ResultSet result = prepare.getResultSet();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				tempConnection.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}

		}

	}

}
