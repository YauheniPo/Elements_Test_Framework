package popo.elems.app.test;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import popo.elems.app.pages.BrandPage;
import popo.elems.app.pages.ItemPage;
import popo.elems.app.pages.MainWatchCo;
import popo.elems.app.pages.items.MenuItem;
import popo.elems.framework.base.BaseTest;

@Log4j2
public class TestWatchCoBrandItemPage extends BaseTest {

    @Test(groups = {"item", "brand"})
    public void testWatchBrandItemLabel() {
        final MenuItem skagenWatch = MenuItem.SKAGEN;

        BrandPage brandPage = (BrandPage) new MainWatchCo().getMenuBar().menBtn.clickButton().fetchItemOfMenuElement(skagenWatch).clickButton();
        String titleItem = brandPage.productsPanel.getTitleFirstItem();
        String lableItem = brandPage.productsPanel.clickFirstItem().productLbl.getText();

        assertHelper.assertThatTrue(titleItem.equals(lableItem),
                String.format("Brand Item label '%s' does not match '%s'", titleItem, lableItem));
    }

    @Test(groups = {"item", "brand"})
    public void testWatchBrandItemCurrency() {
        final MenuItem skagenWatch = MenuItem.SKAGEN;
        final String currency = "$";

        ItemPage itemPage = ((BrandPage) new MainWatchCo().getMenuBar().menBtn.clickButton()
                .fetchItemOfMenuElement(skagenWatch).clickButton()).productsPanel.clickFirstItem();
        String currencyItem = itemPage.getPriceCurrency();

        assertHelper.assertThatTrue(currency.equals(currencyItem),
                String.format("Brand Item currency '%s' does not match '%s'", currencyItem, currency));
    }

    @Test(groups = {"item", "brand", "cart"})
    public void testWatchBrandItemCartPageProceedToCheckoutBtnIsExist() {
        final MenuItem skagenWatch = MenuItem.SKAGEN;

        boolean continueShoppingBtnIsExist = ((BrandPage) new MainWatchCo().getMenuBar().menBtn.clickButton()
                .fetchItemOfMenuElement(skagenWatch).clickButton()).productsPanel.clickFirstItem().addToCartBtn.clickButton()
                .continueShoppingBtn.isElementExists();

        assertHelper.assertThatTrue(continueShoppingBtnIsExist,
                "Continue Shopping Button in Cart Page does not exist");
    }
}
