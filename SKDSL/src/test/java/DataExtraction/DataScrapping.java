package DataExtraction;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DataScrapping {

	public static void main(String[] args) throws InterruptedException, IOException {

		CommonUtils common = new CommonUtils();

		WebDriver driver = common.Openbrowser("https://www.kdmc.gov.in/");

		common.checkPageIsReady(driver);

		driver.findElement(By.cssSelector("a[href=\"sitemap.html\"]")).click();
		common.checkPageIsReady(driver);
		WebElement classs = driver.findElement(By.xpath("(//div[@class=\"categTree\"])[3]"));
		List<WebElement> anchor = classs.findElements(By.tagName("a"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		for (int i = 0; i < anchor.size(); i++) {

if (i==403) {
	


			List<WebElement> subanchor = null;
			common.checkPageIsReady(driver);
			WebElement classs1 = driver.findElement(By.xpath("(//div[@class=\"categTree\"])[3]"));
			subanchor = classs1.findElements(By.tagName("a"));

			if (subanchor.get(i).getAttribute("rel").equalsIgnoreCase("")
					&& !(subanchor.get(i).getAttribute("href")
							.equalsIgnoreCase("https://www.kdmc.gov.in/RtsPortal/sitemap.html#"))
					&& !(subanchor.get(i).getAttribute("href").equalsIgnoreCase(
							"https://www.kdmc.gov.in/RtsPortal/enewsletter/CITIZENCHARTERKDMC.pdf"))) {

				System.out.println(subanchor.get(i).getText() + "==>" + i);
				 subanchor.get(i).click();
				common.checkPageIsReady(driver);
				String titlename, folder;
				try {
					 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/h1")));
					 Thread.sleep(2000);
				titlename = driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
				//	titlename = "ss";

					//folder = driver.findElement(By.xpath("//*[@id=\"middle_right\"]/ul")).getText();

					// String foldername = folder.replaceAll("[-+.^:,]"," ");
					String foldername = titlename;

					File file = new File("C:\\Users\\swapnil.patil\\Desktop\\SKDSL\\Data\\KDMC\\"+i+"\\");
					//
					file.mkdir();
					File file1 = new File("C:\\Users\\swapnil.patil\\Desktop\\SKDSL\\Data\\KDMC\\"+i+"\\" +foldername+"\\");
					
					file1.mkdir();
					
					  common.createfile("C:\\Users\\swapnil.patil\\Desktop\\SKDSL\\Data\\KDMC\\"+i+"\\"+ foldername +"\\"+titlename+".xlsx");
					  
					  String filname ="C:\\Users\\swapnil.patil\\Desktop\\SKDSL\\Data\\KDMC\\"+i+"\\"+ foldername + "\\"+titlename + ".xlsx"; 
					  String filnamepath ="C:\\Users\\swapnil.patil\\Desktop\\SKDSL\\Data\\KDMC\\"+i+"\\"+ foldername + "\\"; common.tableread(filname, 0, filnamepath);
					  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					  "//a[contains(text(),'मराठी')]")));
					  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
					  "//a[contains(text(),'मराठी')]")));
					  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					  "//a[contains(text(),'मराठी')]"))); Thread.sleep(2000);
					  driver.findElement(By.xpath("//a[contains(text(),'मराठी')]")).click();
					  Thread.sleep(2000); //*[@id="topbar"]/div[1]/div[2]/ul/li[5]/a
					  common.checkPageIsReady(driver); common.tableread(filname, 1, filnamepath);
					  
					  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					  "//a[contains(text(),'इंग्रजी')]")));
					  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
					  "//a[contains(text(),'इंग्रजी')]")));
					  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					  "//a[contains(text(),'इंग्रजी')]")));
					  driver.findElement(By.xpath("//a[contains(text(),'इंग्रजी')]")).click();
					  common.checkPageIsReady(driver);
					 
					

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				driver.findElement(By.cssSelector("a[href=\"sitemap.html\"]")).click();
				common.checkPageIsReady(driver);
			}

		}
		}
	}

}
