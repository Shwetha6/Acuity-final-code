package Create_Service_Request_ALS_Oneway;

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


public class ALS_Oneway 
{
	WebDriver driver;
	private java.util.List<WebElement> option; 
	WebDriverWait wait;
	public static String e;
	
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

	@Test(priority=1)
	public void HiFillPatientInformationALSCustom() throws Exception
	{
	
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
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Advanced')]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(),'One-Way')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
			
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Airway management / suctioning required')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Mechanical ventilation')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Medication(s) will be infusing during transport')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Medication(s) will be administered during transport')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Cardiac (ECG) monitoring required')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Requesting physician / clinician judgment')]")).click();
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
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@id='puInfoTypeDivId0']//label[contains(text(), 'Custom')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("puFacultyName0")).sendKeys(pickup);
	driver.findElement(By.id("streetAddressPU0")).sendKeys(streetaddress);
	driver.findElement(By.id("zipcodePU0")).sendKeys(zip);
	Robot als1=new Robot();
	als1.keyPress(KeyEvent.VK_TAB);
	Thread.sleep(4000);
	driver.findElement(By.xpath("//div[@id='destInfoTypeDivId0']//label[contains(text(), 'Custom')]")).click();
	driver.findElement(By.xpath("//div[@id='customHiDivId0']//label[@class='aq-checkbox-label marL5']")).click();
	driver.findElement(By.id("destFacultyName0")).sendKeys(destination);
	driver.findElement(By.id("streetAddress0")).sendKeys(deststreet);
	driver.findElement(By.id("zipcode0")).sendKeys(zipdest);
	als1.keyPress(KeyEvent.VK_TAB);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//label[@class='aq-checkbox-label marB20']//strong[contains(text(), ' EMERGENCY RESPONSE')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("note")).sendKeys(note);
	driver.findElement(By.id("srDivId3")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("submitRequestButtonId")).click();
	Thread.sleep(2000);
	WebElement ele41=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
	String t39=ele41.getText();
	System.out.println("Pop up title:"+ t39);
	SoftAssert s25= new SoftAssert();
	s25.assertEquals(ele41, "Service request successfully created.");
	Reporter.log("Service request successfully created pop up is displayed(ALS) with custom pick up and destination(One-way)", true);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
	
		}
		
	
	
	@Test(priority=2)
	public void HiCreateServiceRequest() throws Exception
	{
			
		    Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Advanced')]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(),'One-Way')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
			
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Airway management / suctioning required')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Mechanical ventilation')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Medication(s) will be infusing during transport')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Medication(s) will be administered during transport')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Cardiac (ECG) monitoring required')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Requesting physician / clinician judgment')]")).click();
			driver.findElement(By.xpath("//button[@class='btn aq-btn open1'][contains(text(), 'Next')]")).click();
			
			Data_Acuity.setExcelFile(Constant_Acuity.Excelpath,"Sheet1");
			String firstname=Data_Acuity.getCellData(23, 1); 
			String lastname=Data_Acuity.getCellData(23, 2);
			String dob=Data_Acuity.getCellData(23, 3);
			String phno=Data_Acuity.getCellData(23, 4);
			String weight=Data_Acuity.getCellData(23, 5);
			String roomno=Data_Acuity.getCellData(23, 6);
			String desthi=Data_Acuity.getCellData(23, 7);
			String note=Data_Acuity.getCellData(23, 8);
			
			
			
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
	
	Thread.sleep(3000);
	driver.findElement(By.id("searchId0")).sendKeys(desthi);
	Thread.sleep(4000);
	Robot als=new Robot();
	als.keyPress(KeyEvent.VK_DOWN);	
	als.keyPress(KeyEvent.VK_ENTER);
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
	driver.findElement(By.xpath("//label[@class='aq-checkbox-label marB20']//strong")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("note")).sendKeys(note);
	driver.findElement(By.id("srDivId3")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("submitRequestButtonId")).click();
	Thread.sleep(2000);
	WebElement ele37=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
	String t35=ele37.getText();
	System.out.println("Pop up title:"+ t35);
	SoftAssert s21= new SoftAssert();
	s21.assertEquals(ele37, "Service request successfully created.");
	Reporter.log("Service request successfully created pop up is displayed(ALS) with default pick up and destination(One-way)", true);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
	
		}
	
	
	@Test(priority=3)
	public void HiFillPatientInformationALSCustomAndDefault() throws Exception
	{
		    Thread.sleep(3000);
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
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Advanced')]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(),'One-Way')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
			
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Airway management / suctioning required')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Mechanical ventilation')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Medication(s) will be infusing during transport')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Medication(s) will be administered during transport')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Cardiac (ECG) monitoring required')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Requesting physician / clinician judgment')]")).click();
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
	Robot als2=new Robot();
	als2.keyPress(KeyEvent.VK_TAB);
	Thread.sleep(3000);
	
	driver.findElement(By.id("searchId0")).sendKeys(desthi);
	Thread.sleep(4000);
	Robot als=new Robot();
	als2.keyPress(KeyEvent.VK_DOWN);	
	als2.keyPress(KeyEvent.VK_ENTER);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Sam')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[3]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Random')]")).click();
	
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//label[@class='aq-checkbox-label marB20']//strong[contains(text(), ' EMERGENCY RESPONSE')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("note")).sendKeys(note);
	driver.findElement(By.id("srDivId3")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("submitRequestButtonId")).click();
	Thread.sleep(2000);
	WebElement ele44=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
	String t42=ele44.getText();
	System.out.println("Pop up title:"+ t42);
	SoftAssert s28= new SoftAssert();
	s28.assertEquals(ele44, "Service request successfully created.");
	Reporter.log("Service request successfully created pop up is displayed(ALS) with custom pick up and acuity network destination(One-way)", true);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
	
		}
		
	
	@Test(priority=4)
	public void HiFillPatientInformationALSDefaultAndCustom() throws Exception
	{
		
		Thread.sleep(3000);
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
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Advanced')]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(),'One-Way')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-radio-label'][contains(text(),'No')]")).click();
			
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Airway management / suctioning required')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Mechanical ventilation')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Medication(s) will be infusing during transport')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Medication(s) will be administered during transport')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Cardiac (ECG) monitoring required')]")).click();
			driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(), 'Requesting physician / clinician judgment')]")).click();
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
	
	driver.findElement(By.xpath("//div[@id='destInfoTypeDivId0']//label[contains(text(), 'Custom')]")).click();
	driver.findElement(By.xpath("//div[@id='customHiDivId0']//label[@class='aq-checkbox-label marL5']")).click();
	driver.findElement(By.id("destFacultyName0")).sendKeys(destination);
	driver.findElement(By.id("streetAddress0")).sendKeys(deststreet);
	driver.findElement(By.id("zipcode0")).sendKeys(zipdest);
	Robot als3=new Robot();
	als3.keyPress(KeyEvent.VK_TAB);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//label[@class='aq-checkbox-label marB20']//strong")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("note")).sendKeys(note);
	driver.findElement(By.id("srDivId3")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("submitRequestButtonId")).click();
	Thread.sleep(2000);
	WebElement ele47=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
	String t45=ele47.getText();
	System.out.println("Pop up title:"+ t45);
	SoftAssert s31= new SoftAssert();
	s31.assertEquals(ele47, "Service request successfully created.");
	Reporter.log("Service request successfully created pop up is displayed(ALS) with default pick up and custom destination(One-way)", true);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[@id='0']")).click();
	Thread.sleep(3000);
	e = driver.findElement(By.xpath("//span[@id='customRequestId']")).getText();
    System.out.println("Text is: "+e);
    System.out.println(e);
		}
		
	}
	
	

