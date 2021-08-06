package com.xworkz.jdbc.scam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ScamTester {

	public static void main(String[] args) {

		String userName = "root";
		String password = "Harshi@248";
		String url = "jdbc:mysql://localhost:3306/harshitha_jdbc";

		try (Connection connection = DriverManager.getConnection(url, userName, password)) {

			String query = "insert into scam_table values(1,'Stock market scam','Trading',2010,'Ketan Parekh',8,'India','involved in circular trading ')";
			String query1 = "insert into scam_table values(2,'Saradha Group chit fund scam','Financial',2013,' Debjani Mukhopadhdhay ',15.3,'West BEnagal','variety of collective investment schemes')";
			String query2 = "insert into scam_table values(3,'2G Spectrum Scam','Telecommunication',2008,'A Raja',1.78,'India','Telecommunication Scam')";
			String query3 = "insert into scam_table values(4,'Tatra truck scam','Bharat Earth Movers Ltd (BEML)',2011,'VK Singh',14,'India',' purchase of components for Tatra trucks')";
			String query4 = "insert into scam_table values(5,'Commonwealth Gamesscam','Games',2010,' Suresh Kalmadi',70000,'New dehli','criminal conspiracy cheating and forgery ')";
			String query5 = "insert into scam_table values(6,' Fodder scam','fictitious livestock',1996,'Jagannath Mishra',950,'India','medicines and animal husbandry equipment')";
			String query6 = "insert into scam_table values(7,'VijayMalya Scam','Finacial',2016,'VijayMalya',9000,'Mumbai','bank loan scam')";
			String query7 = "insert into scam_table values(8,'Railgate Scam','Indian Railway Board',2012,' Pawan Kumar Bansal',7,'India','with the help of  telephonic conversations ')";
			String query8 = "insert into scam_table values(9,'Harshad Mehta scam','Bank',1992,'Harshad Mehta',5000,'Mumbai','Bombay Stock Exchange')";
			String query9 = "insert into scam_table values(10,'Telgi scam','finacial',2001,'Abdul Karim Telgi',20000,'Rajastan','printing duplicate stamp papers')";
			String query10 = "insert into scam_table values(11,'Chopper Scam','Helicaptors',2013,'Santosh Bagrodia, Satish Bagrodia',3.8,'Italy','VVIP helicopter deal')";
			String query11 = "insert into scam_table values(12,'IPL Scam','BCCI',2013,'Arun Jaitley and Jyotiraditya Scindia',3.75,'Pune','IPL Scam')";
			String query12 = "insert into scam_table values(13,' Commonwealth Gamesscam','Games',2010,' Suresh Kalmadi',70000,'New dehli','criminal conspiracy cheating and forgery ')";
			String query13 = "insert into scam_table values(14,'Hawala Scandal','Banking',1996,'N K Jain',1.8,'India','Money transfer based on owner')";
			String query14 = "insert into scam_table values(15,'Bellary mining scam','Mining leases',2006,'Reddy brothers',16.0,'Bellary','xchange for issuing mining leases ')";
			Statement statement = connection.createStatement();
			statement.execute(query);
			statement.execute(query1);
			statement.execute(query2);
			statement.execute(query3);
			statement.execute(query4);
			statement.execute(query5);
			statement.execute(query6);
			statement.execute(query7);
			statement.execute(query8);
			statement.execute(query9);
			statement.execute(query10);
			statement.execute(query11);
			statement.execute(query12);
			statement.execute(query13);
			statement.execute(query14);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
