package DataExtraction;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DataScrappingsmartcity {

	public static void main(String[] args) throws InterruptedException, IOException {

		CommonUtils common = new CommonUtils();
		
		WebDriver driver = common.Openbrowser("https://www.kdmc.gov.in/RtsPortal/scm/index.jsp");

		common.checkPageIsReady(driver);

	
	




			
		
		
		
		try {
			
			 
			 
			 
	
			 
			List<WebElement>subanchori = driver.findElements(By.tagName("a"));
			System.out.println(subanchori.size());
			  for (int j = 0; j < subanchori.size(); j++) {
				  
				/*
				 * String url = subanchori.get(j).getAttribute("href");
				 * 
				 * String parts[] = url.split("/"); String ss21 =
				 * url.replace("https://www.kdmc.gov.in/", ""); //System.err.println(ss21);
				 * String ss2 = ss21.replace("%20", " "); String[] ss = ss2.split("/"); String
				 * ss11 = ss2.replace(ss[ss.length - 1], ""); // String ss1=ss11.replace(ss[0],
				 * " ");
				 * 
				 * // System.out.println(ss2);
				 */					//System.out.println(ss11);
				/*
				 * String path = "C:\\Users\\swapnil.patil\\Desktop\\SKDSL\\Data\\" + ss11; File
				 * file1 = new File(path); file1.mkdirs();
				 */
				  
				  
				  
				  
				  
				  
				  
				  
				  
				  
				  
				  
				  
				  
			
				  
				  
				  
				  System.out.println(j+"============"+subanchori.get(j).getText());
				 // common.DownloadPDFFromURL(subanchori.get(j).getAttribute("href"),path );
				
			}
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		 
		
	
		  
		 
		 

	
	
	

	

	}}
