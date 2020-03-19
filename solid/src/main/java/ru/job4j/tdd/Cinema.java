package ru.job4j.tdd;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Ilya Devyatkov
 * @since 16.03.2020
 */
public interface Cinema {
    List<Session> find(Predicate<Session> filter);

    Ticket buy(Account acount, int row, int column, Calendar date);

    void add(Session session);
}
