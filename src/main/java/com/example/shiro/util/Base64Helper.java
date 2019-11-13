package com.example.shiro.util;

import java.util.Base64;

public class Base64Helper {
	
	/**
	 * base64加密解密自定义字符
	 */
	private static final char[] S_BASE64CHAR = {  
	        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',  
	        'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',  
	        'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd',  
	        'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',  
	        'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',  
	        'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7',  
	        '_','9','+','!'  
	    };  
	    private static final char S_BASE64PAD = '8';  
	    private static final byte[] S_DECODETABLE = new byte[128];  
	    static {  
	        for (int i = 0;   i < S_DECODETABLE.length;   i ++)  
	            S_DECODETABLE[i] = Byte.MAX_VALUE;  // 127  
	        for (int i = 0;   i < S_BASE64CHAR.length;   i ++) // 0 to 63  
	            S_DECODETABLE[S_BASE64CHAR[i]] = (byte)i;  
	    }  
	      
	    private static int decode0(char[] ibuf, byte[] obuf, int wp) {  
	        int outlen = 3;  
	        if (ibuf[3] == S_BASE64PAD)   outlen = 2;  
	        if (ibuf[2] == S_BASE64PAD)   outlen = 1;  
	        int b0 = S_DECODETABLE[ibuf[0]];  
	        int b1 = S_DECODETABLE[ibuf[1]];  
	        int b2 = S_DECODETABLE[ibuf[2]];  
	        int b3 = S_DECODETABLE[ibuf[3]];  
	        switch (outlen) {  
	        case 1:  
	            obuf[wp] = (byte)(b0 << 2 & 0xfc | b1 >> 4 & 0x3);  
	            return 1;  
	        case 2:  
	            obuf[wp++] = (byte)(b0 << 2 & 0xfc | b1 >> 4 & 0x3);  
	            obuf[wp] = (byte)(b1 << 4 & 0xf0 | b2 >> 2 & 0xf);  
	            return 2;  
	        case 3:  
	            obuf[wp++] = (byte)(b0 << 2 & 0xfc | b1 >> 4 & 0x3);  
	            obuf[wp++] = (byte)(b1 << 4 & 0xf0 | b2 >> 2 & 0xf);  
	            obuf[wp] = (byte)(b2 << 6 & 0xc0 | b3 & 0x3f);  
	            return 3;  
	        default:  
	            throw new RuntimeException("Couldn't decode.");  
	        }  
	    }  
	  
	    /**
	     * base64解密
	     * @param data
	     * @return
	     */
	    public static String decode(String data) {  
	        char[] ibuf = new char[4];  
	        int ibufcount = 0;  
	        byte[] obuf = new byte[data.length()/4*3+3];  
	        int obufcount = 0;  
	        for (int i = 0;   i < data.length();   i ++) {  
	            char ch = data.charAt(i);  
	            if (ch == S_BASE64PAD  
	                || ch < S_DECODETABLE.length && S_DECODETABLE[ch] != Byte.MAX_VALUE) {  
	                ibuf[ibufcount++] = ch;  
	                if (ibufcount == ibuf.length) {  
	                    ibufcount = 0;  
	                    obufcount += decode0(ibuf, obuf, obufcount);  
	                }  
	            }  
	        }  
	        if (obufcount == obuf.length)  
	            return new String(obuf);  
	        byte[] ret = new byte[obufcount];  
	        System.arraycopy(obuf, 0, ret, 0, obufcount);  
	        return new String(ret);  
	    }  
	    
	    /**
	     * base64加密
	     * @param data
	     * @return
	     */
	    public  String encode(String data) throws Exception {
			String result = Base64.getEncoder().encodeToString(data.getBytes("UTF-8"));
			return result;
	    }
	    
}
