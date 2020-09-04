package com.everis.training.fleet.business.fleet.control;

import com.everis.training.fleet.business.fleet.entity.Vehicle;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)
class VehicleControllerTest {
    @InjectMocks    //@Spy
    VehicleController underTest;
    @Mock
    VehicleRepository repo;

    @Test
    void addVehicle_validParameters_success() throws Exception {
        //given
        Vehicle vehicle = new Vehicle();
        vehicle.setFleet(1);
        vehicle.setBrand("BMW");
        vehicle.setModel("320d");
        vehicle.setPlate("1234HTY");
        vehicle.setVin("123456789qwerty13");
        //when
        underTest.add(vehicle);
        //then
        verify(repo).addVehicle(vehicle);
    }

    @Test
    void reserveCar_validParameters_success() throws Exception {
        //given
        int id = 1;
        String vin = "123456789qwertyu1";
        //when
        underTest.reserveCar(id, vin);
        //then
        verify(repo).reserveCar(id, vin);
    }

    @Test
    void deleteVehicle_validParameters_success() throws Exception {
        //given
        String vin = "123456789qwertyu1";
        //when
        underTest.delete(vin);
        //then
        verify(repo).deleteVehicle(vin);
    }

    @Test
    void findVehicle_validParameters_success() {
        //given
        String vin = "123456789qwertyu1";
        //when
        underTest.findVehicle(vin);
        //then
        verify(repo).findVehicle(vin);
    }

    @Test
    void getAllVehicles_validParameters_success() {
        //given

        //when
        underTest.getAllVehicles();
        //then
        verify(repo).getAll();
    }

    @Test
    void getAllFreeVehicles_validParameters_success() {
        //given

        //when
        underTest.getAllFreeVehicles();
        //then
        verify(repo).getAllFreeVehicles();
    }
}