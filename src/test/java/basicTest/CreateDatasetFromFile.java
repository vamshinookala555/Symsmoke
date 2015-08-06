package basicTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.testng.Assert;
import org.testng.annotations.Test;

import basic.Basic_Functional;
import basic.Dropdown;

public class CreateDatasetFromFile {
	Dropdown drop=new Dropdown();
	Basic_Functional basic =new Basic_Functional();
	
	@Test
	public void CreateDataSetsFile(WebDriver driver) throws FileNotFoundException, IOException, InterruptedException
	{
		basic.loadProperties("DatasetFromFile");
		drop.dropdown(driver, basic.getProperties("Setup"), "Datasets");
		drop.dropdown(driver, basic.getProperties("Action"), "New DataSet from File");
		Thread.sleep(5000);
		WebElement element =  driver.findElement(By.id("Content_Content_ASPxUploadControlDatasetFile_TextBox0"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("javascript:document.getElementById('Content_Content_ASPxUploadControlDatasetFile_TextBox0').click()");
		Runtime.getRuntime().exec("AutoItScripts\\FileUpload.exe");
		Thread.sleep(5000);
		
			basic.button(driver, basic.getProperties("Load"));
			Thread.sleep(8000);
			basic.button(driver, basic.getProperties("Continue"));
			Thread.sleep(5000);
			basic.textBox(driver, basic.getProperties("DatasetName"), "DataSet From File");
			driver.findElement(By.id("Content_Content_checkComboBox_I")).click();
			 List<WebElement> cbox=driver.findElements(By.cssSelector("span[id^='Content_Content_checkComboBox_DDD_DatasetCategoryTreeList']"));
		     cbox.get(0).click();
		     basic.Checkbox(driver, basic.getProperties("EnableInputForm"));
		     drop.dropdown(driver, basic.getProperties("EnableAEIntegration"), "Enabled - single record per entity");
		     Thread.sleep(4000);
		     basic.button(driver, basic.getProperties("Save"));
		     
		     Alert al=driver.switchTo().alert();
		     al.accept();
		     
		     Thread.sleep(3500);
			  WebElement w= driver.findElement(By.id("Content_Content_SuccessMessageLabel"));
			  String s= w.getAttribute("innerHTML");
			    Assert.assertEquals(s, "Dataset has been saved successfully");
			    basic.screenShot(driver, "Create_dataset_File");
			    
	     
	}
}
