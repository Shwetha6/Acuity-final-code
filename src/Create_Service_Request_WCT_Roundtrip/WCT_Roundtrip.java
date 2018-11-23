package Create_Service_Request_WCT_Roundtrip;

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


public class WCT_Roundtrip 
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
	public void HiFillPatientInformationWCTRoundTripcustompickdest() throws Exception
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
			
			
			driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Wheelchair')]")).click();
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
			Robot wctround1=new Robot();
			wctround1.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@id='destInfoTypeDivId0']//label[contains(text(), 'Custom')]")).click();
			driver.findElement(By.xpath("//div[@id='customHiDivId0']//label[@class='aq-checkbox-label marL5']")).click();
			driver.findElement(By.id("destFacultyName0")).sendKeys(destination);
			driver.findElement(By.id("streetAddress0")).sendKeys(deststreet);
			driver.findElement(By.id("zipcode0")).sendKeys(zipdest);
			wctround1.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(2000);
	
	driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
	
	SoftAssert s56= new SoftAssert();
	
	driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
	Thread.sleep(3000);
    WebElement ele92=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
	String t90=ele92.getText();
	System.out.println("Pop up title:"+ t90);
	s56.assertEquals(ele92, "Service request successfully created.");
	Reporter.log("Service request successfully created pop up is displayed(WCT) with custom pick up and destination(Round trip)", true);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
	
		}
		
		
		
		@Test(priority=2)
		public void HiFillPatientInformationWCTRoundTripdefaultpickcustomdest() throws Exception
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
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Wheelchair')]")).click();
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
		Robot wctdc=new Robot();
		wctdc.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);

	driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);

	SoftAssert s60= new SoftAssert();

	driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
	Thread.sleep(3000);
	WebElement ele96=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
	String t94=ele96.getText();
	System.out.println("Pop up title:"+ t94);
	s60.assertEquals(ele96, "Service request successfully created.");
	Reporter.log("Service request successfully created pop up is displayed(WCT) with default pick up and custom destination(Round trip)", true);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();

		}
		
			
			
			@Test(priority=3)
			public void HiFillPatientInformationWCTRoundcustompickdefaultdest() throws Exception
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
					driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Wheelchair')]")).click();
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
					Robot wctcd=new Robot();
					wctcd.keyPress(KeyEvent.VK_TAB);
					Thread.sleep(3000);
			
					driver.findElement(By.id("searchId0")).sendKeys(desthi);
					Thread.sleep(4000);
					wctcd.keyPress(KeyEvent.VK_DOWN);	
					wctcd.keyPress(KeyEvent.VK_ENTER);
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
					
					
					/*driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
					driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[2]")).click();
					Thread.sleep(3000);*/
					
					driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
					
					
					SoftAssert s64= new SoftAssert();
					
					driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
					driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
					Thread.sleep(3000);
				    WebElement ele100=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
					String t98=ele100.getText();
					System.out.println("Pop up title:"+ t98);
					s64.assertEquals(ele100, "Service request successfully created.");
					Reporter.log("Service request successfully created pop up is displayed(WCT) with custom pick up and default destination(Round trip)", true);
					Thread.sleep(3000);
					driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
					
						}
						
				
				
				@Test(priority=4)
				public void HiFillPatientInformationWCTRoundTrip() throws Exception
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
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Wheelchair')]")).click();
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
				Robot wctrnd=new Robot();
				wctrnd.keyPress(KeyEvent.VK_DOWN);
				wctrnd.keyPress(KeyEvent.VK_ENTER);
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Sam')]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
			    Thread.sleep(3000);
			    driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[2]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[4]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')]")).click();
			    driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Random')]")).click();
				Thread.sleep(3000);
				/*driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
				driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[2]")).click();
				Thread.sleep(3000);*/
				
				driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
				
				WebElement ele65=driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Sam')])[1]"));
				String t63=ele65.getText();
				WebElement ele66=driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Sam')])[2]"));
				String t64=ele66.getText();
				if(t63==t64)
				{
					System.out.println("Destination is assigned as pick up to next trip for WCT");
				}
				else
				{
					System.out.println("Destination is not assigned as pick up to next trip for WCT");
				}
				
				WebElement ele67=driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Auto')])[1]"));
				String t65=ele67.getText();
				WebElement ele68=driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Auto')])[2]"));
				String t66=ele68.getText();
				if(t65==t66)
				{
					System.out.println("Pick up is assigned as destination to round trip for WCT");
				}
				else
				{
					System.out.println("Pick up is not assigned as destination to round trip for WCT");
				}
				
				SoftAssert s36= new SoftAssert();
				Reporter.log("Pick up and destination is verified for next trips", true);
				
				driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
				driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
				Thread.sleep(3000);
			    WebElement ele69=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
				String t67=ele69.getText();
				System.out.println("Pop up title:"+ t67);
				s36.assertEquals(ele69, "Service request successfully created.");
				Reporter.log("Service request successfully created pop up is displayed(WCT) with default pick up and destination(Round trip)", true);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
				
					}
					
}
