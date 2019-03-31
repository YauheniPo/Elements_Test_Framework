package popo.elems.app.elements;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import popo.elems.app.pages.items.SortingItem;
import popo.elems.framework.base.BasePage;
import popo.elems.framework.base.elements.Element;
import popo.elems.framework.helpers.Locators;
import popo.elems.framework.helpers.Waiters;

import static com.codeborne.selenide.Condition.text;
import static popo.elems.app.Constants.REG_EXP_NUMBER_BETWEEN_BRACKETS;

@Log4j2
public class SortingPanel<L extends BasePage> extends Element {

    @Getter private L landingPage;
    private final By bySortedCase = Locators.getByXpath("//div[@class='currently']");

    public SortingPanel(L landingPage) {
        super(landingPage);
        this.landingPage = landingPage;
    }

    public SortingPanel<L> switchSortingItem(SortingItem item) {
        fetchElement().getSelenideElement().find(Locators.getByWithText(item.getSortingItem())).click();
        fetchElement().getSelenideElement().find(bySortedCase).waitUntil(text(item.getSortingItem()), Waiters.EXIST_TIMEOUT);
        return this;
    }

    public int getSortingItemsCount(SortingItem item) {
        String count = fetchElement().getSelenideElement().find(Locators.getByWithText(item.getSortingItem())).parent().getText();
        return Integer.parseInt(count.replaceAll(REG_EXP_NUMBER_BETWEEN_BRACKETS, ""));
    }
}