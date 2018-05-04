package com.db.bexlibrary.BexLibrary.controllers;

import com.db.bexlibrary.BexLibrary.entities.Book;
import com.db.bexlibrary.BexLibrary.entities.GlobalVariables;
import com.db.bexlibrary.BexLibrary.repositories.BookRepository;
import com.db.bexlibrary.BexLibrary.service.BookService;
import jdk.nashorn.internal.objects.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class BooksController {


    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private BookService bookService;


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


    @GetMapping(value = "/booksbyauthor")
    public List<Book> findBookByAuthor(@RequestParam(name="name")String name) {
        return bookService.findBooksByAuthorName(name);
    }



}
