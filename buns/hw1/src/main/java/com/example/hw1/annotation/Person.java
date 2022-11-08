package com.example.hw1.annotation;

import com.example.hw1.annotation.Animal;
import com.example.hw1.annotation.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component("person")
public class Person implements Animal {
    private String type;
    private Pet pet;
    public Person(){
        this.type = "Human";
        System.out.println("Person bean is created");
    }
    @Autowired
    public Person(@Qualifier("dog") Pet pet) {
        System.out.println("Person bean is created");
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
