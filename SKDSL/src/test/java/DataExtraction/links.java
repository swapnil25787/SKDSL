package DataExtraction;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class links {

	public static void main(String[] args) throws InterruptedException, IOException {

		CommonUtils common = new CommonUtils();
		ExcelWriting ew = new ExcelWriting();
		WebDriver driver = common.Openbrowser("https://www.kdmc.gov.in/");
		ArrayList<String> datatobewritten = new ArrayList<String>();
		common.checkPageIsReady(driver);

		driver.findElement(By.cssSelector("a[href=\"sitemap.html\"]")).click();
		common.checkPageIsReady(driver);
		WebElement classs = driver.findElement(By.xpath("(//div[@class=\"categTree\"])[3]"));
		List<WebElement> anchor = classs.findElements(By.tagName("a"));
		common.createfile("C:\\Users\\swapnil.patil\\Desktop\\SKDSL\\Data\\" + "data" + ".xlsx");
		
		
		for (int i = 0; i < anchor.size(); i++) {
			if (i>427) {
				
			
			
			List<WebElement> subanchor = null;
			common.checkPageIsReady(driver);
			WebElement classs1 = driver.findElement(By.xpath("(//div[@class=\"categTree\"])[3]"));
			subanchor = classs1.findElements(By.tagName("a"));

			if (subanchor.get(i).getAttribute("rel").equalsIgnoreCase("")
					&& !(subanchor.get(i).getAttribute("href")
							.equalsIgnoreCase("https://www.kdmc.gov.in/RtsPortal/sitemap.html#"))
					&& !(subanchor.get(i).getAttribute("href").equalsIgnoreCase(
							"https://www.kdmc.gov.in/RtsPortal/enewsletter/CITIZENCHARTERKDMC.pdf"))) {

		
			
				subanchor.get(i).click();
				
				
				common.checkPageIsReady(driver);
				
				
				String titlename, folder;
				
				try {
					datatobewritten = new ArrayList<String>();
					int pathcount = driver.findElements(By.xpath("//*[@id=\"middle_right\"]/ul/li")).size();

					for (int ll = 1; ll <= pathcount; ll++) {

						String uipath = "//*[@id=\"middle_right\"]/ul/li[" + ll + "]";
						System.out.println(driver.findElement(By.xpath(uipath)).getText());
						datatobewritten.add(driver.findElement(By.xpath(uipath)).getText());
					}

					titlename = driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();

					

					String filname = "C:\\Users\\swapnil.patil\\Desktop\\SKDSL\\Data\\" + "data" + ".xlsx";
					String filnamepath = "C:\\Users\\swapnil.patil\\Desktop\\SKDSL\\Data\\";

					int rows = driver.findElements(By.xpath("//*[@id=\"content\"]/div/table/tbody/tr")).size();

					int col = driver.findElements(By.xpath("//*[@id=\"content\"]/div/table/tbody/tr[1]/th")).size();
					
					
					driver.findElement(By.xpath("//*[@id=\"topbar\"]/div[1]/div[2]/ul/li[5]/a")).click();

					driver.findElement(By.xpath("//*[@id=\"topbar\"]/div[1]/div[2]/ul/li[5]/a")).click();
					
					
					for (int l = 1; l <= rows; l++) {
					

						for (int j1 = 1; j1 <= col; j1++) {

							if (l == 1) {

								String rowdata1 = "//*[@id=\"content\"]/div/table/tbody/tr[" + l + "]/th[" + j1 + "]";
								System.out.println(driver.findElement(By.xpath(rowdata1)).getText());
								datatobewritten.add(driver.findElement(By.xpath(rowdata1)).getText().toString());
							
							} else {break;}
						
						}

					}
					
					
					
					driver.findElement(By.xpath("//*[@id=\"topbar\"]/div[1]/div[2]/ul/li[5]")).click();
					common.checkPageIsReady(driver);
					
					
					for (int ll1 = 1; ll1 <= pathcount; ll1++) {

						String uipath = "//*[@id=\"middle_right\"]/ul/li[" + ll1 + "]";
						System.out.println(driver.findElement(By.xpath(uipath)).getText());
						datatobewritten.add(driver.findElement(By.xpath(uipath)).getText());
					}

					
					
					for (int l1 = 1; l1 <= rows; l1++) {
						

						for (int j2 = 1; j2 <= col; j2++) {

							if (l1 == 1) {

								String rowdata1 = "//*[@id=\"content\"]/div/table/tbody/tr[" + l1 + "]/th[" + j2 + "]";
								System.out.println(driver.findElement(By.xpath(rowdata1)).getText());
								datatobewritten.add(driver.findElement(By.xpath(rowdata1)).getText().toString());
							
							} else {break;}
						
						}

					}
					
					
					System.out.println(datatobewritten);
					ew.excelWriting2(filname, i, datatobewritten, 0);
					driver.findElement(By.xpath("//*[@id=\"topbar\"]/div[1]/div[2]/ul/li[5]")).click();
					common.checkPageIsReady(driver);
					

				} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}

				driver.findElement(By.cssSelector("a[href=\"sitemap.html\"]")).click();
			
				common.checkPageIsReady(driver);
			}

		
		
		
		}
		}}

}
