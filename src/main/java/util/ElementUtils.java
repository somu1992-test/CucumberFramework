package util;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	
	WebDriver driver;
	
	//private WebDriverWait wait;
	
	public ElementUtils(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	public WebElement waitForElementToBeClickble(WebElement element,long durationInSeconds) 
	{
		WebElement webElement=null;
		try {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		
		webElement=wait.until(ExpectedConditions.elementToBeClickable(element));
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return  webElement;
		
		
	}
	public WebElement waitForElementToBeVisible(WebElement element,long durationInSeconds) 
	{
		WebElement webElement=null;
		
		try {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Throwable e) 
		{
			e.printStackTrace();
		}
		
		return webElement;
	}
	
	public Alert waitForAlert(long durationInSeconds) 
	{
		Alert alert=null;
		
		try {
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		
		alert=wait.until(ExpectedConditions.alertIsPresent());
		
		
		}catch(Throwable e) 
		{
			e.printStackTrace();
		}
		
		return alert;
	}
	
	
	
	public void clickOnElement(WebElement element,long durationInSeconds) 
	{
		WebElement webElement=waitForElementToBeClickble(element, durationInSeconds);
		
		webElement.click();
	}
	
	public void typeTextIntoElement(WebElement element,String text,long durationInSeconds) 
	{
		WebElement webElement=waitForElementToBeClickble(element, durationInSeconds);
		
		webElement.click();
		webElement.clear();
		webElement.sendKeys(text);
	}
	
	public void mouseHoverAndClick(WebElement element,long durationInSeconds) 
	{
		WebElement webElement=waitForElementToBeVisible(element,durationInSeconds);
		
		Actions actions=new Actions(driver);
		
		actions.moveToElement(webElement).build().perform();
	}
	
	public void acceptAlert(long durationInSeconds) 
	{
		Alert alert=waitForAlert(durationInSeconds);
		
		alert.accept();
	}
	
	public void dismissAlert(long durationInSeconds) 
	{
		Alert alert=waitForAlert(durationInSeconds);
		
		alert.dismiss();
	}
	
	public void javaScriptClick(WebElement element,long durationInSeconds) 
	{
		WebElement webElement=waitForElementToBeVisible(element, durationInSeconds);
		
		JavascriptExecutor jse=((JavascriptExecutor)driver);
		
		jse.executeScript("arguments[0].click();", webElement);
	}
	
	public void javaScriptType(WebElement element,long durationInSeconds,String typeText) 
	{
		WebElement webElement=waitForElementToBeVisible(element, durationInSeconds);
		
		JavascriptExecutor jse=((JavascriptExecutor)driver);
		
		jse.executeScript("arguments[0].value='"+typeText+"'", webElement);
		
		
	}
	
	public String getTextFromElement(WebElement element,long durationInSeconds) 
	{
		WebElement webElement=waitForElementToBeClickble(element,durationInSeconds);
		
		return webElement.getText();
	}
	
	public boolean getElementIsDisplayed(WebElement element,long durationInSeconds) 
	{
		try {
		WebElement webElement=waitForElementToBeClickble(element,durationInSeconds);
		
		
		return webElement.isDisplayed();
		}catch(Throwable e) 
		{
			return false;
		}
	}

}
