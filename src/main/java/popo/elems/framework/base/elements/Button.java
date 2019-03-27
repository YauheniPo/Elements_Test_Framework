package popo.elems.framework.base.elements;

import lombok.NoArgsConstructor;
import popo.elems.framework.base.BasePage;

@NoArgsConstructor
public class Button<L extends BasePage, T extends BasePage> extends Element {

    private T targetPage;

    public Button(L landingPage, T targetPage) {
        super(landingPage);
        this.targetPage = targetPage;
    }

    public Button(String xPath) {
        super.xPath = xPath;
    }

    public T clickButton() {
        clickElement();
        return this.targetPage;
    }
}
