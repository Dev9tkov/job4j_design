package ru.job4j.tdd;

import java.util.Map;

/**
 * @author Ilya Devyatkov
 * @since 16.03.2020
 */
public interface Generator {
    String produce(String template, Map<String, String> args);
}
