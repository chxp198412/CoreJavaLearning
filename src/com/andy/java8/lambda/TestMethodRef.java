package com.andy.java8.lambda;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class TestMethodRef {

    @Test
    public void test1(){
        Consumer<String> con = System.out::println;
        con.accept("abc");
    }

    @Test
    public void test2(){
        Employee employee = new Employee("andy", 25, Employee.Status.BUSY);
        Supplier<String> supplier = employee::getName;
        System.out.println(supplier.get());
    }

    @Test
    public void test3(){


    }
}
