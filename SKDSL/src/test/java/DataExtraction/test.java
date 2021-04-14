package DataExtraction;

import java.io.File;

public class test {
	
	
	
	
	public static void removeWhiteSpace (File IBFolder) {
	    // For clarification:
	    File IBFolder1 = new File("C:\\Users\\swapnil.patil\\Desktop\\SKDSL\\Home Departments Town Planning Building Permission Granted 27 Villages\\");
	    String oldName;
	    String newName;
	    String temp;
	    for (File old : IBFolder1.listFiles()) {
	        oldName = old.getName();
	        temp = oldName.replaceAll(" ", "");
	        // I have also tried:
	        // temp = oldName.replaceAll("//s", "");
	        temp = temp.split(".pdf")[0];
	        newName = temp + ".pdf";
	        System.out.println(newName);
	        old.renameTo(new File(newName));
	    }}
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		 File IBFolder1 = new File("C:\\Users\\swapnil.patil\\Desktop\\SKDSL\\Home Departments Town Planning Building Permission Granted 27 Villages\\");
		    String oldName;
		    String newName;
		    String temp;
		    for (File old : IBFolder1.listFiles()) {
		        oldName = old.getName();
		        temp = oldName.replaceAll("  ", " ");
		        // I have also tried:
		        // temp = oldName.replaceAll("//s", "");
		        temp = temp.split(".pdf")[0];
		        newName = temp + ".pdf";
		        System.out.println(newName);
		        old.renameTo(new File(newName));
		    }
		
		
	}
}
