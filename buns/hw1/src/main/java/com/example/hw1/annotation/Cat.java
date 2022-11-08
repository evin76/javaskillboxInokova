package com.example.hw1.annotation;

import org.springframework.stereotype.Component;

@Component("cat")
public class Cat extends com.example.hw1.annotation.Pet {
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
