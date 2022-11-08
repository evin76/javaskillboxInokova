package com.example.hw1.javacode1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//запустите этот файл для проверки конфигурации Java Code 1
public class JavaCodeConfig1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Person person = context.getBean("person", Person.class);
        System.out.println(person.getPet());

        context.close();
    }
}
