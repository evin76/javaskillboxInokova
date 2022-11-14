package com.example.hw2;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component("unilib")
public class UniLibrary implements Library {
    UniLibrary(){}

    public void getBook(Book book){
        System.out.println("get book from university library - " + book.getName());
    }

    public String returnBook(Book book) throws Exception {
        Random rand = new Random();
        int upperbound = 25;
        int int_random = rand.nextInt(upperbound);
        if (int_random % 2 != 0) {
            throw new Exception();
        }
        System.out.println("book was returned to university library");
        return book.getName();
    }

    public void addBook(Book book, String person){
        System.out.println("Book was added to university library");
    }
}
