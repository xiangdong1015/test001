package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/mvc")
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/test")
    public void test(){
        System.out.println("test");
    }

    @RequestMapping("/upload")
    public void upload(MultipartFile meFile, String fileName) throws UnsupportedEncodingException {
        if (meFile != null) {
            System.out.println(meFile.getContentType());//在控制台打印文件的类型
            System.out.println(meFile.getName());//返回文件的名称
            System.out.println(meFile.getOriginalFilename());//返回文件的原文件名
            byte[] bytes = meFile.getOriginalFilename().getBytes("UTF-8");
            System.out.println("444444:"+new String(bytes,"UTF-8"));
            System.out.println(fileName);
            System.out.println("汉字");
        }
    }
}
