package ru.job4j.parking;

/**
 * @author Ilya Devyatkov
 * @since 12.03.2020
 */
public class Parking implements ParkingCar {
    /**
     * кол-во парковочных мест для легковых машин
     */
    private int passenCarPlace;

    /**
     * кол-во парковочных мест для грузовых машин
     */
    private int truckPlace;

    /**
     * конструктор для создания парковки
     * @param passenCarPlace
     * @param truckPlace
     */
    public Parking(int passenCarPlace, int truckPlace) {
        this.passenCarPlace = passenCarPlace;
        this.truckPlace = truckPlace;
    }

    /**
     * Добавление транспортного средства на парковку
     * @param car
     * @return результат добавления. Успешно либо нет
     */
    @Override
    public boolean addCar(Car car) {
        return false;
    }
}
