package popo.elems.framework.base.elements;

import popo.elems.framework.base.BasePage;

public class InputField<L extends BasePage> extends WebElement {

    public InputField(L landingPage) {
        super(landingPage);
    }
}