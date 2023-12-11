package com.testclasses;


import org.apache.commons.mail.EmailException;



import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automationbase.TestBase;
import com.pageobjects.FADVerifyPage;
import com.pageobjects.FindADoctorPage;
import com.pageobjects.HomePage;
import com.pageobjects.PageFooter;
import com.pageobjects.PageHeader;
import com.utils.EmailReport;

public class FAD_Verify_Testing extends TestBase {
	
	@Parameters("deviceConfig")
    @Test(dataProvider = "data-provider" , priority=1)
    public static void FADVerifyTest(String testUrl) throws InterruptedException {
		testCaseId = "1";
        extentTest = extent.createTest("Verify FAD");

        logInfo("===== TestCase  TestHomePageLoad Started =====");
        System.out.println("ENV:"+testUrl);
        FADVerifyPage.navigateToUrl(testUrl);
        FADVerifyPage.verifyPageTitle();
        FADVerifyPage.goToFADPage();
        FADVerifyPage.verifyFindADoctorPageTitle();
        FADVerifyPage.clickOnSearchByName();
        FADVerifyPage.selectVideoVisitRadioBtn();
        FADVerifyPage.CheckVisitTypeAvailableFor_VideoVisit();
        FADVerifyPage.verifySearchResultPageTitle();
        FADVerifyPage.selectTimeSlot();
        FADVerifyPage.verifyVideoVisit();
        FADVerifyPage.searchReults();
        FADVerifyPage.verifyVideoVisitFollowUP();
        FADVerifyPage.selectTimeSlot();
        FADVerifyPage.verifyVideoVisit();
        FADVerifyPage.verifyCancel();
        FADVerifyPage.confirmCancel();
        FADVerifyPage.verifyVideoVisitFollowUP();
        logInfo("===== TestCase  Test HomePage Load Ended =====");

    }
	
	@Parameters("deviceConfig")
    @Test(priority = 2)
    public static void generalVerificationHomePage() throws InterruptedException, EmailException {
		testCaseId = "2";
        extentTest = extent.createTest("Verify Footer is Present On Home Page");
        logInfo("===== TestCase  General Verification Home Page Started =====");
        PageFooter.verifyPageFooter();
        logInfo("===== TestCase  General Verification Home Page Ended =====");

    }
	
	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() {

		String sheetName="TestURLs";
		//int rowCount = datatable.getRowCount(sheetName);

					return new Object[][] { { datatable.getCellData(sheetName, 0, 2) }};

	}

}
