package ru.job4j.srp;

import java.util.List;
import java.util.function.Predicate;

/**
 * Класс нужен для того, чтобы генерировать отчеты с измененной зарплатой
 * @author Ilya Devyatkov
 * @since 11.03.2020
 */
public class ReportChangeSalary implements Report {
    private Store store;

    public ReportChangeSalary(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employer> filter) {
        List<Employer> employers = store.findBy(filter);
        StringBuilder text = new StringBuilder();
            text.append("Name; Hired; Fired; Salary")
                .append(System.lineSeparator());
        for (Employer employer : employers) {
            double salary = employer.getSalary() * 100;
            text.append(employer.getName()).append(";")
                    .append(employer.getHired()).append(";")
                    .append(employer.getFired()).append(";")
                    .append(salary).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
