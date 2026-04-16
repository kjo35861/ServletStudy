package com.example.servletstudy.login;

import com.fasterxml.jackson.core.JsonParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/api/auth/signin")
public class AuthenticationController extends HttpServlet {

    private User loginUser = User.builder()
            .id(1)
            .userName("abcd")
            .userPassword("1234")
            .name("김준일")
            .build();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(loginUser);
        String json = JsonParserUtil.getJson(req);
        Map<String, Object> requestBody = JsonParserUtil.parse(json);
        System.out.println(requestBody);
        if (!loginUser.getUserName().equals(requestBody.get("username"))) {
            errorResponse(resp, "사용자 정보가 일치하지 않습니다.");
        }
    }

    private void errorResponse(HttpServletResponse resp, String message) throws IOException {
        resp.setStatus(403);
        resp.setContentType("application/json");
        Map<String, Object> responseMap = Map.of(
                "code", 403,
                "message", message
        );
        resp.getWriter().println(JsonParserUtil.stringify(responseMap));

    }

}
