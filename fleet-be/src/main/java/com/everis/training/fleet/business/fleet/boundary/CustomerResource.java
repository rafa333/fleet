package com.everis.training.fleet.business.fleet.boundary;

import com.everis.training.fleet.business.fleet.control.CustomerController;
import com.everis.training.fleet.business.fleet.entity.Customer;
import com.everis.training.fleet.business.fleet.entity.Fleet;
import com.google.gson.Gson;

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
    public Response addCustomer(String json){
        Gson gson = new Gson();
        Customer c = gson.fromJson(json, Customer.class);
        con.add(c);
        return Response.ok().entity(String.format("The customer has been added successfully!")).build();
    }

    @Path("reserve")
    @PUT
    public Response reserveCar(String json){
        con.reserveCar(json);
        return Response.ok().entity(String.format("The reserve has been done successfully!")).build();
    }

    @PUT
    public Response updateCustomer(String json){
        Gson gson = new Gson();
        Customer c = gson.fromJson(json, Customer.class);
        con.update(c);
        return Response.ok().entity(String.format("The customer has been updated successfully!")).build();
    }

    @Path("{customerId}")
    @DELETE
    public Response deleteCustomer(@PathParam("customerId") final Integer id) {
        con.delete(id);
        return Response.ok().entity(String.format("The customer with id: %s has been deleted successfully!", id)).build();
    }
}
