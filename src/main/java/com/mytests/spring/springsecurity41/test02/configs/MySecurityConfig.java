package com.mytests.spring.springsecurity41.test02.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 4/27/2016.
 * Project: test01
 * *******************************
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    public void configureGlobal(
            AuthenticationManagerBuilder auth) throws Exception {
                auth
                .inMemoryAuthentication()
                .withUser("irina").password("jolt").roles("PARENT","ADMIN").and()
                .withUser("vera").password("1001").roles("CHILD", "VALID").and()
                .withUser("andrey").password("foo").roles("PARENT").and()
                .withUser("kate").password("bar").roles("CHILD");
    }

    @Override
    protected void configure(
            HttpSecurity http) throws Exception {
                http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()

                .and()
                .sessionManagement()
                .maximumSessions(1)
                .expiredUrl("/login?expired")
                ;
    }


}
