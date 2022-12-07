package quickaccess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Quickfunctions {
	public WebDriver driver;
	public Actions actions;
	public WebDriverWait wait;
	
	
	// Quick Access Functions Are Listed Below 
		public void ActionsClick(WebElement elem) {
			actions.click(elem).perform();
		}

		public void ActionsClickAndHold(WebElement elem) {
			actions.clickAndHold(elem).perform();
		}

		public WebElement WaitXpath(String xpath) {
			WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			return elem;
		}

		public void HomeButtonClick() {
			// ActionsWaitClick("//button[@class='btn btn-default']");
			WebElement homeBut = WaitXpath("//button[@ng-click='home()']");
			ActionsClick(homeBut);
		}

		public void AlertAccept() {
			driver.switchTo().alert().accept();
		}

		public void SubmitButtonClick() {
			WebElement submitBut = WaitXpath("//button[@type='submit']");
			ActionsClick(submitBut);
		}

}
