package ru.job4j.parking;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Ilya Devyatkov
 * @since 16.03.2020
 */
public class ParkingTest {
    @Test
    public void whenPlaceDoesNotExistThenCarAndTruckNotParked() {
        Parking parking = new Parking(0, 0);
        PassengerCar car = new PassengerCar("t089km");
        Truck truck = new Truck("t091op", 2);
        assertFalse(parking.addCar(car));
        assertFalse(parking.addCar(truck));
    }

    @Test
    public void whenPlaceExistThenCarAndTruckParked() {
        Parking parking = new Parking(1, 1);
        PassengerCar car = new PassengerCar("t089km");
        Truck truck = new Truck("t091op", 2);
        assertTrue(parking.addCar(car));
        assertTrue(parking.addCar(truck));
    }

    @Test
    public void whenPlaceExistForTruckAndNoCarThenTruckParked() {
        Parking parking = new Parking(2, 0);
        Truck truck = new Truck("t091op", 2);
        assertTrue(parking.addCar(truck));
    }
}