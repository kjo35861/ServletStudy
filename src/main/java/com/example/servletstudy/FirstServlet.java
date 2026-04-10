package com.example.servletstudy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = "abcd";

        System.out.println(req.getRequestURL());
        System.out.println(req.getParameter("aaa"));

        resp.getWriter().println(username);
    }
}
