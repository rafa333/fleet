package com.everis.training.fleet.business.fleet.boundary;

import com.everis.training.fleet.business.fleet.control.CustomerController;
import com.everis.training.fleet.business.fleet.entity.Customer;


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
    public Response retrieveCustomer(@PathParam("customerId") final Integer id) {
        return Response.ok().entity(con.findCustomer(id)).build();
    }

    @GET
    public Response listCustomers() {
        return Response.ok().entity(con.getAllCustomers()).build();
    }


    @POST
    public Response addCustomer(Customer customer){
        con.add(customer);
        return Response.ok().entity("The customer has been added successfully!").build();
    }

    @Path("{customerId}/reserve-vehicle/{vin}")
    @POST
    public Response reserveCar(@PathParam("customerId") final Integer id, @PathParam("vin") String vin){
        con.reserveCar(id, vin);
        return Response.ok().entity("The reserve has been done successfully!").build();
    }

    @Path("{customerId}/finalize-reservation")
    @POST
    public Response finalizeReserveCar(@PathParam("customerId") final Integer id){
        con.finalizeReserveCar(id);
        return Response.ok().entity("The reserve has been done successfully!").build();
    }

    @Path("{customerId}")
    @DELETE
    public Response deleteCustomer(@PathParam("customerId") final Integer id) {
        con.delete(id);
        return Response.ok().entity(String.format("The customer with id: %s has been deleted successfully!", id)).build();
    }
}
