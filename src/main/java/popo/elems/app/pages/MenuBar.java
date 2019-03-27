package popo.elems.app.pages;

import popo.elems.app.pages.items.MenuItem;
import popo.elems.app.pages.locators.MenuBarLocators;
import popo.elems.framework.base.BasePage;
import popo.elems.framework.base.elements.Button;
import popo.elems.framework.base.elements.annotation.Element;

public class MenuBar extends BasePage implements MenuBarLocators {

    @Element(хPath = SALE_BTN_LOCATOR)
    public final Button<MenuBar, MenuBar> saleBtn = new Button<>(this, this);
    @Element(хPath = MEN_BTN_LOCATOR)
    public final Button<MenuBar, MenuBar> menBtn = new Button<>(this, this);
    @Element(хPath = WOMEN_BTN_LOCATOR)
    public final Button<MenuBar, MenuBar> womenBtn = new Button<>(this, this);
    @Element(хPath = ITEM_MENU_CATEGORY_BTN_LOCATOR)
    public final Button<MenuBar, BrandPage> itemWatchBtn = new Button<>(this, new BrandPage());

    public MenuBar() {
        super();
        initElements();
    }

    public Button<MenuBar, BrandPage> fetchItemOfMenuElement(MenuItem item) {
        return (Button<MenuBar, BrandPage>) itemWatchBtn.setXPathPart(item.getItem());
    }
}
