package popo.elems.framework.base.elements;

import io.qameta.allure.Step;
import popo.elems.framework.base.BasePage;

public class Button<L extends BasePage, T extends BasePage> extends WebElement {

    private T targetPage;

    public Button(L landingPage, T targetPage) {
        super(landingPage);
        this.targetPage = targetPage;
    }

    @Step
    public T clickButton() {
        clickElement();
        return this.targetPage;
    }

    public Button<L, T> setXPathPart(String xPathPart) {
        this.xPathPart = xPathPart;
        return this;
    }
}
