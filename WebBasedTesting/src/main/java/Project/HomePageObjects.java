package Project;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {
	WebDriver driver;
	
	public HomePageObjects(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table[@table-title='Smart Table example']")
	WebElement table;
	
	@FindBy(tagName="tr")
	List<WebElement> noRows;
	
	
	
	public void TableValidation()
	{
		if(table.isDisplayed()){
			
			System.out.println("Number of Rows in the given table are:"+noRows.size());
		}
		else {
			System.out.println("Table is not displayed on the page");
		}
	}




}

