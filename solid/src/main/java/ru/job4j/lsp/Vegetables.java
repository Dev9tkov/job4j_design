package ru.job4j.lsp;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Ilya Devyatkov
 * @since 04.03.2020
 */
public class Vegetables extends Food {

    public Vegetables(String name, Date createDate, Date expaireDate, double price, double discount) {
        super(name, createDate, expaireDate, price, discount);
    }
}
