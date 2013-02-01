package com.in6k.employees;

public class User {
    private String name;
    private String surName;
    private String email;
    private String pass;
    private String birhdate;

    public User(String name, String surName, String email, String pass, String birhdate) {
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.pass = pass;
        this.birhdate = birhdate;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getBirhdate() {
        return birhdate;
    }

    public void setBirhdate(String birhdate) {
        this.birhdate = birhdate;
    }
}
