package ru.job4j.srp;

import java.util.List;
import java.util.function.Predicate;

/**
 * Класс нужен для генерации отчетов в виде html.
 * @author Ilya Devyatkov
 * @since 11.03.2020
 */
public class ReportHtml implements Report{
    private Store store;

    public ReportHtml(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employer> filter) {
        List<Employer> employers = store.findBy(filter);
        StringBuilder text = new StringBuilder();
        text.append("<head>")
                .append(System.lineSeparator())
                .append("Name; Hired; Fired; Salary")
                .append(System.lineSeparator())
                .append("</head>")
                .append(System.lineSeparator())
                .append("<body>")
                .append(System.lineSeparator());
        for (Employer employer : employers) {
            text.append(employer.getName()).append(";")
                    .append(employer.getHired()).append(";")
                    .append(employer.getFired()).append(";")
                    .append(employer.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        text.append("</body>");
        return text.toString();
    }
}
