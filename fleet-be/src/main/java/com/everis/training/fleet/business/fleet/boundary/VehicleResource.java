package com.everis.training.fleet.business.fleet.boundary;


import com.everis.training.fleet.business.fleet.control.VehicleController;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;


@Path("v1/vehicles")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
@Stateless
public class VehicleResource {

  VehicleController con;
  @Path("{vehicleId}")
  @GET
  public Response retrieveVehicle(@PathParam("vehicleId") final String vin) {
    return Response.ok().entity(con.findVehicle(vin)).build();
  }
/*
  @Path("{vehicleId}")
  @GET
  public Response listVehicles(@PathParam("vehicleId") final String vin) {
    con.getAllVehicles();
    return Response.ok().entity(con.findVehicle(vin)).build();
  }

  @Path("{vehicleId}")
  @POST
  public Response addVehicle(@PathParam("vehicleId") final Long id) {
    con.add();
    return Response.ok().entity(String.format("Mock: here your vehicle %s", id)).build();
  }

  @Path("{vehicleId}")
  @PUT
  public Response updateVehicle(@PathParam("vehicleId") final Long id) {
    con.update();
    return Response.ok().entity(String.format("Mock: here your vehicle %s", id)).build();
  }

  @Path("{vehicleId}")
  @DELETE
  public Response deleteVehicle(@PathParam("vehicleId") final String vin) {
    con.delete(vin);
    return Response.ok().entity(String.format("Mock: here your vehicle %s", vin)).build();
  }*/
}
