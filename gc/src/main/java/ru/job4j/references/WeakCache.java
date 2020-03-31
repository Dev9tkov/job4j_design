package ru.job4j.references;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * @author Ilya Devyatkov
 * @since 26.03.2020
 */
public class WeakCache extends AbstractCache {
    private static final Logger LOG = LogManager.getLogger(WeakCache.class.getName());
    /**
     * Путь к файлу
     */
    private final String path;

    /**
     * Имя файла - содержимое
     */
    private final Map<String, WeakReference<String>> weakCache = new HashMap<>();

    public WeakCache(String path) {
        this.path = path;
    }

    @Override
    String getText(String name) {
        String result;
        if (!weakCache.containsKey(name)) {
            putInMap(name);
        }
        result = weakCache.get(name).get();
        return result;
    }

    private void putInMap(String name) {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(path, name)))) {
            StringJoiner joiner = new StringJoiner(System.lineSeparator());
            reader.lines().forEach(joiner::add);
            weakCache.put(name, new WeakReference<>(joiner.toString()));
        } catch (IOException e) {
            LOG.error(e);
        }
    }
}
