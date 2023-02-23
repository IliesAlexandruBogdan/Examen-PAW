package com.example.demo.repository;

import com.example.demo.modal.Books;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BooksRepo extends CrudRepository<Books, Long> {
    List<Books> findAll();
    Optional<Books> findById(Long id);

}
