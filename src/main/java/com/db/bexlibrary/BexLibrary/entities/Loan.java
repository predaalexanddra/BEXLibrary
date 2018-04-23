package com.db.bexlibrary.BexLibrary.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Data
public class Loan {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id") private int id;

    @NotNull
    private Date borrowDate;
    @NotNull
    private Date returnDate;
    @NotNull
    private boolean isReturned = false;


    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "fk_loanUser")
    private User loanUser;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "fk_loanBook")
    private Book loanBook;


    public boolean isReturned() {
        return isReturned;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }

    public User getLoanUser() {
        return loanUser;
    }

    public void setLoanUser(User loanUser) {
        this.loanUser = loanUser;
    }

    public Book getLoanBook() {
        return loanBook;
    }

    public void setLoanBook(Book loanBook) {
        this.loanBook = loanBook;
    }
}
