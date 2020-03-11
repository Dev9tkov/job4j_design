package ru.job4j.srp;

import java.util.Comparator;

/**
 * @author Ilya Devyatkov
 * @since 11.03.2020
 */
public class EmpSalaryComparator implements Comparator<Employer> {

    /**
     * Сортировка работников по убыванию зарплаты
     * @param o1 первый работник
     * @param o2 второй работник
     * @return
     */
    @Override
    public int compare(Employer o1, Employer o2) {
        if (o1.getSalary() == o2.getSalary()) {
            return 0;
        } else if (o1.getSalary() > o2.getSalary()) {
            return -1;
        } else {
            return 1;
        }
    }
}
