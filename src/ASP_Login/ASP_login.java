package ASP_Login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Design1.Constant_Acuity;
import Design1.Data_Acuity;

public class ASP_login 
{
	WebDriver driver;
	private java.util.List<WebElement> option; 
	WebDriverWait wait;
	
	@BeforeTest
	public void init4() throws Exception
	{
		Data_Acuity.setExcelFile(Constant_Acuity.Excelpath,"Sheet1");
		String url=Data_Acuity.getCellData(5, 0); 
		System.setProperty("webdriver.chrome.driver","./Reqfiles/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get(url);  //Enter the URL
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	
	
			@Test(priority=1)
			public void aspinvalidlogin() throws Exception
			{
				Data_Acuity.setExcelFile(Constant_Acuity.Excelpath,"Sheet1");
						String emaili=Data_Acuity.getCellData(2, 3); 
						String passi =Data_Acuity.getCellData(2, 4); 
						
						driver.findElement(By.id("samlUserEmail")).sendKeys(emaili);
						driver.findElement(By.id("samlLoginBtn")).click();
						WebElement ele7=driver.findElement(By.xpath("//li[text()= 'E-mail address is invalid']"));
						String t5=ele7.getText();
						System.out.println("Error message is:"+ t5);
						SoftAssert s7= new SoftAssert();
						s7.assertEquals(ele7, "E-mail address is invalid");
						Reporter.log("E-mail address is invalid", true);
			
			}
				 
			
			/*@Test(priority=2)
			public void aspinvalid1() throws Exception
			{
				
				Data_Acuity.setExcelFile(Constant_Acuity.Excelpath,"Sheet1");
						String emaili1=Data_Acuity.getCellData(2, 6); 
						String passi1 =Data_Acuity.getCellData(2, 7); 
						
						Thread.sleep(3000);
						driver.findElement(By.id("samlUserEmail")).sendKeys(emaili1);
						driver.findElement(By.id("samlLoginBtn")).click();
						Thread.sleep(3000);
						driver.findElement(By.id("password")).sendKeys(passi1);
						driver.findElement(By.id("loginBtnId")).click();
			
						WebDriverWait wait= new WebDriverWait(driver, 2);
						WebElement ele8=driver.findElement(By.xpath("(//div[text()= 'Username and Password does not match. Try again.'])[1]"));
						wait.until(ExpectedConditions.visibilityOf(ele8));
						
						String t6=ele8.getText();
						System.out.println("Error message is:"+ t6);
						SoftAssert s8= new SoftAssert();
						s8.assertEquals(ele8, "Username and Password does not match. Try again.");
						Reporter.log("Username and Password does not match. Try again.", true);
			
			Thread.sleep(3000);
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("password")).clear();

			}
			
			

			@Test(priority=3)
			public void aspinvalid2() throws Exception
			{
					Data_Acuity.setExcelFile(Constant_Acuity.Excelpath,"Sheet1");
					String email2=Data_Acuity.getCellData(6, 3); 
					String pass2 =Data_Acuity.getCellData(6, 4);
			
					driver.findElement(By.id("samlUserEmail")).sendKeys(email2);
					driver.findElement(By.id("samlLoginBtn")).click();
					Thread.sleep(3000);
					
					driver.findElement(By.id("password")).sendKeys(pass2);
					driver.findElement(By.id("loginBtnId")).click();
					
					Thread.sleep(3000);
					WebElement ele9=driver.findElement(By.xpath("(//div[text()= 'Username and Password does not match. Try again.'])[1]"));
					String t7=ele9.getText();
					System.out.println("Error message is:"+t7);
					SoftAssert s9= new SoftAssert();
					s9.assertEquals(ele9, "Username and Password does not match. Try again.");
					Reporter.log("Username and Password does not match. Try again.", true);
			
			Thread.sleep(3000);
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("password")).clear();
				}*/
			
		
@Test(priority=2)
public void aspvalid() throws Exception
{
		Data_Acuity.setExcelFile(Constant_Acuity.Excelpath,"Sheet1");
		String email1=Data_Acuity.getCellData(2, 9); 
		String password1=Data_Acuity.getCellData(2, 10);
		
	
		Thread.sleep(2000);
	driver.findElement(By.id("samlUserEmail")).sendKeys(email1);
	driver.findElement(By.id("samlLoginBtn")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("password")).sendKeys(password1);
	driver.findElement(By.id("loginBtnId")).click();
	Thread.sleep(3000);
	
	//wait.until(ExpectedConditions.titleContains("Acuity Link"));
	String t= driver.getTitle();
	System.out.println("Title of the page:"+t);
	Reporter.log("Title of the page:"+t,true);
	SoftAssert s= new SoftAssert();
	s.assertEquals(t, "Acuity Link");
	Reporter.log("Login successful", true);
	WebElement ele1= driver.findElement(By.id("manageAmbulance"));
	String t1= ele1.getText();
	System.out.println("Tab name:"+t1);
	Reporter.log("Tab name is:"+ t1, true);
	SoftAssert s1= new SoftAssert();
	s1.assertEquals(t1, "Vehicles");
	Reporter.log("ASP Validation successful", true);
	Thread.sleep(2000);
		}
	
		

/*@AfterTest
public void close()
{
	driver.close();
}*/
}


