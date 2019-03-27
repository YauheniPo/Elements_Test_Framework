package popo.elems.app.test;

import lombok.extern.log4j.Log4j2;

import org.testng.annotations.Test;
import popo.elems.app.pages.MainWatchCo;
import popo.elems.app.pages.SortingPanel;
import popo.elems.app.pages.BrandPage;
import popo.elems.app.pages.items.MenuItem;
import popo.elems.app.pages.items.SortingItem;
import popo.elems.framework.base.BaseTest;

@Log4j2
public class TestWatchCoBrandSortingPage extends BaseTest {

    @Test(groups = {"sorting", "watch", "menu"})
    public void testSortingWatchBrandItem() {
        final MenuItem watchItem = MenuItem.LUMINOX;
        final SortingItem sortingItem = SortingItem.ANALOG;

        MainWatchCo mainWatchCo = new MainWatchCo();
        SortingPanel<BrandPage> sortingPanel = mainWatchCo.menuBar.menBtn.clickButton().fetchItemOfMenuElement(watchItem).clickButton().sortingPanel;
        int count = sortingPanel.getSortingItemsCount(sortingItem);
        BrandPage brandPage = sortingPanel.switchSortingItem(sortingItem).finishSorting();
        int actualCount = brandPage.productsPanel.getCountWatches();

        assertHelper.assertThatTrue(actualCount == count,
                String.format("Sorting count of watches %s does not match %d, exists %d watch(es)", watchItem.getItem(), count, actualCount));
    }
}
