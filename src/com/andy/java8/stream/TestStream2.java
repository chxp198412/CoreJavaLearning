package com.andy.java8.stream;

import com.andy.java8.lambda.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestStream2 {
    List<Employee> employees = Arrays.asList(
            new Employee("c", 20, Employee.Status.BUSY),
            new Employee("a", 20, Employee.Status.FREE),
            new Employee("b", 35, Employee.Status.FREE),
            new Employee("d", 15, Employee.Status.BUSY),
            new Employee("e", 40, Employee.Status.FREE));

    @Test
    public void test1(){
        boolean isAllBusy = employees.stream().allMatch(e -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(isAllBusy);

        boolean isAnyFree = employees.stream().anyMatch(e -> e.getStatus().equals(Employee.Status.FREE));
        System.out.println(isAnyFree);

        //是否全部员工没有休假
        boolean isNoVacation = employees.stream().noneMatch(e -> e.getStatus().equals(Employee.Status.VACATION));
        System.out.println(isNoVacation);

        System.out.println(employees.stream().sorted(Comparator.comparingInt(Employee::getAge)).findFirst().get());

        System.out.println(employees.stream().filter(e -> e.getStatus().equals(Employee.Status.FREE)).findAny().get());

    }

    @Test
    public void test2(){
        System.out.println(employees.stream().max(Comparator.comparingInt(Employee::getAge)).get());
    }
}
