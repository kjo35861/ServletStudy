<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 26. 4. 16.
  Time: 오전 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String name = (String) request.getAttribute("name");
    String year = request.getParameter("year");
    if (year.equals("2026")) {
        response.sendRedirect("https://naver.com");
    } else if (year.equals("2025")) {
        response.sendRedirect("http://localhost:8080/servlet_study_war_exploded");
    } else if (year.equals("2024")) {
        response.sendRedirect("http://localhost:8080/servlet_study_war_exploded/lifecircle");
    }
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <%= name%>
</body>
</html>
