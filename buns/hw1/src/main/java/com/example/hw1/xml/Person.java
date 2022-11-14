package com.example.hw1.xml;

import com.example.hw1.xml.Animal;
import org.springframework.beans.factory.annotation.Value;

public class Person implements Animal {
    @Value("Human")
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
