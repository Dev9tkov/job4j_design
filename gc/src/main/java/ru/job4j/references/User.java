package ru.job4j.references;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Ilya Devyatkov
 * @since 26.03.2020
 */
public class User {
    private static final Logger LOG = LogManager.getLogger(User.class.getName());

    public String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println(String.format("finalize"));
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + '}';
    }
}
