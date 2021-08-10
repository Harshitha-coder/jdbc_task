package com.xworkz.restaurant.dto;

import java.io.Serializable;

import com.xworkz.restaurant.constants.RestaurantType;

public class RestaurantDTO implements Serializable{

	private String name;
	private String location;
	private String specialFood;
	private boolean best;
	private RestaurantType type;
	
	public RestaurantDTO() {
		
	}

	public RestaurantDTO(String name, String location, String specialFood, boolean best, RestaurantType type) {
		super();
		this.name = name;
		this.location = location;
		this.specialFood = specialFood;
		this.best = best;
		this.type = type;
	}

	@Override
	public String toString() {
		return "RestaurantDTO [name=" + name + ", location=" + location + ", specialFood=" + specialFood + ", best="
				+ best + ", type=" + type + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSpecialFood() {
		return specialFood;
	}

	public void setSpecialFood(String specialFood) {
		this.specialFood = specialFood;
	}

	public boolean isBest() {
		return best;
	}

	public void setBest(boolean best) {
		this.best = best;
	}

	public RestaurantType getType() {
		return type;
	}

	public void setType(RestaurantType type) {
		this.type = type;
	}
}
