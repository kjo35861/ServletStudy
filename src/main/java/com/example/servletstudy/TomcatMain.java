package com.example.servletstudy;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Req {
    private String requestUrl;

}

class Resp {

}

class TestServlet {
    private static TestServlet instance;
    private TestServlet() {}
    public static TestServlet getInstance() {
        if (instance == null) instance = new TestServlet();
        return instance;
    }
    public void init() {
        System.out.println("초기화");
    }
    public void service(Req req, Resp resp) {
        System.out.println(req.getRequestUrl());
    }
    public void destroy() {
        System.out.println("소멸");
    }
}

public class TomcatMain {
    public static void main(String[] args) {
        String requestUrl = "http://localhost:8080/backserver/test";
        TestServlet testServlet = TestServlet.getInstance();
        testServlet.init();
        testServlet.service(new Req(requestUrl), new Resp());
        testServlet.service(new Req(requestUrl), new Resp());
        testServlet.service(new Req(requestUrl), new Resp());
        testServlet.destroy();

    }
}
