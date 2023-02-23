package com.example.demo.controller;


import com.example.demo.dto.BooksDTO;
import com.example.demo.modal.Books;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class BooksController {
    private static final Map<Long, BooksDTO> booksMap = new HashMap<>();
    final com.example.demo.repository.BooksRepo booksRepo;

    public BooksController(com.example.demo.repository.BooksRepo cartiRepo){
        this.booksRepo = cartiRepo;
    }
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ResponseEntity<Object> getBooks() {
        return new ResponseEntity<>(booksRepo.findAll().stream().map(o -> new BooksDTO(o.getId(),o.getTitlu(),o.getKeys(),
                o.getAutor(),o.getAn())), HttpStatus.OK);
    }
    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public ResponseEntity<Object> createBook(@RequestBody BooksDTO booksDTO){
        booksMap.put(booksDTO.getId(), booksDTO);
        Books books = new Books();
        books.setTitlu(booksDTO.getTitlu());
        books.setKeys(booksDTO.getKeys());
        books.setAutor(booksDTO.getAutor());
        books.setAn(booksDTO.getAn());
        booksRepo.save(books);
        return new ResponseEntity<>("Book Created", HttpStatus.OK);
    }
    @RequestMapping(value = "/books/{keys}", method = RequestMethod.GET)
    public ResponseEntity<Object> updateBooks(@PathVariable("keys") Long keys){
        return new ResponseEntity<>(booksRepo.findById(keys).map(o -> new BooksDTO(o.getId(),o.getTitlu(),o.getKeys(),o.getAutor()
                ,o.getAn())).orElse(null), HttpStatus.OK);
    }
}
