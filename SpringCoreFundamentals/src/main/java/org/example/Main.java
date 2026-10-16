package org.example;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Employee emp1 = ctx.getBean(Employee.class);
        Employee emp2 = ctx.getBean(Employee.class); // singleton
        System.out.println(emp1.equals(emp2)); // same
        System.out.println(emp1.hashCode() + "   " + emp2.hashCode());

        emp1.display();

    }
}