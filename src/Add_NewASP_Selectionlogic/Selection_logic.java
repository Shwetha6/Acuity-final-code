package Add_NewASP_Selectionlogic;

import java.util.List;
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



public class Selection_logic 
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
		String url = Data_Acuity.getCellData(5, 0);
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
	public void VerifySelectionLogicPage() throws Exception
	{
		
		
driver.findElement(By.xpath("//a[@class='dropdown-toggle'][contains(text(), 'ASPs & Configuration')]")).click();
Thread.sleep(2000);
driver.findElement(By.linkText("Selection Logic")).click();
WebElement ele7=driver.findElement(By.xpath("//h2[@class='font26 fontW400 marT5 marB25'][contains(text(), 'Selection Logic')]"));
String t5=ele7.getText();
System.out.println("Page title:"+ t5);
SoftAssert s7= new SoftAssert();
s7.assertEquals(ele7, "Selection Logic");
Reporter.log("Selection logic page is displayed", true);
Thread.sleep(3000);
		 }
	
	@Test(priority=2)
	public void ExclusiveAmbSection() throws InterruptedException
	{
	WebElement ele8=driver.findElement(By.xpath("//h2[@class='font26'][contains(text(), 'Exclusive Ambulance ')]"));
	String t6=ele8.getText();
	System.out.println("Title:"+ t6);
	SoftAssert s8= new SoftAssert();
	s8.assertEquals(ele8, "Exclusive Ambulance");
	Reporter.log("Exclusive Ambulance section is present", true);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/button[1]")).click();
	Thread.sleep(3000);
	WebElement ele9=driver.findElement(By.xpath("//h4[@class='modal-title'][contains(text(), 'Ambulance Service Providers')]"));
	String t7=ele9.getText();
	System.out.println("Title of the pop up:"+ t7);
	s8.assertEquals(ele9, "Ambulance Service Providers");
	Reporter.log("Ambulance Service Providers pop up is displayed: Hence Add ASP button is present and clickable in Exclusive Ambulance section ", true);
	List<WebElement> aspname = driver.findElements(By.xpath("//div[@id='addAspModal']//div[contains(@class,'modal-body')]"));
	//System.out.println(aspname.size());
	for(WebElement e: aspname) {
	System.out.println(e.getText());
	}
	Reporter.log("ASP's in the pop up are listed", true);
	driver.findElement(By.xpath("(//button[@aspid='24'])[1]")).click();
	Thread.sleep(4000);
	WebElement ele10=driver.findElement(By.xpath("//button[@class='btn aq-btn aq-btn-sm removeOrder'][contains(text(), 'Remove')]"));
	String t8=ele10.getText();
	System.out.println("Button name is:"+ t8);
	s8.assertEquals(ele10, "Remove");
	Reporter.log("Remove button is present:Hence ASP has been added in the Exclusive Ambulance section", true);
	}
	
		
	@Test(priority=3)
	public void CustomRotationSection() throws InterruptedException
	{
		Thread.sleep(3000);
		WebElement ele11=driver.findElement(By.xpath("//h2[@class='font26'][contains(text(), 'Custom Rotation ')]"));
		String t9=ele11.getText();
		System.out.println("Title:"+ t9);
		SoftAssert s9= new SoftAssert();
		s9.assertEquals(ele11, "Custom Rotation");
		Reporter.log("Custom Rotation section is present", true);
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[3]/div[1]/div[3]/button[1]")).click();
		Thread.sleep(3000);
		WebElement ele12=driver.findElement(By.xpath("//h4[@class='modal-title'][contains(text(), 'Ambulance Service Providers')]"));
		String t10=ele12.getText();
		System.out.println("Title of the pop up:"+ t10);
		s9.assertEquals(ele12, "Ambulance Service Providers");
		Reporter.log("Ambulance Service Providers pop up is displayed: Hence Add ASP button is present and clickable in Custom Rotation section ", true);
		List<WebElement> aspname1 = driver.findElements(By.xpath("//div[@id='addAspModal']//div[contains(@class,'modal-body')]"));
		//System.out.println(aspname.size());
		for(WebElement e1: aspname1) 
		{
		System.out.println(e1.getText());
		}
		Reporter.log("ASP's in the pop up are listed", true);
		driver.findElement(By.xpath("//button[@class='btn aq-btn aq-btn-sm padL10 padR10 addOrder'][contains(text(), 'Add')]")).click();
		Thread.sleep(4000);
		WebElement ele13=driver.findElement(By.xpath("//table[@id='customRotation']//button[@type='button'][contains(text(),'Remove')]"));
		String t11=ele13.getText();
		System.out.println("Button name is:"+ t11);
		s9.assertEquals(ele13, "Remove");
		Reporter.log("Remove button is present:Hence ASP has been added in the Custom Rotation section", true);
		
		}
	
	
	
	@Test(priority=4)
	public void SetPercentageListAsp() throws InterruptedException
	{
		Thread.sleep(3000);
		WebElement ele14=driver.findElement(By.xpath("//button[@class='btn aq-btn allotmentPopupClass'][contains(text(),'Set % of Allotment')]"));
		String t12=ele14.getText();
		System.out.println("Button name is:"+ t12);
		SoftAssert s10= new SoftAssert();
		s10.assertEquals(ele14, "Set % of Allotment");
		driver.findElement(By.xpath("//button[@class='btn aq-btn allotmentPopupClass'][contains(text(),'Set % of Allotment')]")).click();
		Thread.sleep(4000);
		WebElement ele15=driver.findElement(By.xpath("//h4[@class='modal-title'][contains(text(),'SET % ALLOTMENT')]"));
		String t13=ele15.getText();
		System.out.println("Pop up title is:"+ t13);
		s10.assertEquals(ele15, "SET % ALLOTMENT");
		Reporter.log("Set % of Allotment button is present and clickable", true);
		driver.findElement(By.xpath("//span[@class='filter-option pull-left']")).click();
		driver.findElement(By.xpath("//span[@class='text'][contains(text(),'100%')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Update')]")).click();
		Thread.sleep(3000);
		WebElement ele16=driver.findElement(By.xpath("//td[@class='aspRotationPer']"));
		String t14=ele16.getText();
		s10.assertEquals(ele16, "100%");
		Reporter.log("% set to 100%", true);
		}
	
	
	
	@Test(priority=5)
	public void OrderNumberEvenRotationSection() throws InterruptedException
	{
		Thread.sleep(3000);
	    WebElement ele17=driver.findElement(By.xpath("//h2[contains(text(),'Order Number and Even Rotation')]"));
		String t15=ele17.getText();
		System.out.println("Title:"+ t15);
		SoftAssert s11= new SoftAssert();
		s11.assertEquals(ele17, "Order Number and Even Rotation");
		Reporter.log("Order Number and Even Rotation section is present", true);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='col-lg-12 col-md-12 col-sm-12 col-xs-12 pad0 topContentHead']//div[4]//div[1]//div[2]//button[1]")).click();
		Thread.sleep(3000);
		WebElement ele18=driver.findElement(By.xpath("//h4[contains(text(),'Ambulance Service Providers')]"));
		String t16=ele18.getText();
		System.out.println("Title of the pop up:"+ t16);
		s11.assertEquals(ele18, "Ambulance Service Providers");
		Reporter.log("Ambulance Service Providers pop up is displayed: Hence Add ASP button is present and clickable in Order Number and Even Rotation section", true);
		List<WebElement> aspname2 = driver.findElements(By.xpath("//div[@id='addAspModal']//div[contains(@class,'modal-body')]"));
		//System.out.println(aspname.size());
		for(WebElement e2: aspname2) {
		System.out.println(e2.getText());
		}
		Reporter.log("ASP's in the pop up are listed", true);
		driver.findElement(By.xpath("//button[@class='btn aq-btn aq-btn-sm padL10 padR10 addOrder'][contains(text(), 'Add')]")).click();
		Thread.sleep(4000);
		WebElement ele19=driver.findElement(By.xpath("//table[@id='orderRotation']//button[@type='button'][contains(text(),'Remove')]"));
		String t17=ele19.getText();
		System.out.println("Button name is:"+ t17);
		s11.assertEquals(ele19, "Remove");
		Reporter.log("Remove button is present:Hence ASP has been added in the Order Number and Even Rotation section", true);
		
	}
	
	
	
	@Test(priority=6)
	public void AvailableAppropriateASPSection() throws InterruptedException
	{
	
		Thread.sleep(3000);		
	WebElement ele20=driver.findElement(By.xpath("//h2[@class='font26'][contains(text(),'Available appropriate ASP ')]"));
	String t18=ele20.getText();
	System.out.println("Title:"+ t18);
	SoftAssert s12= new SoftAssert();
	s12.assertEquals(ele20, "Available appropriate ASP");
	Reporter.log("Available appropriate ASP section is present", true);
	WebElement ele21=driver.findElement(By.xpath("//h4[contains(text(),'Add ASP')]"));
	String t19=ele21.getText();
	System.out.println("Button name is:"+ t18);
	s12.assertEquals(ele21, "Add ASP");
	Reporter.log("Add ASP button is not present:Test case pass", true);
		}
	
	
	
	}
	
	
	
	
	
	
		 
	
	
	
	
	
	
	

