package org.test.key;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ListofMap {
	static WebDriver driver;
	@Given("^I want to open the Demoguru home page$")
	public void i_want_to_open_the_Demoguru_home_page() {
		System.setProperty("webdriver.chrome.driver", "D:\\Mani\\GreensTech\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/v4/");
		driver.manage().window().maximize();
	}

	@When("^Pass the username and password using List of Map$")
	public void pass_the_username_and_password_using_List_of_Map(DataTable credentials) {
		List<Map<String, String>> credentialsMap = credentials.asMaps(String.class, String.class);
		driver.findElement(By.name("uid")).sendKeys(credentialsMap.get(2).get("username"));
		driver.findElement(By.name("password")).sendKeys(credentialsMap.get(2).get("password"));
	}

	@When("^Click reset button after pass the values$")
	public void click_reset_button_after_pass_the_values() {
		driver.findElement(By.name("btnReset")).click();
	}

	@Then("^I validate the expected values$")
	public void i_validate_the_expected_values() {
		Assert.assertEquals("", driver.findElement(By.name("uid")).getAttribute("value"));
		Assert.assertEquals("", driver.findElement(By.name("password")).getAttribute("value"));

	}

}
