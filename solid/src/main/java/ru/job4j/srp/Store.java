package ru.job4j.srp;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author Ilya Devyatkov
 * @since 06.03.2020
 */
public interface Store {

    List<Employer> findBy(Predicate<Employer> filter);
}
