package com.qaTest.Pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qaTest.gmailapp.TestBase;

public class GmailHomePage extends TestBase
{
	Actions actions;

	@FindBy(xpath="//div[@class='T-I J-J5-Ji T-I-KE L3']")
	WebElement compose;
	
	@FindBy(xpath="//textarea[@class='vO' and @name='to']")
	WebElement Recipients;
	//*[@id=':qm']
	
	@FindBy(xpath="//input[@name='subjectbox']")
	WebElement subject;
	
	@FindBy(xpath="//span[@class='bog']")
	WebElement EmailSub;
	
	@FindBy(xpath="//div[@class='Am Al editable LW-avf tS-tW' ]")
	WebElement Discription;
	
	@FindBy(xpath="(//div[@class='J-J5-Ji J-JN-M-I-JG'])[5]")
	WebElement set;
	
	@FindBy(xpath="//div[text()='Label']")
	WebElement ClickLabal;
	
	@FindBy(xpath="//input[@class='bqf']")
	WebElement TypLabSoc;
	
	@FindBy(xpath="//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']")
	WebElement SendBtn;
	
	@FindBy(xpath="//div[@class='aKp aKe-aLf']")
	WebElement SocialSec;
	
	@FindBy(xpath="//span[@class='T-KT']")
	WebElement MarkStar; 

	@FindBy(className="aAU")
	WebElement MailSearch;
	
	@FindBy(xpath="//div[@class='a3s aXjCH ']/div[@dir='ltr']")
	WebElement EmailcontentEle;
	
    

	 public GmailHomePage ()
	    {
	    	PageFactory.initElements(driver, this);
	    	//this key use for pointing current class object
	    	//For How to initialaze pagefactory -> using initElement method   	
	    }
	    public void ComposeMail()
	   
	    {
	    	 actions = new Actions(driver);
	      WebElement menuOption = driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']"));
	      actions.moveToElement(menuOption).perform();
	      menuOption.click();
	      
	    }
	    
	    public void TypeLabel(String TypeSoc)
	    { 
	    	
	    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	    	TypLabSoc.sendKeys(TypeSoc);
	    
	    	TypLabSoc.sendKeys(Keys.ENTER);
	    	
	    	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
	    }
	    
	    public void RecipientsMail(String RecEmail)
	    {  
	    	
	    		try {
	    			Recipients.click();
		    	    
			    	Recipients.sendKeys(RecEmail);
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			   
			    
	    }
	    
	    public String subjectMail(String subEmail)
	    {
	    	
	    	subject.sendKeys(subEmail);
		    return subEmail;	    
	    }
	    
	    public String DiscriptionMail(String DiscriptionEmail)
	    {
	    	Discription.sendKeys(DiscriptionEmail);
		    return DiscriptionEmail;
		  
			    
	    }
	    
	    public void SelectLabel() 
	    {
	    	
	    	set.click();
	    	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
	    	ClickLabal.click();
	    }
	      	
	    public void ClickSendBtn() throws InterruptedException
	    {
	    
	    	Thread.sleep(2000);
	    	SendBtn.click();
	    	
	    	
	    }
	  public void SocialSecation() throws InterruptedException
	    {
	    	SocialSec.click();
	    	  
	    	Thread.sleep(3000);
	    	
	    	
	    }
	  
	 
	  public void OpenEmail()
	  {
		  java.util.List<WebElement> emailSub=driver.findElements(By.xpath("//span[@class='bog']"));
		  
		
		  System.out.println("Total Email : "+emailSub.size());
	    	
	    	for (WebElement webElement : emailSub)
	    	{
	    		String subValue=webElement.getText();
	    		
	    		
	    		if(subValue.equalsIgnoreCase("Screen_LogicTest"))
	    		{
	    			
	    			System.out.println(subValue);
	    			webElement.click();
	    			break;		
	    		}
				
			}
	  }
	  public void ClickOnStar()
	    {
		  
		  
	    	MarkStar.click();
	    	
	    }
	    
	    public String GetEmailContent()
	    {
	    	return EmailcontentEle.getText();
	    }	    
	   
}
		
	    
	   
	    
	    
	    
	   
	
	


