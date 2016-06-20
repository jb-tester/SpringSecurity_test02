package com.mytests.spring.springsecurity41.test02.configs;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 6/17/2016.
 * Project: test01
 * *******************************
 */
public class Book {
    String name;
    String author;
    Cathegory cathegory;

    public Book(String name, String author, Cathegory cathegory) {
        this.name = name;
        this.author = author;
        this.cathegory = cathegory;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Cathegory getCathegory() {
        return cathegory;
    }

    public void setCathegory(Cathegory cathegory) {
        this.cathegory = cathegory;
    }
}
