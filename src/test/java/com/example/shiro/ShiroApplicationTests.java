package com.example.shiro;

import com.example.shiro.util.MD5;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShiroApplicationTests {
	@Test
	public void contextLoads() {

		String t = "<order></order>123456";
		MD5 md5 = new MD5();
		md5.encrypt(t);

	}


}
