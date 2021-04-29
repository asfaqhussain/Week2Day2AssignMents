package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.id("UserName")).sendKeys("DemoSalesManger");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativesubmit")).click();
		String Text=driver.findElementByTagName("h2").getText();
		Thread.sleep(1000);
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("FindLeads")).click();
		driver.findElement(By.linkText("Phone")).click();
		driver.findElementByName("PhoneNumber").sendKeys("1234");
		Thread.sleep(1000);
		String firstLeadString=driver.findElementByXPath("(//div[@class='x'-grid3-cell-inner x-grid3-col-partyId])[1])").getText();
		driver.findElementByXPath("(//div[@class='x'-grid3-cell-inner x-grid3-col-partyId])[1])").click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Delete")).click();
		driver.findElement(By.linkText("FindLeads")).click();
		driver.findElementByName("id").sendKeys("FirstLead");
		driver.findElementByXPath("//button[Text()='FindLeads']").getText();
		String norecords=driver.findElementByXPath("//div[Text()='no records to display']").getText();
		driver.findElementByXPath("//div[Text()='no records to display']").getText();
if(norecords.contains("no records to display")) {
	System.out.println("Delete Sucess.Lead Record Not Available");
}
else
{
	System.out.println("Lead Record Available.Delete Failed");
}
driver.close();
}



}
