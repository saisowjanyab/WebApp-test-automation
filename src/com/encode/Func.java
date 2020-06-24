package com.encode;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import com.encodereport.Reporter;



public class Func {

private WebDriver driver;
private String baseUrl;
public boolean acceptNextAlert = true;
protected StringBuffer verificationErrors = new StringBuffer();

String exc=null;

public void setUp() throws Exception {
	pathsconst te= new pathsconst();
	System.setProperty("webdriver.chrome.driver",te.Driver());
    this.driver = new ChromeDriver();
    baseUrl = "http://www.phptravels.net";
    driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
}

public void offersTest(String que) throws Exception{
	driver.get(baseUrl+'/');
	driver.get(baseUrl+"/offers"+"/"+que);
	if(isElementPresent(By.xpath("/html/body/div[4]/div[3]/div[4]/div/div/div[1]"))) {
		System.out.println("OFFER EXISTS");
	}
	Reporter.report("true", "true", "OFFERTEST", "");
	Reporter.writeResults();
}
public void testSss() throws Exception {
	driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(//a[contains(text(),'My Account')])[2]")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'Login')])[2]")).click();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("user@phptravels.com");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("demouser");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
	  driver.get(baseUrl + "/");
	    driver.findElement(By.cssSelector("a.thm-btn.btn-block")).click();
	    new Select(driver.findElement(By.id("selectedAdults"))).selectByVisibleText("3");
	    new Select(driver.findElement(By.id("selectedChild"))).selectByVisibleText("1");
	    new Select(driver.findElement(By.id("selectedInfants"))).selectByVisibleText("2");
	    driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
	    if(isElementPresent(By.className("RTL")))
  		{
	    	System.out.println("booking test success");
	    	 Reporter.report("true","true","Booking_Test","Booking Passed");  
  		}
  else
  	{
	  System.out.println("NO");
	  Reporter.report("false","true","Booking_Test",""); 
	  Reporter.writeResults();
}
}


public void logiout(String User,String Pass) throws Exception
{
	driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(//a[contains(text(),'My Account')])[2]")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'Login')])[2]")).click();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys(User);
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys(Pass);
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    if(isElementPresent(By.className("RTL")))
    {	System.out.println("Login Success");
         Reporter.report("true","true","LOGIN_TEST","correct Credentials");   
    }
    else
    	{
    	System.out.println("NO");
    	Reporter.report("false","true","LOGIN_TEST","Incorrect Credentials"); 
File srcee= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(srcee, new File("C:/selenium/error.png"));
    	}
    Reporter.writeResults();
}


public void tearDown()  {
	try
	{
    driver.quit();
	}
	finally {}
}



public boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }


public void viewReport()
{  	pathsconst temp =new pathsconst();
	driver.get(temp.Report1());
}

}
