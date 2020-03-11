package ru.job4j.srp;

import java.util.List;
import java.util.function.Predicate;

/**
 * Отдел HR попросил выводить сотрудников в порядке убывания зарплаты и убрать поля даты найма и увольнения.
 * @author Ilya Devyatkov
 * @since 11.03.2020
 */
public class ReportHR implements Report{
    private EmpSalaryComparator emp = new EmpSalaryComparator();
    private Store store;

    public ReportHR(Store store) {
        this.store = store;
    }

    @Override
    public String generate (Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary")
                .append(System.lineSeparator());
        List<Employer> employers = store.findBy(filter);
        employers.sort(emp);
        for (Employer employer : employers) {
            text.append(employer.getName()).append(";")
                    .append(employer.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
