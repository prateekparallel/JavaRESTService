package com.web.data;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({"id", "VehicleName"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vehicle implements Serializable{
	
	private static final long serialVersionUID = -3501772243949297054L;
	
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("vehicleName")
	private String vehicleName; 
	
	@JsonProperty("countryName")
	private String countryName;
	
	public Vehicle(){};
	public Vehicle(int i, String vehicleName){ 
		super(); 
		this.id = i; 
		this.vehicleName = vehicleName; 
	} 
	
	public int getId(){ 
		return id; 
	} 
	
	public void setId(int id) { 
		this.id = id; 
		
	} 
	
	public String getVehicleName() { 
		return vehicleName; 
	} 
	
	public void setVehicleName(String vehicleName) { 
		this.vehicleName = vehicleName; 
	} 
	
	public String getCountryName() { 
		return countryName; 
	} 
	
	public void setCountryName(String countryName) { 
		this.countryName = countryName; 
	} 
}
