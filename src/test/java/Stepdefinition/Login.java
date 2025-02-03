package Stepdefinition;

import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import DriverFactory.DriverFactory;
import Pages.AccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.CommonUtils;

public class Login {

	WebDriver driver;
	private LoginPage login;
	private AccountPage ac;
	private HomePage home;
	
	@Given("user navigates to login page")
	public void user_navigates_to_login_page() {
		driver=DriverFactory.getDriver();
		
		home=new HomePage(driver);
		
		home.clickOnMyacbtn();
		login=home.clickOnLogin();
	    
	    
	}

	@When("user enters valid email adress {string} into email field")
	public void user_enters_valid_email_adress_into_email_field(String validemailText) {
		
		 //login=new LoginPage(driver);
		 login.enterEmailText(validemailText);
		 
	    //driver.findElement(By.id("input-email")).sendKeys(validemailText);
	}
	@And("user enters valid pwd {string} into pwd field")
	public void user_enters_valid_pwd_into_pwd_field(String validpwd) {
		
		login.enterPwdText(validpwd);
		
		//driver.findElement(By.id("input-password")).sendKeys(validpwd);
	}

	

	@And("user clicks on login button")
	public void user_clicks_on_login_button() {
		
		ac=login.clickOnLoginbutn();
		
	    //driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@Then("user should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
		//AccountPage acpage=new AccountPage(driver);
	    Assert.assertTrue(ac.verifyLoginSuccess());
	}

	@When("user enters invalid email adress  into email field")
	public void user_enters_invalid_email_adress_into_email_field() {
		
		//login=new LoginPage(driver);
		
		login.enterEmailText(CommonUtils.getEmailWithTimeStamp());
		
	    //driver.findElement(By.id("input-email")).sendKeys(CommonUtils.getEmailWithTimeStamp());
	}

	@And("user enters invalid pwd {string} into pwd field")
	public void user_enters_invalid_pwd_into_pwd_field(String invalidpwd) {
		
		login.enterPwdText(invalidpwd);
		
	    //driver.findElement(By.id("input-password")).sendKeys(invalidpwd);
	}

	@Then("user should get warning msg about credentials mismatch")
	public void user_should_get_warning_msg_about_credentials_mismatch() {
	    Assert.assertTrue(login.verifyCredMisMatch().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	

	@When("user dont enter any email adress  into email feild")
	public void user_dont_enter_any_email_adress_into_email_feild() {
		
		//login=new LoginPage(driver);
		
		login.enterEmailText(" ");
		
		//driver.findElement(By.id("input-email")).sendKeys(" ");
	}

	@And("user dont enter any pwd  into pwd field")
	public void user_dont_enter_any_pwd_into_pwd_field() {
		
		login.enterPwdText(" ");
		
		//driver.findElement(By.id("input-password")).sendKeys(" ");
	}
	
	




	}

