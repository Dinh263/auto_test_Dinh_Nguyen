package Pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.Page;

import org.openqa.selenium.support.ui.Select;
import CommonPage.PageCommonActivity;

public class PageRegisterAccount {
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath="//input[@id='RegistrationForm_gender_0']")
	WebElement chbox_Male;
	
	@FindBy(xpath="//input[@id='RegistrationForm_gender_1']")
	WebElement chbox_FeMale;
	
	@FindBy(xpath="//input[@id='RegistrationForm_email']")
	WebElement txt_Email;
	
	@FindBy(xpath="//input[@id='RegistrationForm_first_name']")
	WebElement txt_Name;
	
	@FindBy(xpath="//select[@id='RegistrationForm_day']")
	WebElement ddList_Day;
	
	@FindBy(xpath="//select[@id='RegistrationForm_month']")
	WebElement ddList_Month;
	
	
	@FindBy(xpath="//select[@id='RegistrationForm_year']")
	WebElement ddList_Year;
	
	@FindBy(xpath="//input[@id='RegistrationForm_password']")
	WebElement txt_Password;

	
	@FindBy(xpath="//input[@id='RegistrationForm_password2']")
	WebElement txt_ReEnterPassword;
	
	@FindBy(xpath="//button[@id='send']")
	WebElement btn_Submit;
	
	
	@FindBy(linkText="Sign up with Facebook")
	WebElement lnk_Facebook;
	
	@FindBy(linkText="Sign up with Google")
	WebElement lnk_Google;
	
	
	
	
	public PageRegisterAccount(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, 30);
	}
	
	public void checkMaleCheckbox(){
		PageCommonActivity.waitForElementPresentOnThePage(wait, chbox_Male);
		chbox_Male.click();
	}
	
	public void checkFameleCheckbox(){
		PageCommonActivity.waitForElementPresentOnThePage(wait, chbox_FeMale);
		chbox_FeMale.click();
	}
	
	public void inputEmail(String pEmail){
		PageCommonActivity.waitForElementPresentOnThePage(wait, txt_Email);
		txt_Email.sendKeys(pEmail);
	}
	
	public void inputName(String name){
		PageCommonActivity.waitForElementPresentOnThePage(wait, txt_Name);
		txt_Name.sendKeys(name);
	}
	
	public void inputDayOfBirth(String day){
		PageCommonActivity.waitForElementPresentOnThePage(wait, ddList_Day);
		Select dropdown=new Select(ddList_Day);
		dropdown.selectByVisibleText(day);
	}
	
	public void inputMonthOfBirth(String month){
		PageCommonActivity.waitForElementPresentOnThePage(wait, ddList_Month);
		Select dropdown=new Select(ddList_Month);
		dropdown.selectByVisibleText(month);
	}
	
	public void inputYearOfBirth(String year){
		PageCommonActivity.waitForElementPresentOnThePage(wait, ddList_Year);
		Select dropdown=new Select(ddList_Year);
		dropdown.selectByVisibleText(year);
	}
	
	public void inputPassword(String password){
		PageCommonActivity.waitForElementPresentOnThePage(wait, txt_Password);
		txt_Password.sendKeys(password);
	}
	
	public void reInputPassword(String password){
		PageCommonActivity.waitForElementPresentOnThePage(wait, txt_ReEnterPassword);
		txt_ReEnterPassword.sendKeys(password);
	}
	
	
	public void clickSubmitButton(){
		PageCommonActivity.waitForElementPresentOnThePage(wait, btn_Submit);
		btn_Submit.click();
	}
	
	private void clickLinkFacebook(){
		PageCommonActivity.waitForElementPresentOnThePage(wait, lnk_Facebook);
		lnk_Facebook.click();
	}
	
	public void loginViaFacebook(){
		clickLinkFacebook();
	}
	
	public void loginViaGoogle(){
		clickLinkGoogle();
	}
	
	private void clickLinkGoogle(){
		PageCommonActivity.waitForElementPresentOnThePage(wait, lnk_Google);
		lnk_Google.click();
	}
	
	
	
	
	}
	
	
	
	


