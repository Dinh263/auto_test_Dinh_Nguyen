package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommonPage.PageCommonActivity;

public class PageLazada {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath="//div[@class='c-header-search__input-group']/div/input")
	WebElement txt_Search;
	
	@FindBy(xpath="//div[@class='c-paging__wrapper']/a[@class='c-paging__next-link']")
	WebElement btnNext;
	
	@FindBy(xpath="//div[@class='catalog__status__title']/div/div")
	WebElement lbel_TotalProductFound;
	
	public PageLazada(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, 30);
	}
	
	private void inputSearchText(String textSearch){
		PageCommonActivity.waitForElementPresentOnThePage(wait, txt_Search);
		txt_Search.sendKeys(textSearch);
	}
	
		
	public void searchProduct(String textSearch){
		inputSearchText(textSearch);
		txt_Search.sendKeys(Keys.ENTER);		
	}
	
	public String totalSearchedProductsFound() throws InterruptedException{
		wait.until(ExpectedConditions.visibilityOf(lbel_TotalProductFound));
		String result = lbel_TotalProductFound.getText();
		return result.substring(0,result.indexOf(" "));
	}
	

}
