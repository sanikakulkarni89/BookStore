package com.sanika.bookstore1.model;


import com.sanika.bookstore1.enums.BookState;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

//@Data
@Setter
@Getter
@Entity
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isbn;
    private String title;
    private String author;
    private String edition;
    private double price;
    @Enumerated(EnumType.STRING)
    private BookState state;


    public Book() {}

    public Book(String isbn, String title, String author, String edition, double price, BookState state ) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.price = price;
        this.state = state;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", edition='" + edition + '\'' +
                ", price=" + price +
                ", state=" + state +
                '}';
    }
}
