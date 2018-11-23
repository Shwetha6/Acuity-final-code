package ASP_Add_New_ASP;
import java.awt.Robot;
import java.awt.event.KeyEvent;
//import java.awt.List;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
import Login.HI_Login;

public class ASP_AddASP {

	WebDriver driver;
	private java.util.List<WebElement> option; 
	WebDriverWait wait;
	
	
	
	
	@BeforeTest
	public void init4() throws Exception
	{
		
		Data_Acuity.setExcelFile(Constant_Acuity.Excelpath,"Sheet1");
		String email1=Data_Acuity.getCellData(2, 12); 
		String password1=Data_Acuity.getCellData(2, 13);
		String url=Data_Acuity.getCellData(5, 0);
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

	//To check whether Ambulance Service Provider page is displayed
	
			@Test(priority=1)
			public void VerifyAspPage() throws Exception 
			{
				Data_Acuity.setExcelFile(Constant_Acuity.Excelpath,"Sheet1");
				String email1=Data_Acuity.getCellData(2, 12); 
				String password1=Data_Acuity.getCellData(2, 13);
				
				driver.findElement(By.id("samlUserEmail")).sendKeys(email1);
				driver.findElement(By.id("samlLoginBtn")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("password")).sendKeys(password1);
				driver.findElement(By.id("loginBtnId")).click();
				Thread.sleep(3000);

		driver.findElement(By.xpath("//a[@class='dropdown-toggle'][contains(text(), 'ASPs & Configuration')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Ambulance Service Providers")).click();
		WebElement ele=driver.findElement(By.xpath("//h2[@class='font26 fontW400 marT5 marB20'][contains(text(), 'Ambulance Service Providers')]"));
		String t2=ele.getText();
		System.out.println("Page title:"+ t2);
		SoftAssert s2= new SoftAssert();
		s2.assertEquals(ele, "Ambulance Service Providers");
		Reporter.log("Ambulance service provider page is displayed", true);
		Thread.sleep(3000);
	
		}
				
	

@Test(priority=2)
public void AddNewAsp() throws Exception
{
		
	    Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-default aq-btn marR15 btn01 aq-btn-1024'][contains(text(), 'Add New ASP')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[3]/div[1]/div[1]/div[1]/button[1]")).click();
		Thread.sleep(3000);
		System.out.println("Add New ASP to Acuity Link Network pop up is closed");
			
		//Adding new ASP by fetching data from excel
		Data_Acuity.setExcelFile(Constant_Acuity.Excelpath,"Sheet1");
		String aspname=Data_Acuity.getCellData(11, 1); 
		String email=Data_Acuity.getCellData(11, 2);
		String phno=Data_Acuity.getCellData(11, 3);
		
	driver.findElement(By.xpath("//button[@class='btn btn-default aq-btn marR15 btn01 aq-btn-1024'][contains(text(), 'Add New ASP')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.name("aspName")).sendKeys(aspname);
	driver.findElement(By.id("newUserEmail")).sendKeys(email);
	driver.findElement(By.id("newPhoneNumber")).sendKeys(phno);
	Thread.sleep(3000);
	driver.findElement(By.id("newASPBtn")).click();
	Thread.sleep(3000);
	if(driver.findElement(By.xpath("//div[@class='msg'][contains(text(), 'Request has been sent successfully.')]")).isDisplayed())
    {
    	System.out.println("New ASP created");
    }
	else
	{
		System.out.println("Test case fail");
	}
	WebElement ele1=driver.findElement(By.xpath("//div[@class='msg'][contains(text(), 'Request has been sent successfully.')]"));
	String t3=ele1.getText();
	System.out.println("Success message:"+ t3);
	SoftAssert s3= new SoftAssert();
	s3.assertEquals(ele1, "Request has been sent successfully.");
	Reporter.log("New ASP created", true);
	}
	

@Test(priority=3)
public void AddExistingAsp() throws InterruptedException 
{
        Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-default aq-btn marR15 btn01 aq-btn-1024'][contains(text(), 'Add Existing ASP')]")).click();
		WebElement ele3=driver.findElement(By.xpath("//h2[@class='font26 fontW400 marT5 marB20'][contains(text(), 'Existing Ambulance Service Providers')]"));
		String t3=ele3.getText();
		System.out.println("Title of the page:"+ t3);
		SoftAssert s4= new SoftAssert();
		s4.assertEquals(ele3, "Existing Ambulance Service Providers");
		Reporter.log("Add Existing ASP button is clickable", true);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[contains(@src, '../images/leftArrow.png')]")).click();
		Thread.sleep(4000);
		s4.assertEquals(ele3, "Existing Ambulance Service Providers");
		Reporter.log("Back button is clickable:Existing Ambulance Service Providers page is displayed", true);

	}

	
@Test(priority=4)
public void RemoveAsp() throws InterruptedException 
{

driver.findElement(By.xpath("//button[@class='btn aq-btn wauto aspRemove'][contains(text(), 'Remove')]")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//div[@class='bootbox-body'][contains(text(), 'Are you sure that you want to remove?')]")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
Thread.sleep(2000);
WebElement ele5= driver.findElement(By.xpath("//div[@class='msg'][contains(text(), 'ASP removed successfully.')]"));
String t4 = ele5.getText();
System.out.println("Success message:"+ t4);
SoftAssert s5= new SoftAssert();
s5.assertEquals(ele5, "ASP removed successfully.");
Reporter.log("ASP has been successfully removed", true);
	}
	 


@Test(priority=5)
public void RemoveAspFromAspdetailPage() throws InterruptedException 
{
		
Thread.sleep(3000);
driver.findElement(By.xpath("//a[@class='aspDetail dis-ellipsis']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//button[@class='btn aq-btn aspRemove'][contains(text(), 'Remove')]")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//div[@class='bootbox-body'][contains(text(), 'Are you sure that you want to remove?')]")).click();
Thread.sleep(4000);
driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[2]/button[2]")).click();
System.out.println("Success message: ASP removed using 'Remove' button from ASP detail page" );
WebElement ele6= driver.findElement(By.xpath("//div[@class='msg'][contains(text(), 'ASP removed successfully.')]"));
String t5 = ele6.getText();
SoftAssert s6= new SoftAssert();
s6.assertEquals(ele6, "ASP removed successfully.");
Reporter.log("ASP has been successfully removed using 'Remove' button in the ASP detail page", true);
Thread.sleep(2000);
	}
	


@Test(priority=6)
public void Pagination() throws InterruptedException 
{
		
Thread.sleep(2000);
driver.findElement(By.xpath("//a[@class='paginate_button ']")).click();
System.out.println("Pagination is clickable");
Thread.sleep(2000);


}

}













