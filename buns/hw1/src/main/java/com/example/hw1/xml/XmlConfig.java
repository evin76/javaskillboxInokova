package com.example.hw1.xml;

import com.example.hw1.xml.Animal;
import com.example.hw1.xml.Pet;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//для проверки xml-конфигураций необходимо запустить этот файл
public class XmlConfig {
    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Pet pet = context.getBean("myPet", Pet.class);
        System.out.println(pet.getType());
        pet.say();

        Animal animal = context.getBean("animal", Animal.class);
        System.out.println(animal.getType());
        animal.say();

        context.close();
    }
}
