package com.scu.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class ReadFileText {
	
	public ReadFileText(){}
	
	/**
	 * 获取文件里面的内容
	 * @param filepath
	 * @return
	 * @throws IOException
	 */
    public String getText(String filepath) throws IOException{
    	
    	InputStreamReader isReader =new InputStreamReader(new FileInputStream(filepath),"GBK");
		BufferedReader reader = new BufferedReader(isReader);
		String aline;
		StringBuilder sb = new StringBuilder();
	
		while ((aline = reader.readLine()) != null)
		{
			sb.append(aline + " ");
		}
		isReader.close();
		reader.close();
		return sb.toString();
    }

}
