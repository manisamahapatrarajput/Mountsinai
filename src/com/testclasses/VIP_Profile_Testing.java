package com.testclasses;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automationbase.TestBase;
import com.pageobjects.HomePage;
import com.pageobjects.FindADoctorPage;
import com.pageobjects.DoctorProfilePage;


public class VIP_Profile_Testing extends TestBase {
	 
	@Parameters("deviceConfig")
	@Test
	public static void VerifyVIPProfiles() throws InterruptedException, IOException {

		extentTest = extent.createTest("Verify VIP Profiles");

		logInfo("===== TestCase  VerifyVIPProfiles Started =====");
		
		logInfo("===== Verifying on PreProd =====");
		DoctorProfilePage.verifyVIPProfiles(2);
		
		logInfo("===== Verifying on Prod-CDS2 =====");
		//DoctorProfilePage.verifyVIPProfiles(3);
		
		logInfo("===== Verifying on LIVE =====");
		//DoctorProfilePage.verifyVIPProfiles(4);
		
	
		logInfo("===== TestCase  VeriffocusOnElementyVIPProfiles Load Ended =====");

	}


	
}
