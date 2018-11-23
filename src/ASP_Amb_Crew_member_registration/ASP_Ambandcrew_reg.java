package ASP_Amb_Crew_member_registration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Design1.Constant_Acuity;
import Design1.Data_Acuity; 

public class ASP_Ambandcrew_reg 
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
		String url=Data_Acuity.getCellData(22, 0);
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
		public void ambulanceregistration() throws Exception
		{
			
			
			String unit=Data_Acuity.getCellData(7, 0);
			String capability=Data_Acuity.getCellData(7, 1);
			String noplate=Data_Acuity.getCellData(7, 2);
			
			
		driver.findElement(By.id("aspManageVeh")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    Thread.sleep(3000);
	    
	    driver.findElement(By.xpath("//img[@src='../images/leftArrow.png']")).click();
	    Thread.sleep(3000);
	    WebElement ele1=driver.findElement(By.xpath("//h2[@class='font26 fontW400 marT5 marB20'][contains(text(), 'Vehicles')]"));
		String t1=ele1.getText();
		System.out.println("Title of the page:"+ t1);
		SoftAssert s2= new SoftAssert();
		s2.assertEquals(ele1, "Vehicles");
		Reporter.log("Vehicles page is displayed. Hence back button is clickable", true);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.id("unitNum")).click();
	    driver.findElement(By.id("unitNum")).clear();
	    driver.findElement(By.id("unitNum")).sendKeys(unit);
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//form[@id='createAmbulanceFormId']/div/div/div[2]/div/button/span")).click();
	    driver.findElement(By.xpath("//form[@id='createAmbulanceFormId']/div/div/div[2]/div/div/ul/li[2]/a/span")).click();
	    new Select(driver.findElement(By.id("capability"))).selectByVisibleText(capability);
	    Thread.sleep(2000);
	    driver.findElement(By.id("vehilePlateNumber")).click();
	    driver.findElement(By.id("vehilePlateNumber")).clear();
	    driver.findElement(By.id("vehilePlateNumber")).sendKeys(noplate);
	    Thread.sleep(2000);
	    driver.findElement(By.id("createId")).click();
	    Thread.sleep(3000);
	    WebElement ele2=driver.findElement(By.xpath("//h2[@class='font26 fontW400 marT5 marB20'][contains(text(), 'Vehicles')]"));
		String t2=ele2.getText();
		System.out.println("Title of the page:"+ t2);
		s2.assertEquals(ele2, "Vehicles");
		Reporter.log("Vehicles page is displayed. Hence vehicle has been created", true);
	  	
	}
		
		
		@Test(priority=2)
		public void crewmemberregistration() throws Exception
		{
			
			Data_Acuity.setExcelFile(Constant_Acuity.Excelpath,"Sheet2");
			String fname=Data_Acuity.getCellData(15, 0); 
			String lname=Data_Acuity.getCellData(15, 1);
			String email1=Data_Acuity.getCellData(15, 2);
			String phno=Data_Acuity.getCellData(15, 3);
			String carrier=Data_Acuity.getCellData(15, 4);
			String licence=Data_Acuity.getCellData(15, 5);
			
		driver.findElement(By.id("aspManageCrew")).click();
	    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.id("closeBtn")).click();
	    Thread.sleep(2000);
	    WebElement ele3=driver.findElement(By.xpath("//button[@class='btn btn-default aq-btn marR15 btn01 aq-btn-1024'][contains(text(), 'Add Crew Member')]"));
		String t3=ele3.getText();
		System.out.println("Button name is :"+ t3);
		SoftAssert s3= new SoftAssert();
		s3.assertEquals(ele3, "Add Crew Member");
		Reporter.log("Add crew member button is displayed. Hence pop up has been closed", true);
		
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
	    Thread.sleep(2000);
	    
	    driver.findElement(By.id("firstName")).sendKeys(fname);
	    driver.findElement(By.id("lastName")).sendKeys(lname);
	    Thread.sleep(2000);
	    driver.findElement(By.id("email")).sendKeys(email1);
	    Thread.sleep(2000);
	    driver.findElement(By.id("phoneNumber")).sendKeys(phno);
	    driver.findElement(By.id("phoneCarrier")).sendKeys(carrier);
	    driver.findElement(By.id("memberLicense")).sendKeys(licence);
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//form[@id='addOrUpdateCrewMemebersForm']/div/div/div/div[7]/div/button/span")).click();
	    driver.findElement(By.xpath("//span[@class='text'][contains(text(),'Paramedic')]")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.id("submitId")).click();
	    //new Select(driver.findElement(By.id("certificationLevel"))).selectByVisibleText(level);
	    Thread.sleep(3000);
	    WebElement ele4=driver.findElement(By.xpath("//button[@class='btn btn-default aq-btn marR15 btn01 aq-btn-1024'][contains(text(), 'Add Crew Member')]"));
		String t4=ele4.getText();
		System.out.println("Button name is :"+ t4);
		s3.assertEquals(ele4, "Add Crew Member");
		Reporter.log("Add crew member button is displayed. Hence crew member has been created", true);
		
		}
		
		
		@Test(priority=3)
		public void crewmemberassignambulance() throws Exception
		{
			
			Data_Acuity.setExcelFile(Constant_Acuity.Excelpath,"Sheet2");
			String edate=Data_Acuity.getCellData(19, 0); 
			String time1=Data_Acuity.getCellData(19, 1);
		

		driver.findElement(By.xpath("(//a[@href='#'])[4]")).click();    //click on crew member
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//button[@type='button'][contains(text(),'Assign Vehicle')]")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Vehicle')]")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.linkText("WCT")).click();
	    driver.findElement(By.id("startTimePicker")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.id("endTimePicker")).click();
	    driver.findElement(By.id("endTimePicker")).clear();
	    driver.findElement(By.id("endTimePicker")).sendKeys(edate, time1);
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//div[@class='col-lg-12 col-md-12 col-sm-12 col-xs-12 marT10']")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//button[@id='submit']")).click();
	    Thread.sleep(5000);
	    WebElement ele5=driver.findElement(By.xpath("(//td)[3]"));
		String t5=ele5.getText();
		System.out.println("Button name is :"+ t5);
		SoftAssert s4= new SoftAssert();
		s4.assertEquals(ele5, "View Details");
		Reporter.log("Crew member has been assigned to ambulance", true);
	    
	
		}
}
