package com.web.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.rest.car.bean.CarDetailBean;
import com.rest.car.bean.CarInfoBean;
import com.rest.car.bean.InList;

@Path("/v/vehicle")
public interface VehicleController {
    //Below four different get examples
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public Response getVehicles();
	
	@GET @Path("/{id}") 
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVehicleById(@PathParam("id") int id);
	
	@GET @Path("/{id}/{id2}") 
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVehicleById(@Context UriInfo info, @PathParam("id") int id, @PathParam("id2") int id2);
	
	@GET @Path("/{id}/car/{zone}") 
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVehicleById(@Context UriInfo info, @PathParam("id") int id, @PathParam("zone") String zone,@HeaderParam("user") String user);
	
	//Below two different POST examples#
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/orders")
	public Response registerCar(@Context UriInfo info, CarDetailBean carDetailBean, @HeaderParam("user") String user);
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/orderlist/vehicle.json")
	public Response placeCarOrder(@Context UriInfo info, CarInfoBean carInfoBean, @HeaderParam("user") String user);
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/inlist/InList.json")
	public Response setInList(@Context UriInfo info, InList inList, @HeaderParam("user") String user);
}
