package com.example.servletstudy.login;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Data
@AllArgsConstructor
@Builder
public class ResponseEntity<T> {
    private int status;
    private T body;

    public void response(ServletResponse response) throws IOException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setStatus(status);
        httpResponse.setContentType("application/json");
        httpResponse.getWriter().println(JsonParserUtil.stringify(this));

    }
}
