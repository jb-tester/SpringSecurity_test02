package com.mytests.spring.springsecurity41.test02.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 6/17/2016.
 * Project: test01
 * *******************************
 */
@Controller
public class LibController {

    @Autowired
    private SecuredService securedService;

    @PreAuthorize("hasAnyRole('PARENT','ADMIN') and (#pr.name == 'irina')")
    @RequestMapping("/entertainment/parent")
    public String entertainmentParent(ModelMap model, @P("pr")Principal my_principal) {
        model.addAttribute("entertainment_attr1", "entertainment_attr1");
        model.addAttribute("allBooks", securedService.getAllBooks());
        model.addAttribute("principal_name", my_principal.getName());
        model.addAttribute("childBooks", securedService.getChildAllowedBooks());
        model.addAttribute("childMovies", securedService.getChildAllowedMovies());
        return "entertainment";
    }

    @PreAuthorize("isFullyAuthenticated()")
    @RequestMapping("/entertainment/fullyAuthenticated")
    public String entertainmentFullyAuthenticated(ModelMap model, Principal principal) {
        model.addAttribute("principal_name",principal.getName());
        model.addAttribute("entertainment_attr1", "entertainment_attr1");
        model.addAttribute("allChildMovies", securedService.getChildAllowedMovies());
        return "entertainment";
    }

    @Secured({"ROLE_CHILD","ROLE_PARENT"})
    @RequestMapping("/entertainment/child")
    public String entertainmentChild(ModelMap model, Principal principal) {
        model.addAttribute("entertainment_attr1", "entertainment_attr1");
        model.addAttribute("principal_name",principal.getName());
        model.addAttribute("childBooks", securedService.getChildAllowedBooks());
        model.addAttribute("childMovies", securedService.getChildAllowedMovies());
        return "entertainment";
    }

    @RequestMapping("/entertainment/prohibited")
    @PreAuthorize("authentication.name == 'irina' and principal.password != '' and permitAll()")
    public String entertainmentProhibited(ModelMap model) {
        model.addAttribute("entertainment_attr1", "entertainment_attr1");
        model.addAttribute("x_films", securedService.getPornMovies());
        model.addAttribute("x_books", securedService.getPornBooks());
        List<String> authors = new ArrayList<>();
        authors.add("a1");
        authors.add("a2");
        authors.add("a7");
        model.addAttribute("my_books", securedService.getMyBooks(authors));
        return "entertainment";
    }

}
