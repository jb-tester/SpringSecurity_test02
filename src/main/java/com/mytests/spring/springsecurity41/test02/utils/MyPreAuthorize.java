package com.mytests.spring.springsecurity41.test02.utils;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.*;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 6/22/2016.
 * Project: test02
 * *******************************
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@PreAuthorize("(hasAnyAuthority('ROLE_PARENT','ROLE_CHILD') and @refBean.refInt>0 and T(com.mytests.spring.springsecurity41.test02.model.RefBean).REFCONST)")
public @interface MyPreAuthorize {
}
