package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class HomePage extends BaseClass
{
	public HomePage() 
	{
		PageFactory.initElements(driver, this);
	}

	
	
	
}
