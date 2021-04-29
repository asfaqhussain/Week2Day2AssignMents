package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.id("UserName")).sendKeys("DemoSalesManger");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativesubmit")).click();
		String LoggedDuser=driver.findElementByTagName("h2").getText();
		System.out.println(LoggedDuser);
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("FindLeads")).click();
        Thread.sleep(1000);
        driver.findElementByName("FirstName").click();
        driver.findElementByName("FirstName").sendKeys("Aswak");
        System.out.println("FirstName Text Passed Sucessfully");
        driver.findElementByXPath("//button[text()=Find Leads']").click();
        Thread.sleep(1000);
        driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
        String ViewLeadTitle=driver.findElementByXPath("//div[text()='View Lead']").getText();
        if(ViewLeadTitle.contains("View Lead")) {
        	System.out.println("we are on view lead screen. please check");
        
	}else {
		System.err.println("sorry. we are not on view klead screen please check");
	}
        driver.findElementById("UpdateLeadForm_CoompanyName").clear();
        driver.findElementById("UpdateLeadForm_CoompanyName").sendKeys("wolsvogan");
        driver.findElementByName("Submit Button").click();
        String NewCompanyName=driver.findElementById("ViewLead_CompanyName_sp").getText();
        if(NewCompanyName.contains("Renault")) {
        	System.out.println("Test Passed");
        }else {
        	System.err.println("Test Failed");
        }
        driver.close();
        	System.out.println("Edit Lead Test Sucessfully Completed");
        }
	}

	
	
	
	
	
	

