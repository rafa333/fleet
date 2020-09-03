package com.everis.training.fleet.business.fleet.control;

import com.everis.training.fleet.business.fleet.entity.Customer;
import com.everis.training.fleet.business.fleet.entity.Reserve;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {
    @InjectMocks
    CustomerController underTest;
    @Mock
    CustomerRepository repo;

    @Test
    void findCustomer_validParameters_success() {
        //given
        int idCustomer = 1;
        //when
        underTest.findCustomer(idCustomer);
        //then
        verify(repo).findCustomer(idCustomer);
    }

    @Test
    void getAllCustomers_validParameters_success() {
        //given
        //when
        underTest.getAllCustomers();
        //then
        verify(repo).getAll();
    }

    @Test
    void addCustomer_validParameters_success() {
        //given
        Customer customer = new Customer();
        customer.setIdcustomer(1);
        customer.setName("Benito Guerra");
        customer.setVehicle("123456789qwertyu1");
        //when
        underTest.add(customer);
        //then
        verify(repo).saveCustomer(customer);

    }

    @Test
    void updateCustomer_validParameters_success() {
        //given
        Customer customer = new Customer();
        customer.setIdcustomer(1);
        customer.setName("Benito Guerra");
        customer.setVehicle("123456789qwertyu1");
        //when
        underTest.update(customer);
        //then
        verify(repo).updateCustomer(customer);
    }

    @Test
    void deleteCustomer_validParameters_success() {
        //given
        int idCustomer = 1;
        //when
        underTest.delete(idCustomer);
        //then
        verify(repo).deleteVehicle(idCustomer);
    }

    @Test
    void reserveCar_validParameters_success() {
        //given
        Reserve reserve = new Reserve();
        reserve.setIdcustomer(1);
        reserve.setVin("123456789qwertyu1");
        //when
        underTest.reserveCar(reserve);
        //then
        verify(repo).reserveCar(reserve);
    }

    @Test
    void finalizeReserveCar_validParameters_success() {
        //given
        int idCustomer = 1;
        //when
        underTest.finalizeReserveCar(idCustomer);
        //then
        verify(repo).finalizeReserveCar(idCustomer);
    }
}