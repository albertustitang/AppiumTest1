package com.nexsoft.appium;



import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import static org.testng.Assert.assertEquals;

import java.util.Hashtable;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class CalculatorFunctionTest {

	public AndroidDriver driver;
	public Hashtable<String, WebElement> keys;

	@AndroidFindBy(id = "com.google.android.calculator:id/digit_1")
	private WebElement btn1;
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_2")
	private WebElement btn2;
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_3")
	private WebElement btn3;
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_4")
	private WebElement btn4;
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_5")
	private WebElement btn5;
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_6")
	private WebElement btn6;
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_7")
	private WebElement btn7;
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_8")
	private WebElement btn8;
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_9")
	private WebElement btn9;
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_0")
	private WebElement btn0;

	@AndroidFindBy(id = "com.google.android.calculator:id/op_add")
	private WebElement btnTambah;
	@AndroidFindBy(id = "com.google.android.calculator:id/op_sub")
	private WebElement btnKurang;
	@AndroidFindBy(id = "com.google.android.calculator:id/op_mul")
	private WebElement btnKali;
	@AndroidFindBy(id = "com.google.android.calculator:id/op_div")
	private WebElement btnBagi;
	@AndroidFindBy(id = "com.google.android.calculator:id/eq")
	private WebElement btnSamaDengan;
	@AndroidFindBy(id = "com.google.android.calculator:id/result_final")
	private WebElement btnResult;
	

	public void mapping() {

		keys = new Hashtable<String, WebElement>();
		keys.put("0", btn0);
		keys.put("1", btn1);
		keys.put("2", btn2);
		keys.put("3", btn3);
		keys.put("4", btn4);
		keys.put("5", btn5);
		keys.put("6", btn6);
		keys.put("7", btn7);
		keys.put("8", btn8);
		keys.put("9", btn9);
		keys.put("+", btnTambah);
		keys.put("-", btnKurang);
		keys.put("*", btnKali);
		keys.put("/", btnBagi);
		keys.put("=", btnSamaDengan);
		keys.put("result", btnResult);
	}

	public CalculatorFunctionTest(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
		mapping();
	}

	public void tambah(int a, int b) {

		String expectedResult = String.valueOf(a + b);
		keys.get(String.valueOf(a)).click();
		keys.get("+").click();
		keys.get(String.valueOf(b)).click();
		keys.get("=").click();
		String hasil = keys.get("result").getText();		
		
		assertEquals(hasil, expectedResult);
	}

	public void kurang(int a, int b) {

		String expectedResult = String.valueOf(a - b);
		keys.get(String.valueOf(a)).click();
		keys.get("-").click();
		keys.get(String.valueOf(b)).click();
		keys.get("=").click();
		String hasil = keys.get("result").getText();
		
		assertEquals(hasil, expectedResult);

	}

	public void kali(int a, int b) {

		String expectedResult = String.valueOf(a * b);
		keys.get(String.valueOf(a)).click();
		keys.get("*").click();
		keys.get(String.valueOf(b)).click();
		keys.get("=").click();
		String hasil = keys.get("result").getText();
		
		assertEquals(hasil, expectedResult);

	}

	public void bagi(int a, int b) {

		String expectedResult = String.valueOf(a / b);
		keys.get(String.valueOf(a)).click();
		keys.get("/").click();
		keys.get(String.valueOf(b)).click();
		keys.get("=").click();
		String hasil = keys.get("result").getText();
		
		assertEquals(hasil, expectedResult);

	}

}
