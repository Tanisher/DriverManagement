package com.logistics.payload;

import com.logistics.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtResponse {
    private String token;
    private User.UserRole role;
    private String username;

    public JwtResponse(String token, User.UserRole role, String username) {
        this.token = token;
        this.role = role;
        this.username = username;
    }


}