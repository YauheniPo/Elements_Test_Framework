package popo.elems.framework.base.elements;

import popo.elems.framework.base.BasePage;

public class G2Link<L extends BasePage, T extends BasePage> extends G2Element {

    private T targetPage;

    public G2Link(L landingPage, T targetPage) {
        super(landingPage);
        this.targetPage = targetPage;
    }

    public T clickLink() {
        clickElement(super.xPath);
        return targetPage;
    }
}
