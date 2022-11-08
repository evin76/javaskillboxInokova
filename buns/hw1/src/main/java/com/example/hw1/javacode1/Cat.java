package com.example.hw1.javacode1;

import org.springframework.stereotype.Component;

@Component
public class Cat extends Pet {
    private String type;
    public Cat(){
        this.type = "Cat";
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
