package org.example.app.services;


import java.util.List;

public interface ProjectRepository<T> {
    List<T> retreiveAll();

    void store(T book);

    boolean removeItem(String bookIdToRemove, String bookAuthorToRemove, String bookTitleToRemove,
                       String bookSizeToRemove);

    void removeAll(List<T> books);

}
