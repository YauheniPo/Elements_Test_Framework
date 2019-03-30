package popo.elems.framework.base.elements;

import lombok.NoArgsConstructor;
import popo.elems.framework.base.BasePage;

@NoArgsConstructor
public class Button<L extends BasePage, T extends BasePage> extends Element {

    private L landingPage;
    private T targetPage;

    public Button(L landingPage, T targetPage) {
        super(landingPage);
        this.landingPage = landingPage;
        this.targetPage = targetPage;
    }

    public T clickButton() {
        clickElement();
        return this.targetPage;
    }

    public Button<L, T> setXPathPart(String xPathPart) {
        this.xPathPart = xPathPart;
        return this;
    }
}
