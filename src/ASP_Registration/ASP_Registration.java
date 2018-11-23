package ASP_Registration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Design1.Constant_Acuity;
import Design1.Data_Acuity; 

public class ASP_Registration 
{
WebDriver driver;
private java.util.List<WebElement> option; 
WebDriverWait wait;
	
	@BeforeTest
	public void init4() throws Exception
	{
		Data_Acuity.setExcelFile(Constant_Acuity.Excelpath,"Sheet2");
		String url=Data_Acuity.getCellData(22, 0); 
		System.setProperty("webdriver.chrome.driver","./Reqfiles/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get(url);  //Enter the URL
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	
	@Test
	public void aspreg() throws Exception
	{
		
		Data_Acuity.setExcelFile(Constant_Acuity.Excelpath,"Sheet2");
		String aspname=Data_Acuity.getCellData(2, 0); 
		String streetAddress=Data_Acuity.getCellData(2, 1);
		String zip=Data_Acuity.getCellData(2, 2);
		String licence=Data_Acuity.getCellData(2, 3);
		String fname=Data_Acuity.getCellData(2, 4);
		String lname=Data_Acuity.getCellData(2, 5);
		String email=Data_Acuity.getCellData(2, 6);
		String phno=Data_Acuity.getCellData(2, 7);
		
		driver.findElement(By.xpath("//button[@class='btn aq-btn-yellow'][contains(text(), 'Register as Ambulance Service Provider')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//img[@src='images/leftArrow-white.png'])[2]")).click();
		Thread.sleep(3000);
		WebElement ele1= driver.findElement(By.id("samlLoginBtn"));
		String t1=ele1.getText();
		System.out.println("Button name is:"+ t1);
		SoftAssert s1= new SoftAssert();
		s1.assertEquals(ele1, "Next");
		Reporter.log("Back button is clickable", true);
		
		driver.findElement(By.xpath("//button[@class='btn aq-btn-yellow'][contains(text(), 'Register as Ambulance Service Provider')]")).click();
		driver.findElement(By.name("aspName")).clear();
	    driver.findElement(By.name("aspName")).sendKeys(aspname);
	    driver.findElement(By.name("aspName")).sendKeys(Keys.TAB);
	    Thread.sleep(10000);
	    driver.findElement(By.xpath("//form[@id='aspRegistrationForm']/div/div[2]/div/button/span")).click();
	  
	    driver.findElement(By.xpath("//form[@id='aspRegistrationForm']/div/div[2]/div/div/ul/li/a/span")).click();
	    driver.findElement(By.xpath("//form[@id='aspRegistrationForm']/div/div[2]/div/div/ul/li[2]/a/span")).click();
	    driver.findElement(By.xpath("//form[@id='aspRegistrationForm']/div/div[2]/div/div/ul/li[3]/a/span")).click();
	    driver.findElement(By.xpath("//form[@id='aspRegistrationForm']/div/div[2]/div/div/ul/li[4]/a/span")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.id("streetAddress")).click();
	    driver.findElement(By.id("streetAddress")).clear();
	    driver.findElement(By.id("streetAddress")).sendKeys(streetAddress);
	    driver.findElement(By.id("zipCode")).click();
	    driver.findElement(By.id("zipCode")).sendKeys(zip);
	    driver.findElement(By.name("aspLicenseNumber")).click();
	    driver.findElement(By.name("aspLicenseNumber")).clear();
	    driver.findElement(By.name("aspLicenseNumber")).sendKeys(licence);
	    driver.findElement(By.name("firstName")).clear();
	    driver.findElement(By.name("firstName")).sendKeys(fname);
	    driver.findElement(By.name("lastName")).clear();
	    driver.findElement(By.name("lastName")).sendKeys(lname);
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("(//input[@name='userEmail'])[2]")).sendKeys(email);
	    driver.findElement(By.name("phoneNumber")).clear();
	    driver.findElement(By.name("phoneNumber")).sendKeys(phno);
	    Thread.sleep(5000);
	    driver.findElement(By.id("aspSubmit")).click();
	    Thread.sleep(3000);
	    WebElement ele2= driver.findElement(By.xpath("(//div[@class='msg'][contains(text(), 'Request has been sent successfully.')])[2]"));
		String t2=ele2.getText();
		System.out.println("Success message is:"+ t2);
		s1.assertEquals(ele1, "Request has been sent successfully.");
		Reporter.log("ASP Registration successful", true);
	    
		
	}
}
