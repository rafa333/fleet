package com.everis.training.fleet.business.fleet.control;

import com.everis.training.fleet.business.fleet.entity.Customer;
import com.everis.training.fleet.business.fleet.entity.Fleet;
import com.google.gson.Gson;

import javax.faces.bean.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@ApplicationScoped
public class CustomerRepository {
    @PersistenceContext(unitName = "fleet")
    EntityManager em;

    public String findCustomer(Integer id) {
        Gson gson = new Gson();
        String jsonCustomer = gson.toJson(em.find(Customer.class, id));
        return jsonCustomer;
    }

    public String getAll() {
        Query q = em.createQuery("SELECT customer FROM Customer customer", Customer.class);
        Gson gson = new Gson();
        String jsonCustomerList = gson.toJson((List<Fleet>) q.getResultList());
        return jsonCustomerList;
    }

    public void saveCustomer(Customer customer) {
        em.persist(customer);
        em.flush();
    }

    public void updateCustomer(Customer customer) {
        em.merge(customer);
    }
}
