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

public class ListOnly {
	static WebDriver driver;

	@Given("^I want open the demoguru site$")
	public void i_want_open_the_demoguru_site() {
		System.setProperty("webdriver.chrome.driver", "D:\\Mani\\GreensTech\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/v4/");
		driver.manage().window().maximize();

	}

	@When("^Pass the username and Password using List$")
	public void pass_the_username_and_Password_using_List(DataTable credentials) {
		List<String> credentialList = credentials.asList(String.class);
		driver.findElement(By.name("uid")).sendKeys(credentialList.get(0));
		driver.findElement(By.name("password")).sendKeys(credentialList.get(1));
	}

	@When("^Click the reset button$")
	public void click_the_reset_button() {
		driver.findElement(By.name("btnReset")).click();
	}

	@Then("^Check the outcomes$")
	public void check_the_outcomes() {
		Assert.assertEquals("", driver.findElement(By.name("uid")).getAttribute("value"));
		Assert.assertEquals("", driver.findElement(By.name("password")).getAttribute("value"));

	}

}
