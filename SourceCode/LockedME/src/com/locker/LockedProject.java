package com.locker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LockedProject 
{
    static final String folderpath="E:\\MyPhaseProject1\\Files";	
	public static void main(String[] args) 
{
	int proceed =1;
	
	do {
	//Variable declaration
	
	int ch;
	
	//Display Menu
	ch=displayMenu();
	
	switch(ch) 
	{
	case 1 : getAllFiles();
			 break;
	case 2 : createFiles();
			 break;
	case 3 : deleteFile();
			 break;
	case 4 : searchFile();
			 break;
	case 5 : System.exit(0);
			 break;
	default : System.out.println("Invalid Option");
	}
	
	
	}while (proceed>0);
}
	public static int displayMenu() 
	{
		Scanner obj = new Scanner(System.in);
		//Menu
		int ch;
		System.out.println("************$$$$$$$$$$$$$$$$*************");
		System.out.println("\tWelcome to LockedME");
		System.out.println("************$$$$$$$$$$$$$$$$*************");
		System.out.println("1. Display all files");
		System.out.println("2. Add a new file");
		System.out.println("3. Delete a file");
		System.out.println("4. Search a file");
		System.out.println("5. Exit");
		System.out.println("*****************************************");
		System.out.println("Enter your choice : ");
		ch=Integer.parseInt(obj.nextLine());
		//obj.close();
		return ch;
	}
	/**
	 * This Method is used to get all files from the folder path
	 */
	public static void getAllFiles() 
	{
		// Get file name
		List<String> fileNames = TextManager.getAllFiles(folderpath);
			for(String f:fileNames)
				System.out.println(f);
	}
	
	/**
	 * This Method is used to add a file 
	 */
	public static void createFiles() 
	{
		//Add file Code

		//Variable declration
				Scanner obj = new Scanner(System.in);
				String fileName;
				int linesCount;
				List<String> content = new ArrayList<String>();
				
				//Read file name from user
				System.out.println("Enter file Name : ");
				fileName=obj.nextLine();
				
				//Read number of lines from user
				System.out.println("Enter how many lines in the file :");
				linesCount=Integer.parseInt(obj.nextLine());
				
				//Read Lines from user
				for(int i=1;i<=linesCount;i++) 
				{
				System.out.println("Enter line "+i+":");
				content.add(obj.nextLine());
				}
				
				//save the content into the file
				boolean isSaved = TextManager.createFiles(folderpath, fileName, content);
				
				if(isSaved)
					System.out.println("File and data saved succesfully");
				else
					System.out.println("Some error occured, Please contact admin@zadesrujan");
				//close Scanner object
				//obj.close();
	}
	
	/**
	 * This Method is used to delete a file
	 */
	public static void deleteFile() 
	{
		//Delete a file

		//Code for deleting a file
			String fileName;
			Scanner obj = new Scanner(System.in);
			System.out.println("Enter file name to be deleted : ");
			fileName=obj.nextLine();
			
			boolean isDeleted = TextManager.deleteFile(folderpath, fileName);
			
			if(isDeleted)
				System.out.println("File deleted Successflly");
			else
				System.out.println("Either file not there or some access issued");
	}
	
	/**
	 * This Method is used to search a file
	 */
	public static void searchFile() 
	{
		//Search a file

		//Code for searching a file
				String fileName;
				Scanner obj = new Scanner(System.in);
				System.out.println("Enter file name to be searched : ");
				fileName=obj.nextLine();
				
				boolean isSearch = TextManager.searchFile(folderpath, fileName);
				
				if(isSearch)
					System.out.println("File detected Successflly");
				else
					System.out.println("File not detected");
	}
}
