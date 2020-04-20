package com.andy.java8.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaPractice {

    @Test
    public void testSort() {
        List<Employee> employees = Arrays.asList(
                new Employee("c", 20, Employee.Status.BUSY),
                new Employee("a", 20, Employee.Status.FREE),
                new Employee("b", 35, Employee.Status.VACATION),
                new Employee("d", 15, Employee.Status.BUSY),
                new Employee("e", 40, Employee.Status.FREE));

        Collections.sort(employees, (o1, o2) -> {
            if (o1.getAge() == o2.getAge()) {
                return o1.getName().compareTo(o2.getName());
            } else {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void testMyStringFun(){
        String test = "abc";
        String result = stringOperation(test, str-> str.trim().toUpperCase());
        System.out.println(result);

        test= "abcdefg";
        result = stringOperation(test, str -> str.substring(2,5));
        System.out.println(result);
    }

    @Test
    public void test(){
        op(100L, 200L, (x,y) -> x + y);
        op(100L, 200L, (x,y) -> x * y);
    }

    private String stringOperation(String s, MyStringFun mf){
        return mf.getValue(s);
    }

    public void op(Long l1, Long l2, MyFun2<Long, Long> myFun2){
        System.out.println(myFun2.getValue(l1, l2));
    }

}
