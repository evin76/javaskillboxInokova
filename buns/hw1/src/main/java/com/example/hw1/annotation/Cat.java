package com.example.hw1.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("cat")
public class Cat extends com.example.hw1.annotation.Pet {
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
