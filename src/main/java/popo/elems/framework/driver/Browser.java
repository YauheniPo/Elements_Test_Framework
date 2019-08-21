package popo.elems.framework.driver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import popo.elems.framework.util.OSValidator;
import popo.elems.framework.util.ResourcePropertiesManager;

import java.util.Locale;

@Log4j2
public final class Browser {

    private volatile static Browser instance = new Browser();
    private static ResourcePropertiesManager rpStage = new ResourcePropertiesManager("stage.properties");
    private static ResourcePropertiesManager rpBrowser = new ResourcePropertiesManager("browser.properties");
    @Getter private static final String BROWSER_URL = String.format(rpStage.getProperty("url"), rpStage.getProperty("stage"));
    private static final Long IMPLICITLY_WAIT = Long.valueOf(rpBrowser.getProperty("browser.timeout"));
    private static final boolean IS_BROWSER_HEADLESS = Boolean.valueOf(rpBrowser.getProperty("browser.headless"));
    private static BrowserType currentBrowser = BrowserType.valueOf((System.getenv("browser") == null
            ? rpBrowser.getProperty("browser") : System.getenv("browser")).toUpperCase(Locale.ENGLISH));
    public static final Long EXIST_LOADING_WAIT = Long.valueOf(rpBrowser.getProperty("browser.existtimeout"));

    public static void getInstance() {
        if (instance == null) {
            synchronized (Browser.class) {
                instance = new Browser();
            }
        }
    }

    private static synchronized void setBrowser(String browserName) {
        if (!BrowserType.valueOf(browserName).equals(BrowserType.DEFAULT)) {
            currentBrowser = BrowserType.valueOf(browserName);
        }
        fetchNewDriver();
    }

    private static void fetchNewDriver() {
        setBrowserSettings();
        log.info(String.format("*************** %s ***************", getDriver().getCapabilities().getBrowserName()).toUpperCase(Locale.ENGLISH));
    }

    private static void setBrowserSettings() {
        Configuration.timeout = IMPLICITLY_WAIT;
        Configuration.headless = IS_BROWSER_HEADLESS;
        Configuration.baseUrl = BROWSER_URL;
        Configuration.startMaximized = true;
        DriverFactory.setUp(currentBrowser);
    }

    private static void windowMaximize() {
        WebDriver.Window window = getDriver().manage().window();
        if (OSValidator.isUnix()) {
            window.setSize(new Dimension(1920, 1080));
        } else if (OSValidator.isWindows()) {
            window.maximize();
        }
    }

    public static void openStartPage(String browserName) {
        setBrowser(browserName.toUpperCase(Locale.ENGLISH));
        Selenide.open("/");
        windowMaximize();
    }

    public static void refreshPage() {
        Selenide.refresh();
    }

    public static RemoteWebDriver getDriver() {
        return (RemoteWebDriver) WebDriverRunner.getAndCheckWebDriver();
    }

    @AllArgsConstructor()
    public enum BrowserType {
        FIREFOX("firefox"),
        CHROME("chrome"),
        EDGE("edge"),
        IE("ie"), //Open Internet Explorer browser. Go to menu View -> Zoom -> Select 100% & Settings -> Security -> Lower & uncheck checkbox,
        DEFAULT("default");

        @Getter
        private final String value;
    }
}
