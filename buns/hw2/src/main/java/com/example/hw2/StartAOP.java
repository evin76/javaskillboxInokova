package com.example.hw2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//для того, чтобы не видеть в консоли логи какого-либо аспекта, закомментируйте аннотации @Component и @Aspect
//для проверки дз запустите этот файл
public class StartAOP {
    public static void main (String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        UniLibrary uniLibrary = context.getBean("unilib", UniLibrary.class);
        Book book = context.getBean("book", Book.class);
        //uniLibrary.getBook(book);
        //uniLibrary.addBook(book,"hi");
        System.out.println(uniLibrary.returnBook(book));

        //PublicLibrary publicLibrary = context.getBean("publib", PublicLibrary.class);
        //publicLibrary.getBook();

        context.close();
    }
}
