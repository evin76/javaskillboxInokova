package com.example.hw1.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//для проверки аннотаций необходимо запустить этот файл
public class AnnotationConfig {
    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");

        Dog dog = context.getBean("dog", Dog.class);
        dog.say();

        Person person = context.getBean("person", Person.class);
        person.getType();
        person.setPet(dog);
        System.out.println(person.getPet());

        context.close();
    }
}
