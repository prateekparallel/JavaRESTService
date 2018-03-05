package com.web.controller.impl;

import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

import net.minidev.json.JSONObject;

import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import com.web.data.Vehicle;
import com.web.data.VehicleStore;
import com.rest.car.bean.CarDetailBean;
import com.rest.car.bean.CarInfoBean;
import com.rest.car.bean.InList;
import com.web.controller.VehicleController;


public class VehicleControllerImpl implements VehicleController{
	
	ObjectMapper JSON_MAPPER = new ObjectMapper();
	String result = null;
	
		
	@Override
	public Response getVehicles(){
		
		System.out.println("In getVehicles()");
		VehicleStore vehicleStore = VehicleStore.getStoreInstance();
		List<Vehicle> listOfVehicles = vehicleStore.getVehicleList(); 
		JSONObject obj=new JSONObject();
		try{
			obj.put("Vehicles", listOfVehicles);
		}catch(Exception je){
			je.printStackTrace();
			return Response.status(Status.EXPECTATION_FAILED).entity(je.getMessage()).type(MediaType.APPLICATION_JSON).build();	
		}
		System.out.println("Exit getVehicles()");
		return Response.status(Status.OK).entity(obj).type(MediaType.APPLICATION_JSON).build();	
	}
	
	@Override 
	public Response getVehicleById(int id){
		System.out.println("In getVehicleById(int id)");
		System.out.println("id :"+id);
		VehicleStore vehicleStore = VehicleStore.getStoreInstance();
		List<Vehicle> listOfVehicles = vehicleStore.getVehicleList(); 
		JSONObject obj=new JSONObject();
		for (Vehicle vehicle: listOfVehicles) { 
			if(vehicle.getId()==id){ 
			try{
				obj.put("Vehicle", vehicle);
				return Response.status(Status.OK).entity(obj).type(MediaType.APPLICATION_JSON).build();
			}catch(Exception je){
				je.printStackTrace();
				return Response.status(Status.EXPECTATION_FAILED).entity(je.getMessage()).type(MediaType.APPLICATION_JSON).build();	
			}
		  }
			
		}
		return Response.status(Status.EXPECTATION_FAILED).entity("No Data found").type(MediaType.APPLICATION_JSON).build();
	}
	
	@Override 
	public Response getVehicleById(UriInfo info, int id1, int id2){
		System.out.println("In getVehicleById(UriInfo info, int id1, int id2)");
		System.out.println("id1 :"+id1);
		System.out.println("id2 :"+id2);
		MultivaluedMap <String, String> parameters = info.getQueryParameters();
		String userID = parameters.getFirst("user");
		String srvcURL = info.getRequestUri().toString();
		System.out.println("srvcURL : "+srvcURL);
		VehicleStore vehicleStore = VehicleStore.getStoreInstance();
		List<Vehicle> listOfVehicles = vehicleStore.getVehicleList();  
		JSONObject obj=new JSONObject();
		boolean vehicleFound = false;
		for (Vehicle vehicle: listOfVehicles) { 
			if(vehicle.getId()==id1 || vehicle.getId()==id2){ 
			try{
				obj.put("Vehicle"+vehicle.getId(), vehicle);
				vehicleFound = true;
			}catch(Exception e){
				e.printStackTrace();
				return Response.status(Status.EXPECTATION_FAILED).entity(e.getMessage()).type(MediaType.APPLICATION_JSON).build();	
			}
		  }
			
		}
		if(vehicleFound)
			return Response.status(Status.OK).entity(obj).type(MediaType.APPLICATION_JSON).build();
		return Response.status(Status.EXPECTATION_FAILED).entity("No Data found").type(MediaType.APPLICATION_JSON).build();
	}
	
	@Override 
	public Response getVehicleById(UriInfo info, int id,String zone,String user){
		System.out.println("In getVehicleById(UriInfo info, int id,String zone,String user)");
		System.out.println("id : "+id);
		System.out.println("user : "+user);
		System.out.println("Zone : "+zone);
		VehicleStore vehicleStore = VehicleStore.getStoreInstance();
		List<Vehicle> listOfVehicles = vehicleStore.getVehicleList();
		JSONObject obj=new JSONObject();
		for (Vehicle vehicle: listOfVehicles) { 
			if(vehicle.getId()==id){ 
			try{
				vehicle.setCountryName("Vehicle From :" + zone);
				obj.put("Vehicle", vehicle);
				Writer strWriter = new StringWriter();
				JSON_MAPPER.writeValue(strWriter, vehicle);
				result = JSON_MAPPER.writeValueAsString(strWriter);
				return Response.status(Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();
			}catch(Exception e){
				e.printStackTrace();
				return Response.status(Status.EXPECTATION_FAILED).entity(e.getMessage()).type(MediaType.APPLICATION_JSON).build();	
			}
		  }
		
		}
		return Response.status(Status.EXPECTATION_FAILED).entity("No Data found").type(MediaType.APPLICATION_JSON).build();
	}
	
	@Override
	public Response registerCar(UriInfo info, CarDetailBean carDetailBean, String user) {
		System.out.println("In registerCar(UriInfo info, CarDetailBean carDetailBean, String user)");
		VehicleStore vehicleStore = VehicleStore.getStoreInstance();
		List<Vehicle> listOfVehicles = vehicleStore.getVehicleList();
		for (Vehicle vehicle: listOfVehicles) { 
			if(vehicle.getId()==carDetailBean.getCarId()){ 
				return Response.status(Status.EXPECTATION_FAILED).entity("Car id already present. Please use different id").type(MediaType.APPLICATION_JSON).build();
		  }
		
		}
		System.out.println("In registerCar(UriInfo info, CarDetailBean carDetailBean, String user)2");
		Vehicle newvehicle = new Vehicle(carDetailBean.getCarId(), carDetailBean.getCarInfo());
		System.out.println("In registerCar(UriInfo info, CarDetailBean carDetailBean, String user)3");
		vehicleStore.addVehicle(newvehicle);
		System.out.println("In registerCar(UriInfo info, CarDetailBean carDetailBean, String user)4");
		JSONObject obj=new JSONObject();
		try{
			obj.put("Vehicles", listOfVehicles);
		}catch(Exception je){
			je.printStackTrace();
			return Response.status(Status.EXPECTATION_FAILED).entity(je.getMessage()).type(MediaType.APPLICATION_JSON).build();	
		}
		System.out.println("Exit getVehicles()");
		return Response.status(Status.OK).entity(obj).type(MediaType.APPLICATION_JSON).build();	
	}
	
	@Override
	public Response placeCarOrder(UriInfo info, CarInfoBean carInfoBean,  String user) {
		System.out.println("In placeCarOrder(UriInfo info, CarInfoBean carInfoBean,  String user)");
		JSONObject obj=new JSONObject();
		obj.put("CarOrder", carInfoBean);
		return Response.status(Status.OK).entity(obj).type(MediaType.APPLICATION_JSON).build();	
	}	
	
	@Override
	public Response setInList(@Context UriInfo info, InList inList, @HeaderParam("user") String user) {
		System.out.println("In setInList(UriInfo info, InList carInfoBean,  String user)");
		//JSONObject obj=new JSONObject();
		//obj.put("InList", inList);
		return Response.status(Status.OK).entity("testing").type(MediaType.APPLICATION_JSON).build();	
	}

}
