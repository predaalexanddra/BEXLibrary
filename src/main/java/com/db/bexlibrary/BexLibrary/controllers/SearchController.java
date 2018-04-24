package com.db.bexlibrary.BexLibrary.controllers;

import com.db.bexlibrary.BexLibrary.entities.Book;
import com.db.bexlibrary.BexLibrary.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class SearchController {

    @Autowired
    private BookRepository bookRepo;

    @GetMapping(value="/search")
    private List<Book> searchMethod(@RequestParam(name="title") String title){
        List<Book> results=new ArrayList<>();
        System.out.println(title);

        results.addAll( bookRepo.findBooksByAuthorLike(title));
        results.addAll(bookRepo.findBooksByTitleContaining(title));
        System.out.println(results);
        return results;


}

}
