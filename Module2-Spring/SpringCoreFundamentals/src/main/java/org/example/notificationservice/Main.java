package org.example.notificationservice;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);
        Student student = ctx.getBean(Student.class);
        Student student1 = ctx.getBean(Student.class);
        System.out.println(student.hashCode());
        System.out.println(student1.hashCode());
       student.notifyStudent();
       ctx.close();
    }
}