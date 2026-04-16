package com.example.servletstudy.login;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private int id;
    private String userName;
    private String userPassword;
    private String name;
}
