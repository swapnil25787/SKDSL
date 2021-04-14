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

public class dataUploadskdsl {
	public static void main(String[] args) throws InterruptedException, IOException {
		
		
		
		String fp,ln,fn;


		File directoryPath1 = new File("C:\\Users\\swapnil.patil\\Desktop\\SKDSL\\Data\\");

		File filesList[] = directoryPath1.listFiles();
		System.out.println(filesList.length);

		for (int no = 0; no < filesList.length; no++) {
			// System.out.println("File path: "+filesList[i]);
			File filesList1[] = filesList[no].listFiles();
			for (int no1 = 0; no1 < filesList1.length; no1++) {

				if (filesList1[no1].toString().contains(".xlsx")) {
					System.out.println("File path: " + filesList1[no1]);
					 Path path = Paths.get(filesList1[no1].toString()); 
					 fp=filesList1[no1].toString();
					 
						 
				
						Path fileName = path.getFileName(); 
				        System.err.println("FileName: "  + fileName.toString().replaceAll(".xlsx", "")); 
				        ln=fileName.toString().replaceAll(".xlsx", "");
				        System.out.println(ln);
				        fn=fileName.toString();
				        System.out.println("FileName: "  + fileName.toString()); 
					
				    
				        
					
				
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		CommonUtils common = new CommonUtils();
		WebDriver driver = common.Openbrowser("http://13.234.173.159/Skdcl/CitizenHome.html");

		common.checkPageIsReady(driver);
		driver.findElement(By.xpath("//*[@id=\"text-resize\"]/header/div[1]/div/div[2]/div[2]/ul/li[4]/a")).click();
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

		driver.findElement(By.xpath("//*[@id=\"15\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Authenticated")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"search_gridSectionDetailsApp\"]/div/span")).click();

		Select dd = new Select(
				driver.findElement(By.xpath("//*[@id=\"fbox_gridSectionDetailsApp\"]/table/tbody/tr[3]/td[2]/select")));
		dd.selectByVisibleText("Link Name (English)");
		Select dd1 = new Select(
				driver.findElement(By.xpath("//*[@id=\"fbox_gridSectionDetailsApp\"]/table/tbody/tr[3]/td[3]/select")));
		dd1.selectByVisibleText("equal");
		driver.findElement(By.id("jqg2")).click();
		
		 File directoryPath = new File("C:\\Users\\swapnil.patil\\Desktop\\SKDSL\\Data\\");
		
		String linkname=ln;
		ReadGuru99ExcelFile objExcelFile = new ReadGuru99ExcelFile();
		String filePath = fp.replaceAll(fn, "");
		objExcelFile.readExcel(filePath, linkname+".xlsx", "English");
		
		
		driver.findElement(By.id("jqg2")).sendKeys(linkname.trim());
		
		
		Thread.sleep(5000);
		driver.findElement(By.id("fbox_gridSectionDetailsApp_search")).click();
		driver.findElement(By.xpath("//*[@id=\"search_gridSectionDetailsApp\"]/div/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("fbox_gridSectionDetailsApp_search")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Thread.sleep(1000);
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"gridSectionDetailsApp\"]/tbody/tr[2]/td[6]/form/a")));
				int rowc=driver.findElements(By.xpath("//*[@id=\"gridSectionDetailsApp\"]/tbody/tr")).size();
				//*[@id="gridSectionDetailsApp"]/tbody
				for (int i = 0; i < rowc; i++) {
				String XPath="//*[@id=\"gridSectionDetailsApp\"]/tbody/tr["+(i+2)+"]";
				//System.out.println("##############################"+driver.findElement(By.xpath(XPath+"/td[2]")).getText().toString());
				if (driver.findElement(By.xpath(XPath+"/td[4]")).getText().toString().equalsIgnoreCase("Important Information")) {
				System.out.println("##############################"+driver.findElement(By.xpath(XPath)).getText().toString());
				driver.findElement(By.xpath(XPath+"/td[6]/form/a")).click();
				break;

				}

				}
		////////////////////////////////////////////////////////////////////////////////////
		
		

		

		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i = objExcelFile.map1.get("eng").size() - 1; i >= 0; i--) {

			wait.until(ExpectedConditions.elementToBeClickable(By.id("AdminAdd")));
			Thread.sleep(1000);
			driver.findElement(By.id("AdminAdd")).click();

			wait.until(ExpectedConditions
					.elementToBeClickable(By.cssSelector("input[type=\"submit\"][value=\"Submit\"]")));

			wait.until(ExpectedConditions.elementToBeClickable(By.name("entity.txt_01_rg")));
			driver.findElement(By.name("entity.txt_01_en")).sendKeys(objExcelFile.map1.get("eng").get(i).toString().trim());
			driver.findElement(By.name("entity.txt_01_rg")).sendKeys(objExcelFile.map1.get("mar").get(i).toString().trim());
		
			
						
						
						/*
						 * wait.until(ExpectedConditions.elementToBeClickable(By.name(
						 * "entity.date_01")));
						 * 
						 * driver.findElement(By.name("entity.date_01")).click();
						 * driver.findElement(By.name("entity.date_01")).sendKeys(objExcelFile.map1.get(
						 * "eng1").get(i).toString().trim());
						 */	  
						  
						  
						/*
						 * driver.findElement(By.name("entity.txta_02_en")).click();
						 * driver.findElement(By.name("entity.txta_02_en")).sendKeys(objExcelFile.map1.
						 * get("eng1").get(i).toString().trim());
						 * 
						 * 
						 * driver.findElement(By.name("entity.txta_02_rg")).sendKeys(objExcelFile.map1.
						 * get("marn").get(i).toString().trim());
						 */
						 
			
			
			

						  	
						
						  //
						  System.out.println(objExcelFile.map1.get("eng").get(i).toString().trim()+"==" +objExcelFile.map1.get("mar").get(i).toString().trim());
						  
						  String doc[] =objExcelFile.map1.get("d").get(i).toString().split(".pdf");
						  
						  if (doc.length>0) {
							  for (int j = 0; j < doc.length; j++) {
						
						  
						  String fpath=filePath+doc[j].toString(); 
						  System.out.println("fpath===>"+fpath);
						  File f = new File(fpath); if(f.exists() ) {
							
						  driver.findElement(By.xpath("//label[contains(text(),'Download')]")).click(); 
						  //
						//  js.executeScript("arguments[0].click();", button); 
						  common.upload(fpath);
						  common.wait(driver, (j + 1),doc[j].toString()); 
						  }else { System.out.println("file does no t exist"+fpath);
						  }
						  
						  } }
						 
					
			
		
			driver.findElement(By.cssSelector("input[type=\"submit\"][value=\"Submit\"]")).click();

		}
		driver.quit();
		
		
		
		
	
	///
	
	
	
	
	driver.quit();
	
	
	


	}

}

}

	
	
	
	
	
	
	
	}
}