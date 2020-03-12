package ru.job4j.parking;

/**
 * @author Ilya Devyatkov
 * @since 12.03.2020
 */
public interface Car {

    /**
     * Лицензионный номер транспортного средства
     * @return
     */
    String getNumber();

    /**
     * размер, занимаемый транспортным средством
     * @return
     */
    int getSize();
}
