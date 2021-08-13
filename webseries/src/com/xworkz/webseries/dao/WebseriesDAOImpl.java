package com.xworkz.webseries.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

import com.xworkz.webseries.constants.Genre;
import com.xworkz.webseries.constants.StreamedIn;
import com.xworkz.webseries.dto.WebseriesDTO;
import static com.xworkz.webseries.constants.JdbcConstant.*;

public class WebseriesDAOImpl implements WebseriesDAO {

	@Override
	public int save(WebseriesDTO dto) {
		Connection tempConnection = null;
		int temp = 0;
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, SECRET)) {
			tempConnection = connection;
			connection.setAutoCommit(false);

			String query = "insert into webseries_table (w_name,w_noofepisodes,w_totalseason,w_streamedin,w_genre,w_yestageindanodbohudu)values(?,?,?,?,?,?)";
			PreparedStatement prepare = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ResultSet result = prepare.getGeneratedKeys();
			if (result.next()) {
				temp = result.getInt(1);
			}
			prepare.setString(1, dto.getName());
			prepare.setInt(2, dto.getNoOfEpisodes());
			prepare.setInt(3, dto.getTotalSeason());
			prepare.setString(4, dto.getStreamedIn().toString());
			prepare.setString(5, dto.getGenre().toString());
			prepare.setInt(6, dto.getYestAgeIndaNodbohudu());
			prepare.execute();
			connection.commit();
			dto.setId(temp);
			System.out.println(dto);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				tempConnection.rollback();
			} catch (Exception e2) {
				e.printStackTrace();
			}
		}
		return temp;
	}

	@Override
	public int total() {
		int temp = 0;
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, SECRET)) {
			String query = "select count(w_id) from webseries_table";
			PreparedStatement prepare = connection.prepareStatement(query);
			prepare.execute();
			ResultSet result = prepare.getResultSet();
			if (result.next()) {
				temp = result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return temp;

	}

	@Override
	public int findMaxSeason() {
		int temp = 0;
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, SECRET)) {
			String query = "select max(w_totalseason) from webseries_table";
			PreparedStatement prepare = connection.prepareStatement(query);
			prepare.execute();
			ResultSet result = prepare.getResultSet();
			if (result.next()) {
				temp = result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return temp;

	}

	@Override
	public int findMinSeason() {
		int temp = 0;
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, SECRET)) {
			String query = "select min(w_totalseason) from webseries_table";
			PreparedStatement prepare = connection.prepareStatement(query);
			prepare.execute();
			ResultSet result = prepare.getResultSet();
			if (result.next()) {
				temp = result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return temp;

	}

	@Override
	public Collection<WebseriesDTO> findAll() {
		Collection<WebseriesDTO> collection = new ArrayList<WebseriesDTO>();
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, SECRET)) {
			String query = "select * from webseries_table ";

			PreparedStatement prepare = connection.prepareStatement(query);
			prepare.execute();
			ResultSet result = prepare.getResultSet();
			while (result.next()) {
				int id = result.getInt("w_id");
				String name = result.getString("w_name");
				int episodes = result.getInt("w_noOfEpisodes");
				int season = result.getInt("w_totalSeason");
				String streamed = result.getString("w_streamedIn");
				String genre = result.getString("w_genre");
				int yestAgeIndaNodbohudu = result.getInt("w_yestAgeIndaNodbohudu");

				WebseriesDTO dto = new WebseriesDTO(name, episodes, season, StreamedIn.valueOf(streamed),
						Genre.valueOf(genre), yestAgeIndaNodbohudu);
				dto.setId(id);
				collection.add(dto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collection;

	}
	
	/*@Override
	public Collection<WebseriesDTO> findAll(Predicate<WebseriesDTO> predicate) {
		Collection<WebseriesDTO> collection = new ArrayList<WebseriesDTO>();
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, SECRET)) {
			String query = "select * from webseries_table";
			PreparedStatement prepare = connection.prepareStatement(query);
			prepare.execute();
			ResultSet result = prepare.getResultSet();
			while (result.next()) {
				int id = result.getInt("w_id");
				String name = result.getString("w_name");
				int episodes = result.getInt("w_noOfEpisodes");
				int season = result.getInt("w_totalSeason");
				String streamed = result.getString("w_streamedIn");
				String genre = result.getString("w_genre");
				int yestAgeIndaNodbohudu = result.getInt("w_yestAgeIndaNodbohudu");

				WebseriesDTO dto = new WebseriesDTO(name, episodes, season, StreamedIn.valueOf(streamed),
						Genre.valueOf(genre), yestAgeIndaNodbohudu);
				dto.setId(id);
				collection.add(dto);
		}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}*/

	@Override
	public Collection<WebseriesDTO> findAllSortByNameDesc() {
		Collection<WebseriesDTO> collection = new ArrayList<WebseriesDTO>();
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, SECRET)) {
			String query = "select * from webseries_table  order by w_name desc";

			PreparedStatement prepare = connection.prepareStatement(query);
			prepare.execute();
			ResultSet result = prepare.getResultSet();
			while (result.next()) {
				int id = result.getInt("w_id");
				String name = result.getString("w_name");
				int episodes = result.getInt("w_noOfEpisodes");
				int season = result.getInt("w_totalSeason");
				String streamed = result.getString("w_streamedIn");
				String genre = result.getString("w_genre");
				int yestAgeIndaNodbohudu = result.getInt("w_yestAgeIndaNodbohudu");

				WebseriesDTO dto = new WebseriesDTO(name, episodes, season, StreamedIn.valueOf(streamed),
						Genre.valueOf(genre), yestAgeIndaNodbohudu);
				dto.setId(id);
				collection.add(dto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collection;
	}
}
