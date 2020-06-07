package com.amarsoft.first;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/a")
public class Test {

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

        return "success";
    }

    @RequestMapping("/hello")
    public String hello(){

        return "hello";
    }
}
