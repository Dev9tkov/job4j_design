package ru.job4j.parking;

/**
 * @author Ilya Devyatkov
 * @since 12.03.2020
 */
public class Truck implements Car {

    private String number;
    private int size;

    public Truck(String number, int size) {
        this.number = number;
        this.size = size;
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Truck{"
                + "number='" + number + '\''
                + ", size=" + size
                + '}';
    }
}
