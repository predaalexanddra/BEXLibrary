package com.db.bexlibrary.BexLibrary.entities;

public class LoanPOJO {

    private int bookId;
    private String bookTitle;
    private int bookPeriod;


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getBookPeriod() {
        return bookPeriod;
    }

    public void setBookPeriod(int bookPeriod) {
        this.bookPeriod = bookPeriod;
    }
}
