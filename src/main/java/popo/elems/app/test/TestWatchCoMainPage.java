package popo.elems.app.test;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import popo.elems.app.pages.MainWatchCo;
import popo.elems.app.pages.MainWatchCoElem;
import popo.elems.app.pages.items.MenuItem;
import popo.elems.framework.base.BaseTest;

@Log4j2
public class TestWatchCoMainPage extends BaseTest {

    @Test(groups = {"menu"})
    public void testHeaderWomenItem() {
        MenuItem item = MenuItem.TOP_WATCH_BRANDS_MAIN_MENU_ITEM;

        MainWatchCo mainWatchCo = new MainWatchCo();
        mainWatchCo.menuBar.clickWomen();

        assertHelper.assertThatTrue(mainWatchCo.menuBar.isItemExist(item),
                String.format("%s does not exist", item.getItem()));
    }

    @Test(groups = {"menu"})
    public void testHeaderMenItem() {
        MenuItem item = MenuItem.TOP_WATCH_BRANDS_MAIN_MENU_ITEM;

        MainWatchCo mainWatchCo = new MainWatchCo();
        mainWatchCo.menuBar.clickMen();

        assertHelper.assertThatTrue(mainWatchCo.menuBar.isItemExist(item),
                String.format("%s does not exist", item.getItem()));
    }

    @Test(groups = {"menu"})
    public void testHeaderSaleItem() {
        MenuItem item = MenuItem.ALL;

        MainWatchCo mainWatchCo = new MainWatchCo();
        mainWatchCo.menuBar.clickSale();

        assertHelper.assertThatTrue(mainWatchCo.menuBar.isItemExist(item),
                String.format("%s does not exist", item.getItem()));
    }

    @Test(groups = {"elem"})
    public void testHeaderSaleItemElem() {
        MenuItem item = MenuItem.ALL;

        MainWatchCoElem mainWatchCoElem = new MainWatchCoElem();

        assertHelper.assertThatTrue(mainWatchCoElem.menuBarElem.saleBtn.clickButton().fetchItemOfMenuElement(item).isElementExists(),
                String.format("%s does not exist", item.getItem()));
    }
}
