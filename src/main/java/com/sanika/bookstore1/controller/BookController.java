package com.sanika.bookstore1.controller;

import com.sanika.bookstore1.model.Book;
import com.sanika.bookstore1.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookServiceImpl bookServiceImpl;

//    @Autowired
//    public BookController(BookService bookService) {
//        this.bookService = bookService;
//    }

    @GetMapping("/inventory")
    public List<Book> getInventory() {
        return bookServiceImpl.getAllBooks();
    }

    @PostMapping("/buy/{id}")
    public String buyBook(@PathVariable Long id) {
        Optional<Book> book = bookServiceImpl.getBookById(id);
        if (book.isPresent()) {
            bookServiceImpl.deleteBook(id);
            return "Success! Book bought.";
        }
        return "Failure! Book not found.";
    }

    @PostMapping("/sell")
    public String sellBook(@RequestBody Book book) {
        bookServiceImpl.saveBook(book);
        return "Success! Book added to inventory.";
    }
}
