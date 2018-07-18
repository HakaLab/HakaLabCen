package cl.cencosud.publicsite.automation.poc.business.flow;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.PageFactory;

import cl.cencosud.publicsite.automation.constants.Constants;
import cl.cencosud.publicsite.automation.poc.model.CompraSingleton;
import cl.cencosud.publicsite.automation.poc.model.PageComponentCart;
import cl.cencosud.publicsite.automation.poc.model.PageComponentFooter;
import cl.cencosud.publicsite.automation.poc.model.PageComponentHeader;
import cl.cencosud.publicsite.automation.poc.model.PageComponentMiniCart;
import cl.cencosud.publicsite.automation.poc.model.PageComponentPdp;
import cl.cencosud.publicsite.automation.poc.model.PageModelHome;
import cl.cencosud.publicsite.automation.poc.util.ManagementMicrosoftService;
import cl.cencosud.publicsite.automation.poc.util.PSCException;

@RunWith(Suite.class)
@SuiteClasses({})
public class BaseFlow {
	private static final Log log = LogFactory.getLog(BaseFlow.class);
	public static WebDriver driver;
	public static SessionId session;
	public static PageModelHome pageModel;
	public static PageComponentCart pageComponentCart;
	public static PageComponentHeader componentHeader;
	public static PageComponentFooter componentFooter;
	public static PageComponentMiniCart componentMiniCart;
	public static PageComponentPdp componentPdp;
	public static CompraSingleton SingletonCompra;
	
	static DesiredCapabilities caps = null;
	public static final String USERNAME = "hugoHaka";
	public static final String ACCESS_KEY = "cf258cd2-347e-4954-afea-0f3864b4ec4b";
	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
	
	
	@BeforeClass
	public static void InitializeWebDriver() throws Exception {
		
//		if (null != System.getenv("navegador")) {
//			capabilityBrowser(System.getenv("navegador"));
//			capabilityBrowser("chrome");
//		}else {
			setDriverDesa();
//		}
//		driver = new RemoteWebDriver(new URL(URL), caps);
//		CreateFileExcel.createFileExcel("UsuarioGuest_", "Guest_");
		ManagementMicrosoftService.createNewFileExcel();
	    pageModel = PageFactory.initElements(driver, PageModelHome.class);
	    SingletonCompra = PageFactory.initElements(driver, CompraSingleton.class);
	    componentMiniCart = PageFactory.initElements(driver, PageComponentMiniCart.class);
	    componentPdp = PageFactory.initElements(driver, PageComponentPdp.class);
	    
	    
	  //pageComponentCart = PageFactory.initElements(driver,PageComponentCart.class);
	}

	@AfterClass
	public static void setUpFinal() throws Exception {
//		driver.quit();
	}

	public static void setDriver() throws MalformedURLException {
//switch (Constants.Browser) {
//		case "chrome":
//			System.setProperty("webdriver.chrome.driver",  Constants.chromeDriver);
//			break;
//		case "iExplorer":
//			caps = DesiredCapabilities.internetExplorer();
//			caps.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
//			caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
//			caps.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, true);
//			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//		}
//		caps.setJavascriptEnabled(true);
//		caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//		driver = new RemoteWebDriver(new java.net.URL(URL), caps);
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		
//		DesiredCapabilities capability = null;
//		capability = DesiredCapabilities.chrome();
//		driver = new RemoteWebDriver(new URL(System.getenv("SELENIUM_SERVER_URL")), capability);
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);

	}

	public static void setDriverDesa() throws Exception {
		switch (Constants.Browser) {
		
		case "chrome":
			System.setProperty("webdriver.chrome.driver",  Constants.chromeDriver);
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.navigate().to("https://storefront:cen_2018@dev10-na01-cencosud.demandware.net/s/Paris/home");
			break;
		
		case "iExplorer":
			System.setProperty("webdriver.ie.driver", Constants.iExplorerDriver);
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();    
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);    
			driver = new InternetExplorerDriver(caps);
			driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			Runtime.getRuntime().exec("C:\\Users\\rcesp\\Documents\\GitHub\\Auto-Genesis_Web\\cencosud_test\\WebDriver\\WebDriver\\IExplorer\\Windows\\aut.exe");
			driver.get("https://dev10-na01-cencosud.demandware.net/s/Paris/home");
			break;
		
		}
		
	}
	
	
	public static Capabilities capabilityBrowser(String dispositivo) {
		switch (dispositivo) {
		case "firefox":
			caps = DesiredCapabilities.firefox();
			caps.setCapability("platform", "Windows 10");
			caps.setCapability("version", "61.0");
			break;
		case "chrome":
			caps = DesiredCapabilities.chrome();
			caps.setCapability("platform", "Windows 10");
			caps.setCapability("version", "67.0");
			break;
		case "iExplore":
			caps = DesiredCapabilities.internetExplorer();
			caps.setCapability("platform", "Windows 10");
			caps.setCapability("version", "11.103");
		break;
		}

		return caps;

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
