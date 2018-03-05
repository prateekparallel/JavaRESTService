package com.rest.car.bean;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class CustomerRequestInfo {

	@JsonProperty("requestId")
	private String requestId;

	@JsonProperty("orderDetail")
	private List<OrderDetail> orderDetail;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public List<OrderDetail> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(List<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}

}
