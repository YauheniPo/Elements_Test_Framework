package popo.elems.app.test;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import popo.elems.app.pages.BrandPage;
import popo.elems.app.pages.HeaderContainer;
import popo.elems.app.pages.MainWatchCo;
import popo.elems.app.pages.items.MenuItem;
import popo.elems.framework.base.BaseTest;

@Log4j2
public class TestWatchCoOrders extends BaseTest {

    @Test(groups = {"item", "brand", "cart"})
    public void testWatchBrandItemCartPageProceedToCheckoutBtnIsExist() {
        final MenuItem skagenWatch = MenuItem.SKAGEN;

        boolean continueShoppingBtnIsExist = ((BrandPage) new MainWatchCo().getMenuBar().menBtn.clickButton()
                .fetchItemOfMenuElement(skagenWatch).clickButton()).productsPanel.clickFirstItem().addToCartBtn.clickButton()
                .proceedToCheckoutBtn.isElementExists();

        assertHelper.assertThatTrue(continueShoppingBtnIsExist,
                "Continue Shopping Button in Cart Page does not exist");
    }

    @Test(groups = {"item", "brand", "cart", "order"})
    public void testWatchBrandItemOrderCartIn() {
        final MenuItem citizenWatch = MenuItem.CITIZEN;

        boolean itemIsInMiniCart = ((HeaderContainer)((BrandPage) new MainWatchCo().getMenuBar().womenBtn.clickButton()
                .fetchItemOfMenuElement(citizenWatch).clickButton()).productsPanel.clickFirstItem().addToCartBtn.clickButton()
                .continueShoppingBtn.clickButton().getHeaderContainer().miniCartIcon
                .hover()
                .getLandingPage()).miniCartItem.isElementExists();

        assertHelper.assertThatTrue(itemIsInMiniCart,
                "Item does not exist in the Mini Cart");
    }
}
