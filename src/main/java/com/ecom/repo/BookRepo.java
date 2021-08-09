package com.ecom.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.Book;

public interface BookRepo extends JpaRepository<Book, Long> {

}
