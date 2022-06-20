package com.nexsoft.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nexsoft.testing.SignInPage;

public class HomePage {

	protected WebDriver driver;

//	@FindBy(xpath ="//a[@class='page-scroll']" )
//	private WebElement signIn;

	@FindBy()
	private WebElement languageSetting;

	@FindBy(xpath = "//a[normalize-space()='Logout']")
	private WebElement btnLogout;

	@FindBy(xpath = "//a[@class='page-scroll dropdown-toggle']")
	private WebElement btnDashboardUsername;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public SignInPage clickSignIn() {

		signIn.click();

		SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);

		return signInPage;
	}

	public void logout() {

		btnDashboardUsername.click();
		btnLogout.click();

	}
}
