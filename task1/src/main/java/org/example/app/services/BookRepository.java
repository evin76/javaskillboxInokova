package org.example.app.services;

import org.apache.log4j.Logger;
import org.example.web.dto.Book;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class BookRepository<T> implements ProjectRepository<Book>, ApplicationContextAware {

    private final Logger logger = Logger.getLogger(BookRepository.class);
    private List<Book> repo = new ArrayList<>();
    private ApplicationContext context;

    @Override
    public List<Book> retreiveAll() {
        return new ArrayList<>(repo);
    }

    @Override
    public void store(Book book) {
        book.setId(String.valueOf(book.hashCode()));
        logger.info("store new book: " + book);
        repo.add(book);
    }

    @Override
    public boolean removeItem(String bookIdToRemove, String bookAuthorToRemove, String bookTitleToRemove,
                              String bookSizeToRemove) {
        boolean wasAtLeastOneDelete = false;
        String bookId = bookIdToRemove;
        String bookAuthor = bookAuthorToRemove;
        String bookTitle = bookTitleToRemove;
        String bookSize = bookSizeToRemove;
        if (String.valueOf(bookId).isEmpty() && bookAuthor.isEmpty()
                && bookTitle.isEmpty() && bookSize.isEmpty())
            return wasAtLeastOneDelete;
        for (Book book : retreiveAll()) {
            if (String.valueOf(bookId).isEmpty())
                bookId = book.getId();
            if (bookAuthor.isEmpty())
                bookAuthor = book.getAuthor();
            if (bookTitle.isEmpty())
                bookTitle = book.getTitle();
            if (bookSize.isEmpty())
                bookSize = book.getSize();
            if (book.getId().equals(bookId) && book.getAuthor().equals(bookAuthor)
            && book.getSize().equals(bookSize) && book.getTitle().equals(bookTitle)) {
                logger.info("remove book completed: " + book);
                repo.remove(book);
                removeItem(bookIdToRemove, bookAuthorToRemove, bookTitleToRemove, bookSizeToRemove);
                wasAtLeastOneDelete = true;
            }
        }
        return wasAtLeastOneDelete;
    }

    @Override
    public void removeAll(List<Book> books) {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    private void defaultInit() {
        logger.info("default INIT in book repo bean");
    }

    private void defaultDestroy() {
        logger.info("default DESTROY in book repo bean");
    }

}

