package com.example.shiro;

import com.example.shiro.util.Base64Helper;
import com.example.shiro.util.MD5;
import org.apache.tomcat.util.codec.binary.Base64;

import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.logging.Logger;

public class Test {
    public static void main(String[] args) throws Exception {
       /* String t = "<order></order>123456";
        MD5 md5 = new MD5();
        Base64Helper base = new Base64Helper();
        String a = md5.encrypt(t);
        System.out.println(md5.encrypt(t));
        System.out.println(base.encode(a));

        String result = "";
        MessageDigest m = MessageDigest.getInstance("MD5");
        byte[] bytes = m.digest(("<order></order>123456").getBytes(Charset.forName("utf-8")));
        System.out.println(bytes);
        result = new String(Base64.encodeBase64(bytes),"utf-8");
        System.out.println(result);
        String encode = URLEncoder.encode(result, "utf-8");
        System.out.println(encode);
        System.out.println(URLEncoder.encode("<order></order>", "utf-8"));*/

    }
}
