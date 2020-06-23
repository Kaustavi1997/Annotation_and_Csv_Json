package com.bridgelabz;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {
    String author() default "Kaustavi";

    String date();

    int revision() default 1;

    String comments();
}