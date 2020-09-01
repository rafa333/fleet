package com.everis.training.fleet.business.fleet.control;

import com.everis.training.fleet.business.fleet.entity.Customer;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CustomerController {
    @Inject
    CustomerRepository repo;
    public String findCustomer(Integer id) {
        return repo.findCustomer(id);
    }

    public String getAllCustomers() {
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
}
