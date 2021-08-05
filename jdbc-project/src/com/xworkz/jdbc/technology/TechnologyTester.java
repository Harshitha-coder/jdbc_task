package com.xworkz.jdbc.technology;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TechnologyTester {

	public static void main(String[] args) {

		String userName = "root";
		String password = "Harshi@248";
		String url = "jdbc:mysql://localhost:3306/harshitha_jdbc";

		Connection connection=null;
		try {
			 connection = DriverManager.getConnection(url, userName, password);
			System.out.println(connection);

			String query = "insert into technology_table values(5,'SQL','Software','Donald d Clamberlin',1979)";
			Statement statement = connection.createStatement();
			statement.execute(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
			connection.close();
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
				
		}

	}
}

