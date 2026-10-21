package org.example.settedi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(App2Config.class);

        Employee emp = ctx.getBean(Employee.class);
        emp.displayAddress();
    }
}