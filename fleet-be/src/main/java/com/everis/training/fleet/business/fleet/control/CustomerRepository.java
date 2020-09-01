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

    public Customer findCustomer(Integer id) {
        return em.find(Customer.class, id);
    }

    public List<Customer> getAll() {
        Query q = em.createQuery("SELECT customer FROM Customer customer", Customer.class);
        return (List<Customer>) q.getResultList();
    }

    public void saveCustomer(Customer customer) {
        em.persist(customer);
        em.flush();
    }

    public void updateCustomer(Customer customer) {
        em.merge(customer);
    }

    public void deleteVehicle(Integer id) {
        Customer customer;
        customer = em.find(Customer.class, id);
        em.remove(customer);
    }

    public void reserveCar(Integer id, String vin) {
        Customer c;
        c=em.find(Customer.class, id);
        c.setVehicle(vin);
        em.merge(c);
    }
}
