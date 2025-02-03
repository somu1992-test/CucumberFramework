package Stepdefinition;

import java.util.Date;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import DriverFactory.DriverFactory;
import Pages.AccountSuccessPage;
import Pages.HomePage;
import Pages.RegisterPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import util.CommonUtils;

public class Register {

	WebDriver driver;
	private HomePage home;
	private RegisterPage reg;
	private AccountSuccessPage acc;

	@Given("user navigates to Register Account page")
	public void user_navigates_to_register_account_page() {
	    driver=DriverFactory.getDriver();
	    
	    home=new HomePage(driver);
	    
	    home.clickOnMyacbtn();
	    reg=home.rigisterOption();
	     
	    //driver.findElement(By.xpath("//span[text()='My Account']")).click();
	    
	    //driver.findElement(By.linkText("Register")).click();
	    
	    
	}

	@When("user enters details into below fields")
	public void user_enters_details_into_below_fields(DataTable dataTable) {
	    Map<String, String> dataMap=dataTable.asMap(String.class,String.class);
	    
	    reg.enterFirstname(dataMap.get("firstName"));
	    reg.enterLastname(dataMap.get("lastName"));
	    reg.enterEmail(CommonUtils.getEmailWithTimeStamp());
	    reg.enterTelephone(dataMap.get("telephone"));
	    reg.enterPassword(dataMap.get("password"));
	    reg.enterConfirmPassword(dataMap.get("password"));
	    
	    //driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstName"));
	    //driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastName"));
	    //driver.findElement(By.id("input-email")).sendKeys(CommonUtils.getEmailWithTimeStamp());
	    //driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
	    //driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
	    //driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));
	}

	@And("user selects privacy policy")
	public void user_selects_privacy_policy() {
		
		reg.clickPrivacyPolicy();
	    
		//driver.findElement(By.xpath("//input[@name='agree'][@value='1']")).click();
	}

	@And("user clicks on continue button")
	public void user_clicks_on_continue_button() {
		
		reg.clickConinueBtn();
	    
		//driver.findElement(By.xpath("//input[@type='submit'][@value='Continue']")).click();
	}

	@Then("user account should get created successfully")
	public void user_account_should_get_created_successfully() 
	{
	    acc=new AccountSuccessPage(driver);
		Assert.assertEquals("Your Account Has Been Created!", acc.getAccountSuccess());
	}
	
	@When("user enters details into below fields with duplicate email")
	public void user_enters_details_into_below_fields_with_duplicate_email(DataTable dataTable) 
	{
        Map<String, String> dataMap=dataTable.asMap(String.class,String.class);
	    
	    reg.enterFirstname(dataMap.get("firstName"));
	    reg.enterLastname(dataMap.get("lastName"));
	    reg.enterEmail(dataMap.get("email"));
	    reg.enterTelephone(dataMap.get("telephone"));
	    reg.enterPassword(dataMap.get("password"));
	    reg.enterConfirmPassword(dataMap.get("password"));
	}

	@And("user selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() 
	{
		reg.newsLetterYes();
		
	    //driver.findElement(By.name("newsletter")).click();
	}

	@Then("user should get warning msg about duplicate account")
	public void user_should_get_warning_msg_about_duplicate_account() 
	{
		
		
		Assert.assertTrue(reg.warningMsgDuplicateacc());
		
		//Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning: E-Mail Address is already registered!"));
	}

	@When("user dont enter any details into fields")
	public void user_dont_enter_any_details_into_fields() 
	{
		reg.enterFirstname("");
	    reg.enterLastname("");
	    reg.enterEmail("");
	    reg.enterTelephone("");
	    reg.enterPassword("");
	    reg.enterConfirmPassword("");
	    
	}

	

	@Then("user should get warning msg for every mandatory field")
	public void user_should_get_warning_msg_for_every_mandatory_field() {
	    
		Assert.assertTrue(reg.warningMsgOfPrivacyPolicy());
		Assert.assertEquals("First Name must be between 1 and 32 characters!", reg.getWarningMsgFirstName());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!", reg.getWaringMsgLastName());
		Assert.assertEquals("E-Mail Address does not appear to be valid!", reg.getWaringMsgEmail());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!", reg.getWarningMsgTelephone());
		Assert.assertEquals("Password must be between 4 and 20 characters!", reg.getWarningMsgPassword());
		
	}
	
	



}
