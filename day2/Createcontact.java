package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Createcontact {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.id("UserName")).sendKeys("DemoSalesManger");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativesubmit")).click();
	    driver.findElement(By.linkText("CRM/SFA")).click();
	    driver.findElement(By.linkText("Contacts")).click();
	    driver.findElement(By.linkText("CreateContacts")).click();
	    driver.findElement(By.id("FirstNameField")).sendKeys("Aswak");
	    driver.findElement(By.id("LastNameField")).sendKeys("hussain");
	    driver.findElement(By.id("CreateContactsForm_FirstNameLocal")).sendKeys("Asw");
	    driver.findElement(By.id("CreateContactsForm_LastNameLocal")).sendKeys("hussain");
	    driver.findElement(By.id("CreateContactsForm_DepateMentName")).sendKeys("IT");
	    driver.findElement(By.id("CreateContactsForm_Description")).sendKeys("InformationTechnology");
	    driver.findElement(By.id("CreateContactsForm_PrimaryEmail")).sendKeys("Asfaqhussain05@gmail.com");
		WebElement StateProvince=driver.findElementByName("GeneralStateProvincegeoID");
       Select StateProvinceOption=new Select (StateProvince);
       StateProvinceOption.selectByVisibleText("NewYork");
       driver.findElementByName("SubmitButton").click();
       driver.findElementByLinkText("Edit").click();
       driver.findElementById("UpDateContactForm_GeneralProfTitle").sendKeys("AssistantManager");
       driver.findElementById("UpDateContactForm_Description").clear();
       driver.findElementById("UpDateContactForm_ImportantNote").sendKeys("Importance Technology And Sciene");
       driver.findElementByXPath("//inut[@value='update']").click();
       String Title=driver.findElementById("ViewContact_GeneralProfileTitle_sp").getText();
       if(Title.contains("AssistantManger")) {
    	 System.out.println("TestCase Passed");
       }else
    	   System.err.println("TestCase Failed");
       {				
       }	
       
	}}
		
    	    
    	  
			
		
			
		
    	   
			
		
       
       
       
	


