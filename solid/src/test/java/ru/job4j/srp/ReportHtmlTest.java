package ru.job4j.srp;

import org.junit.Test;

import java.util.Calendar;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author Ilya Devyatkov
 * @since 11.03.2020
 */
public class ReportHtmlTest {
    @Test
    public void whenGeneratedWithHtml() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Ivan", now, now, 100);
        store.add(worker);
        ReportHtml engine = new ReportHtml(store);
        StringBuilder expect = new StringBuilder()
                .append("<head>")
                .append(System.lineSeparator())
                .append("Name; Hired; Fired; Salary")
                .append(System.lineSeparator())
                .append("</head>")
                .append(System.lineSeparator())
                .append("<body>")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator())
                .append("</body>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}