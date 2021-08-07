package com.xworkz.jdbc.scam.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xworkz.jdbc.scam.dto.ScamDTO;
import static com.xworkz.jdbc.scam.constants.JdbcConstant.*;

public class SelectTester {

	public static void main(String[] args) {

		try (Connection connection = DriverManager.getConnection(URL, USERNAME, SECRET)) {

			System.out.println(connection);

			String select = "select * from scam_table where s_amount>=3000";
			Statement statement = connection.createStatement();
			statement.execute(select);

			ResultSet result = statement.getResultSet();
			ScamDTO dto = null;
			List<ScamDTO> list = new ArrayList<ScamDTO>();
			while (result.next()) {
				int id = result.getInt("s_id");
				String name = result.getString("s_name");
				String type = result.getString("s_type");
				int year = result.getInt("s_year");
				String by = result.getString("s_by");
				int amount = result.getInt("s_amount");
				String location = result.getString("s_location");
				String description = result.getString("s_descriptiom");
				dto = new ScamDTO(id, name, type, year, by, amount, location, description);

				System.out.println(dto);
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
