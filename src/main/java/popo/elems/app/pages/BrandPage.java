package popo.elems.app.pages;

import popo.elems.app.elements.ProductsPanel;
import popo.elems.app.pages.locators.WatchBrandLocators;
import popo.elems.framework.base.BasePage;
import popo.elems.framework.base.elements.annotation.Element;

public class BrandPage extends BasePage implements WatchBrandLocators {

    public final SortingPanel<BrandPage> sortingPanel = new SortingPanel<>(this);

    @Element(хPath = PRODUCTS_PANEL)
    public final ProductsPanel<BrandPage, ItemPage> productsPanel = new ProductsPanel<>(this, new ItemPage());

    public BrandPage() {
        super();
        initElements();
    }
}
