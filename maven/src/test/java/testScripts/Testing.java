package testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testing {
	WebDriver driver;
	@BeforeTest
	public void test() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Agile1Tech\\Desktop\\drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.navigate().to("http://automationpractice.com/");
		
		driver.manage().deleteAllCookies();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		
	}
	
	@Test(priority = 0)
	public void landingPage() {
		
		WebElement signinButton = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
		signinButton.click();
	}
	
	@Test(priority =1)
	public void accountPage() {
		WebElement emailAddressTextBox = driver.findElement(By.id("email_create"));
		emailAddressTextBox.clear();
		emailAddressTextBox.sendKeys("al25258@gmail.com");
		
		WebElement createAnElementButton = driver.findElement(By.name("SubmitCreate"));
		createAnElementButton.click();
	}
	
	@Test(priority = 2)
	public void registrationPage() {
		
		
		WebElement firstName = driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]"));
		firstName.clear();
		firstName.sendKeys("John");
		
		WebElement lastName = driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]"));
		lastName.clear();
		lastName.sendKeys("Williams");
		
		WebElement password = driver.findElement(By.xpath("//*[@id=\"passwd\"]"));
		password.clear();
		password.sendKeys("testing");
		
		WebElement address = driver.findElement(By.xpath("//*[@id=\"address1\"]"));
		address.clear();
		address.sendKeys("agiletech");
		
		WebElement city = driver.findElement(By.xpath("//*[@id=\"city\"]"));
		city.clear();
		city.sendKeys("agiletech");
		
		Select select = new Select (driver.findElement(By.xpath("//*[@id=\"id_state\"]")));
		select.selectByVisibleText("Virginia");
		
		WebElement zipCode = driver.findElement(By.xpath("//*[@id=\"postcode\"]"));
		zipCode.clear();
		zipCode.sendKeys("22030");
		
		WebElement phoneNumber = driver.findElement(By.xpath("//*[@id=\"phone_mobile\"]"));
		phoneNumber.clear();
		phoneNumber.sendKeys("2023125415");
		
		WebElement registerButton = driver.findElement(By.id("submitAccount"));
		registerButton.click();
		
	}
	
	@Test(priority =3)
	public void userHomePage() {
		
		
		String expectedUserNameText = "John Williams";
		WebElement actualUserName = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span"));
		String actualUserNameText = actualUserName.getText();
		
		if(expectedUserNameText.equals(actualUserNameText)) {
			System.out.println("Registration testing scenario is passed");
		}else {
			System.out.println("Registration testing scenario failed");
		}
		
	}
		@AfterTest
		public void finishTest() {
		driver.quit();
	}

}
