package com.sanika.bookstore1.service;

import com.sanika.bookstore1.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    boolean buyBook(Long id);
    double sellBook(Long id);
    double sellNewBook(String isbn);
}
