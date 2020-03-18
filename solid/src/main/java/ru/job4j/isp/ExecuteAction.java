package ru.job4j.isp;

/**
 * @author Ilya Devyatkov
 * @since 18.03.2020
 */
public interface ExecuteAction {
    void execute(MenuItem menuItem);
    void select(String name);
}
