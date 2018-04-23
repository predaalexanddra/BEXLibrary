package com.db.bexlibrary.BexLibrary.entities;

public class LoanPOJO {

    private Long bookId;
    private String bookTitle;
    private int bookPeriod;
    private String userEmail;


    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
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

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
