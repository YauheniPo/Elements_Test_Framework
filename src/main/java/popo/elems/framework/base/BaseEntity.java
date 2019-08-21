package popo.elems.framework.base;

import com.codeborne.selenide.testng.BrowserPerClass;
import com.codeborne.selenide.testng.BrowserPerTest;
import com.codeborne.selenide.testng.ScreenShooter;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.SkipException;
import org.testng.annotations.*;
import popo.elems.framework.driver.Browser;
import popo.elems.framework.helpers.config.TestFrameworkConfig;
import popo.elems.framework.helpers.listener.TestListener;
import popo.elems.framework.util.NetworkHelper;
import popo.elems.framework.util.OSValidator;

import java.lang.reflect.Method;

import static popo.elems.framework.Constants.LOGGER_THREAD_CONTEXT;

@Log4j2
@Listeners({TestListener.class, ScreenShooter.class, BrowserPerTest.class, BrowserPerClass.class})
@ContextConfiguration(classes = TestFrameworkConfig.class)
public class BaseEntity extends AbstractTestNGSpringContextTests {

    @Autowired
    private String url;

    @BeforeSuite
    public void beforeSuite() {
        ThreadContext.put(LOGGER_THREAD_CONTEXT, "");
        log.info(String.format("---------------- %s ----------------", OSValidator.OS));
        try {
            super.springTestContextPrepareTestInstance();
        } catch (Exception e) {
            log.fatal(e);
            e.printStackTrace();
        }

        if (!NetworkHelper.netIsAvailable(url)) {
            String massageSkipTests = "Skipping tests because resource was not available.";
            log.info(massageSkipTests);
            throw new SkipException(massageSkipTests);
        }
    }

    @BeforeMethod
    public void before(Method m) {
        ThreadContext.put(LOGGER_THREAD_CONTEXT, m.getName() + "-" + Thread.currentThread().getId());
    }

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void beforeTest(@Optional(value = "default") String browserName) {
        try {
            Browser.getInstance();
            Browser.openStartPage(browserName);
        } catch (Throwable throwable) {
            log.fatal(ExceptionUtils.getStackTrace(throwable));
        }
    }

    protected RemoteWebDriver getWebDriver() {
        return Browser.getDriver();
    }
}
