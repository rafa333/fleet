package com.everis.training.fleet.business.fleet.boundary;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("v1/fleets")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
@Stateless
public class FleetResource {
    @Path("{fleetId}")
    @GET
    public Response retrieveFleet(@PathParam("fleetId") final Integer id) {
        return Response.ok().entity(String.format("The vehicle has been added successfully!")).build();
    }
}
