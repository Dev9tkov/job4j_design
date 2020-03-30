package ru.job4j.references;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * @author Ilya Devyatkov
 * @since 26.03.2020
 */
public class SoftCache extends AbstractCache {
    private static final Logger LOG = LogManager.getLogger(SoftCache.class.getName());
    /**
     * Путь к файлу
     */
    private String path;

    /**
     * Имя файла - содержимое
     */
    Map<String, SoftReference<String>> softCache = new HashMap<>();

    public SoftCache(String path) {
        this.path = path;
    }

    @Override
    String getText(String name) {
        String result;
        if (!softCache.containsKey(name)) {
            try (BufferedReader reader = new BufferedReader(new FileReader(new File(path, name)))) {
                StringJoiner joiner = new StringJoiner(System.lineSeparator());
                reader.lines().forEach(joiner::add);
                softCache.put(name, new SoftReference<>(joiner.toString()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        result = softCache.get(name).get();
        return result;
    }
}
