package support;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import pages.Homepage;


public class Master {
	String projectPath = System.getProperty("user.dir");
	public static Properties p = new Properties();
	public static Homepage homePage;
	public static WebDriver driver;
	
	
	public void initialise() throws IOException {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(projectPath + "/Config/config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		p.load(fis);

		//BrowserCreation
		driver=new BrowserCreation().startBrowser(p.getProperty("browser"));
		Master.homePage = new Homepage(driver);
	}

	public void closeBrowser(){
		driver.close();
	}

}
