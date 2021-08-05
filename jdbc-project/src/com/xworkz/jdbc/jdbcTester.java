package com.xworkz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcTester {

	public static void main(String[] args) {

		String userName = "root";
		String password = "Harshi@248";
		String url = "jdbc:mysql://localhost:3306/harshitha_jdbc";

		try {
			Connection connection = DriverManager.getConnection(url, userName, password);
			System.out.println(connection);

			String query = "insert into insurance_table values(3,'Sunitha','Accident',10,'Max life',56467)";
			Statement statement = connection.createStatement();
			statement.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
