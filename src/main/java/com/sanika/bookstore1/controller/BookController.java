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
        if (bookServiceImpl.buyBook(id)) {
            return "Success! Book bought.";
        }
        return "Failure! Book not found.";
    }

    @PostMapping("/sell{id}")
    public String sellBook(@PathVariable Long id){
        double price = bookServiceImpl.sellBook(id);
        if(price < 10){
            return "Failure! Exhausted Selling attempts";
        }else{
            return "Success! Book bought. Price is " + price;
        }
    }

    @PostMapping("/sellNew/{isbn}")
    public String sellNewBook(@PathVariable String isbn) {
       double price =  bookServiceImpl.sellNewBook(isbn);
        return "Success! Book added to inventory. Price of the book now is:" + price;
    }
}
