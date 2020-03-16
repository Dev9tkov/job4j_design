package ru.job4j.tdd;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Ilya Devyatkov
 * @since 16.03.2020
 */
public class SimpleGeneratorTest {
    @Test
    public void generate() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        args.put("subject ", "you");
        Generator generator = new SimpleGenerator();
        String result = generator.produce(template, args);
        String expected = "I am a Petr Arsentev, Who are you?";
        assertThat(result, is(expected));
    }
}