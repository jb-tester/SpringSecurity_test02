package com.mytests.spring.springsecurity41.test02.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 6/23/2016.
 * Project: test02
 * *******************************
 */
@Component
public class RefBean
{
    @Value("#{true}")
    boolean refFlag;
    @Value("#{'foo'}")
    String refStr;
    @Value("#{100}")
    int refInt;

    public static boolean REFCONST = true;

    public boolean isRefFlag() {
        return refFlag;
    }

    public String getRefStr() {
        return refStr;
    }

    public int getRefInt() {
        return refInt;
    }


}
