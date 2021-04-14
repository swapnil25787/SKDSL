package DataExtraction;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class approval3 {
	public static void main(String[] args) throws InterruptedException, IOException {
		
		
		
		String fp,ln,fn;


				
					
				    
		
		
		
		
		
		CommonUtils common = new CommonUtils();
		WebDriver driver = common.Openbrowser("http://13.234.173.159/Skdcl/CitizenHome.html");

		common.checkPageIsReady(driver);driver.findElement(By.xpath("//*[@id=\"text-resize\"]/header/div[1]/div/div[2]/div[2]/ul/li[4]/a")).click();
		common.checkPageIsReady(driver);
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.linkText("Portal Login")).click();

		driver.findElement(By.xpath("//input[@id='emploginname']")).sendKeys("rushi");
		driver.findElement(By.xpath("//input[@id='adminEmployee.emppassword']")).sendKeys("Pass@123");
		Thread.sleep(1000);
		driver.findElement(By.id("captchaSessionLoginValue")).sendKeys("1111");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='btn btn-success btn-block']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"21\"]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Authenticated")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"search_gridSectionDetailsApp\"]/div/span")).click();

		Select dd = new Select(
				driver.findElement(By.xpath("//*[@id=\"fbox_gridSectionDetailsApp\"]/table/tbody/tr[3]/td[2]/select")));
		dd.selectByVisibleText("Link Name (English)");
		Select dd1 = new Select(
				driver.findElement(By.xpath("//*[@id=\"fbox_gridSectionDetailsApp\"]/table/tbody/tr[3]/td[3]/select")));
		dd1.selectByVisibleText("contains");
		driver.findElement(By.id("jqg2")).click();

	
		

		driver.findElement(By.id("jqg2")).sendKeys("ST Agenda 2006-07");
		
		
		
		
		
		Thread.sleep(2000);
		driver.findElement(By.id("fbox_gridSectionDetailsApp_search")).click();
		driver.findElement(By.xpath("//*[@id=\"search_gridSectionDetailsApp\"]/div/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("fbox_gridSectionDetailsApp_search")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"gridSectionDetailsApp\"]/tbody/tr[2]/td[6]/form/a")));
				int rowc=driver.findElements(By.xpath("//*[@id=\"gridSectionDetailsApp\"]/tbody/tr")).size();
				//*[@id="gridSectionDetailsApp"]/tbody
				for (int i = 0; i < rowc; i++) {
				String XPath="//*[@id=\"gridSectionDetailsApp\"]/tbody/tr["+(i+2)+"]";
				System.out.println("##############################"+driver.findElement(By.xpath(XPath+"/td[2]")).getText().toString());
				if (driver.findElement(By.xpath(XPath+"/td[1]")).getText().toString().equalsIgnoreCase("Organisation")) {
				System.out.println("##############################"+driver.findElement(By.xpath(XPath)).getText().toString());
				driver.findElement(By.xpath(XPath+"/td[6]/form/a")).click();
				break;

				}

				}
		////////////////////////////////////////////////////////////////////////////////////
				//C:\Users\swapnil.patil\Desktop\SKDSL\Data\Home Organisation ST Resolution ST Resolution 1995 96 xcel not available aapproval pending

		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i = 0; i < 46; i++) {
			
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[alt=\"Edit\"]")));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("img[alt=\"Edit\"]")));
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt=\"Edit\"]")));
			 
			Thread.sleep(500);
		driver.findElement(By.cssSelector("img[alt=\"Edit\"]")).click();

			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type=\"submit\"][value=\"Submit\"]")));
			Thread.sleep(500);
	driver.findElement(By.id("entity.chekkerflag1")).click();
			driver.findElement(By.cssSelector("input[type=\"submit\"][value=\"Submit\"]")).click();

		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"text-resize\"]/div[1]/ol/li[1]/a/i")));
		
		
		driver.quit();

				

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}}