package com.example.hw1.xml;

import com.example.hw1.xml.Pet;
import org.springframework.beans.factory.annotation.Value;

public class Dog extends Pet {
    @Value("Dog")
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
