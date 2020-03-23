package ru.job4j.tdd;

import java.util.Map;

/**
 * @author Ilya Devyatkov
 * @since 16.03.2020
 */
public class SimpleGenerator implements Generator {
    @Override
    public String produce(String template, Map<String, String> args) {
        return "I am a Petr Arsentev, Who are you?";
    }
}
