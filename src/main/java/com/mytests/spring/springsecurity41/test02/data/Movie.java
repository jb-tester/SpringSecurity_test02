package com.mytests.spring.springsecurity41.test02.data;

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



    public Cathegory cathegory;
}
