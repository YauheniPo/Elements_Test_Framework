package popo.elems.app.elements;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import popo.elems.framework.base.BasePage;
import popo.elems.framework.base.elements.WebElement;
import popo.elems.framework.helpers.Locators;

public class ProductsPanel<L extends BasePage, T extends BasePage> extends WebElement {

    private T targetPage;
    private final By byItems = Locators.getByXpath(".//li");
    private final By byFirstItem = Locators.getByClassName("item-area");
    private final By byFirstItemTitle = Locators.getByClassName("product-name");

    public ProductsPanel(L landingPage, T targetPage) {
        super(landingPage);
        this.targetPage = targetPage;
    }

    @Step
    public int getCountItems() {
        return fetchElement().findAll(byItems).size();
    }

    @Step
    public T clickFirstItem() {
        fetchElement().findAll(byFirstItem).get(0).click();
        return this.targetPage;
    }

    @Step
    public String getTitleFirstItem() {
        return fetchElement().findAll(byFirstItemTitle).get(0).getText();
    }
}
