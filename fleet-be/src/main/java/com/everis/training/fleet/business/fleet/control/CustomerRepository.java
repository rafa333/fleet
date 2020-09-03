package com.everis.training.fleet.business.fleet.control;

import com.everis.training.fleet.business.fleet.entity.Reserve;
import com.everis.training.fleet.business.fleet.entity.Customer;

import javax.faces.bean.ApplicationScoped;
import javax.persistence.EntityManager;
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

    public void reserveCar(Reserve reserve) {
        Customer c;
        c=em.find(Customer.class, reserve.getIdcustomer());
        c.setVehicle(reserve.getVin());
        em.merge(c);
    }

    public void finalizeReserveCar(Integer idcustomer) {
        Customer c;
        c=em.find(Customer.class, idcustomer);
        c.setVehicle(null);
        em.merge(c);

    }
}
