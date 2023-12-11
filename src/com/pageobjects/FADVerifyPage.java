package com.pageobjects;

import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

import com.google.errorprone.annotations.Var;
import com.utils.CommonUtils;
import com.utils.XlsReader;

public class FADVerifyPage extends CommonUtils {

	@FindBy(linkText = "Find a Doctor")
	static WebElement fad_Link;
	@FindBy(xpath = " //input[contains(@id,'downshift')]")
	static WebElement search_textbox;
	@FindBy(xpath = "//span[@class='text-sm md:text-base' and text()='diology (Heart)']")
	static WebElement searchByName;
	@FindBy(xpath = "//button[text()='Search']")
	static WebElement searchButton;
	@FindBy(xpath = "//*[@title='Close welcome popup']")
	static WebElement helpYou;
	@FindBy(xpath = "//section[contains(@class,'md:ml-8 flex-1')]//article[@id='fad_results_Video Visit']//*[name()='svg'] | //section[contains(@class,'result__MobileAppContainer-cc60gj-0 bETpuh miniTab:hidden')]//article[@id='fad_results_Video Visit']//*[name()='svg']")
	static WebElement VideoVisitMB;
	@FindBy(xpath = "//div[contains(@class,'css-eyu88q-placeholder')][normalize-space()='Select Visit Type']")
	static WebElement VideoVisit_Type_Dropdown;
	@FindBy(xpath = "//div[@class='font-semibold'][normalize-space()='VIDEO VISIT - FOLLOW UP']")
	static WebElement VideoVisitDropdown;
	@FindBy(xpath = "//section[@class='result__DesktopAppContainer-cc60gj-1 kjrmly hidden miniTab:flex py-4']//div[1]//article[1]//div[1]//div[1]//div[1]//div[2]//div[1]//span[1]//div[1]//div[1]//button[1]")
	static WebElement timeSlot;
	@FindBy(css = "section[class='result__MobileAppContainer-cc60gj-0 bETpuh miniTab:hidden'] div:nth-child(1) article:nth-child(1) div:nth-child(1) div:nth-child(1) div:nth-child(1) div:nth-child(2) div:nth-child(1) span:nth-child(2) div:nth-child(1) div:nth-child(1) div:nth-child(3) button:nth-child(1)")
	static WebElement timeSlotMB;
	@FindBy(xpath = "//span[@class='schedule-appointment_breadcrumb__16FHe']")
	static WebElement searchResults;
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	static WebElement verifyCancel;
	@FindBy(xpath = "//button[normalize-space()='Yes']")
	static WebElement confirmCancel;
	@FindBy(xpath = "//h3[@class='schedule-appointment_primarydetails__ct3Pc capitalize']")
	static WebElement visitType;
	@FindBy(xpath = "//div[3]//h3[1]")
	static WebElement selectedTimeSlot;
	@FindBy(xpath = "//section[contains(@class,'md:ml-8 flex-1')]//article[@id='fad_results_Video Visit']//*[name()='svg']")
	static WebElement visitTypeDD;

    public FADVerifyPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    public static void navigateToUrl(String url) throws InterruptedException {

        PageFactory.initElements(driver, FADVerifyPage.class);
        navigateToURL(url);
        logInfo("HomePage Loaded");
    }
    
    public static void verifyPageTitle() throws InterruptedException {
    	datatable = new XlsReader(PROJECTDIR + "/testdata/TestInput.xlsx");
        PageFactory.initElements(driver, FADVerifyPage.class);
        String pageTitle=datatable.getCellData("Expected_Value", 0, 4);
        waitForPageTitle(pageTitle);
        String actulPageTitle = getTitle();
        Assert.assertEquals(actulPageTitle,pageTitle);
        logPass("Page Title is : " + actulPageTitle);

    }
    
    public static void goToFADPage() throws InterruptedException {
		PageFactory.initElements(driver, FADVerifyPage.class);
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
    
    public static void clickOnSearchByName() throws InterruptedException{
    	datatable = new XlsReader(PROJECTDIR + "/testdata/TestInput.xlsx");
    	String searchValue=datatable.getCellData("Search", 0, 2);
    	switchIframeByID("myIframe");
    	search_textbox.sendKeys(searchValue);
    	waitAndClick(searchByName);
		try {
			logInfo("Clicking on search");
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
    
    public static void selectVideoVisitRadioBtn() throws InterruptedException{
    	datatable = new XlsReader(PROJECTDIR + "/testdata/TestInput.xlsx");
    	String visitTypeValue=datatable.getCellData("Visit_Type", 0, 2);
		try{
			String xpathExpression="//section[contains(@class,'md:ml-8 flex-1')]//article[@id='fad_results_"+ visitTypeValue +" Visit']//*[name()='svg']";
	    	 WebElement VideoVisit=driver.findElement(By.xpath(xpathExpression));
			VideoVisit.click();
			logPass("radio button clicked desktop");
		}catch(ElementNotInteractableException e) {
			String xpathExp="//section[contains(@class,'result__MobileAppContainer-cc60gj-0 bETpuh miniTab:hidden')]//article[@id='fad_results_"+ visitTypeValue +" Visit']//*[name()='svg']";
	    	WebElement VideoVisitMB=driver.findElement(By.xpath(xpathExp));
		   waitAndClick(VideoVisitMB);
		   logPass("radio button clicked desktop");
		
	}
}
  

	public static void CheckVisitTypeAvailableFor_VideoVisit() throws InterruptedException{
		datatable = new XlsReader(PROJECTDIR + "/testdata/TestInput.xlsx");
    	String ExpectedvisitType=datatable.getCellData("Select Visit_Type", 0, 2);
			click(VideoVisit_Type_Dropdown);
			String xpathExpression="//div[@class='font-semibold'][normalize-space()='VIDEO VISIT - "+ ExpectedvisitType +"']";
	    	 WebElement VideoVisit=driver.findElement(By.xpath(xpathExpression));
			click(VideoVisit);
			 logPass("clicked video visit");
		}
	
	
    public static void verifySearchResultPageTitle() throws InterruptedException {
    	datatable = new XlsReader(PROJECTDIR + "/testdata/TestInput.xlsx");
        PageFactory.initElements(driver, FADVerifyPage.class);
       
        Thread.sleep(2000);
        String currentUrl = driver.getCurrentUrl();
        logInfo("getting currentUrl");
        logPass("Current url: " + currentUrl);
        String ExpectedUrl =datatable.getCellData("Expected_Value", 0, 7);
        boolean isUrlCorrect = currentUrl.contains(ExpectedUrl);
        if(isUrlCorrect) {
        	System.out.println("6515 present");
        	logPass("6515 present");
        	
        }else {
        	logFail("6515 is not  present");
        	
        }

    }
    

	public static void selectTimeSlot() throws InterruptedException{
	if(getPlatform().equalsIgnoreCase("desktop_local") || getPlatform().equalsIgnoreCase("desktop_browserstack") ) {
		System.out.println(getPlatform());
		waitForVisible(timeSlot);
		hoverOverAndClick(timeSlot);
		logPass("Verified : selected the appointment Time slot successfully");
		
	}
	else if(getPlatform().equalsIgnoreCase("mobile_browser_browserstack")) {
		System.out.println("Platform is:"+getPlatform());
		waitForVisible(timeSlotMB);
		waitAndClick(timeSlotMB);
		logPass("Verified : selected the appointment Time slot successfully");
		
	}
	}
    
    public static void verifyVideoVisit() throws InterruptedException {
    	datatable = new XlsReader(PROJECTDIR + "/testdata/TestInput.xlsx");
        PageFactory.initElements(driver, FADVerifyPage.class);
        String visitTypeVideo=visitType.getText();
        System.out.println("verifyVideoVisit Correct"+visitTypeVideo);
        logInfo("verifyVideoVisit Correct"+visitTypeVideo);
        String ExpectedVisitType =datatable.getCellData("Expected_Value", 0, 2);
        Assert.assertEquals(visitTypeVideo, ExpectedVisitType,"Video visit does not match");
        logPass("corrct visit type");
        
    }
    
    public static void verifyVideoVisitFollowUP() throws InterruptedException {
    	datatable = new XlsReader(PROJECTDIR + "/testdata/TestInput.xlsx");
        PageFactory.initElements(driver, FADVerifyPage.class);
        Thread.sleep(2000);
        String visitTypeVideo = driver.getPageSource();
        String ExpectedVisit =datatable.getCellData("Expected_Value", 0, 3);
        boolean ExpectedVisitType1 = visitTypeVideo.contains(ExpectedVisit);
        if(ExpectedVisitType1) {
        	logPass("VIDEO VISIT - FOLLOW UP still set");
        	
        }else {
        	logFail("VIDEO VISIT - FOLLOW UP not there");
        	
        }
    }
    
    
    public static void searchReults() throws InterruptedException {
		PageFactory.initElements(driver, FADVerifyPage.class);
		waitAndClick(searchResults);
		logPass("Clicked on searchResults");

	}
    
    public static void verifyCancel() throws InterruptedException {
		PageFactory.initElements(driver, FADVerifyPage.class);
		waitAndClick(verifyCancel);
		logPass("Clicked on cancel");

	}
    
    
    public static void confirmCancel() throws InterruptedException {
		PageFactory.initElements(driver, FADVerifyPage.class);
		waitAndClick(confirmCancel);
		logPass("Confirmed canceled");

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

 }
