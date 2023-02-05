package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class HomePage extends BaseClass
{
	Actions act = new Actions(driver);
	
	public HomePage() 
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='MyConnect']")
	public WebElement myConnect;
	
	@FindBy(xpath = "//button[@aria-controls='new-search-block']")
	public WebElement search;
	
	@FindBy(xpath = "//a[@title='Time Card Application']")
	public WebElement timeCard;

	public String getMyConnect() {
		act.scrollToElement(myConnect).moveToElement(myConnect).click().build().perform();
		String title = driver.getTitle();
		return title;
	}

	public WebElement getSearch() {
		search.sendKeys("Payroll(HGS)");
		return search;
	}

	public WebElement getTimeCard() {
		act.moveToElement(timeCard).click().build().perform();
		return timeCard;
	}

	
}
