package com.everis.training.fleet.business.fleet.control;

import com.everis.training.fleet.business.exception.InvalidVinException;
import com.everis.training.fleet.business.fleet.entity.Customer;


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

    public void delete(Integer id) {
        repo.deleteVehicle(id);
    }

    public void finalizeReserveCar(Integer idCustomer) {
        repo.finalizeReserveCar(idCustomer);
    }
    public void reserveCar(final Integer id, final String vin) throws InvalidVinException {
        try {
            VehicleController.checkVin(vin);
            repo.reserveCar(id, vin);
        } catch (InvalidVinException e) {
            throw e;
        }
    }
}
