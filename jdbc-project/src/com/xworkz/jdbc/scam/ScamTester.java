package com.xworkz.jdbc.scam;

import static com.xworkz.jdbc.scam.constants.JdbcConstant.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ScamTester {

	public static void main(String[] args) {

		try (Connection connection = DriverManager.getConnection(URL, USERNAME, SECRET)) {

			String query = "insert into scam_table values(1,'Stock market scam','Trading',2010,'Ketan Parekh',8,'India','stock scams have taken the form of accounting fraud that cooks the books and hides losses to pyramid  ')";
			String query1 = "insert into scam_table values(2,'Saradha Group chit fund scam','Financial',2013,' Debjani Mukhopadhdhay ',15.3,'West BEnagal','The Saradha Group financial scandal was a major financial scam and alleged political scandal caused by the collapse of a Ponzi scheme run by Saradha Group, a consortium of over 200 private companies that was believed to be running collective investment schemes popularly but incorrectly referred ')";
			String query2 = "insert into scam_table values(3,'2G Spectrum Scam','Telecommunication',2008,'A Raja',1.78,'India','The prosecution has miserably failed to prove its case, and all accused are acquitted, Special CBI judge OP Saini is reported to have said while acquitting all accused in the 2G scam case.')";
			String query3 = "insert into scam_table values(4,'Tatra truck scam','Bharat Earth Movers Ltd (BEML)',2011,'VK Singh',14,'India',' Tatra sold trucks first to a Hong Kong-based company called Venus Projects at a 35% discount. The company is the trading arm of Vectra Worldwide. If the deal had been made directly with India, the discount benefits would have been availed by the Indian army.')";
			String query4 = "insert into scam_table values(5,'Commonwealth Gamesscam','Games',2010,' Suresh Kalmadi',70000,'New dehli','The Commonwealth games is an international, multi sport events involving athletes from the Commonwealth of Nations. The event was first held in 1930 and has taken place every four years  ')";
			String query5 = "insert into scam_table values(6,' Fodder scam','fictitious livestock',1996,'Jagannath Mishra',950,'India','The Fodder Scam was a corruption scandal that involved the embezzlement of about ₹9.4 billion (equivalent to ₹39 billion or US$540 million in 2019) from the government treasury of the eastern Indian state of Bihar')";
			String query6 = "insert into scam_table values(7,'VijayMalya Scam','Finacial',2016,'VijayMalya',9000,'Mumbai','Vijay Mallya wants to expand his liquor and Airline business. His advisors advise him not to do this but despite his advisor’s advice, he does the same')";
			String query7 = "insert into scam_table values(8,' The Baby Milk Begging Scam','Baby',2006,'Beggers',1,'India','children — will be working for a criminal gang')";
			String query8 = "insert into scam_table values(9,'Harshad Mehta scam','Bank',1992,'Harshad Mehta',5000,'Mumbai','Harshad Mehta discovered a loophole in this system which would make him the king of Indian stock markets. Since he had become a prominent name in the stock markets by then, he convinced banks to issue him cheques in his own name for buying ')";
			String query9 = "insert into scam_table values(10,'Telgi scam','finacial',2001,'Abdul Karim Telgi',20000,'Rajastan','Scam 1992 makers have announced the second season of the franchise. Tentatively titled Scam 2003: The Curious Case of Abdul Karim Telgi, the show will be adapted from the Hindi book, Reporter Ki Diary.')";
			String query10 = "insert into scam_table values(11,'Chopper Scam','Helicaptors',2013,'Santosh Bagrodia',3.8,'Italy','The Augusta WestlandVVIP chopper fraud is a bribery case in which it is claimed that bribes were paid to middlemen, maybe even politicians, when India agreed to buy 12 Augusta Westland helicopters from the Italian Defence Corporation, Finmeccanica, for Rs 3,600 crore.')";
			String query11 = "insert into scam_table values(12,'IPL Scam','BCCI',2013,'Arun Jaitley and Jyotiraditya Scindia',3.75,'Pune','The agency carried out raids on premises of Agrasain Gehlot in Jodhpur. It is alleged that Agrasain Gehlot between 2007 to 2009')";
			String query12 = "insert into scam_table values(13,' Commonwealth Gamesscam','Games',2010,' Suresh Kalmadi',70000,'New dehli','The Commonwealth games is an international, multi sport events involving athletes from the Commonwealth of Nations. The event was first held in 1930 and has taken place every four years   ')";
			String query13 = "insert into scam_table values(14,'Hawala Scandal','Banking',1996,'N K Jain',1.8,'India','The Hawala scandal, also called the Jain Diaries case or the hawala scam was an Indian political and financial scandal involving payments allegedly sent by politicians (black money) through four hawala brokers, namely the Jain brothers')";
			String query14 = "insert into scam_table values(15,'Bellary mining scam','Mining leases',2006,'Reddy brothers',16.0,'Bellary','is a series of widespread scams in various ore-rich states of India, and has generated controversy, which spans encroachment of forest areas, underpayment of government royalties, conflict with tribals regarding land-rights.')";
			String query15 = "insert into scam_table values(16,'Antrix Devas scam','Scientific',2011,'G Madhavan Nair',14.8,'Bengal','Antrix is the name of the corporation, set up in 1992 with the sole aim to promote commercial exploitation of space products, technical consultancy services and transfer of technologies developed by ISRO')";
			String query16 = "insert into scam_table values(17,'Satyam scam','Computers',2015,'Ramalingaraju',14000,'Hydarabad','All this led to a rise in Satyam’s share price. He and the promoters then decided to sell their stake at the inflated stock prices and use the money to buy properties. Satyam promoters reduced their stake from 24% in 1999 to 2% in 2008.')";
			String query17 = "insert into scam_table values(18,'Coal scam','corruption',2000,' Abhishek Banerjee ',40,'Bengal','In a draft report issued in March 2012, the Comptroller and Auditor General of India (CAG) office accused the Government of India of allocating coal blocks in an inefficient manner during the period 2004–2009. Over the Summer of 2012 ')";
			String query18 = "insert into scam_table values(19,'cash-for-votes scandal','Election',2008,'Soniya Gandhi',2,'India','The cash-for-votes scandal was an Indian political scandal allegedly masterminded by then Opposition Party Bharatiya Janata Party politician Sudheendra Kulkarni ')";
			String query19 = "insert into scam_table values(20,'Oil and Food Scam','Food',2005,'Adithya Khanna',6000,'Delhi','The wheels of bureaucracy grind slowly. It has been three weeks since the Union Government announced the setting up of the Justice R.S. Pathak Inquiry Authority to probe the allegations.')";

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
			statement.execute(query15);
			statement.execute(query16);
			statement.execute(query17);
			statement.execute(query18);
			statement.execute(query19);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
