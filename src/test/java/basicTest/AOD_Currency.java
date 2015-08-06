package basicTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import basic.Basic_Functional;

public class AOD_Currency {

	
	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException, InvalidFormatException {
		// TODO Auto-generated method stub
		
		Basic_Functional bf= new Basic_Functional();
		bf.loadProperties("AOD_login");
		WebDriver driver=bf.getURL();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		Workbook workbook;
		Sheet sheet;
		workbook= WorkbookFactory.create(new FileInputStream("src/test/resources/Currency.xls") );
		sheet = workbook.getSheetAt(0);
		bf.textBox(driver, bf.getProperties("Email"), "vamshi.nookala@valuelabs.net");
		bf.Checkbox(driver, bf.getProperties("haspassword"));
		bf.textBox(driver, bf.getProperties("password"), "Alpha$555");
		bf.button(driver, bf.getProperties("login"));
		Thread.sleep(10000);
	
		/*String s = driver.findElement(By.xpath("//*[@id='quoteCostBreakDown']/h3")).getText();
		String s1[]= s.split(" ", 3);
		System.out.println(s1[2]);*/
		bf.button(driver, bf.getProperties("change"));
		Thread.sleep(4000);
		List <WebElement> ls1 = driver.findElements(By.xpath("//*[@class='ember-view ember-select form-control']/option"));
		System.out.println("In Profile");
		int row=1;
		String URL=driver.getCurrentUrl();
		Select sc= new Select(driver.findElement(By.xpath("//*[@class='ember-view ember-select form-control']")));
		List<WebElement> ls= sc.getOptions();
		for (int i= 3; i <ls.size(); i++)
		{

			try{

				Thread.sleep(5000);
				 sc= new Select(driver.findElement(By.xpath("//*[@class='ember-view ember-select form-control']")));
				sc.selectByIndex(i);
				Row r1= sheet.getRow(1);
				Cell c1= r1.getCell(1);
				//ls1.get(i).getText()
				c1.setCellValue("Mexico");
				driver.findElement(By.xpath("//*[@type='button']")).click();
				Thread.sleep(5000);
				
				String s = driver.findElement(By.xpath("//*[@id='quoteCostBreakDown']/h3")).getText();
				String s2[]= s.split(" ", 3);
				System.out.println(s2[2]);
				Cell c2 = r1.getCell(1);
				c2.setCellValue(s2[2]);
				row++;
				FileOutputStream fileOut = new FileOutputStream("src/test/resources/Currency.xls");
				workbook.write(fileOut);
				fileOut.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			bf.button(driver, bf.getProperties("change"));
		}

		
	}

}
