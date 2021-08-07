package com.xworkz.jdbc.scam.dto;

import java.io.Serializable;

public class ScamDTO implements Serializable{

	private int id;
	private String name;
	private String  type;
	private int year;
	private String by;
	private double amount;
	private String location;
	private String description;
	
	public ScamDTO() {
		
	}

	public ScamDTO(int id, String name, String type, int year, String by, double amount, String location,
			String description) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.year = year;
		this.by = by;
		this.amount = amount;
		this.location = location;
		this.description = description;
	}

	@Override
	public String toString() {
		return "ScamDTO [id=" + id + ", name=" + name + ", type=" + type + ", year=" + year + ", by=" + by + ", amount="
				+ amount + ", location=" + location + ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		ScamDTO other = (ScamDTO) obj;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getBy() {
		return by;
	}

	public void setBy(String by) {
		this.by = by;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
