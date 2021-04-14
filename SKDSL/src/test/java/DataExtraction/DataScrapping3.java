package DataExtraction;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DataScrapping3 {

	public static void main(String[] args) throws InterruptedException, IOException {

		CommonUtils common = new CommonUtils();

		WebDriver driver = common.Openbrowser("https://www.kdmc.gov.in/");

		common.checkPageIsReady(driver);

		driver.findElement(By.cssSelector("a[href=\"sitemap.html\"]")).click();
		common.checkPageIsReady(driver);
		WebElement classs = driver.findElement(By.xpath("(//div[@class=\"categTree\"])[3]"));
		List<WebElement> anchor = classs.findElements(By.tagName("a"));

		for (int i = 0; i < anchor.size(); i++) {


			System.out.println(anchor.get(i).getText() + "==>" + i );
		
			

		
		}
	}

}
