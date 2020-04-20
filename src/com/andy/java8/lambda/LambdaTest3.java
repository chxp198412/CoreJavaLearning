package com.andy.java8.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static java.lang.Math.random;

public class LambdaTest3 {



    //Predicate<T> interface test
    // 需求：将满足条件的数字，放入集合中
    @Test
    public void  test4(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
        List<Integer> result = filterInteger(list, num -> num%2 == 0);
        for(Integer num : result){
            System.out.println(num);
        }
    }


    public List<Integer> filterInteger(List<Integer> list, Predicate<Integer> pre){
        List<Integer> result = new ArrayList<>();

        for(Integer num : list){
            if(pre.test(num)){
                result.add(num);
            }
        }

        return result;
    }


    //Function<T,R> interface test
    @Test
    public void test3(){
        String result = stringHandler("abc", str -> str.toUpperCase());
        System.out.println(result);
    }

    public String stringHandler(String s, Function<String, String> fun){
        return fun.apply(s);
    }

    //Consumer<T> interface
    @Test
    public void test1(){
        learn(1000, x -> System.out.println("Learning..., consume : " + x + "dollars"));
    }

    public void learn(double money, Consumer<Double> con){
        con.accept(money);
    }


    //Supplier<T> interface
    //需求：产生指定个数的整数，并放入集合中
    @Test
    public void test2(){
       List<Integer> result = getNumList(10, () -> (int) (random()*100));
       for(Integer num : result){
           System.out.println(num);
       }
    }


    public List<Integer> getNumList(int num, Supplier<Integer> sup){
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < num; i++){
            Integer n = sup.get();
            result.add(n);
        }

        return result;
    }


}
