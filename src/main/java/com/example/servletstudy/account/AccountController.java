package com.example.servletstudy.account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@WebServlet("/api/accounts")
public class AccountController extends HttpServlet {

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("PUT요청 들어옴");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("DEL 요청 들어옴");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET 요청 들어옴");
        String p1 = req.getParameter("age");
        String p2 = req.getParameter("address");
        String p3 = req.getParameter("year");
        String[] p4 = req.getParameterValues("ages");
        Map<String, String[]> p5 = req.getParameterMap();
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(Arrays.toString(p4));
        System.out.println(p5.entrySet());
        System.out.println(p5.entrySet().stream()
                .map(entry -> Map.of(entry.getKey(), Arrays.asList(entry.getValue())))
                .toList());
        System.out.println(p5.keySet());
        String[] p5Values = p5.get("year");
        String p5Value = p5.get("year")[0];


        req.setAttribute("name", "김준일");

        // account.jsp 파일에 포워드 해줄 수 있음
        req.getRequestDispatcher("/account.jsp").forward(req, resp);

        String hostHeader = req.getHeader("Host");
        System.out.println(hostHeader);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        System.out.println("요청들어옴!!!!!");
        BufferedReader bufferedReader = req.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        System.out.println(stringBuilder);
    }
}
