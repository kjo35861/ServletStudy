package com.example.servletstudy.login;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletContext;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> users;

    public UserRepository(ServletContext context) {
        String realPath = context.getRealPath("/WEB-INF/users.json");
        try(FileReader fileReader = new FileReader(realPath)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            ObjectMapper objectMapper = new ObjectMapper();
            users = objectMapper.readValue(stringBuilder.toString(), List.class);
//            System.out.println(users);

        } catch (IOException e) {

        }
    }

    public User save() {
        return null;
    }

    public User findId(int id) {
        return null;
    }

    public User findByUsername(String username) {
        return null;
    }

    public List<User> findByAll() {
        return List.of();
    }


}
