package popo.elems.app.pages;

import io.qameta.allure.Step;
import popo.elems.app.pages.locators.BrandItemLocators;
import popo.elems.framework.base.elements.Button;
import popo.elems.framework.base.elements.Label;
import popo.elems.framework.base.elements.annotation.IElement;

import static popo.elems.app.Constants.REG_EXP_NUMBERS;

public class ItemPage extends MainWatchCo implements BrandItemLocators {

    @IElement(xPath = PRODUCT_LABEL_LOCATOR)
    public final Label<ItemPage> productLbl = new Label<>(this);
    @IElement(xPath = PRICE_LABEL_LOCATOR)
    public final Label<ItemPage> priceLbl = new Label<>(this);
    @IElement(xPath = ADD_TO_CART_BTN_LOCATOR)
    public final Button<ItemPage, CartPage> addToCartBtn = new Button<>(this, new CartPage());

    public ItemPage() {
        initElements();
    }

    @Step
    public String getPriceCurrency() {
        return this.priceLbl.getText().replaceAll(REG_EXP_NUMBERS, "");
    }
}
