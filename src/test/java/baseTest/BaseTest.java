package baseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import pages.LandingPage;
import pages.MyAccountPage;
import pages.elements.HeaderElements;

import java.time.Duration;
public class BaseTest {
    Logger logger = Logger.getLogger(getClass());
    protected WebDriver webDriver;
    protected LandingPage landingPage;
    protected HeaderElements headerElements;
    protected MyAccountPage myAccountPage;

    @Before
    public void setUp(){
        logger.info("----- " + testName.getMethodName() + " -----");
        webDriver = initWebDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        landingPage = new LandingPage(webDriver);
        headerElements = new HeaderElements(webDriver);
        myAccountPage = new MyAccountPage(webDriver);
    }

    @After
    public void closeUp(){
        webDriver.quit();
        logger.info("Browser Is closed");
        logger.info("----- Test " + testName.getMethodName() + " is done.");
    }

    @Rule
    public TestName testName = new TestName();

    protected WebDriver initWebDriver(){
        String browser = System.getProperty("browser");
        if (browser == null || browser.equals("chrome")){
            ChromeOptions ops = new ChromeOptions();
            ops.addArguments("--remote-allow-origins=*");
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver(ops);
        }else if ("firefox".equals(browser)){
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        } else if ("safari".equals(browser)) {
            WebDriverManager.safaridriver().setup();
            webDriver = new SafariDriver();
        } else if ("edge".equals(browser)) {
            WebDriverManager.edgedriver().setup();
            webDriver = new EdgeDriver();
        }
        return webDriver;
    }
}
