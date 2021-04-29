package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
	 
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.id("UserName")).sendKeys("DemoSalesManger");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativesubmit")).click();
		String LoggedDuster=driver.findElementByTagName("h2").getText();
	System.out.println("LoggedDuster");
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("FindLeads")).click();
Thread.sleep(1000);

driver.findElementByXPath("//div[@class='x'-grid3-cell-inner x-grid3-col-partyID']/a").click();
	String CompanyName=driver.findElementById("ViewLead_CompanyName_sp").getText();
	driver.findElement(By.linkText("DuplicateLead")).click();
	String DuplicateHeader=driver.findElementByXPath("//div[[text()='Duplicate Lead']").getText();
	if(DuplicateHeader.contains("DuplicateLead")) {
		System.out.println("WE Are On Duplicate Lead Screen");
	}else {
		System.err.println("WE Are Not On Duplicate Lead Screen");
	}
	driver.findElementByName("SummitButton").click();
	if(CompanyName.contains("wolsvogan")) {
		System.out.println("Test Passed");
	}else {
		System.out.println("Test Failed");
		driver.close();
		System.out.println("Duplicate Lead Test Sucessfully Completed ");
	}
	}
	

}
