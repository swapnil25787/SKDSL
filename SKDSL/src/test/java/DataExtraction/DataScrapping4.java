package DataExtraction;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DataScrapping4 {

	public static void main(String[] args) throws InterruptedException, IOException {

		CommonUtils common = new CommonUtils();
		ArrayList<String> arrayList;

		WebDriver driver = common.Openbrowser("http://13.234.173.159/Skdcl/CitizenHome.html");

		common.checkPageIsReady(driver);
		driver.findElement(By.xpath("//*[@id=\"text-resize\"]/header/div[1]/div/div[2]/div[2]/ul/li[4]/a")).click();
		common.checkPageIsReady(driver);
		driver.findElement(By.cssSelector("a[href=\"sitemap.html\"]")).click();
		common.checkPageIsReady(driver);
		WebElement classs = driver.findElement(By.xpath("(//div[@class=\"categTree\"])[3]"));
		WebDriverWait wait = new WebDriverWait(driver, 10);

		ArrayList<String> datatobewritten = new ArrayList<String>();

		common.checkPageIsReady(driver);
		java.util.List<WebElement> sitemaplinks = classs.findElements(By.tagName("a"));
		System.out.println("Sitmap link" + sitemaplinks.size());
		arrayList = new ArrayList<String>();
		for (int j = 0; j < sitemaplinks.size(); j++)

		{
			try {

				if (sitemaplinks.get(j).getAttribute("href") == null) {

				} else {
					if (sitemaplinks.get(j).getAttribute("href").contains("SectionInformation.html?")) {

						if (!(arrayList.contains(sitemaplinks.get(j).getAttribute("href")))) {
							System.out.println(j+"|"+sitemaplinks.get(j).getText() + "|" + sitemaplinks.get(j).getAttribute("href"));
							arrayList.add(sitemaplinks.get(j).getAttribute("href"));

						}

					}

				}
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		System.out.println("links==" + sitemaplinks.size());

		System.out.println("arrayList==" + arrayList.size());
		System.out.println("arrayList==" + arrayList);

		common.All(driver);
		ExcelWriting ew = new ExcelWriting();
		for (int i = 0; i < arrayList.size(); i++) {
			
			driver.navigate().to(arrayList.get(i));
			common.checkPageIsReady(driver);
			common.All(driver);
			String linkname=driver.findElement(By.xpath("//*[@id=\"text-resize\"]/div[2]/div/div/div[1]/h2")).getText();
			System.out.println(i+ "|"+linkname);

			File file = new File("C:\\Users\\swapnil.patil\\Desktop\\SKDSL\\Data\\newportal\\"+i+"\\");
			//
			file.mkdir();
			File file1 = new File("C:\\Users\\swapnil.patil\\Desktop\\SKDSL\\Data\\newportal\\"+i+"\\" +linkname+"\\");
			
			file1.mkdir();
			  common.createfile("C:\\Users\\swapnil.patil\\Desktop\\SKDSL\\Data\\newportal\\"+i+"\\"+ linkname +"\\"+linkname+".xlsx");
		
String filename="C:\\Users\\swapnil.patil\\Desktop\\SKDSL\\Data\\newportal\\"+i+"\\"+ linkname +"\\"+linkname+".xlsx";

			int row = driver.findElements(By.xpath("//*[@id=\"data\"]/tbody/tr")).size();
			int col = driver.findElements(By.xpath("//*[@id=\"data\"]/tbody/tr[1]/td")).size();

			for (int k = 0; k < row; k++) {
				datatobewritten = new ArrayList<String>();
				for (int c = 0; c < col; c++) {
					

					String txpath = "//*[@id=\"data\"]/tbody/tr[" + (k + 1) + "]/td[" + (c + 1) + "]";
					//System.out.print(driver.findElement(By.xpath(txpath)).getText() + "|");
					datatobewritten.add(driver.findElement(By.xpath(txpath)).getText());
					//*[@id="text-resize"]/div[2]/div/div/div[1]/h2
					
					
					WebElement w = driver.findElement(By.xpath(txpath));
					ArrayList<String> wind = new ArrayList<String>();
					List<WebElement> links = w.findElements(By.tagName("a"));
					List<String> l = new ArrayList<String>();
					
					  if (links.size()<1) {
						  datatobewritten.add("No Document");
					  }else {
						
					
					 
					for (int i1 = 0; i1 < links.size(); i1++) {

						try {
							if (links.get(i1).getAttribute("onclick") != null) {

								if (links.get(i1).getAttribute("onclick").contains("downloadFile")) {
									// System.out.println(links.get(i).getAttribute("onclick"));
									JavascriptExecutor js = (JavascriptExecutor) driver;
									js.executeScript(links.get(i1).getAttribute("onclick"));
									wind = new ArrayList<String>();
									Set<String> allWindowHandles1 = driver.getWindowHandles();
									for (String handle : allWindowHandles1) {
									//	System.out.println("hhhhhhhhhhhhhhhh==="+handle);
										wind.add(handle);
									}

									driver.switchTo().window(wind.get(1));
									common.checkPageIsReady(driver);
									String pdfurls = driver.getCurrentUrl().toString();
							//		System.out.println("+++++++++++++"+pdfurls);
									String pdf[] = pdfurls.split("/");
									
								
									datatobewritten.add(pdf[pdf.length - 1].toString().replaceAll("%20", " "));
									driver.close();
									driver.switchTo().window(wind.get(0));

								}
							}
						} catch (Exception e) {

							
						}

					}}
					ew.excelWriting2(filename, k, datatobewritten, 0);
//System.out.println(datatobewritten);
				
				}
				//System.out.println("-------------------------------------------------------------------------------------------------");
			}

		}

	}

}
