package com.scu.main;

import java.io.IOException;

import com.scu.util.CheckStopWords;
import com.scu.util.NLPIRUtil;
import com.scu.util.ReadFileText;

public class Test {

	public static void main(String[] args) {
		
		//测试数据
		String stopword = "我们";
		String notstopword = "篮球";
		String checkForNLPIR = "质检总局已将最新有关情况再次通报美方，要求美方加强对输华玉米的产地来源、运输及仓储等环节的管控措施";
		String filepath = System.getProperty("user.dir")+"\\testfile.txt";  //从文件中读取全部字符串
		
		
		//初始化两个工具
		CheckStopWords checkStopWords = new CheckStopWords();
		NLPIRUtil nlpirUtil = new NLPIRUtil();
		ReadFileText readFileText = new ReadFileText();
		
		
		try {
			//测试中文停用词
			boolean b = checkStopWords.isStopWord(stopword);
			boolean b1 = checkStopWords.isStopWord(notstopword);
			System.out.println(stopword+" ："+b);
			System.out.println(notstopword+" : "+b1);
			
			//测试中文分词
			String nlpirString = nlpirUtil.chineseSplit(checkForNLPIR);
			System.out.println(nlpirString);
			String[] textArray = nlpirString.split(" ");
			String[] newTextArray = checkStopWords.deleteStopWord(textArray);
			for(String s:newTextArray){
				System.out.print(s+",");
			}
			System.out.println();
			System.out.println();
			
			//测试从文件读取出字符串，然后进行分词
			String textfromFile = readFileText.getText(filepath);
			System.out.println(textfromFile);
			String[] textArray2 = nlpirUtil.chineseSplit(textfromFile).split(" ");
			String[] newTextArray2 = checkStopWords.deleteStopWord(textArray2);
			for(String s:newTextArray2){
				System.out.print(s+",");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
