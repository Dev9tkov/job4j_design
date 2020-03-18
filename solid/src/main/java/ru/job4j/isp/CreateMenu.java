package ru.job4j.isp;


import java.util.Map;
import java.util.Set;

/**
 * @author Ilya Devyatkov
 * @since 18.03.2020
 */
public interface CreateMenu {
    Set<String> create(Map<String, MenuItem> menu);
}
