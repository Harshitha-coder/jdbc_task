package com.xworkz.jdbc.scam.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDescriptionByNameTester {

	public static void main(String[] args) {
		String userName = "root";
		String password = "Harshi@248";
		String url = "jdbc:mysql://localhost:3306/harshitha_jdbc";

		try (Connection connection = DriverManager.getConnection(url, userName, password)) {

			String updateQuery = "update scam_table set s_description='medicines and animal husbandry equipment' where s_name=' Fodder scam'";
			Statement statement = connection.createStatement();
			statement.execute(updateQuery);
		} catch (SQLException e) {
			e.printStackTrace();

	}

}
}
