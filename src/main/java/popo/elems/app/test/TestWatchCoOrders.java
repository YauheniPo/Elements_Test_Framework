package popo.elems.app.test;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import popo.elems.app.TestGroup;
import popo.elems.app.pages.BrandPage;
import popo.elems.app.pages.HeaderContainer;
import popo.elems.app.pages.MainWatchCo;
import popo.elems.app.pages.items.MenuItem;
import popo.elems.framework.base.BaseTest;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;

@Log4j2
public class TestWatchCoOrders extends BaseTest {

    @Description(value = "Validation of order Checkout button")
    @Severity(value = SeverityLevel.NORMAL)
    @Test(groups = {TestGroup.ITEM, TestGroup.BRAND, TestGroup.CART})
    public void testWatchBrandItemCartPageProceedToCheckoutBtnIsExist() {
        final MenuItem skagenWatch = MenuItem.SKAGEN;

        boolean continueShoppingBtnIsExist = ((BrandPage) new MainWatchCo().getMenuBar().menBtn.clickButton()
                .fetchItemOfMenuElement(skagenWatch).clickButton()).productsPanel.clickFirstItem().addToCartBtn.clickButton()
                .proceedToCheckoutBtn.isElementExists();

        assertHelper.assertThatTrue(continueShoppingBtnIsExist,
                "Continue Shopping Button in Cart Page does not exist");
    }

    @Description(value = "Validation of order in the Cart")
    @Severity(value = SeverityLevel.NORMAL)
    @Test(groups = {TestGroup.ITEM, TestGroup.BRAND, TestGroup.CART, TestGroup.ORDER})
    public void testWatchBrandItemOrderCartIn() {
        final MenuItem citizenWatch = MenuItem.CITIZEN;

        boolean itemIsInMiniCart = ((HeaderContainer)((BrandPage) new MainWatchCo().getMenuBar().womenBtn.clickButton()
                .fetchItemOfMenuElement(citizenWatch).clickButton()).productsPanel.clickFirstItem().addToCartBtn.clickButton()
                .continueShoppingBtn.clickButton().getHeaderContainer().miniCartIcon
                .hover().getLandingPage()).miniCartItem.isElementExists();

        assertHelper.assertThatTrue(itemIsInMiniCart,
                "Item does not exist in the Mini Cart");
    }
}
