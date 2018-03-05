package com.rest.car.bean;

import org.codehaus.jackson.annotate.JsonProperty;

public class OrderDetail {

	@JsonProperty("carID")
	private String carID;

	@JsonProperty("carModule")
	private String carModule;

	@JsonProperty("carColor")
	private String carColor;

	@JsonProperty("customerComment")
	private String customerComment;

	public String getCarID() {
		return carID;
	}

	public void setCarID(String carID) {
		this.carID = carID;
	}

	public String getCarModule() {
		return carModule;
	}

	public void setCarModule(String carModule) {
		this.carModule = carModule;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	public String getCustomerComment() {
		return customerComment;
	}

	public void setCustomerComment(String customerComment) {
		this.customerComment = customerComment;
	}

}
