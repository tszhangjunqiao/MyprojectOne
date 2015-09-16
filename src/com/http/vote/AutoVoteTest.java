package com.http.vote;
import com.rand.util.*;

import java.net.HttpURLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;

import com.http.vote.*;
import com.util.*;

public class AutoVoteTest {

	public static void main(String[] args) throws Exception {
		
		
//		System.getProperties().setProperty("http.proxyHost", "58.222.254.11");
//		System.getProperties().setProperty("http.proxyPort", "8080");		
		String nameChinese = RandomTool.getChineseName();
		@SuppressWarnings("deprecation")
		String name = URLEncoder.encode(nameChinese); 
		String tel = RandomTool.getTelNumber();
		String formhash = "a10621fe";
		String tomhash = "253059";
		System.out.println(name);
//		System.out.println(tel);
		String reFresh = HttpRequest.sendGet("http://hongbao.xnjhs.com/dz/plugin.php?id=tom_mengbao&mod=info&vid=1&tid=197&from=timeline&isappinstalled=0");
		System.out.println(reFresh);
		
//		String urlPre = "http://hongbao.xnjhs.com/dz/plugin.php?id=tom_mengbao&mod=save&act=clicks&formhash="+formhash+"&vid=1";
//		System.out.println(urlPre);
//		String responsePre = HttpRequest.sendGet(urlPre);
//		System.out.println(responsePre+"\n>>>>>>>>>>>>>>>>\n");
		
		String host = "http://hongbao.xnjhs.com/dz/plugin.php";
		String param = "?id=tom_mengbao&mod=save&tpxm=" + "zjqzhang" + "&tptel=" + tel + "&formhash="+ formhash + "&tomhash=" + tomhash + "&vid=1&tid=197&act=tpadd";
		String urlRequest = host + param;
		System.out.println(urlRequest);
//		String urlRequest= "/dz/plugin.php?id=tom_mengbao&mod=save&tpxm=%E5%BC%A0%E5%90%9B%E6%A1%A5aaa&tptel=15071794563&formhash=dd6e6a93&tomhash=157421&vid=1&tid=197&act=tpadd";
//		String response = HttpRequest.sendGet("http://hongbao.xnjhs.com/dz/plugin.php?id=tom_mengbao&mod=info&vid=1&tid=197&from=timeline&isappinstalled=0");
//		String response2 = HttpRequest.sendGet("http://hongbao.xnjhs.com/dz/plugin.php?id=tom_mengbao&mod=save&act=tp&formhash=69d4fbfe&tomhash=883928&vid=1&tid=197&userid=57586");
//		
		String response2 = HttpRequest.sendGet(urlRequest);
		System.out.println(response2);
		int MAXCOUNT = 5;
		for (int i = 0; i < MAXCOUNT; i++) {
//			ConnectADSL.connectAdsl("욱던", "jqzhang", "zjq529631424");
//			Thread.sleep(10000);	
//			ConnectADSL.disconnectAdsl("욱던");
		}

	}
}
