package com.db.bexlibrary.BexLibrary.controllers;

import com.db.bexlibrary.BexLibrary.entities.Book;
import com.db.bexlibrary.BexLibrary.entities.Loan;
import com.db.bexlibrary.BexLibrary.entities.LoanPOJO;
import com.db.bexlibrary.BexLibrary.repositories.BookRepository;
import com.db.bexlibrary.BexLibrary.repositories.LoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
public class LoanController {

    @Autowired
    LoanRepo loanRepo;
    @Autowired
    BookRepository bookRepo;

  //  @RequestMapping(value = "/loans", method = RequestMethod.POST)
//    public List<Loan> borrowMethod(@RequestBody LoanPOJO input) {
//
//        Loan loan = new Loan();
//
//        Book book = bookRepo.findBookById(input.getBookId());
//        int period = input.getBookPeriod();
//        Timestamp currDate = Timestamp.valueOf(LocalDateTime.now());
//        //loan.setBorrowDate(currDate);
//        return
//    }

}
