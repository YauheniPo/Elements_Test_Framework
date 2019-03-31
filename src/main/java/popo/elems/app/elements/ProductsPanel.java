package popo.elems.app.elements;

import lombok.Getter;
import org.openqa.selenium.By;
import popo.elems.framework.base.BasePage;
import popo.elems.framework.base.elements.Element;
import popo.elems.framework.helpers.Locators;

public class ProductsPanel<L extends BasePage, T extends BasePage> extends Element {

    @Getter private L landingPage;
    @Getter private T targetPage;
    private final By byItems = Locators.getByXpath(".//li");
    private final By byFirstItem = Locators.getByClassName("item-area");
    private final By byFirstItemTitle = Locators.getByClassName("product-name");

    public ProductsPanel(L landingPage, T targetPage) {
        super(landingPage);
        this.landingPage = landingPage;
        this.targetPage = targetPage;
    }

    public int getCountItems() {
        return fetchElement().getSelenideElement().findAll(byItems).size();
    }

    public T clickFirstItem() {
        fetchElement().getSelenideElement().findAll(byFirstItem).get(0).click();
        return this.targetPage;
    }

    public String getTitleFirstItem() {
        return fetchElement().getSelenideElement().findAll(byFirstItemTitle).get(0).getText();
    }
}
