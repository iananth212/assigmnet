package com.sample.store.driversuggestionservice.dto;

import java.io.Serializable;

public class DriverDetailsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String driverID;
	private Double latitude;
	private Double longitude;

	public DriverDetailsDTO() {
		super();
	}

	public DriverDetailsDTO(String driverID, Double latitude, Double longitude) {
		super();
		this.driverID = driverID;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getDriverID() {
		return driverID;
	}

	public void setDriverID(String driverID) {
		this.driverID = driverID;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
}
