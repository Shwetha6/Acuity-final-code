package ASP_Requests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Design1.Constant_Acuity;
import Design1.Data_Acuity;

public class ASP_requests 
{

	WebDriver driver;
	private java.util.List<WebElement> option; 
	WebDriverWait wait;
	
	@BeforeTest
	public void init4() throws Exception
	{
		
		Data_Acuity.setExcelFile(Constant_Acuity.Excelpath,"Sheet2");
		String email1=Data_Acuity.getCellData(11, 0); 
		String password1=Data_Acuity.getCellData(11, 1);
		String url = Data_Acuity.getCellData(22, 0);
		System.setProperty("webdriver.chrome.driver","./Reqfiles/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get(url);  //Enter the URL
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.findElement(By.id("samlUserEmail")).sendKeys(email1);
		driver.findElement(By.id("samlLoginBtn")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("password")).sendKeys(password1);
		driver.findElement(By.id("loginBtnId")).click();
		Thread.sleep(3000);
	}
		
		@Test(priority=1)
		public void pending_requests() throws Exception
		{
			
		Thread.sleep(15000);
		driver.findElement(By.linkText("Requests")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.id("aspPendingReq")).click();
	    Thread.sleep(2000);
	    System.out.println("Text is: "+Create_Service_Request_ALS_Oneway.ALS_Oneway.e);
	    WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(ExpectedConditions.elementToBeClickable(By.linkText(Create_Service_Request_ALS_Oneway.ALS_Oneway.e)));
	    driver.findElement(By.linkText(Create_Service_Request_ALS_Oneway.ALS_Oneway.e)).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//button[@class='btn aq-btn '][contains(text(), 'Accept')]")).click();
	    Thread.sleep(3000);
	    WebElement ele1=driver.findElement(By.xpath("//h2[@class='font26 fontW400 marT5 marB25'][contains(text(), 'Pending Requests')]"));
		String t1=ele1.getText();
		System.out.println("Title name is :"+ t1);
		SoftAssert s1= new SoftAssert();
		s1.assertEquals(ele1, "Pending Requests");
		Reporter.log("Pending Requests page is displayed. Hence request has been accepted", true);
	    
		}
		
		
		@Test(priority=2)
		public void active_requests() throws Exception
		{
			
		Thread.sleep(5000);
		driver.findElement(By.linkText("Requests")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("aspActiveReq")).click();
	    Thread.sleep(3000);
	    
	    Thread.sleep(2000);
	    
	    for(int i=1; i<=10; i++)
	    {
	    	boolean foundvalue=false;
	    	for(int j=1; j<=10; j++ )
	    	{
	    	  String s = driver.findElement(By.xpath("(//a[@class='txttheme'])["+j+"]")).getText();
	    	  System.out.println("The value is: "+s);
	    	  if(s.equals(Create_Service_Request_ALS_Oneway.ALS_Oneway.e))
	    	  {
	    		  Thread.sleep(2000);
	    		  driver.findElement(By.partialLinkText(Create_Service_Request_ALS_Oneway.ALS_Oneway.e)).click();
	    		  foundvalue=true;
	    		  break;
	    	  }
	    	}
	    	if(foundvalue||!driver.findElement(By.id("manageRequestTableId_next")).isEnabled())
	    		break;	 
    	    else if(driver.findElement(By.id("manageRequestTableId_next")).isEnabled())
    	    	driver.findElement(By.id("manageRequestTableId_next")).click();
	    }
	    System.out.println("Inside request details page now.");
	    Thread.sleep(3000);
	    System.out.println("After waiting for 3 seconds");
	    driver.findElement(By.xpath("(//a/button)[1]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//button[@class='btn aq-btn aq-btn-sm padL10 padR10 txtcenter']")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//a[@id='backToActiveAsp']/img")).click();
	    WebElement ele2=driver.findElement(By.xpath("//h2[@class='font26 fontW400 marT5 marB25'][contains(text(), 'Active Requests')]"));
		String t2=ele2.getText();
		System.out.println("Title name is :"+ t2);
		SoftAssert s2= new SoftAssert();
		s2.assertEquals(ele2, "Active Requests");
		Reporter.log("Active Requests page is displayed. Hence request has been assigned to vehicle", true);
	  
	    
		}
		
}

