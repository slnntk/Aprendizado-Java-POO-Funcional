package src.interfaceComparatorAula.entities;

import java.util.Comparator;

public class MyComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee employee, Employee t1) {
        return employee.getName().toUpperCase().compareTo(t1.getName().toUpperCase());
    }
}
