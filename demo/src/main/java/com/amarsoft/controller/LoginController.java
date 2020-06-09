package com.amarsoft.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/b")
public class LoginController {
    @RequestMapping("/login")
    public String login(@RequestBody Map<String, String> paraMap, HttpServletRequest request, HttpServletResponse response) {
        boolean res = false;
        if (paraMap != null && paraMap.size() > 0) {
            String username = paraMap.get("name");
            String password = paraMap.get("password");
            res = check(username, password);
        }
        return "登录" + (res ? "成功" : "失败");
    }

    private boolean check(String username, String password) {
        if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)) {
            if ("xiao".equals(username) && "qun".equals(password)) {
                return true;
            }
        }
        return false;
    }
}
