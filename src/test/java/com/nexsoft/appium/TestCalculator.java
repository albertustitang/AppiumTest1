package com.nexsoft.appium;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class TestCalculator {
	/*
	 * { "platformName": "Android", "appium:appActivity":
	 * "com.android.calculator2.Calculator", "appium:appPackage":
	 * "com.google.android.calculator" }
	 */

	protected AndroidDriver driver;
	public CalculatorFunctionTest calc;

	@BeforeTest
	public void init() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		capabilities.setCapability("appPackage", "com.google.android.calculator");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		calc = new CalculatorFunctionTest(driver);
	}

//	@Test(priority = 1)
//	public void test_tambah() {
//		calc.tambah(1, 3);
//	}
//
//	@Test(priority = 2)
//	public void test_kurang() {
//		calc.kurang(5, 3);
//	}
//
//	@Test(priority = 3)
//	public void test_kali() {
//		calc.kali(5,5);
//	}

	@Test(priority = 4)
	public void test_bagi() {
		calc.bagi(6, 2);
	}

}
