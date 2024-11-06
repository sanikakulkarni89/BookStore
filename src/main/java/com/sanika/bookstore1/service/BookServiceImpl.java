package com.sanika.bookstore1.service;

import com.sanika.bookstore1.enums.BookState;
import com.sanika.bookstore1.model.Book;
import com.sanika.bookstore1.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
    @Autowired
    private BookRepository bookRepository;

//    @Autowired
//    public BookService(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Transactional
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Transactional
    public boolean buyBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            optionalBook.get().setState(BookState.SOLD);
            saveBook(optionalBook.get());
            return true;

        }else {
            return false;
        }
    }

    @Transactional
    public double sellBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent() && optionalBook.get().getState() == BookState.SOLD) {
            Book book = optionalBook.get();
            book.setState(BookState.AVAILABLE);
            double newPrice = book.getPrice() * 0.9;
            book.setPrice(newPrice);
            saveBook(book);
            return newPrice;
        }else{
            return -1;
        }
    }

    @Transactional
    public double sellNewBook(String isbn) {
        Book book = bookRepository.findFirstByIsbn(isbn);
        logger.debug(book.getTitle() != null ? book.getTitle() : "null");
        bookRepository.save(new Book(book.getIsbn(), book.getTitle(),book.getAuthor(), book.getEdition(), book.getPrice(), book.getState()));
        return book.getPrice();
    }
}
