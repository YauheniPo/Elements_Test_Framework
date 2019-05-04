package popo.elems.app.test;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import popo.elems.app.TestGroup;
import popo.elems.app.pages.BrandPage;
import popo.elems.app.pages.ItemPage;
import popo.elems.app.pages.MainWatchCo;
import popo.elems.app.pages.items.MenuItem;
import popo.elems.framework.base.BaseTest;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;

@Log4j2
public class TestWatchCoBrandItemPage extends BaseTest {

    @Description(value = "Validation of Brand item label")
    @Severity(value = SeverityLevel.NORMAL)
    @Test(groups = {TestGroup.ITEM, TestGroup.BRAND})
    public void testWatchBrandItemLabel() {
        final MenuItem skagenWatch = MenuItem.SKAGEN;

        BrandPage brandPage = (BrandPage) new MainWatchCo().getMenuBar().menBtn.clickButton().fetchItemOfMenuElement(skagenWatch).clickButton();
        String titleItem = brandPage.productsPanel.getTitleFirstItem();
        String labelItem = brandPage.productsPanel.clickFirstItem().productLbl.getText();

        assertHelper.assertThatTrue(titleItem.equals(labelItem),
                String.format("Brand Item label '%s' does not match '%s'", titleItem, labelItem));
    }

    @Description(value = "Validation of Brand item currency")
    @Severity(value = SeverityLevel.NORMAL)
    @Test(groups = {TestGroup.ITEM, TestGroup.BRAND})
    public void testWatchBrandItemCurrency() {
        final MenuItem skagenWatch = MenuItem.SKAGEN;
        final String currency = "$";

        ItemPage itemPage = ((BrandPage) new MainWatchCo().getMenuBar().menBtn.clickButton()
                .fetchItemOfMenuElement(skagenWatch).clickButton()).productsPanel.clickFirstItem();
        String currencyItem = itemPage.getPriceCurrency();

        assertHelper.assertThatTrue(currency.equals(currencyItem),
                String.format("Brand Item currency '%s' does not match '%s'", currencyItem, currency));
    }
}
