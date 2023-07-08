package com.company.singleresp;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class UserMapper {

    private ObjectMapper mapper = new ObjectMapper();

    public User mapUserFromJson(String userJson) throws IOException {
        return mapper.readValue(userJson, User.class);
    }
}
