package com.mytests.spring.springsecurity41.test02.configs;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 6/17/2016.
 * Project: test01
 * *******************************
 */
@Component
public class SecuredServiceImpl implements SecuredService {

    List<Book> books = new ArrayList<>();
    List<Movie> movies = new ArrayList<>();

    public SecuredServiceImpl() {
        books.add(new Book("b1","a1",Cathegory.CHILD));
        books.add(new Book("b2","a2",Cathegory.CHILD));
        books.add(new Book("b3","a3",Cathegory.ADULT));
        books.add(new Book("b4","a4",Cathegory.ADULT));
        books.add(new Book("b5","a5",Cathegory.FAMILY));
        books.add(new Book("b6","a7",Cathegory.PORNO));
        books.add(new Book("b7","a7",Cathegory.PORNO));
        movies.add(new Movie("m1", Cathegory.CHILD));
        movies.add(new Movie("m2", Cathegory.CHILD));
        movies.add(new Movie("m3", Cathegory.ADULT));
        movies.add(new Movie("m4", Cathegory.ADULT));
        movies.add(new Movie("m5", Cathegory.FAMILY));
        movies.add(new Movie("m6", Cathegory.PORNO));
        movies.add(new Movie("m7", Cathegory.PORNO));
        movies.add(new Movie("m8", Cathegory.PORNO));
    }

    @Override

    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movies;
    }

    @Override

    public List<Book> getChildAllowedBooks() {
        List<Book> childbooks = books.stream().filter(book -> (book.cathegory == Cathegory.CHILD) | (book.cathegory == Cathegory.FAMILY)).collect(Collectors.toList());
        return childbooks;
    }

    @Override
    public List<Movie> getChildAllowedMovies() {
        List<Movie> childMovies = movies.stream().filter(movie -> (movie.cathegory == Cathegory.CHILD) | (movie.cathegory == Cathegory.FAMILY)).collect(Collectors.toList());
        return childMovies;
    }

    @Override
    public List<Book> getPornBooks() {
        List<Book> pornBooks = books.stream().filter(book -> book.cathegory == Cathegory.PORNO).collect(Collectors.toList());
        return pornBooks;
    }

    @Override
    public List<Movie> getPornMovies() {
        List<Movie> pornMovies = movies.stream().filter(movie -> movie.cathegory == Cathegory.PORNO).collect(Collectors.toList());
        return pornMovies;
    }

    @Override
    public List<Book> getMyBooks(List<String> authors) {
        List<Book> books1 = new ArrayList<>();
        for (Iterator<Book> iterator = books.iterator(); iterator.hasNext(); ) {
            Book next = iterator.next();
            for (Iterator<String> authorsIterator = authors.iterator(); authorsIterator.hasNext(); ) {
                String s = authorsIterator.next();
                if(next.author.equals(s) ){books1.add(next);}
            }
        }
        return books1;
    }
}
