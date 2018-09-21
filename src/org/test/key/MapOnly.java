package org.test.key;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MapOnly {
	static WebDriver driver;
	
	@Given("^Demoguru using Map and pass the Key and Value$")
	public void demoguru_using_Map_and_pass_the_Key_and_Value() {
		System.setProperty("webdriver.chrome.driver", "D:\\Mani\\GreensTech\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/v4/");
		driver.manage().window().maximize();

	}

	@When("^Pass the username and password from map$")
	public void pass_the_username_and_password(DataTable credentials) {
		Map<String, String> credentialMap = credentials.asMap(String.class, String.class);
		driver.findElement(By.name("uid")).sendKeys(credentialMap.get("Username"));
		driver.findElement(By.name("password")).sendKeys(credentialMap.get("Password"));
	}

	@When("^Click on reset button$")
	public void click_on_reset_button() {
		driver.findElement(By.name("btnReset")).click();
	}

	@Then("^I validate the credentials$")
	public void i_validate_the_credentials() {
		Assert.assertEquals("", driver.findElement(By.name("uid")).getAttribute("value"));
		Assert.assertEquals("", driver.findElement(By.name("password")).getAttribute("value"));
	}



}
