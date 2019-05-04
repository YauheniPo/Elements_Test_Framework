package popo.elems.framework.base.elements;

import popo.elems.framework.base.BasePage;

public class CheckBox<L extends BasePage> extends WebElement {

    public CheckBox(L landingPage) {
        super(landingPage);
    }
}
