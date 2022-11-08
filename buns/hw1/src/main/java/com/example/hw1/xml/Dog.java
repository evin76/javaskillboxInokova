package com.example.hw1.xml;

import com.example.hw1.xml.Pet;

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
