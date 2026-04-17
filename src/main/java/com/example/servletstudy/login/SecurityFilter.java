package com.example.servletstudy.login;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class SecurityFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpReq = (HttpServletRequest) servletRequest;

        String uri = httpReq.getRequestURI();
        String projectNameIgnoreUri = uri.substring(uri.indexOf("/", 1));

        if (projectNameIgnoreUri.startsWith("/api/auth")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        HttpSession session = httpReq.getSession();
        Object authAttribute = session.getAttribute("authentication");
        System.out.println(authAttribute);
        if (authAttribute == null) {            // authAttribute가 null 이면 로그인이 안 된 상태
            ResponseEntity.builder()
                    .status(403)
                    .body("로그인 후 이용가능합니다.")
                    .build()
                    .response(servletResponse);
            return;
        }


//        System.out.println("전처리");
        filterChain.doFilter(servletRequest, servletResponse);
//        System.out.println("후처리");
    }
}
