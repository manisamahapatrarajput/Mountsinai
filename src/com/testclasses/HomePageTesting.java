package com.testclasses;


import org.apache.commons.mail.EmailException;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automationbase.TestBase;
import com.pageobjects.HomePage;
import com.pageobjects.PageFooter;
import com.pageobjects.PageHeader;
import com.utils.EmailReport;

public class HomePageTesting extends TestBase {
	
	@Parameters("deviceConfig")
    @Test(dataProvider = "data-provider")
    public static void HomePageLoadTest(String testUrl) throws InterruptedException {

        extentTest = extent.createTest("Verify HomePageLoad");

        logInfo("===== TestCase  TestHomePageLoad Started =====");
        System.out.println("MMMMMTest:"+testUrl);
        HomePage.navigateToUrl(testUrl);
        HomePage.verifyPageTitle();
        logInfo("===== TestCase  Test HomePage Load Ended =====");

    }
	
	@Parameters("deviceConfig")
    @Test
    public static void generalVerificationHomePage() throws InterruptedException, EmailException {

        extentTest = extent.createTest("Verify Header,Footer, searchbox and logo is Present On Home Page");
        logInfo("===== TestCase  General Verification Home Page Started =====");
        PageFooter.verifyPageFooter();
        PageHeader.verifyPageHeader();
        PageHeader.isLogoPresent();
        HomePage.verifylogoRedirectionlink();
       // EmailReport.sendEmail();
        logInfo("===== TestCase  General Verification Home Page Ended =====");

    }
    
    

	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() {

		String sheetName="TestURLs";
		//int rowCount = datatable.getRowCount(sheetName);

					return new Object[][] { { datatable.getCellData(sheetName, 0, 2) }};

	}

}
