package com.example.hw1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//для проверки xml-конфигураций необходимо запустить файл XmlConfig
//для проверки аннотаций необходимо запустить файл AnnotationConfig
//для проверки Java Code 1 файл - JavaCodeConfig1
//для проверки Java Code 2 файл - JavaCodeConfig2
@SpringBootApplication
public class Hw1Application {

    public static void main(String[] args) {
        SpringApplication.run(Hw1Application.class, args);
    }

}
