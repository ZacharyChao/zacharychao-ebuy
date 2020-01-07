package com.zacharychao.commons.md5;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5Util {
	public static String[] digests = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String message = "123456";
		String md = MD5(message);
		System.out.println(md);
		
	}
	
	public static String MD5(String message) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] digest = md.digest(message.getBytes("UTF-8"));
//		System.out.println(Arrays.toString(digest));
		StringBuilder builder = new StringBuilder();
		for(byte b : digest) {
			int i = b;
			if(i < 0) {
				i += 256;
			}
			
			int index0 = i / 16;
			int index1 = i % 16;
//			System.out.println(index0 + "**" + index1);
//			System.out.println(digests[index0] + "-" + digests[index1]);
			builder.append(digests[index0]).append(digests[index1]);
		}
		return builder.toString();
	}
}
