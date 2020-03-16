package com.andy.annotation;

import org.junit.Test;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

@MyAnnotation(value = "abc")
@MyAnnotation(value = "hi")
class Person{
    public Person() {
    }
}

class Generic<@MyAnnotation T>{

    public void show(){
        List<@MyAnnotation  String> test = new ArrayList<>();
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
