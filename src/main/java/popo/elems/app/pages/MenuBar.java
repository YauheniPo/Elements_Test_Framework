package popo.elems.app.pages;

import lombok.Getter;
import popo.elems.app.pages.items.MenuItem;
import popo.elems.app.pages.locators.MenuBarLocators;
import popo.elems.framework.base.BasePage;
import popo.elems.framework.base.elements.Button;
import popo.elems.framework.base.elements.annotation.IElement;

public class MenuBar<L extends BasePage> extends BasePage implements MenuBarLocators {

    @Getter private L landingPage;

    @IElement(xPath = SALE_BTN_LOCATOR)
    public final Button<MenuBar, MenuBar> saleBtn = new Button<>(this, this);
    @IElement(xPath = MEN_BTN_LOCATOR)
    public final Button<MenuBar, MenuBar> menBtn = new Button<>(this, this);
    @IElement(xPath = WOMEN_BTN_LOCATOR)
    public final Button<MenuBar, MenuBar> womenBtn = new Button<>(this, this);
    @IElement(xPath = ITEM_MENU_CATEGORY_BTN_LOCATOR)
    public final Button<MenuBar, BrandPage> itemWatchBtn = new Button<>(this, new BrandPage());

    public MenuBar(L landingPage) {
        super(landingPage);
        this.landingPage = landingPage;
        initElements();
    }

    public Button<MenuBar, BrandPage> fetchItemOfMenuElement(MenuItem item) {
        return itemWatchBtn.setXPathPart(item.getItem());
    }
}
