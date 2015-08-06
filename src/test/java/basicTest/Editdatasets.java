package basicTest;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import basic.Basic_Functional;
import basic.Dropdown;

public class Editdatasets {

	Basic_Functional basic=new Basic_Functional();
	Dropdown drop=new Dropdown();
	public void editdataset(WebDriver driver) throws FileNotFoundException, IOException, InterruptedException
	{
		basic.loadProperties("Editdatasets");
		drop.dropdown(driver, basic.getProperties("Setup"), "Datasets");
		//drop.dropdown(driver, basic.getProperties("Action"), "New DataSet from File");
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By.cssSelector("span[id*=ASPxLabelName]"));
		actions.moveToElement(menuHoverLink);
		actions.perform();
		WebElement subLink = driver.findElement(By.xpath("//*[contains(@id, 'ArgusNavigationPanel_ASPxTreeListForNavigator_R')]/td[2]/table/tbody/tr/td/div/a/img"));
		actions.moveToElement(subLink);
		actions.click();
		actions.perform();
		WebElement edit=driver.findElement(By.cssSelector("li[id*=ASPxPopupMenuForRootNodes_DXI1_]"));
		actions.moveToElement(edit);
		actions.click();
		actions.perform();
		Thread.sleep(5000);
		basic.button(driver, basic.getProperties("TrackData"));
		basic.button(driver, basic.getProperties("Save"));
		Alert al=driver.switchTo().alert();
		al.accept();
		
	}
}
