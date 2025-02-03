package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.ElementUtils;

public class SearchResultPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	//String products;
	public SearchResultPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		elementUtils=new ElementUtils(driver);
		
	}
	
	@FindBy(xpath = "//a[contains(text(),'MacBook')]")
	private List<WebElement> searchedProducts;
	
	@FindBy(xpath="//input[@id='button-search']/following-sibling::p")
	private WebElement warningMsgOfNoProductMaching;
	
	public boolean getSearchedProducts() 
	{
		String products="";
		
		for(int i=0;i<searchedProducts.size();i++) 
		{
			products=searchedProducts.get(i).getText();
		}
		
	     return products.contains("MacBook");
	     
	     
	}
	
	public String getNoProductMatchingMsg() 
	{
		
		return elementUtils.getTextFromElement(warningMsgOfNoProductMaching, 30);
		
	}
	

}
