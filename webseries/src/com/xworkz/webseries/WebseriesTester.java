package com.xworkz.webseries;

import java.util.Collection;

import com.xworkz.webseries.constants.Genre;
import com.xworkz.webseries.constants.StreamedIn;
import com.xworkz.webseries.dao.WebseriesDAO;
import com.xworkz.webseries.dao.WebseriesDAOImpl;
import com.xworkz.webseries.dto.WebseriesDTO;

public class WebseriesTester {

	public static void main(String[] args) {

		WebseriesDTO series1 = new WebseriesDTO("My Girlfriend is an alien", 28, 1, StreamedIn.WETV, Genre.FANTASY, 18);

		WebseriesDTO series2 = new WebseriesDTO("Never Have I Ever", 20, 2, StreamedIn.NETFLIX, Genre.COMEDY_DRAMA, 15);
		
		WebseriesDTO series3 = new WebseriesDTO("Watchmen", 9, 1, StreamedIn.HOTSTAR, Genre.ACTION, 18);

		WebseriesDTO series4 = new WebseriesDTO("Money Hiest", 37, 4, StreamedIn.NETFLIX, Genre.THRILLER, 20);
		
		WebseriesDAO dao=new WebseriesDAOImpl();
		dao.save(series1);
		dao.save(series2);
		dao.save(series4);
		dao.save(series3);
		
		int total=dao.total();
		System.out.println("total no of webseries:"+total);
		
		int max=dao.findMaxSeason();
		System.out.println("found max season:"+max);
		
		int min=dao.findMinSeason();
		System.out.println("found min season:"+min);

		Collection<WebseriesDTO> collection=dao.findAll();
		collection.forEach((a)->System.out.println("found all:"+a));
		
		Collection<WebseriesDTO> collection1=dao.findAllSortByNameDesc();
		collection1.forEach((a)->System.out.println("found all by name:"+a));
	}

}
