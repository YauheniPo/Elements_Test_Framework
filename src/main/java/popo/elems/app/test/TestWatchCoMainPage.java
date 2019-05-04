package popo.elems.app.test;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import popo.elems.app.TestGroup;
import popo.elems.app.pages.MainWatchCo;
import popo.elems.app.pages.items.MenuItem;
import popo.elems.framework.base.BaseTest;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;

@Log4j2
public class TestWatchCoMainPage extends BaseTest {

    @Description(value = "Validation of Menu item")
    @Severity(value = SeverityLevel.NORMAL)
    @Test(groups = {TestGroup.MENU})
    public void testHeaderWomenItem() {
        MenuItem topWatchBrandsMainMenuItem = MenuItem.TOP_WATCH_BRANDS_MAIN_MENU_ITEM;

        assertHelper.assertThatTrue(new MainWatchCo().getMenuBar().womenBtn.clickButton().fetchItemOfMenuElement(topWatchBrandsMainMenuItem).isElementExists(),
                String.format("%s does not exist", topWatchBrandsMainMenuItem.getItem()));
    }

    @Description(value = "Validation of Menu item")
    @Severity(value = SeverityLevel.NORMAL)
    @Test(groups = {TestGroup.MENU})
    public void testHeaderMenItem() {
        MenuItem topWatchBrandsMainMenuItem = MenuItem.TOP_WATCH_BRANDS_MAIN_MENU_ITEM;

        assertHelper.assertThatTrue(new MainWatchCo().getMenuBar().menBtn.clickButton().fetchItemOfMenuElement(topWatchBrandsMainMenuItem).isElementExists(),
                String.format("%s does not exist", topWatchBrandsMainMenuItem.getItem()));
    }

    @Description(value = "Validation of Menu item")
    @Severity(value = SeverityLevel.NORMAL)
    @Test(groups = {TestGroup.MENU})
    public void testHeaderSaleItemElem() {
        MenuItem allMenuItem = MenuItem.ALL;

        assertHelper.assertThatTrue(new MainWatchCo().getMenuBar().saleBtn.clickButton().fetchItemOfMenuElement(allMenuItem).isElementExists(),
                String.format("%s does not exist", allMenuItem.getItem()));
    }
}
