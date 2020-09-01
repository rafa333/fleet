package com.everis.training.fleet.business.fleet.boundary;


import com.everis.training.fleet.business.fleet.control.VehicleController;
import com.everis.training.fleet.business.fleet.entity.Vehicle;
import com.google.gson.Gson;

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

  @Path("{vehicleId}")
  @GET
  public Response retrieveVehicle(@PathParam("vehicleId") final String vin) {
    return Response.ok().entity(con.findVehicle(vin)).build();
  }

  @GET
  public Response listVehicles() {
    return Response.ok().entity(con.getAllVehicles()).build();
  }

  @POST
  public Response addVehicle(String json) {
    Gson gson = new Gson();
    Vehicle v = gson.fromJson(json, Vehicle.class);
    con.add(v);
    return Response.ok().entity(String.format("The vehicle has been added successfully!")).build();
  }

  @PUT
  public Response updateVehicle(String json) {
    Gson gson = new Gson();
    Vehicle v = gson.fromJson(json, Vehicle.class);
    con.update(v);
    return Response.ok().entity(String.format("The vehicle has been updated successfully!")).build();
  }

  @Path("{vehicleId}")
  @DELETE
  public Response deleteVehicle(@PathParam("vehicleId") final String vin) {
    con.delete(vin);
    return Response.ok().entity(String.format("The vehicle with vin: %s has been deleted successfully!", vin)).build();
  }
}
