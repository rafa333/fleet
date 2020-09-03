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

  @Path("{vehicleId}")
  @GET
  public Response retrieveVehicle(@PathParam("vehicleId") final String vin) {
    return Response.ok().entity(con.findVehicle(vin)).build();
  }

  @GET
  public Response listVehicles() {
    return Response.ok().entity(con.getAllVehicles()).build();
  }

  @Path("free")
  @GET
  public Response listFreeVehicles() {
    return Response.ok().entity(con.getAllFreeVehicles()).build();
  }

  @POST
  public Response addVehicle(Vehicle vehicle) {
    con.add(vehicle);
    return Response.ok().entity("The vehicle has been added successfully!").build();
  }

  @PUT
  public Response updateVehicle(Vehicle vehicle) {
    con.update(vehicle);
    return Response.ok().entity("The vehicle has been updated successfully!").build();
  }

  @Path("{vehicleId}")
  @DELETE
  public Response deleteVehicle(@PathParam("vehicleId") final String vin) {
    con.delete(vin);
    return Response.ok().entity(String.format("The vehicle with vin: %s has been deleted successfully!", vin)).build();
  }
}
