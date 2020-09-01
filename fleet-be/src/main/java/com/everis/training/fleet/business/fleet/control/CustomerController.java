package com.everis.training.fleet.business.fleet.control;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CustomerController {
    @Inject
    CustomerRepository repo;
    public String findCustomer(Integer id) {
        return repo.findCustomer(id);
    }
}
