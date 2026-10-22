package org.example.settedi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class App2Config {

    @Bean
    public Address address() {
        return new Address();
    }

    @Bean
    public Employee emp(Address address) {
        Employee emp1 = new Employee();
        emp1.setAddress(address); // setter injection
        return emp1;
    }
}