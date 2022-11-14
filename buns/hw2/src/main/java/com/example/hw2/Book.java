package com.example.hw2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {
    @Value("Une vie")
    private String name;

    @Value("Guy de Maupassant")
    private String author;

    @Value("1883")
    private String publishingYear;

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishingYear() {
        return publishingYear;
    }
}
