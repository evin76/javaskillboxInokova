package com.example.hw1.javacode2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//запустите этот файл для проверки конфигурации Java Code 2
public class JavaCodeConfig2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(MyConfig.class);
        Pet cat = context.getBean("catBean", Pet.class);
        cat.say();

        Person person = context.getBean("personBean", Person.class);
        System.out.println(person.getPet());

        context.close();
    }
}
