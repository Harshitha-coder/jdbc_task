package com.xworkz.jdbc.scam.delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteByIdTester {

	public static void main(String[] args) {
		String userName = "root";
		String password = "Harshi@248";
		String url = "jdbc:mysql://localhost:3306/harshitha_jdbc";

		try (Connection connection = DriverManager.getConnection(url, userName, password)) {

			String deleteQuery = "delete from scam_table where s_id=10";
			Statement statement = connection.createStatement();
			statement.execute(deleteQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
