package com.db.bexlibrary.BexLibrary.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

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
}
