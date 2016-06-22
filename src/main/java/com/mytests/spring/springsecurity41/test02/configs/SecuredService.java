package com.mytests.spring.springsecurity41.test02.configs;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 6/17/2016.
 * Project: test01
 * *******************************
 */

public interface SecuredService {


    List<Book> getAllBooks();

    List<Movie> getAllMovies();

    List<Book> getChildAllowedBooks();

    List<Movie> getChildAllowedMovies();


    @PostAuthorize("returnObject.size() > 0")
    List<Book> getPornBooks();

    @PostFilter("filterObject.name == 'm7'")
    List<Movie> getPornMovies();

    @PreFilter(value = "filterObject == 'a7'", filterTarget = "authors")
    List<Book> getMyBooks(List<String> authors);
}
