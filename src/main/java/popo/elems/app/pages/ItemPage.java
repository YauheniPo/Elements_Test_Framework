package popo.elems.app.pages;

import popo.elems.app.pages.locators.BrandItemLocators;
import popo.elems.framework.base.elements.Label;
import popo.elems.framework.base.elements.annotation.IElement;

public class ItemPage extends MainWatchCo implements BrandItemLocators {

    @IElement(xPath = PRODUCT_LABEL_LOCATOR)
    public final Label<ItemPage> productLbl = new Label<>(this);

    public ItemPage() {
        initElements();
    }
}
