package com.msita.training.entity;

/**
 * Created by thanhtran on 5/12/2018.
 */
public class User {
    private String username;
    private String password;
    private String fullName;

    public String getFullname() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
