package Create_Service_Request_ALS_Roundtrip;

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


public class ALS_Roundtrip 
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
		Thread.sleep(3000);
	}
	
	
	@Test(priority=1)
	public void HiFillPatientInformationALSRoundTrip() throws Exception
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
			String datetime=Data_Acuity.getCellData(34, 2);
			String datetime1=Data_Acuity.getCellData(34, 3);
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Advanced')]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Round')]")).click();
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
			Robot alsmul=new Robot();
			alsmul.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@id='destInfoTypeDivId0']//label[contains(text(), 'Custom')]")).click();
			driver.findElement(By.xpath("//div[@id='customHiDivId0']//label[@class='aq-checkbox-label marL5']")).click();
			driver.findElement(By.id("destFacultyName0")).sendKeys(destination);
			driver.findElement(By.id("streetAddress0")).sendKeys(deststreet);
			driver.findElement(By.id("zipcode0")).sendKeys(zipdest);
			alsmul.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(2000);
	
	driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
	
	SoftAssert s53= new SoftAssert();
	
	driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
	driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("note")).sendKeys(note);
	driver.findElement(By.id("srDivId3")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
	Thread.sleep(3000);
    WebElement ele89=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
	String t87=ele89.getText();
	System.out.println("Pop up title:"+ t87);
	s53.assertEquals(ele89, "Service request successfully created.");
	Reporter.log("Service request successfully created pop up is displayed(ALS) with custom pick up and destination(Round trip)", true);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
	
		}
		
		
		
		@Test(priority=2)
		public void HiFillPatientInformationALSRoundTripdefaultpickcustomdest() throws Exception
		{
				
				Data_Acuity.setExcelFile(Constant_Acuity.Excelpath,"Sheet1");
				String firstname=Data_Acuity.getCellData(23, 1); 
				String lastname=Data_Acuity.getCellData(23, 2);
				String dob=Data_Acuity.getCellData(23, 3);
				String phno=Data_Acuity.getCellData(23, 4);
				String weight=Data_Acuity.getCellData(23, 5);
				String roomno=Data_Acuity.getCellData(23, 6);
				String note=Data_Acuity.getCellData(23, 8);
				
				String destination=Data_Acuity.getCellData(29, 5);
				String deststreet=Data_Acuity.getCellData(29, 6);
				String zipdest=Data_Acuity.getCellData(29, 7);
				String datetime=Data_Acuity.getCellData(34, 2);
				String datetime1=Data_Acuity.getCellData(34, 3);
				
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Advanced')]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Round')]")).click();
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
		Robot alsdc=new Robot();
		alsdc.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);

	driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);

	SoftAssert s57= new SoftAssert();

	driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("note")).sendKeys(note);
	driver.findElement(By.id("srDivId3")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
	Thread.sleep(3000);
	WebElement ele93=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
	String t91=ele93.getText();
	System.out.println("Pop up title:"+ t91);
	s57.assertEquals(ele93, "Service request successfully created.");
	Reporter.log("Service request successfully created pop up is displayed(ALS) with default pick up and custom destination(Round trip)", true);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();

		}
		
			
			
			@Test(priority=3)
			public void HiFillPatientInformationALSRoundcustompickdefaultdest() throws Exception
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
					String datetime=Data_Acuity.getCellData(34, 2);
					String datetime1=Data_Acuity.getCellData(34, 3);
					
					Thread.sleep(3000);
					driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
					driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
					driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Advanced')]")).click();
					driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
					driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Round')]")).click();
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
					Robot alscd=new Robot();
					alscd.keyPress(KeyEvent.VK_TAB);
					Thread.sleep(3000);
			
					driver.findElement(By.id("searchId0")).sendKeys(desthi);
					Thread.sleep(4000);
					
					alscd.keyPress(KeyEvent.VK_DOWN);	
					alscd.keyPress(KeyEvent.VK_ENTER);
					driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Sam')]")).click();

				    driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
					driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
					driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
					driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[3]")).click();
					driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
					driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Random')]")).click();
					Thread.sleep(3000);
					
					
					driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
					driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[2]")).click();
					Thread.sleep(3000);
					
					driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
					
					
					SoftAssert s61= new SoftAssert();
					
					driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
					driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
					Thread.sleep(3000);
					driver.findElement(By.id("note")).sendKeys(note);
					driver.findElement(By.id("srDivId3")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
					Thread.sleep(3000);
				    WebElement ele97=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
					String t95=ele97.getText();
					System.out.println("Pop up title:"+ t95);
					s61.assertEquals(ele97, "Service request successfully created.");
					Reporter.log("Service request successfully created pop up is displayed(ALS) with custom pick up and default destination(Round trip)", true);
					Thread.sleep(3000);
					driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
					
						}
						 
			
			
			@Test(priority=4)
			public void HiFillPatientInformationALSRoundTripDefaultpickandDest() throws Exception
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
					
					String datetime=Data_Acuity.getCellData(34, 2);
					String datetime1=Data_Acuity.getCellData(34, 3);
					
					Thread.sleep(3000);
					driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
					driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
					driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Advanced')]")).click();
					driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
					driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Round')]")).click();
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
			
			driver.findElement(By.id("searchId0")).sendKeys(desthi);
			Thread.sleep(4000);
			Robot als=new Robot();
			als.keyPress(KeyEvent.VK_DOWN);	
			als.keyPress(KeyEvent.VK_ENTER);
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Sam')]")).click();
		    driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[2]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[4]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Random')]")).click();
			Thread.sleep(3000);
			//driver.findElement(By.id("puBuildingNameTemp1")).click();
			
			/*driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[2]")).click();
			Thread.sleep(2000);*/
			
			driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
			
			WebElement ele50=driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Sam')])[1]"));
			String t48=ele50.getText();
			WebElement ele51=driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Sam')])[2]"));
			String t49=ele51.getText();
			if(t48==t49)
			{
				System.out.println("Destination is assigned as pick up to next trip");
			}
			else
			{
				System.out.println("Destination is not assigned as pick up to next trip");
			}
			
			WebElement ele52=driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Auto')])[1]"));
			String t50=ele52.getText();
			WebElement ele53=driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Auto')])[2]"));
			String t51=ele53.getText();
			if(t50==t51)
			{
				System.out.println("Pick up is assigned as destination to round trip");
			}
			else
			{
				System.out.println("Pick up is not assigned as destination to round trip");
			}
			
			SoftAssert s34= new SoftAssert();
			Reporter.log("Pick up and destination is verified for next trips", true);
			
			driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
			driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("note")).sendKeys(note);
			driver.findElement(By.id("srDivId3")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
			Thread.sleep(3000);
		    WebElement ele54=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
			String t52=ele54.getText();
			System.out.println("Pop up title:"+ t52);
			s34.assertEquals(ele54, "Service request successfully created.");
			Reporter.log("Service request successfully created pop up is displayed(ALS) with default pick up and destination(Round trip)", true);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
			
				}
				
			}
			
			
			
	
	
	
	
	

