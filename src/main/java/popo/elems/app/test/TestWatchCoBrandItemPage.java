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

    @Test(groups = {"item", "brand", "menu"})
    public void testSortingWatchBrandItem() {
        final MenuItem skagenWatch = MenuItem.SKAGEN;

        BrandPage brandPage = (BrandPage) new MainWatchCo().getMenuBar().menBtn.clickButton().fetchItemOfMenuElement(skagenWatch).clickButton();
        String titleItem = brandPage.productsPanel.getTitleFirstItem();
        ItemPage itemPage = brandPage.productsPanel.clickFirstItem();
        String lableItem = itemPage.productLbl.getText();

        assertHelper.assertThatTrue(titleItem.equals(lableItem),
                String.format("Brand Item label '%s' does not match '%s'", titleItem, lableItem));
    }
}
