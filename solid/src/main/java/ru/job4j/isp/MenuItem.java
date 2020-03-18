package ru.job4j.isp;

import java.util.List;

/**
 * @author Ilya Devyatkov
 * @since 18.03.2020
 */
public class MenuItem {
    private String name;
    private List<String> items;

    public MenuItem(String name, List<String> items) {
        this.name = name;
        this.items = items;
    }

    public MenuItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getItems() {
        return items;
    }
}
