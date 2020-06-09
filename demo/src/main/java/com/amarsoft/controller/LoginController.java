package com.amarsoft.controller;

import com.amarsoft.Service.UserService;
import com.amarsoft.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder encoder;

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
        if (!StringUtils.isEmpty(username)) {
            User user = userService.findByName(username);
            if (user != null) {
                String bcyptPassword = user.getPassword();
                return encoder.matches(password, bcyptPassword);
            }
        }
        return false;
    }
}
