package com.example.JWT.JWT.Model;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {

    private String JWT;

    public AuthenticationResponse(String JWT) {
        this.JWT = JWT;
    }

    public String getJWT() {
        return JWT;
    }

    public void setJWT(String JWT) {
        this.JWT = JWT;
    }
}
