package Create_Service_Request_BLS_Multi;

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


public class BLS_Multi 
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
	public void HiFillPatientInformationBLSDefaultMulti() throws Exception
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
			String datetime=Data_Acuity.getCellData(34, 2);
			String datetime1=Data_Acuity.getCellData(34, 3);
			String datetime2=Data_Acuity.getCellData(34, 4);
			String datetime3=Data_Acuity.getCellData(34, 5);
			String datetime4=Data_Acuity.getCellData(34, 6);
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Basic')]")).click();
			driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
			driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Multi-Destination')]")).click();
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
	Robot blsmuldef=new Robot();
	blsmuldef.keyPress(KeyEvent.VK_DOWN);	
	blsmuldef.keyPress(KeyEvent.VK_ENTER);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Sam')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[2]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[4]")).click();
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')]")).click();
    driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Random')]")).click();
	
	driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
	driver.findElement(By.id("addAnotherDestBtn")).click();
	Thread.sleep(2000);
	
	driver.findElement(By.id("searchId1")).sendKeys(desthi);
	Thread.sleep(4000);
	blsmuldef.keyPress(KeyEvent.VK_DOWN);	
	blsmuldef.keyPress(KeyEvent.VK_ENTER);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[2]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[3]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[6]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[2]")).click();
	
	driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
	driver.findElement(By.id("addAnotherDestBtn")).click();
	Thread.sleep(2000);
	
	
	driver.findElement(By.id("searchId2")).sendKeys(desthi);
	Thread.sleep(4000);
	blsmuldef.keyPress(KeyEvent.VK_DOWN);	
	blsmuldef.keyPress(KeyEvent.VK_ENTER);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[3]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[4]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[8]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[3]")).click();
	
	driver.findElement(By.id("puScheduledDateTime2")).sendKeys(datetime2);
	driver.findElement(By.id("addAnotherDestBtn")).click();
	Thread.sleep(2000);
	
	driver.findElement(By.id("searchId3")).sendKeys(desthi);
	Thread.sleep(4000);
	blsmuldef.keyPress(KeyEvent.VK_DOWN);	
	blsmuldef.keyPress(KeyEvent.VK_ENTER);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[4]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[5]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[10]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[4]")).click();
	
	driver.findElement(By.id("puScheduledDateTime3")).sendKeys(datetime3);
	driver.findElement(By.id("addAnotherDestBtn")).click();
	Thread.sleep(2000);
	
	driver.findElement(By.id("searchId4")).sendKeys(desthi);
	Thread.sleep(4000);
	blsmuldef.keyPress(KeyEvent.VK_DOWN);	
	blsmuldef.keyPress(KeyEvent.VK_ENTER);
	driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[5]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[6]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[12]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])")).click();
	driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[5]")).click();
	
	driver.findElement(By.id("puScheduledDateTime4")).sendKeys(datetime4);
	
	driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("note")).sendKeys(note);
	driver.findElement(By.id("srDivId3")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
	Thread.sleep(3000);
	WebElement ele83=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
	String t81=ele83.getText();
	System.out.println("Pop up title:"+ t81);
	SoftAssert s48= new SoftAssert();
	s48.assertEquals(ele83, "Service request successfully created.");
	Reporter.log("Service request successfully created pop up is displayed(BLS) with default pick up and destination for multiple destination", true);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
	
		}
		
		
		
		@Test(priority=2)
		public void HiFillPatientInformationBLSCustomAndDefaultMulti() throws Exception
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
				String datetime=Data_Acuity.getCellData(34, 2);
				String datetime1=Data_Acuity.getCellData(34, 3);
				String datetime2=Data_Acuity.getCellData(34, 4);
				String datetime3=Data_Acuity.getCellData(34, 5);
				String datetime4=Data_Acuity.getCellData(34, 6);
				
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Basic')]")).click();
				driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
				driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Multi-Destination')]")).click();
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
		Robot blsmul1=new Robot();
		blsmul1.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		
		driver.findElement(By.id("searchId0")).sendKeys(desthi);
		Thread.sleep(4000);
		blsmul1.keyPress(KeyEvent.VK_DOWN);	
		blsmul1.keyPress(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Sam')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
		driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Default Lobby')]")).click();
		driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
		driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[3]")).click();
		driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
		driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Random')]")).click();
		
		driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
		driver.findElement(By.id("addAnotherDestBtn")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("searchId1")).sendKeys(desthi);
		Thread.sleep(4000);
		blsmul1.keyPress(KeyEvent.VK_DOWN);	
		blsmul1.keyPress(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
		driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[2]")).click();
		driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
		driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[5]")).click();
		driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
		driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[2]")).click();
		
		driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
		driver.findElement(By.id("addAnotherDestBtn")).click();
		Thread.sleep(2000);
		
		
		driver.findElement(By.id("searchId2")).sendKeys(desthi);
		Thread.sleep(4000);
		blsmul1.keyPress(KeyEvent.VK_DOWN);	
		blsmul1.keyPress(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[3]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
		driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[3]")).click();
		driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
		driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[7]")).click();
		driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
		driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[3]")).click();
		
		driver.findElement(By.id("puScheduledDateTime2")).sendKeys(datetime2);
		driver.findElement(By.id("addAnotherDestBtn")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("searchId3")).sendKeys(desthi);
		Thread.sleep(4000);
		blsmul1.keyPress(KeyEvent.VK_DOWN);	
		blsmul1.keyPress(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[4]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
		driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[4]")).click();
		driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
		driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[9]")).click();
		driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
		driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[4]")).click();
		
		driver.findElement(By.id("puScheduledDateTime3")).sendKeys(datetime3);
		driver.findElement(By.id("addAnotherDestBtn")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("searchId4")).sendKeys(desthi);
		Thread.sleep(4000);
		blsmul1.keyPress(KeyEvent.VK_DOWN);	
		blsmul1.keyPress(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Choose Building')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Sam')])[5]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Lobby')])[2]")).click();
		driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Default Lobby')])[5]")).click();
		driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Floor')])[2]")).click();
		driver.findElement(By.xpath("(//span[@class='text'][contains(text(), '3')])[11]")).click();
		driver.findElement(By.xpath("(//span[@class='filter-option pull-left'][contains(text(), 'Choose Unit')])[2]")).click();
		driver.findElement(By.xpath("(//span[@class='text'][contains(text(), 'Random')])[5]")).click();
		
		driver.findElement(By.id("puScheduledDateTime4")).sendKeys(datetime4);
		
		driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("note")).sendKeys(note);
		driver.findElement(By.id("srDivId3")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
		Thread.sleep(3000);
		WebElement ele75=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
		String t73=ele75.getText();
		System.out.println("Pop up title:"+ t73);
		SoftAssert s41= new SoftAssert();
		s41.assertEquals(ele75, "Service request successfully created.");
		Reporter.log("Service request successfully created pop up is displayed(BLS) with custom pick up and default destination for multiple destination", true);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
		
			}
			
			
			
			
			@Test(priority=3)
			public void HiFillPatientInformationBLSCustomMulti() throws Exception
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
					String datetime2=Data_Acuity.getCellData(34, 4);
					String datetime3=Data_Acuity.getCellData(34, 5);
					String datetime4=Data_Acuity.getCellData(34, 6);
					
					
					Thread.sleep(3000);
					driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
					driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
					driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Basic')]")).click();				
					driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
					driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Multi-Destination')]")).click();
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
			Robot blsmul=new Robot();
			blsmul.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@id='destInfoTypeDivId0']//label[contains(text(), 'Custom')]")).click();
			driver.findElement(By.xpath("//div[@id='customHiDivId0']//label[@class='aq-checkbox-label marL5']")).click();
			driver.findElement(By.id("destFacultyName0")).sendKeys(destination);
			driver.findElement(By.id("streetAddress0")).sendKeys(deststreet);
			driver.findElement(By.id("zipcode0")).sendKeys(zipdest);
			blsmul.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(2000);
			
			
			driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
			driver.findElement(By.id("addAnotherDestBtn")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//label[contains(text(),'Custom Destination Address')]")).click();
			driver.findElement(By.xpath("//label[contains(text(),'Request for addition to Acuity Link network')]")).click();
			driver.findElement(By.id("destFacultyName1")).sendKeys(destination);
			driver.findElement(By.id("streetAddress1")).sendKeys(deststreet);
			driver.findElement(By.id("zipcode1")).sendKeys(zipdest);
			blsmul.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(2000);
			
			driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
			driver.findElement(By.id("addAnotherDestBtn")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@id='destInfoTypeDivId2']//label[@class='aq-radio-label'][contains(text(),'Custom Destination Address')]")).click();
			driver.findElement(By.xpath("//div[@id='customHiDivId2']//label[@class='aq-checkbox-label marL5'][contains(text(),'Request for addition to Acuity Link network')]")).click();
			driver.findElement(By.id("destFacultyName2")).sendKeys(destination);
			driver.findElement(By.id("streetAddress2")).sendKeys(deststreet);
			driver.findElement(By.id("zipcode2")).sendKeys(zipdest);
			blsmul.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(2000);
			
			
			driver.findElement(By.id("puScheduledDateTime2")).sendKeys(datetime2);
			driver.findElement(By.id("addAnotherDestBtn")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@id='destInfoTypeDivId3']//label[@class='aq-radio-label'][contains(text(),'Custom Destination Address')]")).click();
			driver.findElement(By.xpath("//div[@id='customHiDivId3']//label[@class='aq-checkbox-label marL5'][contains(text(),'Request for addition to Acuity Link network')]")).click();
			driver.findElement(By.id("destFacultyName3")).sendKeys(destination);
			driver.findElement(By.id("streetAddress3")).sendKeys(deststreet);
			driver.findElement(By.id("zipcode3")).sendKeys(zipdest);
			blsmul.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(2000);
			
			
			driver.findElement(By.id("puScheduledDateTime3")).sendKeys(datetime3);
			Thread.sleep(3000);
			driver.findElement(By.id("addAnotherDestBtn")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@id='destInfoTypeDivId4']//label[@class='aq-radio-label'][contains(text(),'Custom Destination Address')]")).click();
			driver.findElement(By.xpath("//div[@id='customHiDivId4']//label[@class='aq-checkbox-label marL5'][contains(text(),'Request for addition to Acuity Link network')]")).click();
			driver.findElement(By.id("destFacultyName4")).sendKeys(destination);
			driver.findElement(By.id("streetAddress4")).sendKeys(deststreet);
			driver.findElement(By.id("zipcode4")).sendKeys(zipdest);
			blsmul.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(2000);
			driver.findElement(By.id("puScheduledDateTime4")).sendKeys(datetime4);
			
			driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("note")).sendKeys(note);
			driver.findElement(By.id("srDivId3")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
			Thread.sleep(3000);
			WebElement ele71=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
			String t69=ele71.getText();
			System.out.println("Pop up title:"+ t69);
			SoftAssert s38= new SoftAssert();
			s38.assertEquals(ele71, "Service request successfully created.");
			Reporter.log("Service request successfully created pop up is displayed(BLS) with custom pick up and destination for multiple destination", true);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
			
				}
				
				
				
				
				@Test(priority=4)
				public void HiFillPatientInformationBLSDefaultAndCustomMulti() throws Exception
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
						String datetime=Data_Acuity.getCellData(34, 2);
						String datetime1=Data_Acuity.getCellData(34, 3);
						String datetime2=Data_Acuity.getCellData(34, 4);
						String datetime3=Data_Acuity.getCellData(34, 5);
						String datetime4=Data_Acuity.getCellData(34, 6);
						
						Thread.sleep(3000);
						driver.findElement(By.xpath("//button[@class='aq-btn highlightLabel notHover1'][contains(text(),'Create a Service Request')]")).click();
						driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Capability')]")).click();
						driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Basic')]")).click();
						driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'One-Way')]")).click();
						driver.findElement(By.xpath("//span[@class='text'][contains(text(), 'Multi-Destination')]")).click();
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
				Robot blsmulti=new Robot();
				blsmulti.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				
				driver.findElement(By.id("puScheduledDateTime0")).sendKeys(datetime);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId1']//label[@class='aq-radio-label'][contains(text(),'Custom Destination Address')]")).click();
				driver.findElement(By.xpath("//label[@class='aq-checkbox-label marL5'][contains(text(),'Request for addition to Acuity Link network')]")).click();
				driver.findElement(By.id("destFacultyName1")).sendKeys(destination);
				driver.findElement(By.id("streetAddress1")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode1")).sendKeys(zipdest);
				blsmulti.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				
				driver.findElement(By.id("puScheduledDateTime1")).sendKeys(datetime1);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId2']//label[@class='aq-radio-label'][contains(text(),'Custom Destination Address')]")).click();
				driver.findElement(By.xpath("//div[@id='customHiDivId2']//label[@class='aq-checkbox-label marL5'][contains(text(),'Request for addition to Acuity Link network')]")).click();
				driver.findElement(By.id("destFacultyName2")).sendKeys(destination);
				driver.findElement(By.id("streetAddress2")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode2")).sendKeys(zipdest);
				blsmulti.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				
				
				driver.findElement(By.id("puScheduledDateTime2")).sendKeys(datetime2);
				Thread.sleep(2000);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId3']//label[@class='aq-radio-label'][contains(text(),'Custom Destination Address')]")).click();
				driver.findElement(By.xpath("//div[@id='customHiDivId3']//label[@class='aq-checkbox-label marL5'][contains(text(),'Request for addition to Acuity Link network')]")).click();
				driver.findElement(By.id("destFacultyName3")).sendKeys(destination);
				driver.findElement(By.id("streetAddress3")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode3")).sendKeys(zipdest);
				blsmulti.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				
				
				driver.findElement(By.id("puScheduledDateTime3")).sendKeys(datetime3);
				driver.findElement(By.id("addAnotherDestBtn")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='destInfoTypeDivId4']//label[@class='aq-radio-label'][contains(text(),'Custom Destination Address')]")).click();
				driver.findElement(By.xpath("//div[@id='customHiDivId4']//label[@class='aq-checkbox-label marL5'][contains(text(),'Request for addition to Acuity Link network')]")).click();
				driver.findElement(By.id("destFacultyName4")).sendKeys(destination);
				driver.findElement(By.id("streetAddress4")).sendKeys(deststreet);
				driver.findElement(By.id("zipcode4")).sendKeys(zipdest);
				blsmulti.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				driver.findElement(By.id("puScheduledDateTime4")).sendKeys(datetime4);
				
				driver.findElement(By.xpath("//button[@class='btn aq-btn open2'][contains(text(), 'Next')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("note")).sendKeys(note);
				driver.findElement(By.id("srDivId3")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'Accept')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn aq-btn open3'][contains(text(), 'Submit Requests')]")).click();
				Thread.sleep(3000);
				WebElement ele79=driver.findElement(By.xpath("//div[@class='txtcenter marT10'][contains(text(), 'Service request successfully created.')]"));
				String t77=ele79.getText();
				System.out.println("Pop up title:"+ t77);
				SoftAssert s45= new SoftAssert();
				s45.assertEquals(ele79, "Service request successfully created.");
				Reporter.log("Service request successfully created pop up is displayed(BLS) with default pick up and custom destination for multiple destination", true);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(), 'OK')]")).click();
				
						
					}
		
		
}
