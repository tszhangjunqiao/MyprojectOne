package com.http.vote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;


public class HttpRequest {

	public static String sendGet(String url) {
		String result = "";
		BufferedReader in = null;
		
		try {
		//	String urlNameString = url;
			URL realUrl = new URL(url);
			URLConnection connection = realUrl.openConnection();
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			connection.connect();
			
			//cookie����
//			CookieManager manager = new CookieManager();
//			CookieHandler.setDefault(manager);
//			Object obj = connection.getContent();
//			CookieStore cookieJar = manager.getCookieStore();
//			List<HttpCookie> cookies = cookieJar.getCookies();
//			for( HttpCookie cookie: cookies){
//				System.out.println(cookie);
//			}
					
			
//			Map<String, List<String>> map = connection.getHeaderFields();
//			for (String key : map.keyset) {
//				System.out.println(key + "--->" + map.get(key));
//			}
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ( (line = in.readLine()) != null) {
				result +=line;
				result += "\n";
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("����GET��������쳣 " + e);
		}
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		return result;
		
	}
	
	public static String sendPost(String url) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			URLConnection connection = realUrl.openConnection();
			
			//����ͨ�õ���������
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			//����POST�������������������
			connection.setDoOutput(true);
			connection.setDoInput(true);
			
			out = new PrintWriter(connection.getOutputStream());
		//	out.println(param);
			out.flush();
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			String line;
			while( (line = in.readLine()) != null){
				result += line;
				result += "\n";
				
			}
					
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("����POST����ʧ�� " + e);
		}finally {
			try{
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}
		
		return result;
	}
}
