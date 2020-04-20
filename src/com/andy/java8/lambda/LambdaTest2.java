package com.andy.java8.lambda;

import org.junit.Test;

public class LambdaTest2 {

    @Test
    public void test1(){
        Runnable r = () -> System.out.println("Hello Lambda!");
        r.run();
    }

    @Test
    public void test2(){
        Integer num = operation(100, x -> x*x);
        System.out.println(num);
    }

    public Integer operation(Integer num, MyFun mf){
        return mf.getValue(num);
    }


}
