package com.qa.testrailmanager;

import java.io.IOException;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import com.gurock.testrail.APIClient;
import com.gurock.testrail.APIException;

public class TestRailManager {
	
	public static String Test_RUN_ID = "1";
	
	public static String Test_Rail_UserName = "manisa_mahapatra@persistent.com";
	public static String Test_Rail_Password = "Ma$3695m1";
	public static String Test_Rail_ENGINE_URL = "https://manisamahapatra1.testrail.io/";
	
	public static int Test_Case_Pass_Status = 1;
	public static int Test_Case_Fail_Status = 5;
	
	public static void addResultsForTestCase(String testCaseId, int status,String error) {
		
		String testRunID = Test_RUN_ID;
		APIClient client = new APIClient(Test_Rail_ENGINE_URL);
		client.setUser(Test_Rail_UserName);
		client.setPassword(Test_Rail_Password);
		
		Map<String, Object> data = new HashMap<String,Object>();
		data.put("status_id", status);
		
		data.put("comment", "this test is executed vie mountsinai test automation code" + error);
		System.out.println("status is:"+status);
		
		try {
			client.sendPost("add_result_for_case/"+testRunID+"/"+testCaseId, data);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (APIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
