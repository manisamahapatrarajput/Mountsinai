package com.pageobjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.utils.CommonUtils;

public class HomePageMB extends CommonUtils {

  static String pageTitle="Mount Sinai Health System - New York City | Mount Sinai - New York";


private WebDriver driver;

public HomePageMB(WebDriver driver) {
    this.driver = driver;
}
//Page locators
public static void verifyPageTitle() throws InterruptedException {
   
    waitForPageTitle(pageTitle);
    String actulPageTitle = getTitle();
    Assert.assertEquals(actulPageTitle,pageTitle);
    logPass("Page Title is : " + actulPageTitle);

}
}

