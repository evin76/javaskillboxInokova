package com.example.hw1.javacode1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Cat extends Pet {
    @Value("Cat")
    private String type;
    public Cat(){
    }
    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void say() {
        System.out.println("Meow");
    }
}
