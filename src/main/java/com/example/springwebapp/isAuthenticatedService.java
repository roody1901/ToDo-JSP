package com.example.springwebapp;

import org.springframework.stereotype.Service;

@Service
public class isAuthenticatedService {
    public boolean isAuthenticated (String UserId, String Pass){
        boolean isValidUser= UserId.equalsIgnoreCase("roody");
        boolean isValidPass= Pass.equalsIgnoreCase("123");

        return isValidUser && isValidPass;
    }
}
