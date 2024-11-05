package com.sanika.bookstore1.model;

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
    // Getters and Setters

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isbn;
    private String title;
    private String author;
    private String edition;
    private double price;

    // Constructors
    public Book() {}

    public Book(String isbn, String title, String author, String edition, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.price = price;
    }

    // Additional Getters and Setters for other fields here...

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", edition='" + edition + '\'' +
                ", price=" + price +
                '}';
    }
}
