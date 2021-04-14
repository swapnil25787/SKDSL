package DataExtraction;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ExcelWriting {

	public static int NumberOfRowsforWriting = 0;
	public static WebDriver driver;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet = null;
	public static XSSFRow row1 = null;

	static XSSFCell keyCell = null;
	static XSSFCell valueCell = null;
	static String sheetName = null;
	static int NumberOfRows = 0;
	// static int NumberOfColumns = 0;
	static String key;
	static String value;
	static Boolean isEmpty = false;
	// public static int NumberOfRowsforWriting;

	public static ArrayList<String> datatobewritten = new ArrayList<String>();

	public void excelWriting(String filename, int row, ArrayList<String> data,int col) {

		try {

			FileInputStream fis = new FileInputStream(new File(filename));
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);

			NumberOfRows = sheet.getLastRowNum();
			NumberOfRowsforWriting = NumberOfRows;
			datatobewritten = data;
			datatobewritten.size();
			
			row1 = sheet.getRow(row);
		
			XSSFCell r1c1 = row1.createCell(col);
			r1c1.setCellValue(datatobewritten.get(0));
		

			fis.close();
			FileOutputStream fos = new FileOutputStream(new File(filename));
			workbook.write(fos);
			fos.close();
			//System.out.println("Done");

		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	
	
	
	
	public void excelWriting1(String filename, int r, ArrayList<String> data,int col,int sheetindex) {

		try {

			FileInputStream fis = new FileInputStream(new File(filename));
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(sheetindex);

			NumberOfRows = sheet.getLastRowNum();
			NumberOfRowsforWriting = NumberOfRows;
			datatobewritten = data;
			datatobewritten.size();
			
			row1 = sheet.getRow(r);
		
			XSSFCell r1c1 = row1.createCell(col);
			r1c1.setCellValue(datatobewritten.get(0));
		

			fis.close();
			FileOutputStream fos = new FileOutputStream(new File(filename));
			workbook.write(fos);
			fos.close();
			//System.out.println("Done");

		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public void excelWriting2(String filename, int key, ArrayList<String> data,int index) {

		try {

			FileInputStream fis = new FileInputStream(new File(filename));
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(index);

			NumberOfRows = sheet.getLastRowNum();
			NumberOfRowsforWriting = NumberOfRows;
			datatobewritten = data;
			datatobewritten.size();
			row1 = sheet.createRow(key);
			for (int i = 0; i <= datatobewritten.size() - 1; i++)
			{
				XSSFCell r1c1 = row1.createCell(i);
				r1c1.setCellValue(datatobewritten.get(i));
			}

			fis.close();
			FileOutputStream fos = new FileOutputStream(new File(filename));
			workbook.write(fos);
			fos.close();
		//	System.out.println("Done");

		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excelWriting3(String filename, int key, ArrayList<String> data,int index) {

		try {

			FileInputStream fis = new FileInputStream(new File(filename));
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(index);

			NumberOfRows = sheet.getLastRowNum();
			NumberOfRowsforWriting = NumberOfRows;
			datatobewritten = data;
			datatobewritten.size();
			row1 = sheet.getRow(key);
			for (int i = 0; i <= datatobewritten.size() - 1; i++)
			{
				XSSFCell r1c1 = row1.createCell(i);
				r1c1.setCellValue(datatobewritten.get(i));
			}

			fis.close();
			FileOutputStream fos = new FileOutputStream(new File(filename));
			workbook.write(fos);
			fos.close();
			System.out.println("Done");

		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	}
	
	
	
	
	
	
	


