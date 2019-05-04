package popo.elems.framework.base.elements;

import popo.elems.framework.base.BasePage;

public class Label<L extends BasePage> extends WebElement {

    public Label(L landingPage) {
        super(landingPage);
    }
}
