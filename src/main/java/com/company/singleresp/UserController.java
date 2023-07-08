package com.company.singleresp;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.ObjectMapper;

//Handles incoming JSON requests that work on User
public class UserController {

    private UserValidator validator = new UserValidator();
    private UserPersistenceService userPersistenceService = new UserPersistenceService();
    
    //Create a new user
    public String createUser(String userJson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(userJson, User.class);

        boolean valid = validator.validateUser(user);
        if(!valid) {
            return "ERROR";
        }

        userPersistenceService.saveUser(user);
        
        return "SUCCESS";
    }
}