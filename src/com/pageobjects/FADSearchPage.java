package com.pageobjects;

import java.io.Console;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import com.google.errorprone.annotations.Var;
import com.utils.CommonUtils;
import com.utils.XlsReader;

public class FADSearchPage extends CommonUtils {

	@FindBy(linkText = "Find a Doctor")
	static WebElement fad_Link;
	@FindBy(xpath = " //input[contains(@id,'downshift')]")
	static WebElement search_textbox;
	@FindBy(xpath = "//span[@class='text-sm md:text-base']")
	static WebElement searchByName;
	@FindBy(xpath = "//button[text()='Search']")
	static WebElement searchButton;
	@FindBy(xpath = "//*[@title='Close welcome popup']")
	static WebElement helpYou;
	@FindBy(xpath = "//section[@class='md:ml-8 flex-1']//main[@class='resultsPanel__ResultsPanelContainer-sc-13jufou-0 hyOKHK pb-8']//section[@class='resultList__ResultListContainer-sc-100pp4z-0 bGEFUE pt-4 px-2 miniTab:px-0']//div//article[@class='resultCard__ResCard-qdi3ot-0 gaHIzg bg-white mb-4 p-4 flex']//div[@class='Slots_drDetails__3jc5o']//div//div[@class='Slots_locationBox__18JWE']//div[@class='Slots_primaryLocation__3PVqe']//div[@class='Slots_locationInfo__1fe3L']//div//div[@class='mobileRightCol__RightCol-sc-1v8h5wi-0 hDQdHE lg:w-full']//div[@class='lg:flex items-center']//section//a[@class='mobileRightCol__NameLink-sc-1v8h5wi-1 fxYQXW text-xl tracking-normal font-bold miniPhone:text-base']")
	static WebElement doc_profile;
	@FindBy(xpath = "//body/div[@id='__next']/div[@class='bg-gray-gallery']/main[@id='fad-results-app']/section[@class='result__MobileAppContainer-cc60gj-0 bETpuh miniTab:hidden']/main[@class='resultsPanel__ResultsPanelContainer-sc-13jufou-0 hyOKHK pb-8']/section[@class='resultList__ResultListContainer-sc-100pp4z-0 bGEFUE pt-4 px-2 miniTab:px-0']/div/article[@class='resultCard__ResCard-qdi3ot-0 gaHIzg bg-white mb-4 p-4 flex']/div[@class='Slots_drDetails__3jc5o']/div/div[@class='Slots_locationBox__18JWE']/div[@class='Slots_primaryLocation__3PVqe']/div[@class='Slots_locationInfo__1fe3L']/div/div[@class='mobileRightCol__RightCol-sc-1v8h5wi-0 hDQdHE lg:w-full']/div[@class='lg:flex items-center']/section/p[1]")
	static WebElement doc_profileMB;

    public FADSearchPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    public static void navigateToUrl(String url) throws InterruptedException {

        PageFactory.initElements(driver, FADSearchPage.class);
        navigateToURL(url);
        logInfo("HomePage Loaded");
    }
    
    public static void verifyPageTitle() throws InterruptedException {
        PageFactory.initElements(driver, FADSearchPage.class);
        String pageTitle=datatable.getCellData("Expected_Value", 0, 4);
        waitForPageTitle(pageTitle);
        String actulPageTitle = getTitle();
        Assert.assertEquals(actulPageTitle,pageTitle);
        logPass("Page Title is : " + actulPageTitle);
    }
    
    public static void goToFADPage() throws InterruptedException {
		PageFactory.initElements(driver, FADSearchPage.class);
		logInfo("Clicking on Find a Doctor Menu Link");
		waitAndClick(fad_Link);

	}
    
    public static void verifyFindADoctorPageTitle() throws InterruptedException {
    	datatable = new XlsReader(PROJECTDIR + "/testdata/TestInput.xlsx");
        PageFactory.initElements(driver, FADVerifyPage.class);
        String findADoctorpageTitle=datatable.getCellData("Expected_Value", 0, 5);
        waitForPageTitle(findADoctorpageTitle);
        String actulPageTitle = getTitle();
        Assert.assertEquals(actulPageTitle,findADoctorpageTitle);
        logPass("Page Title is : " + actulPageTitle);
    }
    
    public static void searchFindADoctorPageTitle() throws InterruptedException {
        datatable = new XlsReader(PROJECTDIR + "/testdata/TestInput.xlsx");
        PageFactory.initElements(driver, FADVerifyPage.class);
        String searchADoctorpageTitle=datatable.getCellData("Expected_Value", 0, 8);
        String actulPageTitle = getTitle();
        Assert.assertEquals(actulPageTitle,searchADoctorpageTitle);
        logPass("Page Title is : " + actulPageTitle);

    }
    
    public static void clickOnSearchByName() throws InterruptedException{	
    	datatable = new XlsReader(PROJECTDIR + "/testdata/TestInput.xlsx");
    	String searchValue=datatable.getCellData("Search", 0, 3);
    	switchIframeByID("myIframe");
    	search_textbox.sendKeys(searchValue);
    	waitAndClick(searchByName);
		try {
			 logInfo("clicking on search");
    	waitAndClick(searchButton);
    	 logPass("search selected");
		}catch(ElementClickInterceptedException e) {	
			waitAndClick(searchButton);
			logPass("search selected");
		}catch(TimeoutException ex) {
			waitAndClick(helpYou);
			waitAndClick(searchButton);
			ex.printStackTrace();	
		}
		}

    
    public static void goToDoctorProfilePage() throws InterruptedException {
		PageFactory.initElements(driver, FADSearchPage.class);
    
//    try {
//    	logInfo("Clicking on doctor");
//    	String ui=doc_profile.getText();
//    	 System.out.println("UI docname is:"+ui);
//		waitAndClick(doc_profile);
//
//	}catch(TimeoutException e){
//		logInfo("Clicking on doctor");
//		waitAndClick(doc_profileMB);	
//	}
		try {
		 String platform = getPlatform().toLowerCase();
		 if("desktop_local".equalsIgnoreCase(platform)) {
 	    	logInfo("Clicking on doctor and getting info");
 	    	String ui=doc_profile.getText();
	    	 System.out.println("UI docname is:"+ui);
 			waitAndClick(doc_profile);
 	  }else if(getPlatform().equalsIgnoreCase("desktop_browserstack")) {
 		  logInfo("Clicking on doctor and getting info");
 		// Thread.sleep(20000);
		waitAndClick(doc_profile);
			 
		}else if(getPlatform().equalsIgnoreCase("mobile_browser_browserstack")) {
			logInfo("Clicking on doctor");
			waitAndClick(doc_profileMB);	
 			 
 		}
			}catch(TimeoutException e){
			logInfo("Clicking on doctor");
			Thread.sleep(20000);
			waitAndClick(doc_profile);	
		}
    }
    
    public static void verifyDoctorProfilePageTitle() throws InterruptedException {
    	datatable = new XlsReader(PROJECTDIR + "/testdata/TestInput.xlsx");
        PageFactory.initElements(driver, FADVerifyPage.class);
        String searchADoctorpageTitle=datatable.getCellData("Expected_Value", 0, 8);
        String actulPageTitle = getTitle();
        Assert.assertEquals(actulPageTitle,searchADoctorpageTitle);
        logPass("Page Title is : " + actulPageTitle);
    }
    
    public static void verifyAPISearchDoctorPageCompare() throws InterruptedException {
        PageFactory.initElements(driver, FADSearchPage.class);
    	  String uiDoctorName = "";
    	  String platform = getPlatform().toLowerCase();
    	 
    	  if("desktop_local".equalsIgnoreCase(platform)) {
    	    	logInfo("Clicking on doctor and getting info");
    	    	  uiDoctorName = doc_profile.getText();
    	  }else if(getPlatform().equalsIgnoreCase("desktop_browserstack")) {
    		  logInfo("Clicking on doctor and getting info");
    		  System.out.print(getPlatform());
 			 uiDoctorName = doc_profile.getText();	
			 
 		}else if(getPlatform().equalsIgnoreCase("mobile_browser_browserstack")) {
 			logInfo("Clicking on doctor and getting info");
    			 uiDoctorName = doc_profileMB.getText();	
    			 
    		}
    	 
   
    	  String[] doctorNameParts = uiDoctorName.split(",");
    	  String modifiedDoctorNameui = doctorNameParts[0].trim();
    	  logPass("UI doc name in search page  is:"+modifiedDoctorNameui);
    	  logPass("API doc nmae in profile page  is:"+getAPIInfo());
    	   if(getAPIInfo() !=null) {
       
        Assert.assertEquals(getAPIInfo(), modifiedDoctorNameui,"Doctor's name doesn't match between API and UI");
       }
    	   
    	   else {
    		   logFail("API does not return a valid doctor name:");
       
       }
    }
    
    
    public static void verifyAPIDoctorProfilePageValidation() throws InterruptedException {
        PageFactory.initElements(driver, FADSearchPage.class);
        switchTabs();
    	  String xpathExp="//h1";
	    	WebElement uiDoctorName=driver.findElement(By.xpath(xpathExp));
		   String uiDoctorName1 =uiDoctorName.getText();
    	  System.out.println("UI doc nmae and degree is:"+uiDoctorName1);
    	  String[] doctorNameParts = uiDoctorName1.split(",");
    	  String modifiedDoctorNameui = doctorNameParts[0].trim();
    	  System.out.println("UI doc nmae is:"+modifiedDoctorNameui);
    	  logPass("UI doc name in profile page is:"+modifiedDoctorNameui);
    	  logPass("API doc name in profile page is:"+getAPIInfo());
    	   if(getAPIInfo() !=null) {
        Assert.assertEquals(getAPIInfo(), modifiedDoctorNameui,"Doctor's name doesn't match between API and UI");
       }
    	   
    	   else {
    	   logFail("API does not return a valid doctor name:");
       
       }
    }
    
    public static String getPlatform(){
    	Properties config = new Properties();
		try(FileInputStream ip = new FileInputStream(PROJECTDIR +"/config/config.properties")) {
		config.load(ip);
		}catch(IOException e) {
			e.printStackTrace();
			
		}
		return config.getProperty("platform");
    }
    

    public static String getAPIInfo() throws InterruptedException {
    	datatable = new XlsReader(PROJECTDIR + "/testdata/TestInput.xlsx");
        String baseURI1=datatable.getCellData("Base_URI", 0, 2);
        RestAssured.baseURI = baseURI1;
        String speciality=datatable.getCellData("Search", 0, 3);
        String pageSize=datatable.getCellData("Base_URI", 0, 3);
        String type=datatable.getCellData("Base_URI", 0, 4);
        String responseFields=datatable.getCellData("Base_URI", 0, 5);
        String fad=datatable.getCellData("Base_URI", 0, 6);
		 String response = RestAssured.given().queryParam("type", type).queryParam("specialty", speciality).queryParam("pageSize", pageSize).queryParam("responseFields", responseFields).when().get(fad).then().extract().asString();
	    //logInfo("response is:"+response);
	    JsonPath jsonPath = new JsonPath(response);
	    String apiDoctorName = jsonPath.getString("results.people[0].fullName");
	    logPass("API doc nmae is:"+apiDoctorName);
    	  return apiDoctorName;
    }
    
    

 }
