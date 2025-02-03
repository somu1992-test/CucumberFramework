package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.ElementUtils;

public class HomePage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	public HomePage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement Myacbtn;
	
	@FindBy(linkText ="Login")
	private WebElement Loginbtn;
	
	@FindBy(linkText = "Register")
	private WebElement registerOption;
	
	@FindBy(name="search")
	private WebElement searchbox;
	
	@FindBy(xpath="//button[contains(@class,'btn-lg')]/preceding::span[@class='input-group-btn']")
	private WebElement searchBtn;
	
	public void clickOnMyacbtn() 
	{
		elementUtils.clickOnElement(Myacbtn,30);
		
	}
	
	public LoginPage clickOnLogin() 
	{
		elementUtils.clickOnElement(Loginbtn,30);
		
		return new LoginPage(driver);
	}
	
	public RegisterPage rigisterOption() 
	{
		elementUtils.clickOnElement(registerOption,30);
		
		return new RegisterPage(driver);
	}
	
	public void enterTextintoSearchBox(String prodName) 
	{
		elementUtils.typeTextIntoElement(searchbox, prodName, 30);
		
	}
	
	public SearchResultPage clickOnSearchBtn() 
	{
		elementUtils.clickOnElement(searchBtn,30);
		
		return new SearchResultPage(driver);
	}
	

}
