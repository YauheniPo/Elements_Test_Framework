package popo.elems.app.elements;

import popo.elems.framework.base.BasePage;
import popo.elems.framework.base.elements.Element;
import popo.elems.framework.helpers.Locators;

public class ProductsPanel<L extends BasePage, T extends BasePage> extends Element {

    private T targetPage;

    public ProductsPanel(L landingPage, T targetPage) {
        super(landingPage);
        this.targetPage = targetPage;
    }

    public int getCountWatches() {
        return fetchElement().getSelenideElement().findAll(Locators.getByXpath(".//li")).size();
    }
}
