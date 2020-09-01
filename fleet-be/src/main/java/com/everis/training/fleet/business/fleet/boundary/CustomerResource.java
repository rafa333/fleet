package com.everis.training.fleet.business.fleet.boundary;

import com.everis.training.fleet.business.fleet.control.CustomerController;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("v1/customers")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
@Stateless
public class CustomerResource {
    @Inject
    CustomerController con;

    @Path("{customerId}")
    @GET
    public Response retrieveFleet(@PathParam("customerId") final Integer id) {
        return Response.ok().entity(con.findCustomer(id)).build();
    }

    @GET
    public Response listCustomers() {
        return Response.ok().entity(con.getAllCustomers()).build();
    }

    
}
