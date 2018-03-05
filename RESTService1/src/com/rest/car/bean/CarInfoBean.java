package com.rest.car.bean;

import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;

public class CarInfoBean {
	@JsonProperty("userId")
	private String userId;

	@JsonProperty("passWord")
	private String passWord;

	@JsonProperty("customerRequestInfo")
	private List<CustomerRequestInfo> customerRequestInfo;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public List<CustomerRequestInfo> getCustomerRequestInfo() {
		return customerRequestInfo;
	}

	public void setCustomerRequestInfo(List<CustomerRequestInfo> customerRequestInfo) {
		this.customerRequestInfo = customerRequestInfo;
	}

}