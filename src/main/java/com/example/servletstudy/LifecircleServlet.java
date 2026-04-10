package com.example.servletstudy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/lifecircle")

public class LifecircleServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("객체 생성 및 초기화");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("서비스 실행");
    }

    @Override
    public void destroy() {
        System.out.println("객체 소멸");
    }
}
