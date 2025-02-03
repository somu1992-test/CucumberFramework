package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.ElementUtils;

public class LoginPage {

	WebDriver driver;
	
	private ElementUtils elementUtils;
	
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(id="input-email")
	private WebElement emailText;
	
	@FindBy(id="input-password")
	private WebElement pwdText;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement Loginbutn;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement waringMsgAbtCredMisMatch;
	
	
	
	public void enterEmailText(String emailtext) 
	{
		elementUtils.typeTextIntoElement(emailText, emailtext, 30);
		
	}
	
	public void enterPwdText(String pwd) 
	{
		elementUtils.typeTextIntoElement(pwdText, pwd, 30);
		
	}
	
	public AccountPage clickOnLoginbutn() 
	{
		elementUtils.clickOnElement(Loginbutn, 30);
		
		return new AccountPage(driver);
	}
	
	public String verifyCredMisMatch() 
	{
		return elementUtils.getTextFromElement(waringMsgAbtCredMisMatch, 30);
	}
}
