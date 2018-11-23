package HI_profile;

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




public class Add_Edit_Activate_Deactivate_Building 
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
	
	//To check whether add building block and back button functionality works
	@Test(priority=1)
	public void HIProfileAddBuildingLocation() throws Exception
	{
		
		Data_Acuity.setExcelFile(Constant_Acuity.Excelpath,"Sheet1");
			String buildingname=Data_Acuity.getCellData(11, 5); 
			String lobbyname=Data_Acuity.getCellData(11, 6);
			String floorname=Data_Acuity.getCellData(11, 7);
			String unitName=Data_Acuity.getCellData(11, 8);
			String phoneNumber=Data_Acuity.getCellData(11, 9);
			
			
			
			driver.findElement(By.xpath("//img[contains(@src,'avatar.png')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//li[contains(@class,'linkProf')]/a[1]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='btn btn-default aq-btn marR15 btn01 aq-btn-1024'][contains(text(),'Add Building Location')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='btn btn-default aq-btn marR15 btn01 aq-btn-1024 hiBuildingDetails'][contains(text(),'Add Building')]")).click();
			Thread.sleep(4000);
			driver.findElement(By.id("buildingName")).sendKeys(buildingname);
			driver.findElement(By.xpath("//button[@class='btn aq-btn addUpdateLobbyClass'][contains(text(),'Add Lobby')]")).click();
			Thread.sleep(5000);
			driver.findElement(By.id("lobbyName")).sendKeys(lobbyname);
			driver.findElement(By.id("addLobbyBtn")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@class='btn aq-btn addUpdateFloorClass'][contains(text(),'Add Floor')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("floors")).sendKeys(floorname);
			driver.findElement(By.id("unitName")).sendKeys(unitName);
			driver.findElement(By.id("phoneNumber")).sendKeys(phoneNumber);
			driver.findElement(By.id("addFloorBtn")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("saveOrUpdateBtn")).click();
			Thread.sleep(4000);
			WebElement ele25= driver.findElement(By.xpath("//div[@class='msg'][contains(text(), 'Building created successfully.')]"));
            String t23 = ele25.getText();
            System.out.println("Success message:"+ t23);
            SoftAssert s14= new SoftAssert();
            s14.assertEquals(ele25, "Building created successfully.");
            Reporter.log("Building information successfully added", true);
            driver.findElement(By.xpath("//button[@class='btn btn-default aq-btn marR15 btn01 aq-btn-1024 hiBuildingDetails'][contains(text(),'Add Building')]")).click();
            Thread.sleep(4000);
            driver.findElement(By.xpath("//img[contains(@src, '../images/leftArrow.png')]")).click();
            Thread.sleep(4000);
            WebElement ele26=driver.findElement(By.xpath("//h2[@class='font26 fontW400 marT5 marB20'][contains(text(),'Building List (National Institute of Medical Care)')]"));
			String t24=ele26.getText();
			System.out.println("Page title is:"+ t24);
			s14.assertEquals(ele25, "Building List (National Institute of Medical Care)");
			Reporter.log("Building List page is displayed. Hence back button is clickable", true);
		}
	
		
	@Test(priority=2)
	public void HiDeactivateBuilding() throws InterruptedException
	{
			
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[@class='switchToggle-handle switchbar']/../../../td[2]/label/span[2]")).click();
	WebElement ele28= driver.findElement(By.xpath("//div[@class='bootbox-body'][contains(text(),'Are you sure you want to deactivate this Building?')]"));
	String t26=ele28.getText();
	SoftAssert s16= new SoftAssert();
	s16.assertEquals(ele28, "Are you sure you want to deactivate this Building?");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(),'OK')]")).click();
	Thread.sleep(3000);
	WebElement ele29=driver.findElement(By.xpath("//div[@class='msg'][contains(text(),'Deactivated successfully.')]"));
	String t27=ele29.getText();
	System.out.println("Success message is:"+ t27);
	s16.assertEquals(ele29, "Deactivated successfully.");
	Thread.sleep(3000);
	Reporter.log("'Building deactivated", true);
	
	driver.findElement(By.xpath("//span[@class='switchToggle-handle switchbar']/../../../td[2]/label/span[2]")).click();
	WebElement ele30= driver.findElement(By.xpath("//div[@class='bootbox-body'][contains(text(),'Are you sure you want to activate this Building?')]"));
	String t28=ele30.getText();
	s16.assertEquals(ele30, "Are you sure you want to activate this Building?");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(),'OK')]")).click();
	Thread.sleep(3000);
	WebElement ele31=driver.findElement(By.xpath("//div[@class='msg'][contains(text(),'Activated successfully.')]"));
	String t29=ele31.getText();
	System.out.println("Success message is:"+ t29);
	s16.assertEquals(ele31, "Activated successfully.");
	Reporter.log("'Building activated", true);
	Thread.sleep(3000);
	
		}
		
	
	@Test(priority=3)
	
	public void HiBuildingPagination() throws InterruptedException
	{	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[@class='paginate_button '][contains(text(),'2')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[@class='paginate_button '][contains(text(),'1')]")).click();
	Thread.sleep(2000);	
    System.out.println("Pagination verified");
    Reporter.log("Pages are clickable", true);
			
		}
	
	
	@Test(priority=4)
	public void HiEditBuildingLocation() throws Exception
	{
		
			Data_Acuity.setExcelFile(Constant_Acuity.Excelpath,"Sheet1");
			String newbuildingname=Data_Acuity.getCellData(17, 1); 
			String streetAddress=Data_Acuity.getCellData(17, 2);
			String hiZip=Data_Acuity.getCellData(17, 3);
			String lobbyname=Data_Acuity.getCellData(17, 4);
			String unitnamme=Data_Acuity.getCellData(17, 5);
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[1]")).click();
			Thread.sleep(4000);
			
			driver.findElement(By.xpath("//label[contains(@class,'switchToggle float-R')]//span[contains(@class,'switchToggle-handle switchbar')][contains(text(),'|||')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//label[contains(@class,'switchToggle float-R')]//span[contains(@class,'switchToggle-handle switchbar')][contains(text(),'|||')]")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("(//span[(@class='switchToggle-handle switchbar')][contains(text(), '|||')])[2]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//span[(@class='switchToggle-handle switchbar')][contains(text(), '|||')])[2]")).click();
			Thread.sleep(3000);
			
	
			
			driver.findElement(By.id("buildingName")).clear();
			Thread.sleep(2000);
			driver.findElement(By.id("buildingName")).sendKeys(newbuildingname);
            
			driver.findElement(By.id("streetAddress")).clear();
			driver.findElement(By.id("streetAddress")).sendKeys(streetAddress);
            
			driver.findElement(By.id("hiZip")).clear();
			driver.findElement(By.id("hiZip")).sendKeys(hiZip);
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//button[@id='addUpdateLobbyId']")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("lobbyName")).clear();
			driver.findElement(By.id("lobbyName")).sendKeys(lobbyname);
            
			driver.findElement(By.id("addLobbyBtn")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class='addingUnit']//div[1]//div[3]//div[3]//button[1]")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("unitNameNew")).clear();
			driver.findElement(By.id("unitNameNew")).sendKeys(unitnamme);
			Robot r1=new Robot();
			r1.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(5000);
			Thread.sleep(4000);
			
			driver.findElement(By.id("addUnitBtn")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//button[@id='saveOrUpdateBtn']")).click();
			Thread.sleep(4000);
			WebElement ele27=driver.findElement(By.xpath("//div[@class='msg'][contains(text(),'Building updated successfully.')]"));
			String t25=ele27.getText();
			System.out.println("Success message is:"+ t25);
			SoftAssert s15= new SoftAssert();
			s15.assertEquals(ele27, "Building updated successfully.");
			Reporter.log("'Building updated successfully' message is displayed. Hence edit is done. Check manually once", true);
		}
		
	
	
	@Test(priority=5)
	public void HiEditProfileDetails() throws InterruptedException
	{
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//img[contains(@src, '../images/leftArrow.png')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='btn aq-btn'][contains(text(), 'Edit Information')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//span[@class='switchToggle-handle switchbar'][contains(text(), '|||')])[1]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='btn aq-btn disClick'][contains(text(), 'Update Profile')]")).click();
			Thread.sleep(3000);
			WebElement ele32 = driver.findElement(By.xpath("//div[@class='msg'][contains(text(), 'Your profile has been updated successfully and sent for admin approval.')]"));
			String t30=ele32.getText();
			System.out.println("Success message is:"+ t30);
			SoftAssert s17= new SoftAssert();
			s17.assertEquals(ele32, "Your profile has been updated successfully and sent for admin approval.");
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//button[@class='btn aq-btn'][contains(text(), 'Edit Information')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//span[@class='switchToggle-handle switchbar'][contains(text(), '|||')])[1]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='btn aq-btn disClick'][contains(text(), 'Update Profile')]")).click();
			WebElement ele33 = driver.findElement(By.xpath("//div[@class='msg'][contains(text(), 'Your profile has been updated successfully and sent for admin approval.')]"));
			String t31=ele33.getText();
			System.out.println("Success message is:"+ t31);
			s17.assertEquals(ele32, "Your profile has been updated successfully and sent for admin approval.");
			Reporter.log("Profile has been updated successfully and sent for admin approval.", true);
			Thread.sleep(3000);
		}
	
	
	@Test(priority=6)
	public void HiChangePassword() throws Exception
	{
	
			Data_Acuity.setExcelFile(Constant_Acuity.Excelpath,"Sheet1");
			String oldpassword=Data_Acuity.getCellData(17, 7); 
			String newpassword=Data_Acuity.getCellData(17, 8);
			String confirmpassword=Data_Acuity.getCellData(17, 9);
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='aq-btn aq-btn-trans'][contains(text(),'Change Password')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("oldPassword")).sendKeys(oldpassword);
			Thread.sleep(2000);
			driver.findElement(By.id("password")).sendKeys(newpassword);
			Thread.sleep(2000);
			driver.findElement(By.id("conpassword")).sendKeys(confirmpassword);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@class='btn aq-btn wauto savePass'][contains(text(),'Update Password')]")).click();
			Thread.sleep(3000);
			WebElement ele35 = driver.findElement(By.xpath("//div[@class='msg'][contains(text(),'Password updated successfully.')]"));
			String t33=ele35.getText();
			System.out.println("Success message is:"+ t33);
			SoftAssert s19= new SoftAssert();
			s19.assertEquals(ele35, "Password updated successfully.");
			Reporter.log("Password changed successfully", true);
			
		}
	 
	}

	
	
	

