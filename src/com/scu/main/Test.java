package com.scu.main;

import java.io.IOException;

import com.scu.util.CheckStopWords;
import com.scu.util.NLPIRUtil;
import com.scu.util.ReadFileText;

public class Test {

	public static void main(String[] args) {
		
		//��������
		String stopword = "����";
		String notstopword = "����";
		String checkForNLPIR = "�ʼ��ܾ��ѽ������й�����ٴ�ͨ��������Ҫ��������ǿ���仪���׵Ĳ�����Դ�����估�ִ��Ȼ��ڵĹܿش�ʩ";
		String filepath = System.getProperty("user.dir")+"\\testfile.txt";  //���ļ��ж�ȡȫ���ַ���
		
		
		//��ʼ����������
		CheckStopWords checkStopWords = new CheckStopWords();
		NLPIRUtil nlpirUtil = new NLPIRUtil();
		ReadFileText readFileText = new ReadFileText();
		
		
		try {
			//��������ͣ�ô�
			boolean b = checkStopWords.isStopWord(stopword);
			boolean b1 = checkStopWords.isStopWord(notstopword);
			System.out.println(stopword+" ��"+b);
			System.out.println(notstopword+" : "+b1);
			
			//�������ķִ�
			String nlpirString = nlpirUtil.chineseSplit(checkForNLPIR);
			System.out.println(nlpirString);
			String[] textArray = nlpirString.split(" ");
			String[] newTextArray = checkStopWords.deleteStopWord(textArray);
			for(String s:newTextArray){
				System.out.print(s+",");
			}
			System.out.println();
			System.out.println();
			
			//���Դ��ļ���ȡ���ַ�����Ȼ����зִ�
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
