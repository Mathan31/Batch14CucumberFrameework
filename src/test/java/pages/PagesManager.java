package pages;

import org.openqa.selenium.WebDriver;

public class PagesManager {
	
	private WebDriver driver;
	private EbayHome ebayHome;
	private AmazonHome amazonHome;
	
	public PagesManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public EbayHome getEbayPage() {
		if(ebayHome == null) {
			ebayHome = new EbayHome(driver);
		}
		return ebayHome;
	}
	
	public AmazonHome getAmazonPage() {
		if(amazonHome == null) {
			amazonHome = new AmazonHome(driver);
		}
		return amazonHome;
	}
}
