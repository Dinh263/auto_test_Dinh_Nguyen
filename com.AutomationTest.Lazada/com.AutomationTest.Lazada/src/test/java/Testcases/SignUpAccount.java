package Testcases;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.bcel.generic.AASTORE;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CommonPage.PageCommonActivity;
import CustomizedLibs.PropertyUtility;
import DataMapping.DataRegisterAccount;
import Pages.PageFacebookLogin;
import Pages.PageGoogleLogin;
import Pages.PageHome;

/**
 * 
 * @author Administrator
 * This class is used for automate the function create account in lazada page.
 * Step 1 : Open browser and go to URL.
 * Step 2 : get the value in the excel file for testing:
 *   + register type : account by lazada, facebook account, gmail account. 
 *   + other information : gender, email, password.
 * Step 3 : if the register type is lazada account. then it will read all information in the excel file and create an account.
 *          if the register type is facebook or gmail account, it will read the email and password only and create account by facebook or gmail
 * Step 4 : after create account and check if the label account name displayed on the page.         
 */

public class SignUpAccount {
	
	WebDriver driver;
	
	PageHome pageHome;
	PageFacebookLogin pageFacebook;
	PageGoogleLogin pageGoogle;
	DataRegisterAccount dataRegister;
	
	String registerType;
	String gender;
	String email;
	String name;
	String day;
	String month;
	String year;
	String password;
	
	String parentWinddow;
	String childWindow;
	
	@BeforeTest
	public void openApplication() throws IOException, InterruptedException{
		
		// set environment variable.
		System.setProperty("webdriver.gecko.driver", PropertyUtility.getGeckoDriverPath());
		
		driver= new FirefoxDriver();
		
		// go to the URL create account. 
		driver.get(PropertyUtility.getUrlCreateAccount());
		driver.manage().window().maximize();
		Thread.sleep(1000);
		initDataForTesting();
	}
	
	@Test
	public void testSingupAccount() throws InterruptedException{
		pageHome=new PageHome(driver);
		
		// check register type 
		if(registerType.equals("Create new account")){
			createNormalAccount();
		}
		else {
			if(registerType.equals("Facebook")){
				pageHome.signupViaFacebook();
				switchToFacebookWindow();
				pageFacebook = new PageFacebookLogin(driver);
				pageFacebook.loginViaFacebook(email, password);		
				
				
			}
			else{
				pageHome.signupViaGoogle();
				switchToGoogleWindow();
				pageGoogle= new PageGoogleLogin(driver);
				pageGoogle.loginViaGoogle(email, password);
				if(PageCommonActivity.getNumberOWidnows(driver)==2){
					pageGoogle.clickAllowAccessButton();
					driver.close();
				}
				driver.switchTo().window(parentWinddow);
				System.out.print(driver.getTitle());
			}
			
			
			
		}
		Assert.assertTrue(pageHome.isRegisteredSuccessfully());
		System.out.println("done");
	}
	
	public void initDataForTesting() throws IOException{
		dataRegister=new DataRegisterAccount(PropertyUtility.getDataFileNameWithPath());
		registerType=dataRegister.getRegisterType();
		email=dataRegister.getEmail();
		password=dataRegister.getPassword();
		gender=dataRegister.getGender();
		name=dataRegister.getName();
		day=dataRegister.getDayOfBirth();
		month=dataRegister.getMonthOfBirth();
		year=dataRegister.getYearOfBirth();
		
	}
	
	public void switchToChildWindow(){
		Set<String> setWindows=driver.getWindowHandles();
		Iterator<String> wins=setWindows.iterator();
		parentWinddow=wins.next();
		childWindow = wins.next();
		driver.switchTo().window(childWindow);
	}
	
	
	
	public void switchToFacebookWindow(){
		switchToChildWindow();
	}
	
	public void switchToGoogleWindow(){
		switchToChildWindow();
	}
	
	public void createNormalAccount(){
		if(gender!=" "){
			if(gender.equals("Male")){
				pageHome.checkMaleCheckbox();
			}else{
				pageHome.checkFameleCheckbox();
			}
		}		
		
		pageHome.inputEmail(email);
		pageHome.inputName(name);
		if(day!=" "){
			pageHome.inputDayOfBirth(day);
		}
		if(month!=" "){
			pageHome.inputMonthOfBirth(month);
		}
		if(year!=" "){
			pageHome.inputYearOfBirth(year);
		}
		pageHome.inputPassword(password);
		pageHome.reInputPassword(password);
		pageHome.clickSubmitButton();	
		
	}

}
