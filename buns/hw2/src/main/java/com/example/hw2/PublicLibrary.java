package com.example.hw2;

import com.example.hw2.Library;
import org.springframework.stereotype.Component;

@Component("publib")
public class PublicLibrary implements Library {

    public void getBook(){
        System.out.println("get book from public library");
    }
}
