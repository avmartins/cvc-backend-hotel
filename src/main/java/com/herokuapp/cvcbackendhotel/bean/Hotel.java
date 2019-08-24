package com.herokuapp.cvcbackendhotel.bean;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Hotel implements Serializable {
	private static final long serialVersionUID = 6058259455646229768L;
	
	private Long id;
    @JsonIgnore
    private String name;
    @JsonIgnore
    private Long cityCode;
    private String cityName;
    private List<Room> rooms;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCityCode() {
		return cityCode;
	}

	public void setCityCode(Long cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public void removePriceBody() {
		this.getRooms().get(0).setPrice(null);
	}

}
