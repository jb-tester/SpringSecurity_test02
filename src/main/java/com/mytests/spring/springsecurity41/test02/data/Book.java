package com.mytests.spring.springsecurity41.test02.data;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 6/17/2016.
 * Project: test01
 * *******************************
 */
public class Book {
    String name;
    public String author;
    public Cathegory cathegory;

    public Book(String name, String author, Cathegory cathegory) {
        this.name = name;
        this.author = author;
        this.cathegory = cathegory;
    }

    public String getName() {

        return name;
    }

    public String getAuthor() {
        return author;
    }

}
