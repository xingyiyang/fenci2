package com.scu.util;

import com.scu.interfa.CLibrary;

/**
 * 使用中科院的NLPIR工具进行中文分词
 * 把训练集的文本拆分成词组
 * @author xing
 *
 */
public class NLPIRUtil {
	
	public NLPIRUtil(){}

	/**
	 * 对一个字符串进行中文分词
	 * @param text
	 * @return 分词好的文本中的词组用一个空格隔开，返回整个字符串
	 */
	public String chineseSplit(String text){
		
		String splitresult = null;
		//获取该工程的当前目录
		String argu = System.getProperty("user.dir");
		int charset_type = 1;
		
		int init_flag = CLibrary.Instance.NLPIR_Init(argu, charset_type, "0");
		
		if (0 == init_flag) {
			splitresult = CLibrary.Instance.NLPIR_GetLastErrorMsg();
			System.err.println("初始化失败！fail reason is "+splitresult);
			return null;
		}
		
		//参数0表示不带词性，参数1表示带有词性
		//NLPIR_ParagraphProcess处理该字符串得到分好词的字符串
		splitresult = CLibrary.Instance.NLPIR_ParagraphProcess(text, 0);
		
		return splitresult;
	}
}
