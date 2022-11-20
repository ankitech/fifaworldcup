package com.nuance.quiz.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;

public class CommonUtils {

    private CommonUtils() {
    }

    public static User getContext() {

        com.nuance.quiz.entity.User principal = (com.nuance.quiz.entity.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return new User(String.valueOf(principal.getUserId()), principal.getPassword(), Collections.emptyList());
    }
}
