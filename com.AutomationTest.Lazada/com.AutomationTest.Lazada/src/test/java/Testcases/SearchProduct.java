package Testcases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.arrays.Int32Array;

import CommonPage.PageCommonActivity;
import CustomizedLibs.PropertyUtility;
import DataMapping.DataSearchingProduct;
import Pages.PageLazada;

/**
 * 
 * @author Administrator
 * this test case is used for automating search function in Lazada page. 
 * steps:
 * step 1 : open browser and go to the url.
 * step 2 : maximize the window.
 * step 3 : initiate data for test : data for searching and data for validation.
 * step 4 : get the total product found in page and compare to the value in the excel 
 * test case will be passed if the total product found in the page equals to the value validate in the excel
 * and failed if other.
 */
public class SearchProduct {
	WebDriver driver;
	String textSearch="";
	String totalProduct;
	PageLazada pageLazada;
	
	DataSearchingProduct dataSearch;
	
	
	@BeforeTest
	public void openApplication() throws IOException, InterruptedException{
		//set system varible.
		System.setProperty("webdriver.gecko.driver", PropertyUtility.getGeckoDriverPath());		
		driver= new FirefoxDriver();
		
		// go to the url lazada.vn. this value will be retrieve from class PropertyUtility
		driver.get(PropertyUtility.getUrlApplication());
		
		// maximize the window.
		driver.manage().window().maximize();
		Thread.sleep(1000);
		pageLazada=new PageLazada(driver);
		
	}
	
	@BeforeMethod
	public void initDataForSearching() throws IOException{
		// initiate the instance of data searching object.
		dataSearch=new DataSearchingProduct(PropertyUtility.getDataFileNameWithPath());		
		
		// get the text searching
		textSearch=dataSearch.getTextSearch();
		
		// get the total value for later checking. 
		totalProduct = dataSearch.getTotalProductsFound();
	}
	
	
	@Test
	public void searchProduct() throws InterruptedException{
		// automate step of input string to text box and click enter to search.
		pageLazada.searchProduct(textSearch);
		
		// compare the value of total products found in page with the value in the excel file 
		// will return true if these values are equal otherwise it will be failed.
		Assert.assertTrue(pageLazada.totalSearchedProductsFound().equals(totalProduct));	
	}
	
	
	
	
	
	
}
