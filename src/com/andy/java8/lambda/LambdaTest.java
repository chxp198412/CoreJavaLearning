package com.andy.java8.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LambdaTest {

    @Test
    public void test1(){

        //匿名内部类写法
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        TreeSet<Integer> ts = new TreeSet<>(comparator);

        //lambda写法
        Comparator<Integer> comparator1 = (x,y) -> Integer.compare(x,y);

        TreeSet<Integer> ts1 = new TreeSet<>(comparator1);

    }

    @Test
    public void test2(){
        List<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(5);
        test.add(8);
        test.add(23);
        test.add(10);
        test.add(6);

        test.stream().filter(i -> i>5)
                .sorted()
                .limit(2)
                .forEach(System.out::println);

    }

}
