package basicTest;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import basic.Basic_Functional;


public class LoginTest {
 

  public void Login(WebDriver driver) throws FileNotFoundException, IOException, InvalidFormatException {
	  Basic_Functional basic =new Basic_Functional();
	  //basic.Basic();
	  //basic.getURL();
	  basic.loadProperties("Login");
	  basic.LoadExcel("Logindata");
	  basic.textBox(driver, basic.getProperties("Login"), basic.getExceldata(1, 0));
	  basic.textBox(driver, basic.getProperties("pswd"), basic.getExceldata(1, 1));
	  basic.button(driver, basic.getProperties("loginbutton"));
	  //basic.screenShot(driver,"Loginsuccessful");
	  
	  
  }
}
