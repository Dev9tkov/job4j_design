package ru.job4j.references;

import org.junit.Test;

import java.io.File;
import java.util.StringJoiner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Ilya Devyatkov
 * @since 26.03.2020
 */
public class SoftCacheTest {
    private final String path = new File("src/main/resources").getAbsolutePath();
    @Test
    public void getTextAdress() {
        SoftCache softCache = new SoftCache(path);
        String expected =
                softCache.getText("Adress.txt");
        String result = String.join(System.lineSeparator(),
                "Perm", "Moskva", "Novosibirsk");
        assertThat(result, is (expected));
    }
    @Test
    public void getTextNames() {
        SoftCache softCache = new SoftCache(path);
        String expected =
                softCache.getText("Name.txt");
        String result = String.join(System.lineSeparator(),
                "Kostya", "Ilya", "Maksim","Dima");
        assertThat(result, is (expected));
    }
}