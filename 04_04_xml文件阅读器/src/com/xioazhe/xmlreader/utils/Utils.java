package com.xioazhe.xmlreader.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Utils {

	static public  String inputStreamToText(InputStream is){
		String text = null;
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		byte [] buf = new byte[1024];
		int len = -1;
		try {
			while((len = is.read(buf))!=-1){
				baos.write(buf, 0, len);
			}
			
			text = new String(baos.toByteArray(),"utf-8");
			return text;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
