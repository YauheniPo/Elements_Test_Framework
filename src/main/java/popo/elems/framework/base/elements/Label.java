package popo.elems.framework.base.elements;

import popo.elems.framework.base.BasePage;

public class Label<L extends BasePage> extends Element {

    public Label(L landingPage) {
        super(landingPage);
    }

    public L containsText(String text) {
        //logic
        return (L) super.landingPage;
    }

}
