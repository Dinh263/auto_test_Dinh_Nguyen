package CommonPage;


import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageCommonActivity {
	
	/**
	 * this function is used for waiting for an element presenting on the page.
	 * the duration time for waiting is set on webdriverwait. 
	 * Error will throw if the duration time ends but the element doesnot still exist on the page.
	 * @param wait
	 * @param element
	 */
	public static void waitForElementPresentOnThePage(WebDriverWait wait, WebElement element){
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	/**
	 * this function is used for get the total window during the process.
	 * @param driver
	 * @return total window are displaying.
	 */
	public static int getNumberOWidnows(WebDriver driver){
		Set<String> setWindows=driver.getWindowHandles();
		return setWindows.size();
	}		
	

}
