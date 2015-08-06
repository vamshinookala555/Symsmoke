package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dropdown {

	public void dropdown(WebDriver driver, String locator, String dropdownvalue)
	{
		boolean find=true;
		if(locator.startsWith("//")){
			driver.findElement(By.xpath(locator)).click();
			//Thread.sleep(500);
			driver.findElement(By.xpath("//*[text()= '"+dropdownvalue +"']")).click();
			find=false;
			
		}
		else if (find){
			try{
				WebElement webbutton=driver.findElement(By.id(locator));
				webbutton.click();
			}
			catch(Exception e){
				//driver.findElement(By.id(locator)).click();
				e.printStackTrace();
			}
		}
	}
	
	public void dropdown(WebDriver driver, String locator, String dropdownvalue, String dropdownvalue2)
	{
		boolean find=true;
		if(locator.startsWith("//")){
			driver.findElement(By.xpath(locator)).click();
			driver.findElement(By.xpath("//*[text()= '"+dropdownvalue +"']")).click();
			driver.findElement(By.xpath("//*[text()= '"+dropdownvalue2 +"']")).click();
			find=false;
			
		}
		else if (find){
			try{
				WebElement webbutton=driver.findElement(By.id(locator));
				webbutton.click();
			}
			catch(Exception e){
				//driver.findElement(By.id(locator)).click();
				e.printStackTrace();
			}
		}
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		
	}

}
