package ru.job4j.srp;

import java.util.function.Predicate;

/**
 * @author Ilya Devyatkov
 * @since 06.03.2020
 */
public class ReportEngine implements Report{
    private Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary")
        .append(System.lineSeparator());
        for (Employer employer : store.findBy(filter)) {
            text.append(employer.getName()).append(";")
                    .append(employer.getHired()).append(";")
                    .append(employer.getFired()).append(";")
                    .append(employer.getSalary()).append(";");
        }
        return text.toString();
    }
}
