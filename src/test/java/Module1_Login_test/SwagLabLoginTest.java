package Module1_Login_test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Libraryfiles.BaseClass;
import Libraryfiles.UtilityClass1;
import Module1_Login.SwagLabHomePage;
import Module1_Login.SwagLabLoginPage;
import Module1_Login.SwagLabOpenMenuPage;

public class SwagLabLoginTest extends BaseClass
{
	SwagLabLoginPage login;
	SwagLabHomePage home;
	 SwagLabOpenMenuPage  menu;
	Sheet Sh;
	int TCID;
	@BeforeClass
	public void openBrowser() throws EncryptedDocumentException, IOException
	{
				 
		 initializeBrowser();
		
		 login=new SwagLabLoginPage (driver);
		 home=new SwagLabHomePage (driver);
		 menu=new SwagLabOpenMenuPage (driver);
		
	}
	@BeforeMethod
	public void loginToAPP () throws InterruptedException, EncryptedDocumentException, IOException
	{
		login.inpSwagLabLoginPageUsername(UtilityClass1.getPfdata("UN"));
		login.inpSwagLabLoginPagePassword(UtilityClass1.getPfdata("PWD"));
		login.clickSwagLabLoginPageLoginBtn();
		Thread.sleep(2000);
	}
	@Test
	public void verifyLogo() throws InterruptedException, EncryptedDocumentException, IOException
	{
		TCID=101;
		home.getSwagLabHomePageLogo(UtilityClass1.getTD(0, 2));
		
		
		Thread.sleep(2000);
	}
	@AfterMethod
	public void logOutFromApp(ITestResult s1) throws InterruptedException, IOException
	{
		if(s1.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass1.captureSS( driver, TCID);
		}
		
		home.clickSwaglabHomePageOpenMenu();
		Thread.sleep(2000);
		menu. clickSwagLabOpenmenuPageLogOut();
		Thread.sleep(2000);
	
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}

}
