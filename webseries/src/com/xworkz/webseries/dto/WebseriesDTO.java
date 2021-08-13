package com.xworkz.webseries.dto;

import java.io.Serializable;

import com.xworkz.webseries.constants.Genre;
import com.xworkz.webseries.constants.StreamedIn;

public class WebseriesDTO implements Serializable{

	private int id;
	private String name;
	private int noOfEpisodes;
	private int totalSeason;
	private StreamedIn streamedIn;
	private Genre genre;
	private int yestAgeIndaNodbohudu;
	
	public WebseriesDTO() {
		
	}

	public WebseriesDTO( String name, int noOfEpisodes, int totalSeason, StreamedIn streamedIn, Genre genre,
			int yestAgeIndaNodbohudu) {
		super();
		this.name = name;
		this.noOfEpisodes = noOfEpisodes;
		this.totalSeason = totalSeason;
		this.streamedIn = streamedIn;
		this.genre = genre;
		this.yestAgeIndaNodbohudu = yestAgeIndaNodbohudu;
	}

	@Override
	public String toString() {
		return "WebseriesDTO [ name=" + name + ", noOfEpisodes=" + noOfEpisodes + ", totalSeason="
				+ totalSeason + ", streamedIn=" + streamedIn + ", genre=" + genre + ", yestAgeIndaNodbohudu="
				+ yestAgeIndaNodbohudu + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WebseriesDTO other = (WebseriesDTO) obj;
		if (genre != other.genre)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoOfEpisodes() {
		return noOfEpisodes;
	}

	public void setNoOfEpisodes(int noOfEpisodes) {
		this.noOfEpisodes = noOfEpisodes;
	}

	public int getTotalSeason() {
		return totalSeason;
	}

	public void setTotalSeason(int totalSeason) {
		this.totalSeason = totalSeason;
	}

	public StreamedIn getStreamedIn() {
		return streamedIn;
	}

	public void setStreamedIn(StreamedIn streamedIn) {
		this.streamedIn = streamedIn;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public int getYestAgeIndaNodbohudu() {
		return yestAgeIndaNodbohudu;
	}

	public void setYestAgeIndaNodbohudu(int yestAgeIndaNodbohudu) {
		this.yestAgeIndaNodbohudu = yestAgeIndaNodbohudu;
	}

	
}
