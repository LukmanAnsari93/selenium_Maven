package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabHomePage {
	

	
		@FindBy(xpath="//div[@class='app_logo']") private WebElement logo;
		@FindBy(xpath="//button[@id='react-burger-menu-btn']") private WebElement openMenu;
		
		public  SwagLabHomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
			
		}
		/*public void verifySwagLabHomePageLogo(String expLogoText) {
			String actLogoText = logo.getText();
			if(actLogoText.equals(expLogoText))
			{
				System.out.println("pass");
			}
			else {
				System.out.println("fail");
			}
		}*/
		public void getSwagLabHomePageLogo(String expLogoText)
		{
			String actLogoText=logo.getText();
			if(expLogoText.equals(actLogoText))
					{
				System.out.println("pass");
			}
			else {
				System.out.println("fail");
			}
			
		}
		
		public void clickSwaglabHomePageOpenMenu()
		{
			openMenu.click();
		}
}
