package com.andy.annotation;

import org.junit.Test;
import java.lang.annotation.Annotation;

@MyAnnotation(value = "abc")
class Person{
    public Person() {
    }
}

public class AnnotationTest {
    public static void main(String[] args) {

    }

    @Test
    public void testAnnotations(){
        Class<Person> clazz = Person.class;
        Annotation[] annotations = clazz.getAnnotations();
        for(int i = 0; i<annotations.length ; i++){
            System.out.println(annotations[i]);
        }
    }
}
