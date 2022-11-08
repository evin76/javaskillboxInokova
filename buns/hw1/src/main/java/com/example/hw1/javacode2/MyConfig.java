package com.example.hw1.javacode2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public Pet catBean() {
        return new Cat();
    }

    @Bean
    public Pet dogBean() {
        return new Dog();
    }

    @Bean
    public Person personBean() {
        return new Person(catBean());
    }
}
