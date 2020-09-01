package com.everis.training.fleet.business.fleet.boundary;

import com.everis.training.fleet.business.fleet.control.FleetController;
import com.everis.training.fleet.business.fleet.entity.Fleet;
import com.google.gson.Gson;

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

    @POST
    public Response addFleet(String json){
        Gson gson = new Gson();
        Fleet f = gson.fromJson(json, Fleet.class);
        con.add(f);
        return Response.ok().entity(String.format("The fleet has been added successfully!")).build();
    }

    @PUT
    public Response updateFleet(String json){
        Gson gson = new Gson();
        Fleet f = gson.fromJson(json, Fleet.class);
        con.update(f);
        return Response.ok().entity(String.format("The fleet has been updated successfully!")).build();    }
}
