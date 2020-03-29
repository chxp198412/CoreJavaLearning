package com.andy.reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {

    @Test
    public void testPerson(){
        Person p = new Person("Tom", 12);
        System.out.println(p);
        p.show();
    }


    @Test
    public void testReflection() throws Exception {
        Class clazz = Person.class;

        Constructor constructor = clazz.getConstructor(String.class, int.class);
        Object obj = constructor.newInstance("Tom", 12);
        Person p  = (Person) obj;
        System.out.println(obj);

        Field age = clazz.getDeclaredField("age");
        age.setAccessible(true);
        age.set(p, 10);
        System.out.println(p);

        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);

        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p, "aaa");
        System.out.println(nation);
    }
}
