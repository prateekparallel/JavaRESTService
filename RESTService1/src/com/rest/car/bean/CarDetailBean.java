package com.rest.car.bean;

import org.codehaus.jackson.annotate.JsonProperty;

public class CarDetailBean {
	@JsonProperty("carId")
	private int carId;

	@JsonProperty("carInfo")
	private String carInfo;

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getCarInfo() {
		return carInfo;
	}

	public void setCarInfo(String carInfo) {
		this.carInfo = carInfo;
	}
}
