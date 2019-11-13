package com.example.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.HttpURLConnection;
import java.net.URL;

@Controller
public class UrlController {

    @PostMapping(value = "url")
    public Object UrlTest() throws Exception{
        String logistics_interface = "";
        String data_digest = "";
        String clientId = "K21000119";
        String type = "";


        URL url = new URL("http://www.baidu.com");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
        return url;
    }
}
