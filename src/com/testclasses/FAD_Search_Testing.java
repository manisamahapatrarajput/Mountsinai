package com.testclasses;


import org.apache.commons.mail.EmailException;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automationbase.TestBase;
import com.pageobjects.FADSearchPage;
import com.pageobjects.FADVerifyPage;
import com.pageobjects.FindADoctorPage;
import com.pageobjects.HomePage;
import com.pageobjects.PageFooter;
import com.pageobjects.PageHeader;
import com.utils.EmailReport;
import com.utils.XlsReader;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class FAD_Search_Testing extends TestBase {
	
	@Parameters("deviceConfig")
    @Test(dataProvider = "data-provider", priority=1)
    public static void FADVerifyTest(String testUrl) throws InterruptedException {
		testCaseId = "7";
        extentTest = extent.createTest("Verify FAD");
       
        logInfo("===== TestCase  FAD search Doctor Started =====");
        System.out.println("ENV:"+testUrl);
        FADSearchPage.navigateToUrl(testUrl);
        FADSearchPage.verifyPageTitle();
        FADSearchPage.goToFADPage();
        FADSearchPage.verifyFindADoctorPageTitle();
        FADSearchPage.clickOnSearchByName();
        FADSearchPage.searchFindADoctorPageTitle();
        FADSearchPage.goToDoctorProfilePage();
        FADSearchPage.verifyAPISearchDoctorPageCompare();
        FADSearchPage.verifyDoctorProfilePageTitle();
        FADSearchPage.verifyAPIDoctorProfilePageValidation();
       
        logInfo("===== TestCase  FAD search Doctor Ended =====");

    }
    
	
	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() {

		String sheetName="TestURLs";
		//int rowCount = datatable.getRowCount(sheetName);

					return new Object[][] { { datatable.getCellData(sheetName, 0, 2) }};

	}
	
	    
	
	

}
