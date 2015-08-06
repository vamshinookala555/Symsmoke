package basicTest;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import basic.Basic_Functional;
import basic.Dropdown;

public class NewInputForm {
	Dropdown drop=new Dropdown();
	Basic_Functional basic =new Basic_Functional();

	@Test
	public void CreateNewInputForm(WebDriver driver) throws FileNotFoundException, IOException, InterruptedException
	{
		basic.loadProperties("NewInputForm");
		drop.dropdown(driver, basic.getProperties("Setup"), "Datasets");
		drop.dropdown(driver, basic.getProperties("Action"), "New Input Form");
		
		//drop.dropdown(driver, basic.getProperties("Dataset"), "dataset1");
		/*WebElement element =  driver.findElement(By.id("Content_Content_ASPxComboBoxInputFormObject_I"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);*/
		/*driver.findElement(By.id("Content_Content_ASPxComboBoxInputFormObject_I")).click();
		driver.findElement(By.id("Content_Content_ASPxComboBoxInputFormObject_DDD_L_LBI2T0")).click();*/
		basic.button(driver, basic.getProperties("Dataset"));
		basic.button(driver, basic.getProperties("datasetValue"));
		Thread.sleep(1000);
		basic.button(driver, basic.getProperties("availableFields")); 
		basic.button(driver, basic.getProperties("Selection"));
		basic.button(driver, basic.getProperties("Next"));
		basic.button(driver, basic.getProperties("Preview"));
		Thread.sleep(1500);
		basic.textBox(driver, basic.getProperties("FormName"), "New Form_Smoketest");
		basic.button(driver, basic.getProperties("save"));
	}
}
