package com.example.hw1.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Dog extends com.example.hw1.annotation.Pet {
    @Value("Dog")
    private String type;
    public Dog(){
    }
    @Override
    public String getType() {
        return this.type;
    }
    @Override
    public void say() {
        System.out.println("Woof");
    }
}
