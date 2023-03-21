package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserBase {
	
	public WebDriver driver;
	public int iBrowserType = 1;
	
	public WebDriver launchChromeBrowser() {
		if(driver == null) {
			switch (iBrowserType) {
			case 1:
				System.out.println("User option is : "+iBrowserType+" ,So invoking Chrome Browser. ");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(options);
				break;
				
			case 2:
				System.out.println("User option is : "+iBrowserType+" ,So invoking FF Browser. ");
				//System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
				break;
				
			case 3:
				System.out.println("User option is : "+iBrowserType+" ,So invoking Edge Browser. ");
				//System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
				driver = new EdgeDriver();
				break;

			default:
				System.out.println("User option is wrong : "+iBrowserType+" ,So invoking the default Chrome Browser. ");
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
				break;
			}
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}

}
