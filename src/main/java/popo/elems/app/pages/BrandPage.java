package popo.elems.app.pages;

import popo.elems.app.elements.ProductsPanel;
import popo.elems.app.elements.SortingPanel;
import popo.elems.app.pages.locators.WatchBrandLocators;
import popo.elems.framework.base.elements.annotation.IElement;

public class BrandPage extends MainWatchCo implements WatchBrandLocators {

    @IElement(xPath = SORTING_PANEL)
    public final SortingPanel<BrandPage> sortingPanel = new SortingPanel<>(this);
    @IElement(xPath = PRODUCTS_PANEL)
    public final ProductsPanel<BrandPage, ItemPage> productsPanel = new ProductsPanel<>(this, new ItemPage());

    public BrandPage() {
        initElements();
    }
}
