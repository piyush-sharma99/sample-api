package com.piyush.rest.webservices.restfulwebservices.jwt.resource;

import java.io.Serializable;

//This class handles the request for example what parameters we are looking for
public class  JwtTokenRequest implements Serializable {
  
  private static final long serialVersionUID = -5616176897013108345L;

  private String username;
    private String password;
    
    
//    {
//    	  "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJpbjI4bWludXRlcyIsImV4cCI6MTY1MDg4OTEwMSwiaWF0IjoxNjUwMjg0MzAxfQ.3Odzcw4zOQKDif8m0xUSuwQB3OFBqTLMeq-j5qVTkZOHvXpFCJi1oauqtzpwA850t9IRu7WtMqGDWSjgo762zw"
//    	}

    public JwtTokenRequest() {
        super();
    }

    public JwtTokenRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

