package ru.job4j.tdd;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Ilya Devyatkov
 * @since 16.03.2020
 */
public class Cinema3D implements Cinema {

    private Integer sessionCapacity;

    @Override
    public List<Session> find(Predicate<Session> filter) {
        return null;
    }

    @Override
    public Ticket buy(Account acount, int row, int column, Calendar date) {
        return null;
    }

    @Override
    public void add(Session session) {
        sessionCapacity++;
    }

    public Integer getSessionCapacity() {
        return sessionCapacity;
    }
}
