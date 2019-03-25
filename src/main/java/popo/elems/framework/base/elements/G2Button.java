package popo.elems.framework.base.elements;

import lombok.NoArgsConstructor;
import popo.elems.framework.base.BasePage;

@NoArgsConstructor
public class G2Button<L extends BasePage, T extends BasePage> extends G2Element {

    private T targetPage;

    public G2Button(L landingPage, T targetPage) {
        super(landingPage);
        this.targetPage = targetPage;
    }

    public G2Button(String xPath) {
        super.xPath = xPath;
    }

    public T clickButton() {
        clickElement(super.xPath);
        return this.targetPage;
    }
}
