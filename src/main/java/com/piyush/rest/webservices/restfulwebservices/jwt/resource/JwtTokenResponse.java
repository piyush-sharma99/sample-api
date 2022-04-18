package com.piyush.rest.webservices.restfulwebservices.jwt.resource;

import java.io.Serializable;
//This class deals with returning a token

public class JwtTokenResponse implements Serializable {

  private static final long serialVersionUID = 8317676219297719109L;

  private final String token;

    public JwtTokenResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}