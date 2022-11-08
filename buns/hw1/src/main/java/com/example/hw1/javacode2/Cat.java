package com.example.hw1.javacode2;

import com.example.hw1.javacode2.Pet;
import org.springframework.stereotype.Component;

public class Cat extends Pet {
    private String type = "Cat";
    public Cat(){
        System.out.println("Cat bean was created");
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
