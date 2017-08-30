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
 * ȥ������ͣ�ô�
 * @author xing
 *
 */
public class CheckStopWords {
	
	public CheckStopWords(){}

	//��������ͣ�ôʵ��ļ�·�����ڵ�ǰ����Ŀ¼��
	String filepath = System.getProperty("user.dir")+"\\stopword.txt";
    String[] stopwordList = null;
	
    /**
     * ���ļ��ж�ȡ����ͣ�ôʣ����һ�����飬���ظ�����
     * @param filepath
     * @return
     * @throws IOException 
     */
	public String[] getStopWord(String filepath) throws IOException{
		
		String[] strArray = null;
		
		//��ȡ�ļ�������
		File file = new File(filepath);
		InputStreamReader inputStreamReader = new InputStreamReader(
				new FileInputStream(file),"utf-8");
		BufferedReader reader = new BufferedReader(inputStreamReader);
		String aline;
		StringBuilder builder = new StringBuilder();
		//ÿ�ζ�ȡһ��
		//�Ѷ�ȡ�ĵ����ÿո����
		while((aline = reader.readLine())!=null){
			builder.append(aline + " ");
		}
		
		//��ƴ�Ӻõ��ַ����ÿո�������������
		String wordString = builder.toString();
		strArray = wordString.split(" ");
		
		inputStreamReader.close();
		reader.close();
		
		return strArray;
	}
	
	/**
	 * �жϵ����Ƿ���������ͣ�ô�
	 * @param word
	 * @return
	 * @throws IOException
	 */
	public boolean isStopWord(String word) throws IOException{
		
		//��ȡ����ͣ�ô�����
		stopwordList = getStopWord(filepath);
		//�жϸõ����Ƿ������ͣ�ô������У��Ǿͷ���true
		for(int i=0;i<stopwordList.length;i++)
		{
			if(word.equalsIgnoreCase(stopwordList[i])){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * ɾ��һ�������е�����ͣ�ôʣ�����û������ͣ�ôʵ�����
	 * @param textResource
	 * @return
	 * @throws IOException
	 */
	public String[] deleteStopWord(String[] textResource) throws IOException{
		
		//Vector ��ʵ���Զ������Ķ�������
		Vector<String> vector = new Vector<String>();
		for(int i=0;i<textResource.length;i++){
			if(isStopWord(textResource[i]) == false){
				vector.add(textResource[i]);
			}
		}
		
		//��vectorװ��Ϊstring����
		String[] newTextArray = new String[vector.size()];
		vector.toArray(newTextArray);
		
		return newTextArray;
	}
}
