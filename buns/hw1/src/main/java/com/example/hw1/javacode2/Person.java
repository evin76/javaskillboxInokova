package com.example.hw1.javacode2;

import com.example.hw1.javacode2.Animal;
import com.example.hw1.javacode2.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class Person implements Animal {
    private String type = "Human";
    private Pet pet;
    public Person(){
        System.out.println("Person bean was created");
    }

    public Person(Pet pet) {
        System.out.println("Person bean was created");
        this.pet = pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
        System.out.println("Pet for person was set");
    }

    public String getPet() {
        return "Pet type: " + this.pet.getType();
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
