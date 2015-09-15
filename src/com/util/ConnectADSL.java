package com.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 通过该类控制ADSL的连接和断开，从而改变IP地址
 * @author jqzhang
 *
 */
public class ConnectADSL {
	/**
	 * 执行CMD命令，并返回字符串
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
	 * 连接ASDL
	 * @param title
	 * @param name
	 * @param pwd
	 * @return
	 * @throws Exception
	 */
	public static boolean connectAdsl(String title, String name, String pwd) throws Exception{
		System.out.println("正在建立连接");
		String adslCmd = "rasdial " + title + " " + name + " " + pwd;
		String result = executeCmd(adslCmd);
		if (result.indexOf("已连接") > 0) {
			System.out.println("已经成功建立连接");
			return true;
		}else {
			System.err.println(result);
			System.err.println("建立连接失败");
			return false;
		}
	}
	
	/**
	 * 断开连接
	 * @param title
	 * @return
	 * @throws Exception
	 */
	public static boolean disconnectAdsl(String title) throws Exception{
		String cutAdsl = "radial " + title + " /disconnect";
		String result = executeCmd(cutAdsl);
		
		if (result.indexOf("没有连接")!=-1) {
			System.out.println(title + "连接不存在");
			return false;
		}else {
			System.out.println("连接已断开");
			return true;
		}
	}
	
	
}


