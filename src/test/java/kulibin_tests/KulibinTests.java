package kulibin_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class KulibinTests extends BaseTest {
    @Test
    public void checkThatPerforatorHasDiscount_2() {
        homePage.clickWebElement(homePage.getPerforatoryField());
        Assert.assertEquals(perforatoryPage.perforatorDiscount().getAttribute("class"), "old-price");
    }

    @Test
    public void bolgarkiWithCreditIconOnFirstThreePagesTest_3() {
        homePage.clickWebElement(homePage.getBolgarkiField());
        bolgarkiPage.listBolgarokWithCreditIcon();
    }
}

