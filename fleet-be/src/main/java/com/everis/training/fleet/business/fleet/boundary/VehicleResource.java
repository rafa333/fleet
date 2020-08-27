package com.everis.training.fleet.business.fleet.boundary;


import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("v1/vehicles")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
@Stateless
public class VehicleResource {

  @Path("{vehicleId}")
  @GET
  public Response retrieveVehicle(@PathParam("vehicleId") final Long id) {
    return Response.ok().entity(String.format("Mock: here your vehicle %s", id)).build();
  }
}
