package com.testclasses;

import org.apache.commons.mail.EmailException;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.automationbase.TestBase;
import com.pageobjects.HomePage;
import com.pageobjects.HomePageMB;


public class HomePageTestingMB extends TestBase {
	
	@Parameters("deviceConfig")
    @Test
    public static void HomePageLoadTest() throws InterruptedException {

        //extentTest = extent.createTest("Verify HomePageLoad");

        //logInfo("===== TestCase  TestHomePageLoad Started =====");
       // System.out.println("MMMMMTest:"+testUrl);
      //  HomePage.navigateToUrl(testUrl);
        HomePage.verifyPageTitle();
      //  logInfo("===== TestCase  Test HomePage Load Ended =====");
	}

    

}
