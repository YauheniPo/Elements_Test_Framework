package popo.elems.app.test;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import popo.elems.app.pages.MainWatchCo;
import popo.elems.app.pages.items.MenuItem;
import popo.elems.framework.base.BaseTest;

@Log4j2
public class TestWatchCoMainPage extends BaseTest {

    @Test(groups = {"menu"})
    public void testHeaderWomenItem() {
        MenuItem item = MenuItem.TOP_WATCH_BRANDS_MAIN_MENU_ITEM;

        assertHelper.assertThatTrue(new MainWatchCo().menuBar.womenBtn.clickButton().fetchItemOfMenuElement(item).isElementExists(),
                String.format("%s does not exist", item.getItem()));
    }

    @Test(groups = {"menu"})
    public void testHeaderMenItem() {
        MenuItem item = MenuItem.TOP_WATCH_BRANDS_MAIN_MENU_ITEM;

        assertHelper.assertThatTrue(new MainWatchCo().menuBar.menBtn.clickButton().fetchItemOfMenuElement(item).isElementExists(),
                String.format("%s does not exist", item.getItem()));
    }

    @Test(groups = {"menu"})
    public void testHeaderSaleItem() {
        MenuItem item = MenuItem.ALL;

        assertHelper.assertThatTrue(new MainWatchCo().menuBar.saleBtn.clickButton().fetchItemOfMenuElement(item).isElementExists(),
                String.format("%s does not exist", item.getItem()));
    }

    @Test(groups = {"menu", "test"})
    public void testHeaderSaleItemElem() {
        MenuItem item = MenuItem.ALL;

        assertHelper.assertThatTrue(new MainWatchCo().menuBar.saleBtn.clickButton().fetchItemOfMenuElement(item).isElementExists(),
                String.format("%s does not exist", item.getItem()));
    }
}
