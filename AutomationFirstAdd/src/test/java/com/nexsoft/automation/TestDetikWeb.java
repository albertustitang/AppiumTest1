package com.nexsoft.automation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestDetikWeb {

	public static WebDriver driver;
	private JavascriptExecutor jse;

	@BeforeAll
	public void createDriver() {
		System.out.println("Run Each");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@Order(1)
	@DisplayName("Login")
	@Test
	public void gotoWeb_andLogin_withUsername_withPassword() {
		driver.get("http://localhost/cicool");
		driver.findElement(By.cssSelector(".fa.fa-sign-in")).click();

//		driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
//		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("albertustitang@gmail.com");

		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("albertustitang@gmail.com");

		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("@Yogyakarta99");

		driver.findElement(By.cssSelector(".btn.btn-primary.btn-block.btn-flat")).click();

//		String errorActual = driver.findElement(By.cssSelector("div[class='callout callout-error'] p")).getText();
//		String errorExpected = "E-mail Address and Password do not match.";
//		assertEquals(errorActual, errorExpected);

//		driver.close();

	}

	@Order(2)
	@DisplayName("Screen1")
	@Test
	public void goTo_Screen_CRUD() {

//		driver.get("http://localhost/cicool/administrator/user/profile");
		driver.findElement(By.cssSelector("a[href='http://localhost:80/cicool/administrator/crud']")).click();

		driver.findElement(By.cssSelector("tbody tr a:nth-child(1)")).click();

	}

	@Order(3)
	@DisplayName("insert data")
	@Test
	public void insert_data() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.cssSelector("#btn_add_new")).click();

		driver.findElement(By.cssSelector("#username")).click();
		driver.findElement(By.cssSelector("#username")).sendKeys("Kael");

		driver.findElement(By.cssSelector("#email")).click();
		driver.findElement(By.cssSelector("#email")).sendKeys("mikael@ymail.com");

		driver.findElement(By.cssSelector("#location")).click();
		driver.findElement(By.cssSelector("#location")).sendKeys("Yogyakarta");

		driver.findElement(By.xpath("//a[@id='btn_save']")).click();

	}

	@DisplayName("Show All Data")
	@Order(4)
	@Test
	public void showAllData() {
		List<WebElement> lstUname = driver.findElements(By.xpath(
				"//html[1]/body[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/table[1]/tbody[1]/tr/td[2]"));
		List<WebElement> lstEmail = driver.findElements(By.xpath(
				"//html[1]/body[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/table[1]/tbody[1]/tr/td[3]"));
		List<WebElement> lstLocation = driver.findElements(By.xpath(
				"//html[1]/body[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/table[1]/tbody[1]/tr/td[4]"));

		//
		for (WebElement webElement : lstUname) {
			System.out.println(webElement.getText());
		}
		System.out.println("Username data terakhir adalah " + lstUname.get(lstUname.size() - 1).getText());
		System.out.println();

		//
		for (WebElement webElement : lstEmail) {
			System.out.println(webElement.getText());
		}
		System.out.println("Email data terakhir adalah " + lstEmail.get(lstEmail.size() - 1).getText());
		System.out.println();

		//
		for (WebElement webElement : lstLocation) {
			System.out.println(webElement.getText());
		}
		System.out.println("Lokasi data terakhir adalah " + lstLocation.get(lstLocation.size() - 1).getText());
		System.out.println();

//		driver.findElement(By.cssSelector(".btn.btn-flat.btn-success[href='http://localhost:80/cicool/administrator/absensi/export?q=&f=']")).click();

	}

//	@DisplayName("Delete Data Directly")
//	@Order(5)
//	@Test
//	public void deleteDataCRUD() {
//		driver.findElement(By.cssSelector("#btn_cancel")).click();
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		driver.findElement(By.cssSelector(".confirm")).click();
//		jse.executeScript("scroll(0, 150);");
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		driver.findElement(By.cssSelector(".iCheck-helper")).click();
//		driver.findElement(By.cssSelector("#apply")).click();
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		driver.findElement(By.xpath("//button[@class='confirm']")).click();
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		driver.close();
//	}

	@Disabled
	@DisplayName("Login")
	@Test
	public void gotoWeb1_andLogin_withUsername_withPassword() {
		driver.get("http://localhost/cicool/administrator/profile/logout");

		driver.findElement(By.xpath("//a[@class='page-scroll']")).click();

		driver.findElement(By.xpath("//input[@placeholder='Email']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("albertustitang@gmail.com");

		driver.findElement(By.xpath("//input[@placeholder='Password']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("");

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		String errorMsg = driver
				.findElement(By.xpath("//p[normalize-space()='E-mail Address and Password do not match.']")).getText();

		assertEquals("E-mail Address and Password do not match.", errorMsg);

	}

}
