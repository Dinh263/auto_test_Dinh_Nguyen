package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommonPage.PageCommonActivity;

public class PageFacebookLogin {
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement txt_EmailorPhone;
	
	@FindBy(xpath="//input[@id='pass']")
	WebElement txt_Password;
	
	@FindBy(xpath="//input[@id='u_0_2']")
	WebElement btn_Login;
	
	public PageFacebookLogin(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, 30);
	}
	
	private void inputEmailOrPhone(String emailorphone){
		PageCommonActivity.waitForElementPresentOnThePage(wait, txt_EmailorPhone);
		txt_EmailorPhone.sendKeys(emailorphone);
	}
	
	private void inputPassword(String password){
		PageCommonActivity.waitForElementPresentOnThePage(wait, txt_Password);
		txt_Password.sendKeys(password);
	}
	
	private void clickLogintButton(){
		PageCommonActivity.waitForElementPresentOnThePage(wait, btn_Login);
		btn_Login.click();
	}
	
	public void loginViaFacebook(String emailOrPhone, String password){
		inputEmailOrPhone(emailOrPhone);
		inputPassword(password);
		clickLogintButton();
	}
}
