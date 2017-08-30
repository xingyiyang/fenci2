package com.scu.util;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Vector;

/**
 * 去除中文停用词
 * @author xing
 *
 */
public class CheckStopWords {
	
	public CheckStopWords(){}

	//保存中文停用词的文件路径，在当前工程目录下
	String filepath = System.getProperty("user.dir")+"\\stopword.txt";
    String[] stopwordList = null;
	
    /**
     * 从文件中读取中文停用词，变成一个数组，返回该数组
     * @param filepath
     * @return
     * @throws IOException 
     */
	public String[] getStopWord(String filepath) throws IOException{
		
		String[] strArray = null;
		
		//读取文件的内容
		File file = new File(filepath);
		InputStreamReader inputStreamReader = new InputStreamReader(
				new FileInputStream(file),"utf-8");
		BufferedReader reader = new BufferedReader(inputStreamReader);
		String aline;
		StringBuilder builder = new StringBuilder();
		//每次读取一行
		//把读取的单词用空格隔开
		while((aline = reader.readLine())!=null){
			builder.append(aline + " ");
		}
		
		//把拼接好的字符串用空格隔开，变成数组
		String wordString = builder.toString();
		strArray = wordString.split(" ");
		
		inputStreamReader.close();
		reader.close();
		
		return strArray;
	}
	
	/**
	 * 判断单词是否属于中文停用词
	 * @param word
	 * @return
	 * @throws IOException
	 */
	public boolean isStopWord(String word) throws IOException{
		
		//获取中文停用词数组
		stopwordList = getStopWord(filepath);
		//判断该单词是否出现在停用词数组中，是就返回true
		for(int i=0;i<stopwordList.length;i++)
		{
			if(word.equalsIgnoreCase(stopwordList[i])){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 删除一个数组中的中文停用词，返回没有中文停用词的数组
	 * @param textResource
	 * @return
	 * @throws IOException
	 */
	public String[] deleteStopWord(String[] textResource) throws IOException{
		
		//Vector 可实现自动增长的对象数组
		Vector<String> vector = new Vector<String>();
		for(int i=0;i<textResource.length;i++){
			if(isStopWord(textResource[i]) == false){
				vector.add(textResource[i]);
			}
		}
		
		//把vector装换为string数组
		String[] newTextArray = new String[vector.size()];
		vector.toArray(newTextArray);
		
		return newTextArray;
	}
}
