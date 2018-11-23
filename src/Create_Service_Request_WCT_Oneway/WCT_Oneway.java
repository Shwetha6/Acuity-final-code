package Create_Service_Request_WCT_Oneway;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Design1.Constant_Acuity;
import Design1.Data_Acuity;



public class WCT_Oneway 
{
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
	}
	
	@Test(priority=1)
	public void HiFillPatientInformationWCTCustom() throws Exception
	{
		
			Data_Acuity.setExcelFile(Constant_Acuity.Excelpath,"Sheet1");
			String firstname=Data_Acuity.getCellData(23, 1); 
			String lastname=Data_Acuity.getCellData(23, 2);
			String dob=Data_Acuity.getCellData(23, 3);
			String phno=Data_Acuity.getCellData(23, 4);
			String weight=Data_Acuity.getCellData(23, 5);
			String roomno=Data_Acuity.getCellData(23, 6);
			String desthi=Data_Acuity.getCellData(23, 7);
			String note=Data_Acuity.getCellData(23, 8);
			
			String pickup=Data_Acuity.getCellData(29, 2);
			String streetaddress=Data_Acuity.getCellData(29, 3);
			String zip=Data_Acuity.getCellData(29, 4);
			String destination=Data_Acuity.getCellData(29, 5);
			String deststreet=Data_Acuity.getCellData(29, 6);
			String zipdest=Data_Acuity.getCellData(29, 7);
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Wheelchair')]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(),'One-Way')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
		    driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();
			
	driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
	driver.findElement(By.id("patientLastName")).sendKeys(lastname);
	driver.findElement(By.id("patientDob")).sendKeys(dob);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
	driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
	driver.findElement(By.id("patientWeight")).sendKeys(weight);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
	driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[contains(text(), 'Custom')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("puFacultyName0")).sendKeys(pickup);
	driver.findElement(By.id("streetAddressPU0")).sendKeys(streetaddress);
	driver.findElement(By.id("zipcodePU0")).sendKeys(zip);
	Robot wctone=new Robot();
	wctone.keyPress(KeyEvent.VK_TAB);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@id='destInfoTypeDivId0']//label[contains(text(), 'Custom')]")).click();
	driver.findElement(By.xpath("//div[@id='customHiDivId0']//label[@class='aq-checkbox-label marL5']")).click();
	driver.findElement(By.id("destFacultyName0")).sendKeys(destination);
	driver.findElement(By.id("streetAddress0")).sendKeys(deststreet);
	driver.findElement(By.id("zipcode0")).sendKeys(zipdest);
	wctone.keyPress(KeyEvent.VK_TAB);
	Thread.sleep(2000);
	driver.findElement(By.id("srDivId2")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("submitRequestButtonId")).click();
	Thread.sleep(2000);
	WebElement ele88=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
	String t86=ele88.getText();
	System.out.println("Pop up title:"+ t86);
	SoftAssert s52= new SoftAssert();
	s52.assertEquals(ele88, "Service request successfully created.");
	Reporter.log("Service request successfully created pop up is displayed(WCT) with custom pick up and destination(One-way)", true);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();

		}
		
	
	@Test(priority=2)
	public void HiFillPatientInformationWCT() throws Exception
	{
		
			Data_Acuity.setExcelFile(Constant_Acuity.Excelpath,"Sheet1");
			String firstname=Data_Acuity.getCellData(23, 1); 
			String lastname=Data_Acuity.getCellData(23, 2);
			String dob=Data_Acuity.getCellData(23, 3);
			String phno=Data_Acuity.getCellData(23, 4);
			String weight=Data_Acuity.getCellData(23, 5);
			String roomno=Data_Acuity.getCellData(23, 6);
			String desthi=Data_Acuity.getCellData(23, 7);
			String note=Data_Acuity.getCellData(23, 8);
			
		
	Thread.sleep(3000);		
	driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Wheelchair')]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(),'One-Way')]")).click();
	driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
	driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();		
			
	driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
	driver.findElement(By.id("patientLastName")).sendKeys(lastname);
	driver.findElement(By.id("patientDob")).sendKeys(dob);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
	driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
	driver.findElement(By.id("patientWeight")).sendKeys(weight);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
	driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][1]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Select Building')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'AutoBuilding5')]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[1]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Floor1')]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[1]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Unit1')]")).click();
	driver.findElement(By.id("puRoomNumber0")).sendKeys(roomno);
	
	driver.findElement(By.id("searchId0")).sendKeys(desthi);
	Thread.sleep(4000);
	Robot wcttwo=new Robot();
	wcttwo.keyPress(KeyEvent.VK_DOWN);
	wcttwo.keyPress(KeyEvent.VK_ENTER);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Sam')]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[2]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[4]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')]")).click();
    driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Random')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Review and Submit')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("submitRequestButtonId")).click();
	Thread.sleep(2000);
	WebElement ele40=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
	String t38=ele40.getText();
	System.out.println("Pop up title:"+ t38);
	SoftAssert s24= new SoftAssert();
	s24.assertEquals(ele40, "Service request successfully created.");
	Reporter.log("Service request successfully created pop up is displayed(WCT) with default pick up and destination(One-way)", true);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
	
		}
	
	
	
	
	@Test(priority=3)
	public void HiFillPatientInformationCCTCustomAndDefault() throws Exception
	{
			
			Data_Acuity.setExcelFile(Constant_Acuity.Excelpath,"Sheet1");
			String firstname=Data_Acuity.getCellData(23, 1); 
			String lastname=Data_Acuity.getCellData(23, 2);
			String dob=Data_Acuity.getCellData(23, 3);
			String phno=Data_Acuity.getCellData(23, 4);
			String weight=Data_Acuity.getCellData(23, 5);
			String roomno=Data_Acuity.getCellData(23, 6);
			String desthi=Data_Acuity.getCellData(23, 7);
			String note=Data_Acuity.getCellData(23, 8);
			
			String pickup=Data_Acuity.getCellData(29, 2);
			String streetaddress=Data_Acuity.getCellData(29, 3);
			String zip=Data_Acuity.getCellData(29, 4);
	
    Thread.sleep(3000);
    driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Wheelchair')]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(),'One-Way')]")).click();
	driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
    driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();	
			
	driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
	driver.findElement(By.id("patientLastName")).sendKeys(lastname);
	driver.findElement(By.id("patientDob")).sendKeys(dob);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
	driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
	driver.findElement(By.id("patientWeight")).sendKeys(weight);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
	
	driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[contains(text(), 'Custom')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("puFacultyName0")).sendKeys(pickup);
	driver.findElement(By.id("streetAddressPU0")).sendKeys(streetaddress);
	driver.findElement(By.id("zipcodePU0")).sendKeys(zip);
	Robot wctt=new Robot();
	wctt.keyPress(KeyEvent.VK_TAB);
	Thread.sleep(3000);
	
	driver.findElement(By.id("searchId0")).sendKeys(desthi);
	Thread.sleep(4000);
	
	wctt.keyPress(KeyEvent.VK_DOWN);
	wctt.keyPress(KeyEvent.VK_ENTER);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Sam')]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[3]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Random')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("srDivId2")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("submitRequestButtonId")).click();
	Thread.sleep(2000);
	WebElement ele86=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
	String t84=ele86.getText();
	System.out.println("Pop up title:"+ t84);
	SoftAssert s50= new SoftAssert();
	s50.assertEquals(ele86, "Service request successfully created.");
	Reporter.log("Service request successfully created pop up is displayed(WCT)using custom pick up and default destinaion(One-way)", true);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
	
		}
	
		
		
		@Test(priority=4)
		public void HiFillPatientInformationWCTDefaultAndCustom() throws Exception
		{
			
				Data_Acuity.setExcelFile(Constant_Acuity.Excelpath,"Sheet1");
				String firstname=Data_Acuity.getCellData(23, 1); 
				String lastname=Data_Acuity.getCellData(23, 2);
				String dob=Data_Acuity.getCellData(23, 3);
				String phno=Data_Acuity.getCellData(23, 4);
				String weight=Data_Acuity.getCellData(23, 5);
				String roomno=Data_Acuity.getCellData(23, 6);
				String desthi=Data_Acuity.getCellData(23, 7);
				String note=Data_Acuity.getCellData(23, 8);
				
				String destination=Data_Acuity.getCellData(29, 5);
				String deststreet=Data_Acuity.getCellData(29, 6);
				String zipdest=Data_Acuity.getCellData(29, 7);
				
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Wheelchair')]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(),'One-Way')]")).click();
				driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();

				driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();
				
				
		driver.findElement(By.id("patientFirstName")).sendKeys(firstname);
		driver.findElement(By.id("patientLastName")).sendKeys(lastname);
		driver.findElement(By.id("patientDob")).sendKeys(dob);
		driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Gender')]")).click();
		driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Female')]")).click();
		driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno);
		driver.findElement(By.id("patientWeight")).sendKeys(weight);
		driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Pounds')]")).click();
		driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Kilograms')]")).click();
		driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[@class='aq-radio-label'][1]")).click();
		driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Select Building')]")).click();
		driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'AutoBuilding5')]")).click();
		driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
		driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
		driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[1]")).click();
		driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Floor1')]")).click();
		driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[1]")).click();
		driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Unit1')]")).click();
		driver.findElement(By.id("puRoomNumber0")).sendKeys(roomno);
		Thread.sleep(2000);
			
		driver.findElement(By.xpath("//div[@id='destInfoTypeDivId0']//label[contains(text(), 'Custom')]")).click();
		driver.findElement(By.xpath("//div[@id='customHiDivId0']//label[@class='aq-checkbox-label marL5']")).click();
		driver.findElement(By.id("destFacultyName0")).sendKeys(destination);
		driver.findElement(By.id("streetAddress0")).sendKeys(deststreet);
		driver.findElement(By.id("zipcode0")).sendKeys(zipdest);
		Robot cct3=new Robot();
		cct3.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(4000);
		driver.findElement(By.id("srDivId2")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("submitRequestButtonId")).click();
		Thread.sleep(2000);
		WebElement ele87=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
		String t85=ele87.getText();
		System.out.println("Pop up title:"+ t85);
		SoftAssert s51= new SoftAssert();
		s51.assertEquals(ele87, "Service request successfully created.");
		Reporter.log("Service request successfully created pop up is displayed(WCT) with default pick up and custom destination(One-way)", true);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
			
		}
}
	
	
	
	
	


