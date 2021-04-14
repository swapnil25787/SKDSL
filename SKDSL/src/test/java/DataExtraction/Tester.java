package DataExtraction;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Tester {
	public static void main(String[] args) throws IOException, InterruptedException {

		File directoryPath11 = new File(
				"C:\\Users\\swapnil.patil\\Desktop\\SKDSL\\Data\\Pot Hole Work Undertaken by KDMC\\");

		File filesList11[] = directoryPath11.listFiles();
		System.out.println(filesList11.length);

		ReadGuru99ExcelFile objExcelFile = new ReadGuru99ExcelFile();
		objExcelFile.readExcel("C:\\Users\\swapnil.patil\\Desktop\\", "a.xlsx", "Sheet1");

		for (int i = 0; i < objExcelFile.map1.get("Filename").size(); i++) {
			
			
			
			
			for (int no11 = 0; no11 < filesList11.length; no11++) {

				Path path1 = Paths.get(filesList11[no11].toString());
				Path fileName1 = path1.getFileName();

				if (objExcelFile.map1.get("Filename").get(i).toString().equalsIgnoreCase(fileName1.toString())) {
					System.out.println(objExcelFile.map1.get("Filename").get(i).toString()+"===="+fileName1.toString());
					moveFile("C:\\Users\\swapnil.patil\\Desktop\\SKDSL\\Data\\Pot Hole Work Undertaken by KDMC\\"+objExcelFile.map1.get("Filename").get(i).toString().trim(), "C:\\Users\\swapnil.patil\\Desktop\\SKDSL\\d\\"+objExcelFile.map1.get("Filename").get(i).toString());
				}

			}
			
			
	


			
			
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		

	

	
	}

	private static void moveFile(String src, String dest) {
		Path result = null;
		try {
			result = Files.move(Paths.get(src), Paths.get(dest));
		} catch (IOException e) {
			System.out.println("Exception while moving file: " + e.getMessage());
		}
		if (result != null) {
			System.out.println("File moved successfully.");
		} else {
			System.out.println("File movement failed.");
		}
	}
}