package com.andy.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD,
         ElementType.PARAMETER, ElementType.CONSTRUCTOR,
         ElementType.LOCAL_VARIABLE, ElementType.MODULE,
         ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@Repeatable(MyAnnotations.class)
public @interface MyAnnotation{
    String value() default "hello";
}
