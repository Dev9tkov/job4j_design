package ru.job4j.parking;

/**
 * @author Ilya Devyatkov
 * @since 12.03.2020
 */
public class PassengerCar implements Car{

    private String number;

    public PassengerCar(String number) {
        this.number = number;
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public int getSize() {
        return 1;
    }

    @Override
    public String toString() {
        return "PassengerCar{"
                + "number='" + number + '\''
                + '}';
    }
}
