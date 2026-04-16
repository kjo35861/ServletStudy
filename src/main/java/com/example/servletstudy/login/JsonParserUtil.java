package com.example.servletstudy.login;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

public class JsonParserUtil {

    public static String getJson(HttpServletRequest request) throws IOException {
        BufferedReader bufferedReader = request.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        return  stringBuilder.toString();
    }

    public static Map<String, Object> parse(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        // Json을 객체로 변환
        return objectMapper.readValue(json, Map.class);

    }

    public static String stringify(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        // 객체를 Json 으로 변환
        return objectMapper.writeValueAsString(obj);
    }
}
