package com.andy.java8.stream;

import com.andy.java8.lambda.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestStream1 {
    List<Employee> employees = Arrays.asList(
            new Employee("c", 20, Employee.Status.BUSY),
            new Employee("a", 20, Employee.Status.FREE),
            new Employee("b", 35, Employee.Status.VACATION),
            new Employee("d", 15, Employee.Status.BUSY),
            new Employee("e", 40, Employee.Status.FREE));

    //filter
    @Test
    public void test1(){


        employees.stream()
                .filter(employee -> employee.getAge() > 30)
                .forEach(System.out::println);
    }

    //limit
    @Test
    public void test2(){
        List<Employee> employees = Arrays.asList(
                new Employee("c", 20, Employee.Status.BUSY),
                new Employee("a", 20, Employee.Status.FREE),
                new Employee("b", 35, Employee.Status.VACATION),
                new Employee("d", 15, Employee.Status.BUSY),
                new Employee("e", 40, Employee.Status.FREE));

        employees.stream()
                .limit(2)
                .forEach(System.out::println);
    }

    //skip
    @Test
    public void test3(){
        employees.stream()
                .skip(2)
                .forEach(System.out::println);
    }

    //distinct
    @Test
    public void test4(){
        Integer[] test = new Integer[]{1,1,2,2,3,4,5};

        Arrays.stream(test)
                .distinct()
                .forEach(System.out::println);
    }

    //map
    @Test
    public void test5(){
        List<String> test = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");

        test.stream().map(str->str.toUpperCase()).forEach(System.out::println);

        employees.stream().map(Employee::getName).forEach(System.out::println);
    }

}
