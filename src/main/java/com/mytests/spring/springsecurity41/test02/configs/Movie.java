package com.mytests.spring.springsecurity41.test02.configs;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 6/17/2016.
 * Project: test01
 * *******************************
 */
public class Movie {
    String name;

    public Movie(String name, Cathegory cathegory) {
        this.name = name;
        this.cathegory = cathegory;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cathegory getCathegory() {
        return cathegory;
    }

    public void setCathegory(Cathegory cathegory) {
        this.cathegory = cathegory;
    }

    Cathegory cathegory;
}
