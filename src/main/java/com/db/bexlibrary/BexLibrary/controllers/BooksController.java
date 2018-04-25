package com.db.bexlibrary.BexLibrary.controllers;

import com.db.bexlibrary.BexLibrary.entities.Book;
import com.db.bexlibrary.BexLibrary.entities.GlobalVariables;
import com.db.bexlibrary.BexLibrary.repositories.BookRepository;
import jdk.nashorn.internal.objects.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class BooksController {


    @Autowired
    public BookRepository bookRepo;


    @GetMapping(value = "/books")
    public List<Book> findBooks() {
        return bookRepo.findAll();
    }

    @GetMapping(value = "/isLoggedIn")
    public ResponseEntity<Boolean> isLoggedIn() {
        return new ResponseEntity<Boolean>(GlobalVariables.getInstance().getEmail() != null && !GlobalVariables.getInstance().getEmail().isEmpty() , HttpStatus.OK );
    }

    @GetMapping(value = "/logOut")
    public ResponseEntity<Boolean> logOut() {
        GlobalVariables.getInstance().setEmail(null);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK );
    }


    @GetMapping(value = "/booksbyid/{id}")
    public Book findBookById(@PathVariable("id") Long id) {
        return bookRepo.findBookById(id);
    }



}
