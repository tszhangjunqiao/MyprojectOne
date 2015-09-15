package com.http.vote;
import com.rand.util.*;
import com.http.vote.*;
import com.util.*;

public class AutoVoteTest {

	public static void main(String[] args) throws Exception {
		String name = RandomTool.getChineseName();
		String tel = RandomTool.getTelNumber();
		
//		System.out.println(name);
//		System.out.println(tel);
		
		String response = HttpRequest.sendGet("http://hongbao.xnjhs.com/dz/plugin.php?id=tom_mengbao&mod=info&vid=1&tid=197&from=timeline&isappinstalled=0");
		System.out.println(response);
		int MAXCOUNT = 5;
		for (int i = 0; i < MAXCOUNT; i++) {
//			ConnectADSL.connectAdsl("욱던", "jqzhang", "zjq529631424");
//			Thread.sleep(10000);	
//			ConnectADSL.disconnectAdsl("욱던");
		}

	}
}
