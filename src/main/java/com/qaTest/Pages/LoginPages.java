package com.qaTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qaTest.gmailapp.TestBase;

public class LoginPages extends TestBase
{
	//PageFactory
	
		@FindBy(xpath="//input[@id='identifierId']")
		WebElement Emailid;
		
		@FindBy(xpath="//span[text()='Next']")
		WebElement NextButton;
		
		@FindBy(xpath="//input[@name='password']")
		WebElement password;
		
		@FindBy(xpath="//span[text()='Next']")
		
		WebElement NextBtn;
	
		 public LoginPages()
		    {
		    	PageFactory.initElements(driver, this);
		    	//this key use for pointing current class object
		    	//For How to initialaze pagefactory -> using initElement method   	
		    }
		    public String validatetitle()
		    {
		    	return driver.getTitle();
		    }
		    
		    public String getEmail(String emailid )
		    {
		    	Emailid.sendKeys(emailid);
				return emailid;
		    }
		    
		    public  void NextButton1()
		    {
		    	 NextButton.click();
		    }
		    
		    
		    public String getPassword(String pass )
		    {
		    	password.sendKeys(pass);
				return pass;
		    }
		    
		    public void NextButton2()
		    {
		    	NextBtn.click();
		    	
		    }
			
		   
			

}
