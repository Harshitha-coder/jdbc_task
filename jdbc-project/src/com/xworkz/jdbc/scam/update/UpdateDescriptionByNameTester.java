package com.xworkz.jdbc.scam.update;

import static com.xworkz.jdbc.scam.constants.JdbcConstant.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDescriptionByNameTester {

	public static void main(String[] args) {

		try (Connection connection = DriverManager.getConnection(URL, USERNAME, SECRET)) {

			String updateQuery = "update scam_table set s_description='The theft spanned for many years, and allegedly involved numerous Bihar states administrative' where s_name='Fodder scam'";
			Statement statement = connection.createStatement();
			statement.execute(updateQuery);
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}
}
