package Project;


import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddUserObjects {
WebDriver driver;
	
	public AddUserObjects(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//table[@table-title='Smart Table example']")
	WebElement table;
	
	@FindBy(tagName="tr")
	List<WebElement> noRows;

	@FindBy(xpath="//input[@name='FirstName']")
	WebElement FirstName;
	
	@FindBy(xpath="//input[@name='LastName']")
	WebElement LastName;
	
	@FindBy(xpath="//input[@name='UserName']")
	WebElement UserName;
	
	@FindBy(xpath="//input[@name='Password']")
	WebElement Password;
	
	@FindBy(xpath="//input[@value='15']")
	WebElement CompanyA;
	
	@FindBy(xpath="//input[@value='16']")
	WebElement CompanyB;
	
	@FindBy(xpath="//select[@name='RoleId']")
	WebElement RoleID;
	
	@FindBy(xpath="//input[@type='email']")
	WebElement EmailAddress;
	
	@FindBy(xpath="//input[@name='Mobilephone']")
	WebElement PhoneNumber;
	
	@FindBy(xpath="//*[contains(text(), 'Save')]")
	WebElement SaveButton;
	
	@FindBy(xpath="//button[@type='add']")
	WebElement AddUser;
	
	public WebElement SaveButton() {
		
		return SaveButton;
	}
	

public WebElement getFirstName() {
	
	return FirstName;
}

public WebElement getLastName() {
	
	return LastName;
}

public WebElement getUserName() {
	
	return UserName;
}

public WebElement getPwd() {
	
	return Password;
}

public WebElement CompanyA() {
	
	return CompanyA;
}
	

public WebElement CompanyB() {
	
	return CompanyB;
}


public void SelectRole() {
	
	Select s1=new Select(RoleID);
	s1.selectByValue("2");
}
public void SelectRole2() {
	
	Select s1=new Select(RoleID);
	s1.selectByValue("1");
}

public void SelectRole3() {
	
	Select s1=new Select(RoleID);
	s1.selectByValue("0");
}
public WebElement getEmailAddress() {
	
	return EmailAddress;
}

public WebElement getPhoneNumber() {
	
	return PhoneNumber;
}

public WebElement AddUser() {
	
	return AddUser;
}

public void AddUserDetails(String Firstname,String LastName,String UserName,String Pwd,String Email,String Cell) 
{
	
	Date d = new Date(System.currentTimeMillis());
	   getFirstName().sendKeys(Firstname);
	   getLastName().sendKeys(LastName);
	   getUserName().sendKeys(UserName+d);
	   getPwd().sendKeys(Pwd);
	   CompanyA().click();
	 //CompanyB().click();
	   SelectRole();
	   //SelectRole1();
	   getEmailAddress().sendKeys(Email);
	   getPhoneNumber().sendKeys(Cell);
	   SaveButton().click();
}


public boolean ValidationofAddDetails(String FirstName) {
    for(WebElement row :noRows) {
    	String text=row.getText();
        if(text.contains(FirstName)) {
        	System.out.println("User details are sucessfully add to table\n" +text);
            return true;
        }
        
    }
    System.out.println("User details are not add to table\n");
    return false;
}
	
}



