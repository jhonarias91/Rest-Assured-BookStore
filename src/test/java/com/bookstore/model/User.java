package com.bookstore.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class User {

    private String userID;
    @JsonProperty("username")
    private String userName;
    private String password;

    private List<Book> books;

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }


    public User(String userID, String userName, List<Book> books) {
        this.userID = userID;
        this.userName = userName;
        this.books = books;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}
