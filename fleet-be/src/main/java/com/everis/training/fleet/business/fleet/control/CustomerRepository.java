package com.everis.training.fleet.business.fleet.control;

import com.everis.training.fleet.business.fleet.entity.Customer;
import com.everis.training.fleet.business.fleet.entity.Fleet;
import com.google.gson.Gson;

import javax.faces.bean.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class CustomerRepository {
    @PersistenceContext(unitName = "fleet")
    EntityManager em;

    public String findCustomer(Integer id) {
        Gson gson = new Gson();
        String jsonCustomer = gson.toJson(em.find(Customer.class, id));
        return jsonCustomer;
    }
}
