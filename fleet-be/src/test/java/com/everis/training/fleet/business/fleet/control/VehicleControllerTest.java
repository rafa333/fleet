package com.everis.training.fleet.business.fleet.control;

import com.everis.training.fleet.business.fleet.entity.Vehicle;
import org.junit.Before;
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

    @Before
    public void setUp(){
        //MockitoAnnotations.initMocks(this);
        //repo = mock(repo.getClass());
    }

    @Test
    void addVehicle_validParameters_success() {
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

    //    verify(con).add(vehicle);
        verify(repo).saveVehicle(vehicle);
    }
    @Test
    void deleteVehicle_validParameters_success() {
        //given
        String vin = "123456789qwertyu1";
        //when
        underTest.delete(vin);
        //then

        //    verify(con).add(vehicle);
        verify(repo).deleteVehicle(vin);
    }

    @Test
    void updateVehicle_validParameters_success() {
        //given
        Vehicle vehicle = new Vehicle();
        vehicle.setFleet(1);
        vehicle.setBrand("BMW");
        vehicle.setModel("320d");
        vehicle.setPlate("1234HTY");
        vehicle.setVin("123456789qwerty13");
        //when
        underTest.update(vehicle);
        //then

        //    verify(con).add(vehicle);
        verify(repo).updateVehicle(vehicle);
    }

    @Test
    void findVehicle_validParameters_success() {
        //given
        String vin = "123456789qwertyu1";
        //when
        underTest.findVehicle(vin);
        //then

        //    verify(con).add(vehicle);
        verify(repo).findVehicle(vin);
    }

    @Test
    void getAllVehicles_validParameters_success() {
        //given

        //when
        underTest.getAllVehicles();
        //then

        //    verify(con).add(vehicle);
        verify(repo).getAll();
    }

    @Test
    void getAllFreeVehicles_validParameters_success() {
        //given

        //when
        underTest.getAllFreeVehicles();
        //then

        //    verify(con).add(vehicle);
        verify(repo).getAllFreeVehicles();
    }
}