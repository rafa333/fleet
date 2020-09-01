package com.everis.training.fleet.business.fleet.boundary;

import com.everis.training.fleet.business.fleet.control.FleetController;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("v1/fleets")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
@Stateless
public class FleetResource {
    @Inject
    FleetController con;

    @Path("{fleetId}")
    @GET
    public Response retrieveFleet(@PathParam("fleetId") final Integer id) {
        return Response.ok().entity(con.findFleet(id)).build();
    }

    @GET
    public Response listFleets() {
        return Response.ok().entity(con.getAllFleets()).build();
    }
}
