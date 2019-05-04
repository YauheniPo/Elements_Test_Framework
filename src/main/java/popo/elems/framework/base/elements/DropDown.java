package popo.elems.framework.base.elements;

import popo.elems.framework.base.BasePage;

public class DropDown<L extends BasePage> extends WebElement {

    public DropDown(L landingPage) {
        super(landingPage);
    }
}