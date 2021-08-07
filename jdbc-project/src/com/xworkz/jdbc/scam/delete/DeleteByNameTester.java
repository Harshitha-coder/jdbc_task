package com.xworkz.jdbc.scam.delete;

import static com.xworkz.jdbc.scam.constants.JdbcConstant.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteByNameTester {

	public static void main(String[] args) {

		try (Connection connection = DriverManager.getConnection(URL, USERNAME, SECRET)) {

			String deleteQuery = "delete from scam_table where s_name=' Fodder scam'";
			Statement statement = connection.createStatement();
			statement.execute(deleteQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
