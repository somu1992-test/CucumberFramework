package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.ElementUtils;

public class RegisterPage {
	
	WebDriver driver;
	
	private ElementUtils elementUtils;
	
	public RegisterPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstName;
	
	@FindBy(id="input-lastname")
	private WebElement lastName;
	
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(id="input-telephone")
	private WebElement telephone;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPassword;
	
	@FindBy(name="newsletter")
	private WebElement newsLetter;
	
	@FindBy(xpath="//input[@name='agree'][@value='1']")
	private WebElement privacyPolicy;
	
	@FindBy(xpath="//input[@type='submit'][@value='Continue']")
	private WebElement continueBtn;
	
	@FindBy(xpath ="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningDuplicateAcc;
	
	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement warningMsgFirstName;
	
	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement warningMsgLastName;
	
	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement warningMsgEmail;
	
	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement warningMsgTelephone;
	
	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement warningMsgPassword;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMsgPrivacyPolicy;
	
	public void enterFirstname(String firstname) 
	{
		elementUtils.typeTextIntoElement(firstName, firstname, 30);
		
	}
	public void enterLastname(String lastname) 
	{
		elementUtils.typeTextIntoElement(lastName, lastname, 30);
		
	}
	public void enterEmail(String Email) 
	{
		elementUtils.typeTextIntoElement(email, Email, 30);
		
	}
	public void enterTelephone(String Telephone) 
	{
		elementUtils.typeTextIntoElement(telephone, Telephone, 30);
		
	}
	public void enterPassword(String Password) 
	{
		elementUtils.typeTextIntoElement(password, Password, 30);
		
	}
	public void enterConfirmPassword(String cnfpwd) 
	{
		elementUtils.typeTextIntoElement(confirmPassword, cnfpwd, 30);
		
	}
	public void newsLetterYes() 
	{
		elementUtils.clickOnElement(newsLetter, 30);
		
	}
	public void clickPrivacyPolicy() 
	{
		elementUtils.clickOnElement(privacyPolicy, 30);
		
	}
	
	public AccountSuccessPage clickConinueBtn() 
	{
		elementUtils.clickOnElement(continueBtn, 30);
		
		return new AccountSuccessPage(driver);
	}
	
	public boolean warningMsgDuplicateacc() 
	{
		
		return elementUtils.getTextFromElement(warningDuplicateAcc, 30).contains("Warning: E-Mail Address is already registered!");
	}
	
	public String getWarningMsgFirstName() 
	{
		
		return elementUtils.getTextFromElement(warningMsgFirstName, 30);
	
	}
	
	public String getWaringMsgLastName() 
	{
		          
		return elementUtils.getTextFromElement(warningMsgLastName, 30);
		
	}
	
	public String getWaringMsgEmail() 
	{
		return elementUtils.getTextFromElement(warningMsgEmail, 30);
	}
	
	public String getWarningMsgTelephone() 
	{
		return elementUtils.getTextFromElement(warningMsgTelephone, 30);
	}
	
	public String getWarningMsgPassword() 
	{
		return elementUtils.getTextFromElement(warningMsgPassword, 30);
	}
	
	public boolean warningMsgOfPrivacyPolicy() 
	{
		return elementUtils.getTextFromElement(warningMsgPrivacyPolicy, 30).contains("Warning: You must agree to the Privacy Policy!");
	}

}
