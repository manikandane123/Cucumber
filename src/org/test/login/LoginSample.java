package org.test.login;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSample {
	static WebDriver driver;

	@Given("^I want enter the demoguru$")
	public void i_want_enter_the_demoguru_page() {
		System.setProperty("webdriver.chrome.driver", "D:\\Mani\\GreensTech\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/v4/");
		driver.manage().window().maximize();

	}

	@When("^Enter username and password$")
	public void enter_username_and_password() {
		driver.findElement(By.name("uid")).sendKeys("mani");
		driver.findElement(By.name("password")).sendKeys("Pass");
	}

	@When("^Click reset button$")
	public void click_reset_button() {
		driver.findElement(By.name("btnReset")).click();

	}

	@Then("^I validate the outcomes$")
	public void i_validate_the_outcomes() {
		Assert.assertEquals("",  driver.findElement(By.name("uid")).getAttribute("value"));
		Assert.assertEquals("", driver.findElement(By.name("password")).getAttribute("value"));
	}

}
