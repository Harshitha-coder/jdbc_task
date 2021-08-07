package com.xworkz.jdbc.scam.update;

import static com.xworkz.jdbc.scam.constants.JdbcConstant.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateSomeByNameAndIdTester {

	public static void main(String[] args) {

		try (Connection connection = DriverManager.getConnection(URL, USERNAME, SECRET)) {

			String updateQuery = "update scam_table set s_year=2000 ,s_amount=40 ,s_location='Bengal', s_type='corruption' where s_name=' Fodder scam' and s_id=6";
			Statement statement = connection.createStatement();
			statement.execute(updateQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
