package com.xworkz.flower;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FlowerTester8 {

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
			prepare.setString(1, "Daisy");
			prepare.setString(2, "Red");
			prepare.setInt(3, 6);
			prepare.setInt(4, 30);
			prepare.setString(5, "Custom");
			prepare.setString(6, "Foul");
			prepare.setBoolean(7, false);
			prepare.setBoolean(8, false);
			prepare.setInt(9, 100);

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
