package support;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Env {
	@Before
	public void beforeRun() throws IOException {
		new Master().initialise();
	}

	@After
	public void AfterRun() {
		new Master().closeBrowser();
	}

}
