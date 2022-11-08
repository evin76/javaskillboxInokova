package com.example.hw1.javacode2;

import com.example.hw1.javacode2.Pet;
import org.springframework.stereotype.Component;

public class Dog extends Pet {
    private String type;
    public Dog(){
        this.type = "Dog";
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
