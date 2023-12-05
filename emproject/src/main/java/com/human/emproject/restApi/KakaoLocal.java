package com.human.emproject.restApi;

import java.io.FileInputStream;
import java.io.InputStream;

public class KakaoLocal {
	
	public static void main(String[] args) throws Exception {
		String keyfile = "D:/WorkSpace/02.DataAnalysis/08.Prototype/static/keys/카카오apikey.txt";
	      InputStream is = new FileInputStream(keyfile);
	      byte[] buffer = new byte[80];
	      while (true) {
	         int num = is.read(buffer);
	         if (num == -1)
	            break;
	      }
	      is.close(); 
	}
}
