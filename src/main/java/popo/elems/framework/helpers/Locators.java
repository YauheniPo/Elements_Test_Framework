package popo.elems.framework.helpers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;

@Log4j2
public class Locators {

    public static By getByText(String locator) {
        log.info(String.format("%s <-- by text", locator));
        return byText(locator);
    }

    public static By getByWithText(String locator) {
        log.info(String.format("%s <-- with text", locator));
        return withText(locator);
    }

    public static By getByClassName(String locator) {
        log.info(String.format("%s <-- by class name", locator));
        return byClassName(locator);
    }

    public static By getByXpath(String locator) {
        log.info(String.format("%s <-- xpath", locator));
        return byXpath(locator);
    }
}
