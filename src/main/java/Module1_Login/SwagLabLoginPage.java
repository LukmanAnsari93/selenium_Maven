package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabLoginPage
{
	       @FindBy(xpath="//input[@id='user-name']")private WebElement un;
		   @FindBy(xpath="//input[@id='password']")private WebElement pwd;
		   @FindBy(xpath="//input[@id='login-button']")private WebElement loginBtn;
		   @FindBy(xpath="//div[@class='error-message-container error']")private WebElement errorMsg;
	
		   public SwagLabLoginPage(WebDriver driver) 
		   {
			   PageFactory.initElements(driver, this);
		   }
			   
			public void inpSwagLabLoginPageUsername(String username) 
			{
				un.sendKeys(username);
			}
			public void inpSwagLabLoginPagePassword(String password) 
			{
				pwd.sendKeys(password);
			}
			public void clickSwagLabLoginPageLoginBtn() 
			{
				loginBtn.click();
			}
			public void varifySwagLabLoginPageErrorMsg(String expErrorMsg) 
			{
				String actErrorMsg = errorMsg.getText();
				if(actErrorMsg.contains(expErrorMsg)) {
					System.out.println("pass");
				}
				else {
					System.out.println("fail");
				}
			}
	}

