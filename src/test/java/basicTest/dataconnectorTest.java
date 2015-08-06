package basicTest;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import basic.Basic_Functional;
import basic.Dropdown;

public class dataconnectorTest {
	Basic_Functional basic =new Basic_Functional();
	Dropdown drop=new Dropdown();
	
	public void dataconnector_func(WebDriver driver) throws FileNotFoundException, IOException, InterruptedException
	{
		basic.loadProperties("dataconnector");
		drop.dropdown(driver, basic.getProperties("Setup"), "Data Connectors");
		drop.dropdown(driver, basic.getProperties("Action"), "New");
		Thread.sleep(5000);
		drop.dropdown(driver, basic.getProperties("Selectdataconnector"), "WindowsAzure");
		basic.button(driver, basic.getProperties("Submit"));
		basic.textBox(driver, basic.getProperties("Name"), "Smoke_Dataconnector");
		basic.textBox(driver, basic.getProperties("Description"), "Smoke_Dataconnector1");
		basic.textBox(driver, basic.getProperties("Enteremailaddress"), "cdizon@argussoftware.com");
		basic.textBox(driver, basic.getProperties("Enterkey"), "argus2");
		basic.textBox(driver, basic.getProperties("Entercountrycode"), "CN");
		basic.textBox(driver, basic.getProperties("Enterindicatorcode"), "CM.MKT.TRNR");
		basic.button(driver, basic.getProperties("Save"));
		
		
	}
}
