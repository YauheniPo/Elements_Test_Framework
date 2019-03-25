package popo.elems.framework.base.elements;

import popo.elems.framework.base.BasePage;

public class G2RadioButtons<L extends BasePage> extends G2Element {

    public G2RadioButtons(L landingPage) {
        super(landingPage);
    }

    public L selectRadioOption() {
        clickElement(super.xPath);
        return (L) super.landingPage;
    }

    public L validateRadioOptionSelected(String option, boolean check) {
        //logic
        return (L) super.landingPage;
    }
}
