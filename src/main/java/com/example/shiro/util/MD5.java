package com.example.shiro.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5 {
	
	public String encrypt(String str) {
		try {
			//生成一个MD5加密计算摘要
			MessageDigest md = MessageDigest.getInstance("MD5");
			//计算MD5函数
			md.update(str.getBytes());
			/**
			 * digest()最后确定返回MD5 hash值，返回值为8位字符串。。因为md5 hash值是16位的hex值，实际上就是8位的字符
			 * BigInteger函数则将8位的字符串转化为16位的hex值，用字符串来表示，得到字符串形式的hash值
			 */
			return new BigInteger(1, md.digest()).toString(16).substring(8, 24);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
