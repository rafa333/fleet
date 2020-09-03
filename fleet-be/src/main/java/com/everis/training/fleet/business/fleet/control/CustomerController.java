package com.everis.training.fleet.business.fleet.control;

import com.everis.training.fleet.business.fleet.boundary.Reserve;
import com.everis.training.fleet.business.fleet.entity.Customer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jdk.nashorn.internal.parser.JSONParser;
import net.minidev.json.JSONObject;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class CustomerController {
    @Inject
    CustomerRepository repo;
    public Customer findCustomer(Integer id) {
        return repo.findCustomer(id);
    }

    public List<Customer> getAllCustomers() {
        return repo.getAll();
    }

    public void add(Customer customer) {
        repo.saveCustomer(customer);
    }

    public void update(Customer customer) {
        repo.updateCustomer(customer);
    }

    public void delete(Integer id) {
        repo.deleteVehicle(id);
    }

    public void reserveCar(Reserve reserve) {
        repo.reserveCar(reserve);
    }


    public void finalizeReserveCar(Integer idcustomer) {
        repo.finalizeReserveCar(idcustomer);
    }
}
