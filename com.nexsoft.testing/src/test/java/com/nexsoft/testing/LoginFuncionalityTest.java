package com.nexsoft.testing;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginFuncionalityTest {

	protected WebDriver driver;

	@BeforeTest
	public void init() {
		System.setProperty("url", "http://localhost/cicool");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@BeforeMethod
	public void cekSession() {
		driver.get(System.getProperty("url"));

		// cek session user telah login atau belum

		HomePage home = PageFactory.initElements(driver, HomePage.class);

//		home.clickSignIn().loginValidUser("dewabrata@gmail.com", "123456");

//		driver.get(System.getProperty("url"));

//		home.logout();

	}

	@Test(priority = 1)
	public void testLoginWithValidUserAndPassword() {

		HomePage home = PageFactory.initElements(driver, HomePage.class);
//		SignInPage formSignIn = home.clickSignIn();
//		Dashboard dashboard =formSignIn.loginValidUser("dewabrata@gmail.com", "123456");
//		
//		dashboard.clickCrudBuilder().clickSeeButtonWithTitle("Absensi");

		Dashboard dash = home.clickSignIn().loginValidUser("dewabrata@gmail.com", "123456");

		Assert.assertEquals(dash.getUsername(), "Dewabrata");

	}

	@Test(priority = 2)
	public void testLoginWithValidUserAndWrongPassword() {

		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.logout();
		SignInPage signin = home.clickSignIn();

		Dashboard dashboard = signin.loginValidUser("dewabrata@gmail.com", "123");

		Assert.assertEquals(signin.getErrorPassword(), "E-mail Address and Password do not match.");

		try {
			dashboard.getUsername();
		} catch (Exception e) {
			assertTrue(true, "Text Tidak ditemukan " + e.getMessage());
		}

	}

}
