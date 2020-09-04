package com.everis.training.fleet.business.fleet.boundary;


import com.everis.training.fleet.business.fleet.control.VehicleController;
import com.everis.training.fleet.business.fleet.entity.Vehicle;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;


@Path("v1/vehicles")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
@Stateless
public class VehicleResource {

  @Inject
  VehicleController con;

  @Path("{vehicleId}/search-vehicle")
  @GET
  public Response retrieveVehicle(@PathParam("vehicleId") final String vin) {
    return Response.ok().entity(con.findVehicle(vin)).build();
  }

  @GET
  public Response listVehicles() {
    return Response.ok().entity(con.getAllVehicles()).build();
  }

  @Path("free-vehicles")
  @GET
  public Response listFreeVehicles() {
    return Response.ok().entity(con.getAllFreeVehicles()).build();
  }

  @Path("{customerId}/reserve-vehicle/{vin}")
  @POST
  public Response reserveCar(@PathParam("customerId") final Integer id, @PathParam("vin") String vin){
    String response = "The reserve has been done successfully!";
    try {
      con.reserveCar(id, vin);
    } catch (Exception e) {
      response=e.getMessage();
    }
    return Response.ok().entity(response).build();
  }

  @POST
  public Response addVehicle(Vehicle vehicle) {
    String response = "The vehicle has been added successfully!";
    try {
      con.add(vehicle);
    } catch (Exception e) {
      response=e.getMessage();
    }
    return Response.ok().entity(response).build();
  }

  @Path("{vehicleId}")
  @DELETE
  public Response deleteVehicle(@PathParam("vehicleId") final String vin) {
    String response = "The vehicle has been deleted successfully!";
    try {
      con.delete(vin);
    } catch (Exception e) {
      response=e.getMessage();
    }
    return Response.ok().entity(response).build();
  }
}
