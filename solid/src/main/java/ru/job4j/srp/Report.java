package ru.job4j.srp;

import java.util.function.Predicate;

/**
 * @author Ilya Devyatkov
 * @since 11.03.2020
 */
public interface Report {
    String generate(Predicate<Employer> filter);
}
