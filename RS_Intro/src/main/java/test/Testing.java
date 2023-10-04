package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import driver.DriverSingleton;
import utility.ConfigReader;

public class Testing {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = DriverSingleton.getDriver();
	}

	@Test
	public void Test() {
		driver.get(ConfigReader.getStringValue("url"));
		System.out.println("===============================================");
		System.out.println("Title of the current page: \n" + driver.getTitle());
		System.out.println("\nUrl of the current page: \n" + driver.getCurrentUrl());
		System.out.println("===============================================");
	}

	@AfterMethod
	public void teadDown() {
		DriverSingleton.quitDriver();
	}
}
