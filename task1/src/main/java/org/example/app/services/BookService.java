package org.example.app.services;

import org.apache.log4j.Logger;
import org.example.web.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final ProjectRepository<Book> bookRepo;

    @Autowired
    public BookService(BookRepository<Book> bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBooks() {
        return bookRepo.retreiveAll();
    }

    public void saveBook(Book book) {
        if (book.getAuthor().isEmpty() && book.getTitle().isEmpty()
                && book.getSize().isEmpty()) {
            return;
        }
        bookRepo.store(book);
    }

    public boolean removeBook(Integer bookIdToRemove, String bookAuthorToRemove, String bookTitleToRemove,
                              String bookSizeToRemove) {
        return bookRepo.removeItem(bookIdToRemove, bookAuthorToRemove, bookTitleToRemove, bookSizeToRemove);
    }
}
