package DataExtraction;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DataScrapping2 {

	public static void main(String[] args) throws InterruptedException, IOException {

		CommonUtils common = new CommonUtils();

		WebDriver driver = common.Openbrowser("http://13.234.173.159/Skdcl/CitizenHome.html");

		common.checkPageIsReady(driver);
		driver.findElement(By.xpath("//*[@id=\"text-resize\"]/header/div[1]/div/div[2]/div[2]/ul/li[4]/a")).click();
		common.checkPageIsReady(driver);
		driver.findElement(By.cssSelector("a[href=\"sitemap.html\"]")).click();
		common.checkPageIsReady(driver);
		WebElement classs = driver.findElement(By.xpath("(//div[@class=\"categTree\"])[3]"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		List<WebElement> anchor = classs.findElements(By.tagName("a"));
		String filename = "C:\\Users\\swapnil.patil\\Desktop\\SKDSL\\stat\\webportal.xlsx";
		ExcelWriting ew = new ExcelWriting();
		ArrayList<String> datatobewritten = new ArrayList<String>();
		for (int i = 0; i < anchor.size(); i++) {

			datatobewritten = new ArrayList<String>();

			List<WebElement> subanchor = null;
			common.checkPageIsReady(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class=\"categTree\"])[3]")));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class=\"categTree\"])[3]")));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class=\"categTree\"])[3]")));
			WebElement classs1 = driver.findElement(By.xpath("(//div[@class=\"categTree\"])[3]"));
			subanchor = classs1.findElements(By.tagName("a"));

			
String exceptiont=subanchor.get(i).getText();
			System.out.println(i+"----->" + subanchor.get(i).getText());
			subanchor.get(i).click();
			common.checkPageIsReady(driver);
			String titlename, folder;
		
			try {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"CitizenService\"]/li")));
				int bredcrumbcount = driver.findElements(By.xpath("//*[@id=\"CitizenService\"]/li")).size();
				for (int j = 1; j <= bredcrumbcount; j++) {

					String xpath = "//*[@id=\"CitizenService\"]/li[" + j + "]";
					datatobewritten.add(driver.findElement(By.xpath(xpath)).getText());

				}
//System.out.println(datatobewritten);
				wait.until(ExpectedConditions.elementToBeClickable(By.name("data_length")));
				Select all = new Select(driver.findElement(By.name("data_length")));
				all.selectByVisibleText("All");

				// *[@id="data"]/tbody/tr[1]/td[1]
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"data\"]/tbody/tr")));
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"data\"]/tbody/tr")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"data\"]/tbody/tr")));
				//Thread.sleep(2000);
				int row = driver.findElements(By.xpath("//*[@id=\"data\"]/tbody/tr")).size();

				int col = driver.findElements(By.xpath("//*[@id=\"data\"]/tbody/tr[1]/td")).size();
				datatobewritten.add(driver.getCurrentUrl().toString());
				if (row > 1) {
					datatobewritten.add("Data present");
					System.out.println(datatobewritten);
					ew.excelWriting2(filename, (i+1), datatobewritten, 0);
				}else {
					datatobewritten.add("No Data present");
					System.out.println(datatobewritten);
					ew.excelWriting2(filename, (i+1), datatobewritten, 0);
				}

			} catch (Exception e) {
				
				datatobewritten.add(exceptiont);
				datatobewritten.add("Exception occured");
				System.out.println(datatobewritten);
				ew.excelWriting2(filename, (i+1), datatobewritten, 0);
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href=\"sitemap.html\"]")));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href=\"sitemap.html\"]")));
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href=\"sitemap.html\"]")));
			
			WebElement ele = driver.findElement(By.cssSelector("a[href=\"sitemap.html\"]"));
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click()", ele);
			
			
			
			
			
			
		//	driver.findElement(By.cssSelector("a[href=\"sitemap.html\"]")).click();
			common.checkPageIsReady(driver);

		}
	}

}
