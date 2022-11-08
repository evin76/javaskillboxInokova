package com.example.hw1.xml;

import com.example.hw1.xml.Pet;

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
