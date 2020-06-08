package com.amarsoft.controller;

import com.alibaba.fastjson.JSON;
import com.amarsoft.Service.UserService;
import com.amarsoft.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/a")
public class Test {
    @Autowired
    private UserService userService;

    @RequestMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
//        String contextPath = request.getServletContext().getContextPath();

        String originalFilename = file.getOriginalFilename();

        String path = "demo/src/main/resources/static/files/";
        File fileDir = new File(path);
        //递归生成文件夹
        if (!fileDir.exists()){
            fileDir.mkdir();
        }

        File newFile = new File(fileDir.getAbsolutePath() + File.separator + originalFilename);

        file.transferTo(newFile);
        //111111111
        //2222222222222
        //888888888888888
        return "success";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
    @GetMapping("/user")
    public List<User> getAll(){
        List<User> users = userService.getAll();
        return users;
    }

}
