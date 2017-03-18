package com.jointstarc.ssm.first.utils;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

public class Md5Util {
	/** 
     * 对字符串进行MD5加密 
     *  
     * @param str 
     * 			加密原文
     * @return String 
     * 			密文
     */  
    public static String md5Encryption(String str) {  
        String newStr = null;  
        try {  
            MessageDigest md5 = MessageDigest.getInstance("MD5");  
            BASE64Encoder base = new BASE64Encoder();  
            newStr = base.encode(md5.digest(str.getBytes("UTF-8")));  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return newStr;  
    }  
     
    public static void main(String[] args) {
        System.out.println(md5Encryption("1234567"));
    }
}
