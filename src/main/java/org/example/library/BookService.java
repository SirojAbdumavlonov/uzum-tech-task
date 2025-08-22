package org.example.library;

import java.util.*;

public class BookService {
    private Map<UUID, Book> books = new HashMap<UUID, Book>();

    public void addBook(Book book) {
        book.setId(UUID.randomUUID());
        books.put(book.getId(), book);
    }

    public Book getBook(UUID id) {
        return books.get(id);
    }

    public List<Book> getBooks() {
        return new ArrayList<Book>(books.values());
    }
    public void removeBook(UUID id) {
        books.remove(id);
    }
}
