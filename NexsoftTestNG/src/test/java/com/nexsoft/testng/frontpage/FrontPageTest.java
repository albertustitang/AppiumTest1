package com.nexsoft.testng.frontpage;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FrontPageTest {
	WebDriver driver;

	public String screenshoot() {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String waktu = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String namaFile = "D:\\TestScreenshoot\\"+waktu+".png";
		File screenshoot = new File(namaFile);
		
		try {
			FileUtils.copyFile(srcFile, screenshoot);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return namaFile;
	}

	@Test(dataProvider = "data-provider", dataProviderClass = com.nexsoft.testng.dataprovider.DataProviderNexSoft.class)
	public void consumeData(String data) {
		System.out.println(data);
	}

	@BeforeClass
	public void init() {
		System.setProperty("url", "http://localhost/cicool");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(System.getProperty("url"));
	}

	@Test
	public void login() {
		driver.findElement(By.cssSelector(".fa.fa-sign-in")).click();

		driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("albertustitang@gmail.com");

		driver.findElement(By.cssSelector("input[placeholder='Password']")).clear();
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("@Yogyakarta99");

		driver.findElement(By.cssSelector("button[type='submit']")).click();

		String file = "<img src='file://"+screenshoot()+"'height=\"800\" width=\"1280\"/>";


		Reporter.log(file);

		String username = driver.findElement(By.cssSelector("span[class='hidden-xs']")).getText();
		assertEquals(username, "Albertustitang");
	}

	@Test
	public void setLanguage() {

	}

}
