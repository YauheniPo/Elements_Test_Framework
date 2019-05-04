package popo.elems.app.elements;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import popo.elems.app.pages.items.SortingItem;
import popo.elems.framework.base.BasePage;
import popo.elems.framework.base.elements.WebElement;
import popo.elems.framework.driver.Browser;
import popo.elems.framework.helpers.Locators;

import static com.codeborne.selenide.Condition.text;
import static popo.elems.app.Constants.REG_EXP_NUMBER_BETWEEN_BRACKETS;

@Log4j2
public class SortingPanel<L extends BasePage> extends WebElement {

    private final By bySortedCase = Locators.getByXpath("//div[@class='currently']");

    public SortingPanel(L landingPage) {
        super(landingPage);
    }

    @Step
    public SortingPanel<L> switchSortingItem(SortingItem item) {
        fetchElement().find(Locators.getByWithText(item.getSortingItem())).click();
        fetchElement().find(bySortedCase).waitUntil(text(item.getSortingItem()), Browser.EXIST_LOADING_WAIT);
        return this;
    }

    @Step
    public int getSortingItemsCount(SortingItem item) {
        String count = fetchElement().find(Locators.getByWithText(item.getSortingItem())).parent().getText();
        return Integer.parseInt(count.replaceAll(REG_EXP_NUMBER_BETWEEN_BRACKETS, ""));
    }
}
