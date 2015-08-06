package last;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class NewTest {
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
		System.setProperty("webdriver.chrome.driver", "chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
	  //WebDriver driver = new FirefoxDriver();
	  driver.get("https://app2.argusexpress.com/");
	  driver.findElement(By.xpath("//text()='Log'")).click();
	  
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
}
