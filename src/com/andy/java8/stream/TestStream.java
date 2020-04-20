package com.andy.java8.stream;

import com.andy.java8.lambda.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestStream {

    //创建Stream
    @Test
    public void test1(){
        //1.通过Collections中的stream() 或 parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        //2.通过Arrays中的stream()
        Employee[] employees = new Employee[10];
        Stream<Employee> stream1 = Arrays.stream(employees);

        //3.通过Stream类中的of()
        Stream<String> stream2 = Stream.of("aa", "bb", "cc");

        //4.创建无限流
        //迭代
        Stream<Integer> stream3 = Stream.iterate(0, x -> x + 2);

        //生成
        Stream.generate(() -> Math.random());

    }
}
