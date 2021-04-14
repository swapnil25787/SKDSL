package DataExtraction;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonUtils {

	public static WebDriver driver = null;

	public static WebDriver Openbrowser(String url) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		return driver;

	}
	public static void All(WebDriver driver) {

		try {
			if (driver.findElement(By.name("data_length")).isDisplayed()) {
				// System.err.println("pagination is there");
				Thread.sleep(1000);
				WebElement drpCountry1 = driver.findElement(By.name("data_length"));
				drpCountry1.sendKeys("All");
				Thread.sleep(4000);

			} else {

				throw new Exception();

			}

		} catch (Exception e) {

		}
	}
	public static void createfile(String filename) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();

		Workbook wb = new XSSFWorkbook();
		Sheet sheet1 = wb.createSheet("English");
		Sheet sheet2 = wb.createSheet("Hindi");
		FileOutputStream fileOut = new FileOutputStream(filename);
		wb.write(fileOut);
		fileOut.close();
		wb.close();
	}

	public static void wait(WebDriver driver, int count, String fn) {

		int i;
		for (i = 0; i < 1;) {

			String xpath = "//li[contains(text(),'" + fn + "')]";

			//System.out.println(xpath);
			try {
				driver.findElement(By.xpath(xpath)).isDisplayed();
				//Thread.sleep(500);
				break;
			} catch (Exception e) {
			//	System.out.println("Path not found");
				i = 0;

			}
		}
	}

	public static void checkPageIsReady(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int j = 0; j < 1;) {

			if (js.executeScript("return document.readyState").toString().equals("complete")) {

				break;
			} else {
				j = 0;
			}

		}
	}

	public static void DownloadPDFFromURL(String link, String path) {
		try {

			URL url = new URL(link);
			InputStream in = url.openStream();
			String pdfname[] = link.split("/");

			String filename = pdfname[pdfname.length - 1].replace("%20", " ");
		//	System.out.println("image name=="+ll+jj+filename);
			FileOutputStream fos = new FileOutputStream(new File(path +filename));
			int length = -1;
			byte[] buffer = new byte[50000];
			while ((length = in.read(buffer)) > -1) {
				fos.write(buffer, 0, length);
			}
			fos.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void upload(String path) throws IOException, InterruptedException {
		String currentDirectory = System.getProperty("user.dir") + "\\upload.exe";
		Process proc = Runtime.getRuntime().exec(currentDirectory + " " + path);

		// System.err.println(proc.isAlive());

		for (int k = 0; k < 1;) {
			if (proc.isAlive()) {
			//	System.err.println(" part1");
				//Thread.sleep(500);
			} else {
				//System.err.println("else part");
				break;
			}
		}

	}

	public static void tableread(String filename, int index, String p) {
		try {
			ExcelWriting ew = new ExcelWriting();
			ArrayList<String> datatobewritten = new ArrayList<String>();

			System.out.println(driver.findElement(By.xpath("//*[@id=\"middle_right\"]/ul")).getText());
			int rows = driver.findElements(By.xpath("//*[@id=\"content\"]/div/table/tbody/tr")).size();

			int col = driver.findElements(By.xpath("//*[@id=\"content\"]/div/table/tbody/tr[1]/th")).size();
			System.out.println(rows + "==================" + col);

			for (int l = 1; l <= rows; l++) {
				datatobewritten = new ArrayList<String>();

				for (int j = 1; j <= col; j++) {

					if (l == 1) {

						String rowdata1 = "//*[@id=\"content\"]/div/table/tbody/tr[" + l + "]/th[" + j + "]";
						System.out.println(driver.findElement(By.xpath(rowdata1)).getText());
						datatobewritten.add(driver.findElement(By.xpath(rowdata1)).getText().toString());
						ew.excelWriting2(filename, l, datatobewritten, index);
					} else {
						String rowdata = "//*[@id=\"content\"]/div/table/tbody/tr[" + l + "]/td[" + j + "]";
						WebElement w = driver.findElement(By.xpath(rowdata));
						System.out.println(driver.findElement(By.xpath(rowdata)).getText());
						datatobewritten.add(driver.findElement(By.xpath(rowdata)).getText().toString());
						System.out.println("datatobewritten===" + datatobewritten);
						if (index == 0) {
							dynamic(w,p);
						}

					}
					ew.excelWriting2(filename, l, datatobewritten, index);
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void tableread1(String filename, int index, String p) {
		try {
		
			ArrayList<String> datatobewritten = new ArrayList<String>();

			System.out.println(driver.findElement(By.xpath("//*[@id=\"middle_right\"]/ul")).getText());
			int rows = driver.findElements(By.xpath("//*[@id=\"content\"]/div/table/tbody/tr")).size();

			int col = driver.findElements(By.xpath("//*[@id=\"content\"]/div/table/tbody/tr[1]/th")).size();
			System.out.println(rows + "==================" + col);

			for (int l = 1; l <= rows; l++) {
				datatobewritten = new ArrayList<String>();

				for (int j = 1; j <= col; j++) {

					if (l == 1) {

						String rowdata1 = "//*[@id=\"content\"]/div/table/tbody/tr[" + l + "]/th[" + j + "]";
						System.out.println(driver.findElement(By.xpath(rowdata1)).getText());
						datatobewritten.add(driver.findElement(By.xpath(rowdata1)).getText().toString());
					
					} else {}
				
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void dynamic(WebElement w, String p) {

		ArrayList<String> wind = new ArrayList<String>();
		List<WebElement> links = w.findElements(By.tagName("a"));
		List<String> l = new ArrayList<String>();
		for (int i = 0; i < links.size(); i++) {

			try {
				if (links.get(i).getAttribute("onclick") != null) {

					if (links.get(i).getAttribute("onclick").contains("downloadFile")) {
						// System.out.println(links.get(i).getAttribute("onclick"));
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript(links.get(i).getAttribute("onclick"));
						wind = new ArrayList<String>();
						Set<String> allWindowHandles1 = driver.getWindowHandles();
						for (String handle : allWindowHandles1) {
							wind.add(handle);
						}

						driver.switchTo().window(wind.get(1));
						checkPageIsReady(driver);
						Thread.sleep(1000);
						System.out.print("url||" + driver.getCurrentUrl());
						l.add(driver.getCurrentUrl());
						DownloadPDFFromURL(driver.getCurrentUrl(), p);
						driver.close();
						driver.switchTo().window(wind.get(0));

					}
				}
			} catch (Exception e) {

			}
		}
	}
}
