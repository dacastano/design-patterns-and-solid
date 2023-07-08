package com.company.singleresp;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.ObjectMapper;

//Handles incoming JSON requests that work on User
public class UserController {

    private UserValidator validator = new UserValidator();
    private UserPersistenceService userPersistenceService = new UserPersistenceService();
    private UserMapper userMapper = new UserMapper();

    //Create a new user
    public String createUser(String userJson) throws IOException {
        User user = userMapper.mapUserFromJson(userJson);

        //boolean valid = validator.validateUser(user);
        if(!validator.validateUser(user)) {
            return "ERROR";
        }

        userPersistenceService.saveUser(user);
        
        return "SUCCESS";
    }
}