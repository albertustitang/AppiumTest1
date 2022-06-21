package com.nexsoft.testng.dashboard;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.checkerframework.common.util.report.qual.ReportCall;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CRUDBuilderTest {
	WebDriver driver;

	@BeforeClass
	public void init() {
		System.setProperty("url", "http://localhost/cicool");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(System.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	 @Test(dataProvider = "getNexSoftData", dataProviderClass = com.nexsoft.testng.dataprovider.DataProviderNexSoft.class)
		public void cobaDulu(String param1, String param2, String param3) {
			System.out.println(param1+param2+param3);
			Reporter.log("Nama: " + param1+ "Email: " + param2 + "Location: "+ param3);
		}

	@Test(priority = 0)
	public void login() {
		driver.findElement(By.cssSelector(".fa.fa-sign-in")).click();

		driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("albertustitang@gmail.com");
		// input[placeholder='Password']
		driver.findElement(By.cssSelector("input[placeholder='Password']")).clear();
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("@Yogyakarta99");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		String username = driver.findElement(By.cssSelector("span[class='hidden-xs']")).getText();
		Assert.assertEquals(username, "Albertustitang");

	}

	@Test(priority = 1)
	public void createData() {

		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		System.out.println( "create data --> "+ sdf2.format(new  Date().getTime()));
		driver.findElement(By.linkText("CRUD Builder")).click();
	    
	    driver.findElement(By.linkText("see")).click();
	  
	    driver.findElement(By.id("btn_add_new")).click();
	   
	    driver.findElement(By.id("username")).click();
	   
	    driver.findElement(By.id("username")).sendKeys("Eva Adam");
	    
	    driver.findElement(By.id("email")).sendKeys("email@ba.com");
	   
	    driver.findElement(By.id("location")).sendKeys("1231121");
	   
	    driver.findElement(By.linkText("Save and go to list")).click();
	    
	    List<WebElement> lstUsername = driver
	    		.findElements(By.xpath("/html[1]/body[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/table[1]/tbody[1]/tr/td/span[@class='list_group-username']"));
	    
	    for (WebElement webElement : lstUsername) {
			System.out.println(webElement.getText());
		}
	    
	    System.out.println("Nama terakhir" +lstUsername.get(lstUsername.size()-1).getText());
	}

	@Test(priority = 2)
	public void getUsername() {
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		System.out.println(
				driver.findElement(By.linkText("Albertustitang")).getText() + sdf2.format(new Date().getTime()));
	}

	@Test(priority = 3)
	public void getUsername2() {
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		System.out.println(
				driver.findElement(By.linkText("Albertustitang")).getText() + sdf2.format(new Date().getTime()));
	}
}