package org.test.key;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ListofList {
	static WebDriver driver;
	@Given("^Open the Demoguru home page$")
	public void open_the_Demoguru_home_page() {
		System.setProperty("webdriver.chrome.driver", "D:\\Mani\\GreensTech\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/v4/");
		driver.manage().window().maximize();

	}

	@When("^Pass the username and password values$")
	public void pass_the_username_and_password_values(DataTable credentials) {
		List<List<String>> credentialLists = credentials.asLists(String.class);
		driver.findElement(By.name("uid")).sendKeys(credentialLists.get(3).get(0));
		driver.findElement(By.name("password")).sendKeys(credentialLists.get(3).get(1));
	}

	@When("^Reset the value$")
	public void reset_the_value() {
		driver.findElement(By.name("btnReset")).click();
	}

	
	@Then("^I validate the expected outcomes$")
	public void i_validate_the_expected_outcomes() {
		Assert.assertEquals("", driver.findElement(By.name("uid")).getAttribute("value"));
		Assert.assertEquals("", driver.findElement(By.name("password")).getAttribute("value"));
	}



}
