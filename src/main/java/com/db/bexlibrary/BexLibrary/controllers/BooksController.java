package com.db.bexlibrary.BexLibrary.controllers;

import com.db.bexlibrary.BexLibrary.entities.Book;
import com.db.bexlibrary.BexLibrary.entities.GlobalVariables;
import com.db.bexlibrary.BexLibrary.repositories.BookRepository;
import jdk.nashorn.internal.objects.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BooksController {


    @Autowired
    public BookRepository bookRepo;


    @GetMapping(value = "/books")
    public List<Book> findBooks() {
        return bookRepo.findAll();
    }

    @GetMapping(value = "/isLoggedIn")
    public Boolean isLoggedIn() {
        return GlobalVariables.getInstance().getEmail().isEmpty();
    }

    @GetMapping(value = "/booksbyid/{id}")
    public Book findBookById(@PathVariable("id") Long id) {
        return bookRepo.findBookById(id);
    }



}
