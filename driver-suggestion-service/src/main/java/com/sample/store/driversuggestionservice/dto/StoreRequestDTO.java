package com.sample.store.driversuggestionservice.dto;

import java.io.Serializable;

public class StoreRequestDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String storeID;
	private Double latitude;
	private Double longitude;
	
	public StoreRequestDTO() {
		super();
	}
	
	public StoreRequestDTO(String storeID, Double latitude, Double longitude) {
		super();
		this.storeID = storeID;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public String getStoreID() {
		return storeID;
	}
	public void setStoreID(String storeID) {
		this.storeID = storeID;
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
