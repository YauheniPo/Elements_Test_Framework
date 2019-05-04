package popo.elems.framework.base.elements;

import popo.elems.framework.base.BasePage;

public class Link<L extends BasePage, T extends BasePage> extends WebElement {

    private T targetPage;

    public Link(L landingPage, T targetPage) {
        super(landingPage);
        this.targetPage = targetPage;
    }

    public T clickLink() {
        clickElement(super.xPath);
        return targetPage;
    }
}
