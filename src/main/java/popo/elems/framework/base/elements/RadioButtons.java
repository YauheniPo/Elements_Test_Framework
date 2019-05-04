package popo.elems.framework.base.elements;

import popo.elems.framework.base.BasePage;

public class RadioButtons<L extends BasePage> extends WebElement {

    public RadioButtons(L landingPage) {
        super(landingPage);
    }

    public L selectRadioOption() {
        clickElement(super.xPath);
        return (L) super.landingPage;
    }
}
