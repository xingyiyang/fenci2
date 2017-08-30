package com.scu.util;

import com.scu.interfa.CLibrary;

/**
 * ʹ���п�Ժ��NLPIR���߽������ķִ�
 * ��ѵ�������ı���ֳɴ���
 * @author xing
 *
 */
public class NLPIRUtil {
	
	public NLPIRUtil(){}

	/**
	 * ��һ���ַ����������ķִ�
	 * @param text
	 * @return �ִʺõ��ı��еĴ�����һ���ո���������������ַ���
	 */
	public String chineseSplit(String text){
		
		String splitresult = null;
		//��ȡ�ù��̵ĵ�ǰĿ¼
		String argu = System.getProperty("user.dir");
		int charset_type = 1;
		
		int init_flag = CLibrary.Instance.NLPIR_Init(argu, charset_type, "0");
		
		if (0 == init_flag) {
			splitresult = CLibrary.Instance.NLPIR_GetLastErrorMsg();
			System.err.println("��ʼ��ʧ�ܣ�fail reason is "+splitresult);
			return null;
		}
		
		//����0��ʾ�������ԣ�����1��ʾ���д���
		//NLPIR_ParagraphProcess������ַ����õ��ֺôʵ��ַ���
		splitresult = CLibrary.Instance.NLPIR_ParagraphProcess(text, 0);
		
		return splitresult;
	}
}
