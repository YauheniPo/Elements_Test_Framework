package popo.elems.app.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import popo.elems.app.pages.items.MenuItem;
import popo.elems.framework.base.BasePage;
import popo.elems.framework.base.elements.G2Button;
import popo.elems.framework.base.elements.annotation.Element;
import popo.elems.framework.helpers.Locators;

import static com.codeborne.selenide.Selenide.$;

public class MenuBarElem extends BasePage {

//    private final SelenideElement menuBar = $(Locators.get("menubar")).shouldBe(Condition.exist);

    @Element(хPath = "//*[@class='menu']")
    public final G2Button<MenuBarElem, MenuBarElem> saleBtn = new G2Button<>(this, this);
    @Element(хPath = "//*[text()='Men']")
    public final G2Button<MenuBarElem, MenuBarElem> menBtn = new G2Button<>(this, this);
    @Element(хPath = "//*[text()='Women']")
    public final G2Button<MenuBarElem, MenuBarElem> womenBtn = new G2Button<>(this, this);
    @Element(хPath = "//*[text()='%s']")
    public final G2Button<MenuBarElem, WatchBrandPage> itemWatchBtn = new G2Button<>(this, new WatchBrandPage());

    public MenuBarElem() {
        super();
        initElements();
    }

    public G2Button<MenuBarElem, WatchBrandPage> fetchItemOfMenuElement(MenuItem item) {
        return (G2Button<MenuBarElem, WatchBrandPage>) itemWatchBtn.setXPathPart(item.getItem());
    }
}
