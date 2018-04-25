package com.db.bexlibrary.BexLibrary.controllers;

import com.db.bexlibrary.BexLibrary.entities.*;
import com.db.bexlibrary.BexLibrary.javamail.MailSender;
import com.db.bexlibrary.BexLibrary.repositories.BookRepository;
import com.db.bexlibrary.BexLibrary.repositories.LoanRepo;
import com.db.bexlibrary.BexLibrary.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class LoanController {

    @Autowired
    LoanRepo loanRepo;
    @Autowired
    BookRepository bookRepo;
    @Autowired
    UserRepository userRepo;
    @Autowired
    MailSender mailSender;

    @RequestMapping(value = "/loans", method = RequestMethod.POST)
    @ResponseBody

    public Loan borrowMethod(@RequestBody LoanPOJO input) {

        Loan loan = new Loan();

        Book book = bookRepo.findBookById(input.getBookId());
        loan.setLoanBook(book);
        int period = input.getBookPeriod();

        Timestamp currDate = Timestamp.valueOf(LocalDateTime.now());
        loan.setBorrowDate(currDate);
        LocalDateTime plusWeek = LocalDateTime.now().plus(period, ChronoUnit.WEEKS);
        Timestamp retDate = Timestamp.valueOf(plusWeek);
        System.out.println(currDate + "--------" + retDate);
        loan.setReturnDate(retDate);

        User user = userRepo.findUserByEmail(GlobalVariables.getInstance().getEmail());
        loan.setLoanUser(user);

        loan.setReturned(false);


        if (book.getNoAvailableCopies() > 0) {
            String date=retDate.toString().substring(0,10);
            String confirmMail = "Your book (" + book.getTitle() + ") was successfully reserved. We are waiting for you at the BEX Library(1st floor) to pick it up.\n" +
                    "For more information you can contact Admin at admin@gmail.com.\n" +
                    "Please return the book until " + date + "\n" +
                    "Thank you for using BEX Library app.";

            loanRepo.save(loan);
            mailSender.sendMail("bexlibrary18@gmail.com", user.getEmail(), "Confirmation email", confirmMail);
            bookRepo.updateBook(book.getId());

        }

        return loan;
    }

}
