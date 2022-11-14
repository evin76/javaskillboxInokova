package com.example.hw1.javacode2;

import com.example.hw1.javacode2.Pet;
import org.springframework.beans.factory.annotation.Value;


public class Dog extends Pet {
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
