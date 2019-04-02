package popo.elems.app.pages;

import popo.elems.app.pages.locators.CartLocators;
import popo.elems.framework.base.elements.Button;
import popo.elems.framework.base.elements.annotation.IElement;

public class CartPage extends MainWatchCo implements CartLocators {

    @IElement(xPath = PROCEED_TO_CHECKOUT_BTN_LOCATOR)
    public final Button<CartPage, CartPage> proceedToCheckoutBtn = new Button<>(this, this);
    @IElement(xPath = CONTINUE_SHOPPING_BTN_LOCATOR)
    public final Button<CartPage, MainWatchCo> continueShoppingBtn = new Button<>(this, new MainWatchCo());

    public CartPage() {
        initElements();
    }
}
