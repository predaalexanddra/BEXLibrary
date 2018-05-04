package com.db.bexlibrary.BexLibrary.service;

import com.db.bexlibrary.BexLibrary.entities.Author;
import com.db.bexlibrary.BexLibrary.entities.Book;
import com.db.bexlibrary.BexLibrary.repositories.AuthorRepo;
import com.db.bexlibrary.BexLibrary.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepo authorRepo;

    public List<Book> findBooksByAuthorName(String name){

        List<Author> authors=new ArrayList<>();
        authors.addAll(authorRepo.findAuthorByAuthorNameContaining(name));
        List<Book> result=new ArrayList();
        for (Author a:authors
             ) {

            result.addAll(bookRepository.findBooksByAuthor(a));
        }
        return result;
    }

}
