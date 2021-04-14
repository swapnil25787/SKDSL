package DataExtraction;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class addlink {
	static ArrayList<String> valSetOne1 = null;
	static int count=0;
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		addlink pr = new addlink();
		ExcelWriting ew= new ExcelWriting();
		
		/// login
		CommonUtils common = new CommonUtils();
		driver.get("http://13.234.173.159/Skdcl/CitizenHome.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;

		common.checkPageIsReady(driver);driver.findElement(By.xpath("//*[@id=\"text-resize\"]/header/div[1]/div/div[2]/div[2]/ul/li[4]/a")).click();
		common.checkPageIsReady(driver);
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.linkText("Portal Login")).click();

		driver.findElement(By.xpath("//input[@id='emploginname']")).sendKeys("sysadmin");
		driver.findElement(By.xpath("//input[@id='adminEmployee.emppassword']")).sendKeys("Abm#4321");
		Thread.sleep(1000);
		driver.findElement(By.id("captchaSessionLoginValue")).sendKeys("1111");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='btn btn-success btn-block']")).click();
		Thread.sleep(2000);


		
		
		ReadGuru99ExcelFile objExcelFile = new ReadGuru99ExcelFile();
		String filePath = "C:\\Users\\swapnil.patil\\Desktop\\SKDSL\\files\\";
		objExcelFile.readExcel(filePath, "AddLink.xlsx", "Sheet3");
		//// add code
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"5\"]/a")).click();
		pr.waits(driver);
		for (int i = 0; i < objExcelFile.map1.get("Sub Link Order").size(); i++) {

			

			count++;
			Thread.sleep(2000);
			driver.findElement(By.partialLinkText("Add New Section")).click();
			pr.waits(driver);

			Thread.sleep(2000);
			Select ModuleName = new Select(driver.findElement(By.id("linkId")));
			ModuleName.selectByVisibleText(objExcelFile.map1.get("ModuleName").get(i).toString().trim());
			// subLinkNameEn
			/*
			 * Thread.sleep(2000); Select subModuleName = new
			 * Select(driver.findElement(By.id("id")));
			 * subModuleName.selectByVisibleText(objExcelFile.map1.get("subModuleName").get(
			 * i).toString().trim());
			 */
			driver.findElement(By.id("subLinkNameEn")).click();
			driver.findElement(By.id("subLinkNameEn")).sendKeys(objExcelFile.map1.get("Section Name Eng").get(i).toString());
			System.out.println(objExcelFile.map1.get("Section Name Eng").get(i).toString()+"="+objExcelFile.map1.get("Sub Link Order").get(i).toString());
			driver.findElement(By.id("entity.subLinkNameRg")).click();
			driver.findElement(By.id("entity.subLinkNameRg")).sendKeys(objExcelFile.map1.get("Section Name Marathi").get(i).toString());

			driver.findElement(By.id("entity.subLinkOrder")).click();
			driver.findElement(By.id("entity.subLinkOrder")).sendKeys(objExcelFile.map1.get("Sub Link Order").get(i).toString());
			Thread.sleep(1000);
			pr.waits(driver);
			Select IsHighlighted = new Select(driver.findElement(By.id("isLinkModify")));
			IsHighlighted.selectByVisibleText("True");
			Thread.sleep(1000);
			pr.waits(driver);
			Select SectionType = new Select(driver.findElement(By.id("sectionType0")));
			SectionType.selectByVisibleText("Table Grid");

			//// chekr click
			/*
			 * JavascriptExecutor js = (JavascriptExecutor) driver; js.
			 * executeScript("document.getElementById('entity.chekkerflag1').disabled = false;"
			 * );
			 * 
			 * WebElement button = driver.findElement(By.id("entity.chekkerflag1"));
			 * js.executeScript("arguments[0].click();", button); pr.waits(driver);
			 */
			//////////////////

			driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();

			Thread.sleep(2000);
			driver.findElement(By.partialLinkText("Add New Element")).click();
			pr.waits(driver);
			Thread.sleep(2000);
			driver.findElement(By.id("subLinkFieldMapping.fieldNameEn")).click();
			driver.findElement(By.id("subLinkFieldMapping.fieldNameEn")).sendKeys(objExcelFile.map1.get("col1").get(i).toString());
			driver.findElement(By.id("subLinkFieldMapping.fieldNameRg")).click();
			driver.findElement(By.id("subLinkFieldMapping.fieldNameRg")).sendKeys(objExcelFile.map1.get("col1mar").get(i).toString());
			Thread.sleep(2000);
			Select TypeofField = new Select(
					driver.findElement(By.id("fieldType")));
			TypeofField.selectByVisibleText("TextArea");

			driver.findElement(By.cssSelector("input[value='Save Element']")).click();
			
			
			

			
			Thread.sleep(2000);
			driver.findElement(By.partialLinkText("Add New Element")).click();
			pr.waits(driver);
			Thread.sleep(2000);
			driver.findElement(By.id("subLinkFieldMapping.fieldNameEn")).click();
			driver.findElement(By.id("subLinkFieldMapping.fieldNameEn")).sendKeys(objExcelFile.map1.get("col2").get(i).toString());
			driver.findElement(By.id("subLinkFieldMapping.fieldNameRg")).click();
			driver.findElement(By.id("subLinkFieldMapping.fieldNameRg")).sendKeys(objExcelFile.map1.get("col2mar").get(i).toString());
			Thread.sleep(2000);
			Select TypeofField1 = new Select(
					driver.findElement(By.id("fieldType")));
			TypeofField1.selectByVisibleText("Attachment");

			driver.findElement(By.cssSelector("input[value='Save Element']")).click();
			
			
			
			
			
			
			
			
			
			
			
			
			
			

////////////////////
			
			
			/*
			 * Thread.sleep(2000);
			 * driver.findElement(By.partialLinkText("Add New Element")).click();
			 * pr.waits(driver); Thread.sleep(2000);
			 * driver.findElement(By.id("subLinkFieldMapping.subLinkFieldlist0.fieldNameEn")
			 * ).click();
			 * driver.findElement(By.id("subLinkFieldMapping.subLinkFieldlist0.fieldNameEn")
			 * ).sendKeys(objExcelFile.map1.get("col2").get(i).toString());
			 * driver.findElement(By.id("subLinkFieldMapping.subLinkFieldlist0.fieldNameRg")
			 * ).click();
			 * driver.findElement(By.id("subLinkFieldMapping.subLinkFieldlist0.fieldNameRg")
			 * ) .sendKeys(objExcelFile.map1.get("col2mar").get(i).toString());
			 * Thread.sleep(2000); Select TypeofField1 = new Select(
			 * driver.findElement(By.id("subLinkFieldMapping.subLinkFieldlist0.fieldType")))
			 * ; TypeofField1.selectByVisibleText("TextArea");
			 * 
			 * driver.findElement(By.cssSelector("input[value='Save Element']")).click();
			 */
		//////////////////////////////////////////
			
			
			
			
			
			
			
			
			

			/*
			 * Thread.sleep(2000);
			 * driver.findElement(By.partialLinkText("Add New Element")).click();
			 * pr.waits(driver); Thread.sleep(2000);
			 * driver.findElement(By.id("subLinkFieldMapping.subLinkFieldlist0.fieldNameEn")
			 * ).click();
			 * driver.findElement(By.id("subLinkFieldMapping.subLinkFieldlist0.fieldNameEn")
			 * ).sendKeys(objExcelFile.map1.get("col3").get(i).toString());
			 * driver.findElement(By.id("subLinkFieldMapping.subLinkFieldlist0.fieldNameRg")
			 * ).click();
			 * driver.findElement(By.id("subLinkFieldMapping.subLinkFieldlist0.fieldNameRg")
			 * ) .sendKeys(objExcelFile.map1.get("col3mar").get(i).toString());
			 * Thread.sleep(2000); Select TypeofField12 = new Select(
			 * driver.findElement(By.id("subLinkFieldMapping.subLinkFieldlist0.fieldType")))
			 * ; TypeofField12.selectByVisibleText("Attachment");
			 * 
			 * driver.findElement(By.cssSelector("input[value='Save Element']")).click();
			 */
////////////////////////
			/*
			 * Thread.sleep(2000);
			 * driver.findElement(By.partialLinkText("Add New Element")).click();
			 * pr.waits(driver); Thread.sleep(2000);
			 * driver.findElement(By.id("subLinkFieldMapping.subLinkFieldlist0.fieldNameEn")
			 * ).click();
			 * driver.findElement(By.id("subLinkFieldMapping.subLinkFieldlist0.fieldNameEn")
			 * ).sendKeys("Photo");
			 * driver.findElement(By.id("subLinkFieldMapping.subLinkFieldlist0.fieldNameRg")
			 * ).click();
			 * driver.findElement(By.id("subLinkFieldMapping.subLinkFieldlist0.fieldNameRg")
			 * ) .sendKeys("Photo"); pr.waits(driver); Select TypeofField2 = new Select(
			 * driver.findElement(By.id("subLinkFieldMapping.subLinkFieldlist0.fieldType")))
			 * ; TypeofField2.selectByVisibleText("Photo");
			 * 
			 * driver.findElement(By.cssSelector("input[value='Save Element']")).click();
			 * Thread.sleep(2000); pr.waits(driver);
			 */			
			//driver.findElement(By.cssSelector("input[value='Save Section']")).click();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"command\"]/input[3]")));
			
			driver.findElement(By.xpath("//*[@id=\"command\"]/input[3]")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnNo\"]")));
			pr.waits(driver);
			driver.findElement(By.xpath("//*[@id=\"btnNo\"]")).click();
		
		}System.out.println(count);

	}

	public void waits(WebDriver d) {

		FluentWait wait = new FluentWait(d);
		// Specify the timout of the wait
		wait.withTimeout(5000, TimeUnit.MILLISECONDS);
		// Sepcify polling time
		wait.pollingEvery(350, TimeUnit.MILLISECONDS);
		// Specify what exceptions to ignore
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotInteractableException.class);
		d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}
}
