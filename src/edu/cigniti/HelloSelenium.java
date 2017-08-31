/**
 * 
 */
package edu.cigniti;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author E003903
 *
 */
public class HelloSelenium {

	/**
	 * 
	 */
	public HelloSelenium() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String OSNAME = System.getProperty("os.name").toLowerCase();
		String PATH = System.getProperty("user.dir");

		if (OSNAME.contains("windows")) {
			System.setProperty("webdriver.gecko.driver", PATH + "/drivers/windows32/geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", PATH + "/drivers/linux32/geckodriver");
		}
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://google.com");

		WebElement searchbox = driver.findElement(By.xpath("//input[@id='lst-ib']"));

	}

}
