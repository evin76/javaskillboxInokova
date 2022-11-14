package com.example.hw1.xml;

import com.example.hw1.xml.Pet;
import org.springframework.beans.factory.annotation.Value;

public class Cat extends Pet {
    @Value("Cat")
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
