package com.andy.reflection;

import org.junit.Test;

public class NewInstanceTest {

    @Test
    public void test1() throws IllegalAccessException, InstantiationException {
        Class clazz = Person.class;

        Object obj = clazz.newInstance();
        System.out.println(obj);

    }

}
