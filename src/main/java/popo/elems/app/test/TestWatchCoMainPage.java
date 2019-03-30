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
        MenuItem topWatchBrandsMainMenuItem = MenuItem.TOP_WATCH_BRANDS_MAIN_MENU_ITEM;

        assertHelper.assertThatTrue(new MainWatchCo().getMenuBar().womenBtn.clickButton().fetchItemOfMenuElement(topWatchBrandsMainMenuItem).isElementExists(),
                String.format("%s does not exist", topWatchBrandsMainMenuItem.getItem()));
    }

    @Test(groups = {"menu"})
    public void testHeaderMenItem() {
        MenuItem topWatchBrandsMainMenuItem = MenuItem.TOP_WATCH_BRANDS_MAIN_MENU_ITEM;

        assertHelper.assertThatTrue(new MainWatchCo().getMenuBar().menBtn.clickButton().fetchItemOfMenuElement(topWatchBrandsMainMenuItem).isElementExists(),
                String.format("%s does not exist", topWatchBrandsMainMenuItem.getItem()));
    }

    @Test(groups = {"menu", "test"})
    public void testHeaderSaleItemElem() {
        MenuItem allMenuItem = MenuItem.ALL;

        assertHelper.assertThatTrue(new MainWatchCo().getMenuBar().saleBtn.clickButton().fetchItemOfMenuElement(allMenuItem).isElementExists(),
                String.format("%s does not exist", allMenuItem.getItem()));
    }
}
