package popo.elems.app.pages;

import lombok.Getter;
import popo.elems.app.pages.locators.HeaderContainerLocators;
import popo.elems.framework.base.BasePage;
import popo.elems.framework.base.elements.Button;
import popo.elems.framework.base.elements.annotation.IElement;

public class HeaderContainer<L extends BasePage> extends BasePage implements HeaderContainerLocators {

    @Getter private L landingPage;

    @IElement(xPath = MINI_CART_ICON)
    public final Button<HeaderContainer, HeaderContainer> miniCartIcon = new Button<>(this, this);
    @IElement(xPath = MINI_CART_ITEM)
    public final Button<HeaderContainer, ItemPage> miniCartItem = new Button<>(this, new ItemPage());

    public HeaderContainer(L landingPage) {
        super(landingPage);
        this.landingPage = landingPage;
        initElements();
    }
}
