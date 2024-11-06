package com.sanika.bookstore1.repository;

import com.sanika.bookstore1.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByTitle(String title);
    Book findFirstByIsbn(String isbn);
}
