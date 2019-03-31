package popo.elems.app.test;

import lombok.extern.log4j.Log4j2;

import org.testng.annotations.Test;
import popo.elems.app.pages.MainWatchCo;
import popo.elems.app.pages.BrandPage;
import popo.elems.app.pages.items.MenuItem;
import popo.elems.app.pages.items.SortingItem;
import popo.elems.framework.base.BaseTest;

@Log4j2
public class TestWatchCoBrandSortingPage extends BaseTest {

    @Test(groups = {"sorting", "brand", "menu"})
    public void testSortingWatchBrandItem() {
        final MenuItem luminoxWatch = MenuItem.LUMINOX;
        final SortingItem analogSort = SortingItem.ANALOG;

        BrandPage brandPage = (BrandPage) new MainWatchCo().getMenuBar().menBtn.clickButton().fetchItemOfMenuElement(luminoxWatch).clickButton();
        int count = brandPage.sortingPanel.getSortingItemsCount(analogSort);
        int actualCount = brandPage.sortingPanel.switchSortingItem(analogSort).getLandingPage().productsPanel.getCountItems();

        assertHelper.assertThatTrue(actualCount == count,
                String.format("Sorting count of watches %s does not match %d, exists %d watch(es)", luminoxWatch.getItem(), count, actualCount));
    }
}
