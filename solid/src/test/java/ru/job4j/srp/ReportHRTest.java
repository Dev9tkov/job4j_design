package ru.job4j.srp;

import org.junit.Test;
import java.util.Calendar;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author Ilya Devyatkov
 * @since 11.03.2020
 */
public class ReportHRTest {
    @Test
    public void whenGeneratedForHR() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker1 = new Employer("Ivan", now, now, 90);
        Employer worker2 = new Employer("Max", now, now, 110);
        Employer worker3 = new Employer("Men", now, now, 70);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        ReportHR engine = new ReportHR(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker3.getName()).append(";")
                .append(worker3.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}