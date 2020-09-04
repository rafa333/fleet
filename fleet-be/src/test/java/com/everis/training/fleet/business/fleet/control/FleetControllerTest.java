package com.everis.training.fleet.business.fleet.control;

import com.everis.training.fleet.business.fleet.entity.Fleet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class FleetControllerTest {
    @InjectMocks
    FleetController underTest;
    @Mock
    FleetRepository repo;
    @Test
    void getAllFleets_validParameters_sucess() {
        //given

        //when
        underTest.getAllFleets();
        //then
        verify(repo).getAll();
    }

    @Test
    void findFleet_validParameters_sucess() {
        //given
        int idFleet = 1;
        //when
        underTest.findFleet(idFleet);
        //then
        verify(repo).findFleet(idFleet);
    }

    @Test
    void addFleet_validParameters_sucess() {
        //given
        Fleet fleet = new Fleet();
        fleet.setIdFleet(1);
        fleet.setName("BMW-US");
        //when
        underTest.add(fleet);
        //then
        verify(repo).saveFleet(fleet);
    }

    @Test
    void deleteFleet_validParameters_sucess() {
        //given
        int idFleet = 1;
        //when
        underTest.delete(idFleet);
        //then
        verify(repo).deleteVehicle(idFleet);
    }
}