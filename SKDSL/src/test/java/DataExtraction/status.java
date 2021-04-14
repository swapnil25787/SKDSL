package DataExtraction;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class status {

	public static void main(String[] args) throws IOException, InterruptedException {
		CommonUtils common = new CommonUtils();
		ExcelWriting ew = new ExcelWriting();
		ArrayList<String> datatobewritten = new ArrayList<String>();
		WebDriver driver = common.Openbrowser("http://13.234.173.159/Skdcl/CitizenHome.html");

		common.checkPageIsReady(driver);
		driver.findElement(By.xpath("//*[@id=\"text-resize\"]/header/div[1]/div/div[2]/div[2]/ul/li[4]/a")).click();
		common.checkPageIsReady(driver);
		driver.findElement(By.cssSelector("a[href=\"sitemap.html\"]")).click();
		common.checkPageIsReady(driver);
		

	
		String filename = "C:\\Users\\swapnil.patil\\Desktop\\SKDSL\\Data\\status.xlsx";
		File directoryPath = new File("C:\\Users\\swapnil.patil\\Desktop\\SKDSL\\Data\\");

		ReadGuru99ExcelFile objExcelFile = new ReadGuru99ExcelFile();
		String filePath = "C:\\Users\\swapnil.patil\\Desktop\\SKDSL\\Data\\";
		objExcelFile.readExcel(filePath, "kdmcdatasheet.xlsx", "Sheet1");
		int i = 0;
		for (int j = 0; j < objExcelFile.map1.get("Link Name").size(); j++) {
			datatobewritten = new ArrayList<String>();
			System.out.println(objExcelFile.map1.get("Link Name").get(j).toString().trim());
			String xllinkname = objExcelFile.map1.get("Link Name").get(j).toString().trim();
			datatobewritten.add(xllinkname);
			String status="";
			WebElement classs = driver.findElement(By.xpath("(//div[@class=\"categTree\"])[3]"));
			List<WebElement> anchor = classs.findElements(By.tagName("a"));
			for ( i = 0; i < anchor.size(); i++) {

				if (anchor.get(i).getText().toString().trim().toLowerCase().equalsIgnoreCase(xllinkname.trim().toLowerCase())) {
					
					status="migrated";
					break;
				}else {
			
					status="data not on kdmc website";
					
				}
				
			}	datatobewritten.add(status);
			
			ew.excelWriting3(filename, j, datatobewritten, 0);
		
		}

		

	}

}
