package org.example.fielddi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.classfile.Annotation;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        Employee emp = ctx.getBean(Employee.class);
        String result = emp.displayAddress();
        System.out.println(result);
    }
}
