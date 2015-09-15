package com.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * ͨ���������ADSL�����ӺͶϿ����Ӷ��ı�IP��ַ
 * @author jqzhang
 *
 */
public class ConnectADSL {
	/**
	 * ִ��CMD����������ַ���
	 * @param strCmd
	 * @return
	 * @throws Exception
	 */
	public static String  executeCmd(String strCmd) throws Exception {
		Process p = Runtime.getRuntime().exec("cmd /c" + strCmd);
		StringBuilder strBuilder = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream(), "GB2312"));
		
		String line;
		while((line = in.readLine()) != null){
			strBuilder.append(line + "\n");
		}
		return strBuilder.toString();
		
	}
	
	/**
	 * ����ASDL
	 * @param title
	 * @param name
	 * @param pwd
	 * @return
	 * @throws Exception
	 */
	public static boolean connectAdsl(String title, String name, String pwd) throws Exception{
		System.out.println("���ڽ�������");
		String adslCmd = "rasdial " + title + " " + name + " " + pwd;
		String result = executeCmd(adslCmd);
		if (result.indexOf("������") > 0) {
			System.out.println("�Ѿ��ɹ���������");
			return true;
		}else {
			System.err.println(result);
			System.err.println("��������ʧ��");
			return false;
		}
	}
	
	/**
	 * �Ͽ�����
	 * @param title
	 * @return
	 * @throws Exception
	 */
	public static boolean disconnectAdsl(String title) throws Exception{
		String cutAdsl = "radial " + title + " /disconnect";
		String result = executeCmd(cutAdsl);
		
		if (result.indexOf("û������")!=-1) {
			System.out.println(title + "���Ӳ�����");
			return false;
		}else {
			System.out.println("�����ѶϿ�");
			return true;
		}
	}
	
	
}


