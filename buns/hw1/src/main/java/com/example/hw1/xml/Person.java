package com.example.hw1.xml;

import com.example.hw1.xml.Animal;

public class Person implements Animal {
    private String type;
    public Person(){
        this.type = "Human";
    }
    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void say() {
        System.out.println("Hi");
    }
}
