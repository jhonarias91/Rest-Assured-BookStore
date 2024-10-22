package com.bookstore.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class User {

    private String userID;

    @JsonProperty("userName") // This will be use for serialization
    @JsonAlias("username")    // This will be use for deserialization
    private String userName;
    private String password;

    private List<Book> books;

    public User() {
    }

    public User(String username, String password) {
        this.userName = username;
        this.password = password;
    }


    public User(String userID, String username, List<Book> books) {
        this.userID = userID;
        this.userName = username;
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

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", books=" + books +
                '}';
    }
}
