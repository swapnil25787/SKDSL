package DataExtraction;

import java.io.File;

public class Main {
	   public static void main(String[] args) {
		   
		   

			String path="C:\\Users\\swapnil.patil\\Desktop\\SKDSL\\Home Departments Town Planning Building Permission Granted 27 Villages\\";
			File f = new File(path); 
			  File[] files = f.listFiles(); 
				
				  
	          System.out.println("Files are:"); 
	          for (int i = 0; i < files.length; i++) {
	        	  System.out.println();
	        	  File oldName = new File(files[i].toString());
	        	  String a[]=files[i].toString().split("\\\\");
	  			System.out.println(a[a.length-1]);
	  			String str = a[a.length-1].toString().replaceAll("[^a-zA-Z0-9]", "")+".pdf";
			      File newName = new File(path+str);
			      
			      if(oldName.renameTo(newName)) {
			         System.out.println("renamed");
			      } else {
			         System.out.println("Error");
			      }
			   }
	        	
				
			}
			
			
		

			
				
				  
	  
	       
			
		
		   
		   
		   
		   
		   
		   
		   
		   
		   
	      
	}