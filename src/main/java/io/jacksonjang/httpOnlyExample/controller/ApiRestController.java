package io.jacksonjang.httpOnlyExample.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ApiRestController {

    @RequestMapping("/")
    public Map index(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap();

        Cookie noneHttpOnly = new Cookie("noneHttpOnly", "test");
        Cookie httpOnly = new Cookie("httpOnly", "test");
        httpOnly.setHttpOnly(true);
        response.addCookie(noneHttpOnly);
        response.addCookie(httpOnly);

        map.put("cookie", request.getCookies());

        return map;
    }
}
