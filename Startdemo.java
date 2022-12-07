package bankingProject;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import quickaccess.Quickfunctions;

public class Startdemo {
	public String baseurl = "https://www.globalsqa.com/angularJs-protractor/BankingProject";
	public WebDriver driver;
	public Actions actions;
	public WebDriverWait wait;
	public String actual = "", expected = "";
	
	@BeforeTest
	public void GetDriverAdress() {
		// System.setProperty("webdriver.chrome.driver","C:\\Users\\Ramish\\Desktop\\eclipse\\chromedriver.exe");
		 
		// Create New WebDriver and maximize it
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(baseurl);

			// Create Actions & Wait Objects
			actions = new Actions(driver);
			wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	}
	
	
	
	//Test Cases Start Here
		@Test(priority = 0)
		public void ManagerAddCustomer() {

			// Hit Manager Button To Login After Wait
			WebElement managerButton = WaitXpath("//button[@ng-click='manager()']");
			ActionsClick(managerButton);
			
			// Hit Add Customer After Wait
			WebElement addCustomer = WaitXpath("//button[@ng-click='addCust()']");
			ActionsClick(addCustomer);

			// Add Customer Details and Handle Alert
			WebElement fName = WaitXpath("//input[@ng-model='fName']");
			fName.sendKeys("Malik");
			WebElement lName = WaitXpath("//input[@ng-model='lName']");
			lName.sendKeys("Ajay");
			WebElement postCode = WaitXpath("//input[@ng-model='postCd']");
			postCode.sendKeys("4123");
			WebElement addCustBut = WaitXpath("//button[@class='btn btn-default']");
			ActionsClick(addCustBut);
			
			actual = driver.switchTo().alert().getText();
			expected = "Customer added successfully with customer id :6";
			AlertAccept();
			Assert.assertEquals(actual, expected,"Add Customer Insuccessful.");
			
		}
		
		@Test(priority = 1)
		public void OpenCustomerAccount() {

			//ManagerAddCustomer();

			// Hit Open Account
			WebElement openAcc = WaitXpath("//button[@ng-click='openAccount()']");
			ActionsClick(openAcc);

			WebElement userSelect = WaitXpath("//select[@id='userSelect']");
			ActionsClickAndHold(userSelect);

			WebElement textName = WaitXpath("//option[text()='Malik Ajay']");
			textName.click();

			WebElement currency = WaitXpath("//select[@id='currency']");
			ActionsClickAndHold(currency);

			WebElement pound = WaitXpath("//option[text()='Pound']");
			pound.click();

			SubmitButtonClick();
			actual = driver.switchTo().alert().getText();
			expected = "Account created successfully with account Number :1016";
			AlertAccept();
			Assert.assertEquals(actual, expected,"Add Customer Insuccessful.");
			
		}

		@Test(priority = 2)
		public void GoToCustomerLogin() {
			//OpenCustomerAccount();

			HomeButtonClick();

			WebElement customerBut = WaitXpath("//button[@ng-click='customer()']");
			ActionsClick(customerBut);

			WebElement userSelect = WaitXpath("//select[@id='userSelect']");
			ActionsClickAndHold(userSelect);

			WebElement textName = WaitXpath("//option[text()='Malik Ajay']");
			textName.click();

			SubmitButtonClick();
			
			
			WebElement getTextElem = WaitXpath("//span[@class='fontBig ng-binding']");
			actual = getTextElem.getText();
			expected = "Malik Ajay";
			Assert.assertEquals(actual, expected,"Add Customer Insuccessful.");
		}
		
		@Test(priority = 3)
		public void DepositCashWithdraw() {
			//span[@class='error ng-binding']
			//GoToCustomerLogin();

			WebElement depositBut = WaitXpath("//button[@ng-click='deposit()']");
			ActionsClick(depositBut);

			WebElement amount = WaitXpath("//input[starts-with(@class,'form-control')]");
			amount.sendKeys("10000");

			SubmitButtonClick();

			WebElement withdrawlBut = WaitXpath("//button[@ng-click='withdrawl()']");
			withdrawlBut.click();

			WebElement amountToWithdraw = WaitXpath("//label[text()='Amount to be Withdrawn :']//following::input");
			amountToWithdraw.sendKeys("2000");

			WebElement withdrawAmountButton = WaitXpath("//button[text()='Withdraw']");
			ActionsClick(withdrawAmountButton);
			
			WebElement getTextElem = WaitXpath("//span[@class='error ng-binding']");
			actual = getTextElem.getText();
			expected = "Transaction successful";
			Assert.assertEquals(actual, expected,"Withdraw Cash Insuccessful.");
			
		}
		
		@Test(priority = 4)
		public void Transactions() {

			//DepositCashWithdraw();

			WebElement transactionsbut = WaitXpath("//button[@ng-click='transactions()']");
			ActionsClick(transactionsbut);
			
			WebElement getTextElem = WaitXpath("//button[@ng-click='reset()']");
			String actual = getTextElem.getText();
			//String actual = driver.findElement(By.xpath("//td[text()='Debit']")).getText();
			String expected = "Reset";
			Assert.assertEquals(actual, expected,"Transactions Insuccessful.");
			
			WebElement startDateTime = WaitXpath("//input[@id='start']");
			startDateTime.sendKeys("2022-08-15T21:33:44");
			WebElement endDateTime = WaitXpath("//input[@id='end']");
			endDateTime.sendKeys("2022-08-17T21:33:44");
		}
		
		@Test(priority = 5)
		public void ResetTransactionsLogout() {

			//Transactions();

			WebElement resetBut = WaitXpath("//button[@ng-click='reset()']");
			ActionsClick(resetBut);

			WebElement logoutBut = WaitXpath("//button[@class='btn logout']");
			ActionsClick(logoutBut);
			
			WebElement getTextElem = WaitXpath("//label[text()='Your Name :']");
			actual = getTextElem.getText();
			//actual = driver.findElement(By.xpath("//label[text()='Your Name :']")).getText();
			expected = "Your Name :";
			Assert.assertEquals(actual, expected,"Logout Insuccessful.");
			
		}

		@Test(priority = 6)
		public void ManagerLoginDeleteCustomer(){

			//ResetTransactionsLogout();

			HomeButtonClick();

			WebElement managerButton = WaitXpath("//button[@ng-click='manager()']");
			ActionsClick(managerButton);

			WebElement showCust = WaitXpath("//button[@ng-click='showCust()']");
			ActionsClick(showCust);

			WebElement delCust = WaitXpath("//input[starts-with(@class,'form-control')]");
			delCust.sendKeys("Malik");
			
			
			WebElement getTextElem = WaitXpath("//td[text()='Malik']");
			actual = getTextElem.getText();
			expected = "Malik";
			Assert.assertEquals(actual, expected,"Search Customer Insuccessful.");

			WebElement delCustBut = WaitXpath("//button[@ng-click='deleteCust(cust)']");
			ActionsClick(delCustBut);
		}
		
		@AfterMethod
		public void CloseURL() {
			driver.close();
		}


}
