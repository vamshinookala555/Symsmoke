package controlTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;



import basic.Basic_Functional;
import basicTest.CreateDataSets;
import basicTest.CreateDatasetFromFile;
import basicTest.Editdatasets;
import basicTest.LoginTest;
import basicTest.dataconnectorTest;


public class TestControlProgram {
	Basic_Functional basic =new Basic_Functional();
	WebDriver driver=basic.getURL();

		@Test(priority=1)
	public void Control() throws IOException, InvalidFormatException, InterruptedException {
		// TODO Auto-generated method stub
		
		FileInputStream fs=new FileInputStream("src/test/resources/Testsuite.xlsx");
		Workbook wb= new XSSFWorkbook(fs);
		Sheet sh=wb.getSheetAt(0);
		int noofrows=sh.getLastRowNum();
		//System.out.println(noofrows);
		for(int i=1; i<=noofrows;i++)
		{
			Row rw= sh.getRow(i);
			System.out.println(sh.getRow(i).getCell(2).getStringCellValue());
			String temp=sh.getRow(i).getCell(2).getStringCellValue();
			StringBuffer switchvar= new StringBuffer(temp.toUpperCase());
			System.out.println(switchvar);
			switch(switchvar.toString())
			{
				
				case "LOGIN":
					if(sh.getRow(i).getCell(3).getStringCellValue().equalsIgnoreCase("YES") ||sh.getRow(i).getCell(3).getStringCellValue().equalsIgnoreCase("Y") )
					{
					LoginTest log=new LoginTest();
					log.Login(driver);
					}
					break;
				case "CREATE DATASETS":
					if(sh.getRow(i).getCell(3).getStringCellValue().equalsIgnoreCase("YES") ||sh.getRow(i).getCell(3).getStringCellValue().equalsIgnoreCase("Y") )
					{
						CreateDataSets edit=new CreateDataSets();
						edit.CreateDataSets_func(driver);
					}
					break;
				case "CREATE DATASETS FROM FILE":
					if(sh.getRow(i).getCell(3).getStringCellValue().equalsIgnoreCase("YES") ||sh.getRow(i).getCell(3).getStringCellValue().equalsIgnoreCase("Y") )
					{
						CreateDatasetFromFile createfile=new CreateDatasetFromFile();
						createfile.CreateDataSetsFile(driver);
					}
					break;
				case "CREATE DATASETS FROM CONNECTORS":
					if(sh.getRow(i).getCell(3).getStringCellValue().equalsIgnoreCase("YES") ||sh.getRow(i).getCell(3).getStringCellValue().equalsIgnoreCase("Y") )
					{
						dataconnectorTest dc = new dataconnectorTest();
						dc.dataconnector_func(driver);
					}
					break;
				case "EDIT DATASET":
					if(sh.getRow(i).getCell(3).getStringCellValue().equalsIgnoreCase("YES") ||sh.getRow(i).getCell(3).getStringCellValue().equalsIgnoreCase("Y") )
					{
						Editdatasets ed= new Editdatasets();
						ed.editdataset(driver);
					}
					break;	
			}
		}
	}

}
