package com.db.bexlibrary.BexLibrary.service;

import com.db.bexlibrary.BexLibrary.entities.Book;
import com.db.bexlibrary.BexLibrary.entities.User;
import com.db.bexlibrary.BexLibrary.javamail.MailSender;
import com.db.bexlibrary.BexLibrary.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class BookDAO {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private MailSender mailSender;

public void sendConfirmationEmail(Book book, User user){
//    if(bookRepository.existingBooks().contains(book)){
//        mailSender.sendMail("bexlibrary18@gmail.com",user.getEmail(),"Confirmation email","Enjoy your reading");
//    }

}


}
