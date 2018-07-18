package cl.cencosud.publicsite.automation.flow;

import cl.cencosud.publicsite.automation.Exception.PSCException;
import cl.cencosud.publicsite.automation.constants.Constants;
import cl.cencosud.publicsite.automation.model.PageModelHome;
import cl.cencosud.publicsite.automation.services.ManagementMicrosoftService;
import cucumber.api.CucumberOptions;
import cucumber.api.Plugin;
import cucumber.runtime.formatter.PluginFactory;
import cucumber.runtime.model.CucumberScenario;
import gherkin.formatter.model.Step;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.mockito.internal.configuration.plugins.Plugins;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.PageFactory;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(Suite.class)
@SuiteClasses({})
public class BaseFlow {
	private static final Log log = LogFactory.getLog(BaseFlow.class);
	public static WebDriver driver;
	 public static SessionId session;
	public static PageModelHome pageModel;
	static DesiredCapabilities caps = null;
	public static final String USERNAME = "hugoHaka";
	public static final String ACCESS_KEY = "cf258cd2-347e-4954-afea-0f3864b4ec4b";
	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

	@BeforeClass
	public static void InitializeWebDriver() throws Exception {
//		if (null != System.getenv("navegador")) {
//			capabilityBrowser( System.getenv("navegador"));
//		}else {
			//driver local
		ManagementMicrosoftService.createNewFileExcel();
		setDriverDesa();
//		}
//		driver = new RemoteWebDriver(new URL(URL), caps);
		// storefront:cen_2018@
		driver.navigate().to("https://storefront:cen_2018@dev10-na01-cencosud.demandware.net/s/Paris/home");
		pageModel = PageFactory.initElements(driver, PageModelHome.class);
	}
	
	public static Capabilities capabilityBrowser(String dispositivo) {
		switch (dispositivo) {
		case "firefox":
			caps = DesiredCapabilities.firefox();
			caps.setCapability("platform", "Windows 10");
			caps.setCapability("version", "60.0");
			break;
		case "chrome":
			caps = DesiredCapabilities.chrome();
			caps.setCapability("platform", "Windows 10");
			caps.setCapability("version", "67.0");
			break;
		}
		return caps;
	}

	@AfterClass
	public static void setUpFinal() throws Exception {
//		driver.quit();
	}

	public static void setDriver() throws MalformedURLException {
//		DesiredCapabilities capability = null;
//		capability = DesiredCapabilities.chrome();
//		driver = new RemoteWebDriver(new URL(System.getenv("SELENIUM_SERVER_URL")), capability);
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
	}

	public static void setDriverDesa() throws Exception {
		System.setProperty("webdriver.chrome.driver",  Constants.chromeDriver);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public static Boolean isActiveSessionDriver() throws Exception {
		session =  ((RemoteWebDriver) driver).getSessionId();
		try {
			if(session==null) {
				throw new PSCException("Session de driver web finalizada");
			}else {
				return true;
			}
		} catch (PSCException e) {
			throw e;
		}catch (Exception e) {
			log.error(e,e);
			throw e;
		}
	}
}
