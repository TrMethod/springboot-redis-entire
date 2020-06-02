package com.cyzs.springbootredisentire.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 测试分布式session
 * @Author xh
 * @create 2019-10-24 11:02
 */
@RestController
public class SessionTestController {

    @GetMapping("/session")
    public Map setSession(HttpServletRequest request){
        String id = request.getSession().getId();
        HashMap<String, String> map = new HashMap<>();
        request.getSession().setAttribute("user","123456");
        map.put("sessionid",id);
        return map;
    }

    @RequestMapping("/get")
    public Map get(HttpServletRequest request){
        String id = request.getSession().getId();
        HashMap<String, String> map = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            String value = cookie.getValue();
            map.put(name,value);
        }
        map.put("sessionid",id);
        String  user = (String) request.getSession().getAttribute("user");
        map.put("user",user);
        return map;
    }

}
