package com.db.bexlibrary.BexLibrary.controllers;

import com.db.bexlibrary.BexLibrary.entities.Book;
import com.db.bexlibrary.BexLibrary.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000", allowedHeaders = "*")
//@Secured()
public class BooksController {


    @Autowired
    public BookRepository bookRepo;


    @GetMapping(value = "/books")
    public List<Book> findBooks(){
        return bookRepo.findAll();
    }

    @GetMapping(value="/booksbyid/{id}")
    public Book findBookByTitle(@PathVariable("id") Long id){
        return bookRepo.findBookById(id);
    }


}
