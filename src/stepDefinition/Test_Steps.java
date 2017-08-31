package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test_Steps {

	private static WebDriver driver = null;

	public Test_Steps() {
		// TODO Auto-generated constructor stub
	}

	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {

		// Write code here that turns the phrase above into concrete actions
		// Create a new instance of the Firefox driver.
		String OSNAME = System.getProperty("os.name").toLowerCase();
		String PATH = System.getProperty("user.dir");

		if (OSNAME.contains("windows")) {
			System.setProperty("webdriver.gecko.driver", PATH + "/drivers/windows32/geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", PATH + "/drivers/linux32/geckodriver");
		}
		driver = new FirefoxDriver();

		// Put a Implicit wait, this means that any search for elements on the
		// page could take the time the implicit wait is set for before throwing
		// exception

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Launch the Online Store Website

		driver.get("http://www.store.demoqa.com");
	}

	@When("^User Navigate to LogIn Page$")
	public void user_Navigate_to_LogIn_Page() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='account']/a")).click();
	}

	@When("^User enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_UserName_and_Password(String username, String password) throws Throwable {
		driver.findElement(By.id("log")).sendKeys(username); //("go1234")
	    driver.findElement(By.id("pwd")).sendKeys(password); //("Hello123$");
	    driver.findElement(By.id("login")).click();
	}

	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() throws Throwable {
		System.out.println("Login Successfully");
	}

	@When("^User LogOut from the Application$")
	public void user_LogOut_from_the_Application() throws Throwable {
		driver.findElement (By.xpath(".//*[@id='account_logout']/a")).click();
	}

	@Then("^Message displayed LogOut Successfully$")
	public void message_displayed_LogOut_Successfully() throws Throwable {
		System.out.println("LogOut Successfully");
	}
}
