package Pages;

import static org.testng.Assert.expectThrows;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.Page;

import CommonPage.PageCommonActivity;

public class PageGoogleLogin {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath="//input[@name='identifier']")
	WebElement txt_EmailOrPhone;
	
	@FindBy(xpath="//div[@id='identifierNext']/content/span")
	WebElement btn_Next;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement txt_Password;
	
	@FindBy(xpath="//div[@id='passwordNext']/content/span")
	WebElement btn_Submit;
	
	@FindBy(xpath="//div[@id='submit_approve_access']/content/span")
	WebElement btn_AllowAccess;
	
	
	
	public PageGoogleLogin(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, 30);
	}
	
	
	private void inputEmailOrPhone(String emailorphone){
		PageCommonActivity.waitForElementPresentOnThePage(wait, txt_EmailOrPhone);
		txt_EmailOrPhone.sendKeys(emailorphone);
	}
	
	private void clickNextToPassword(){
		PageCommonActivity.waitForElementPresentOnThePage(wait, btn_Next);
		btn_Next.click();
	}
	
	private void inputPassword(String password){
		PageCommonActivity.waitForElementPresentOnThePage(wait, txt_Password);
		txt_Password.sendKeys(password);
	}
	
	private void clickSubmitButton(){
		PageCommonActivity.waitForElementPresentOnThePage(wait, btn_Submit);
		btn_Submit.click();
	}
	
	public void clickAllowAccessButton(){
		
		btn_AllowAccess.click();
	}
	
	
	
	public void loginViaGoogle(String emailOrPhone, String password){
		inputEmailOrPhone(emailOrPhone);
		clickNextToPassword();
		inputPassword(password);
		clickSubmitButton();
		
		
	}
}
