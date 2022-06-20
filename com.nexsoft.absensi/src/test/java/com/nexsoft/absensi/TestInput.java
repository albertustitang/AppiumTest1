package com.nexsoft.absensi;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestInput {

	public static WebDriver driver;

	@BeforeAll
	public void createDriver() {
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

		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("albertustitang@gmail.com");

		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("@Yogyakarta99");

		driver.findElement(By.cssSelector(".btn.btn-primary.btn-block.btn-flat")).click();

	}
	
	@Order(2)
	@DisplayName("Go to CRUD Builder")
	@Test
	public void goTo_CRUD_Builder() {


		driver.findElement(By.cssSelector("a[href='http://localhost:80/cicool/administrator/crud']")).click();

		driver.findElement(By.cssSelector("tbody tr a:nth-child(1)")).click();
		
		driver.findElement(By.cssSelector("#btn_add_new")).click();

	}
	
	
	
	
	
}
