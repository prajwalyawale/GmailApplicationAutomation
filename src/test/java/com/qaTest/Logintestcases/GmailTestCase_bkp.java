package com.qaTest.Logintestcases;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;
import com.qaTest.Pages.GmailHomePage;
import com.qaTest.Pages.LoginPages;
import com.qaTest.gmailapp.TestBase;



public class GmailTestCase_bkp extends TestBase
{
   
	LoginPages logPage;
	GmailHomePage gmailHome;

  
	public GmailTestCase_bkp()
	{
		super();
		//super key word call base class constractor 
		//we need to call config fill from to get URL,username,password
	}
	

	@BeforeTest
	public void setUp() throws InterruptedException
	{
		initalization();//this method return in base class
		logPage=new LoginPages();
		
		gmailHome=new GmailHomePage();
		


}
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title=logPage.validatetitle();
		System.out.println(title);
		 AssertJUnit.assertEquals(title, "Gmail");
	}
	@Test(priority=2)
	public void VerifyEmail()
	{
		logPage.getEmail(prop.getProperty("EmailE"));
	}
	
	@Test(priority=3)
	public void VerifyNext()
	{
		logPage.NextButton1();
	}
	
	@Test(priority=4)
	public void VerifyPassword() throws InterruptedException
	{
		Thread.sleep(3000);
       logPage.getPassword(prop.getProperty("passwordp"));
		
		
	}
	
	@Test(priority=5)
	public void VerifyNext2()
	{
		logPage.NextButton2();
	}
	
	
	//click on compose
	
	@Test(priority=6)
	public void ClickOnCompose()
	{
		gmailHome.ComposeMail();
		
	}
	@Test(priority=7)
	public void VerifyLabel() throws InterruptedException
	{
		
		 gmailHome.SelectLabel();
			
	}
	
	@Test(priority=8)
	public void VerifyTypeLabel() throws InterruptedException
	{  
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		 gmailHome.TypeLabel(prop.getProperty("Soc"));
		 	 
		 
		 driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;	
	}
	
	@Test(priority=9)
	public void VerifyRecipient()
	{	
			gmailHome.RecipientsMail(prop.getProperty("Recipient"));
		
	}
	@Test(priority=10)
	public void VerifySubject() throws InterruptedException
	{
		
		gmailHome.subjectMail(prop.getProperty("Subject"));
		
	    Thread.sleep(3000);
			
	}
	
	@Test(priority=11)
	public void VerifyDiscp()
	{
		 gmailHome.DiscriptionMail(prop.getProperty("Disciption"));
			
	}
	
	@Test(priority=12)
	public void VerifyClickSendBtn() throws InterruptedException
	{
		 gmailHome.ClickSendBtn();
	 	 
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}
	
	@Test(priority=13)
	public void verifySocialMailBox() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		 gmailHome.SocialSecation();
			 
			
	}
	
	
	
	@Test(priority=14)
	public void openEmailClick() throws InterruptedException
	{
		gmailHome.OpenEmail();
	}
	/*@Test(priority=15)
	public void verifySearchMailBox()
	{
		
		 gmailHome.Searchbox(prop.getProperty("SearchMail"));
		 	
	}*/
	@Test(priority=15)
	public void MarkEmailStar() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
		gmailHome.ClickOnStar();
	}
	
	
	@Test(priority=16)
	public void VerifyEmailcontents()
	{
		
		String EmailCont=gmailHome.GetEmailContent();
		
		System.out.println(EmailCont);
		Assert.assertEquals(EmailCont,prop.getProperty("Disciption"));
			
	}
	

	@AfterTest
	public void tearDown()
	{
//driver.quit();        
	}

}
