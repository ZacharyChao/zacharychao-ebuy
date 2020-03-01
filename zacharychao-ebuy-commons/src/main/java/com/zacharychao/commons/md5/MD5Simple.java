package com.zacharychao.commons.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Simple {
	private static String[] digest = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
	
	public static void main(String[] args) {
		String message = "123456";
		try {
			String md5 = toMD5(message);
			System.out.println(md5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static String toMD5(String message) throws Exception {
		MessageDigest instance = MessageDigest.getInstance("MD5");
		byte[] bytes = instance.digest(message.getBytes("UTF-8"));
		StringBuilder builder = new StringBuilder();
		for(byte b : bytes) {
			int i = b;
			if(i < 0) {
				i += 256;
			}
			int c = i / 16;
			int y = i % 16;
			builder.append(digest[c]).append(digest[y]);
		}
		return builder.toString();
	}
}
