package ru.job4j;

/**
 * @author Ilya Devyatkov
 * @since 21.03.2020
 */
public class User {
    public String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println(String.format("finalize: object destroy %s", name));
    }

    public void info() {
        int mb = 1024 * 1024;
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Heap utilization statistics [MB]");
        System.out.println("Free memory: " + runtime.freeMemory() / mb);
        System.out.println("Total Memory: " + runtime.totalMemory() / mb);

    }

    public static void main(String[] args) {
        User user = new User("Name");
        user.info();
        int index = 0;
        while (index < 315970) {
            index++;
            user = new User("Name " + index);
        }
    }
}
