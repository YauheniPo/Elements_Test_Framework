package popo.elems.app.test;

import lombok.extern.log4j.Log4j2;

import org.testng.annotations.Test;
import popo.elems.app.TestGroup;
import popo.elems.app.pages.MainWatchCo;
import popo.elems.app.pages.BrandPage;
import popo.elems.app.pages.items.MenuItem;
import popo.elems.app.pages.items.SortingItem;
import popo.elems.framework.base.BaseTest;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;

@Log4j2
public class TestWatchCoBrandSortingPage extends BaseTest {

    @Description(value = "Validation of sorting products")
    @Severity(value = SeverityLevel.NORMAL)
    @Test(groups = {TestGroup.SORTING, TestGroup.BRAND, TestGroup.MENU})
    public void testSortingWatchBrandItem() {
        final MenuItem luminoxWatch = MenuItem.LUMINOX;
        final SortingItem analogSort = SortingItem.ANALOG;

        BrandPage brandPage = (BrandPage) new MainWatchCo().getMenuBar().menBtn.clickButton().fetchItemOfMenuElement(luminoxWatch).clickButton();
        int count = brandPage.sortingPanel.getSortingItemsCount(analogSort);
        int actualCount = ((BrandPage) brandPage.sortingPanel.switchSortingItem(analogSort).getLandingPage()).productsPanel.getCountItems();

        assertHelper.assertThatTrue(actualCount == count,
                String.format("Sorting count of watches %s does not match %d, exists %d watch(es)", luminoxWatch.getItem(), count, actualCount));
    }
}
