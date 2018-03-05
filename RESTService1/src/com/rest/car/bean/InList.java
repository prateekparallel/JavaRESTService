package com.rest.car.bean;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class InList {	
	@JsonProperty("inList")
	private List<InListDetail> inList;

	public List<InListDetail> getInList() {
		return inList;
	}

	public void setInList(List<InListDetail> inList) {
		this.inList = inList;
	}

}
