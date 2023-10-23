package kulibin_tests;

import configuration.CreateDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import pages.BolgarkiPage;
import pages.HomePage;
import pages.PerforatoryPage;

import static configuration.Configuration.CLEAR_COOKIES_AND_STORAGE;
import static configuration.Configuration.HOLD_BROWSER_OPEN;
import static configuration.Constants.KULIBIN_COM_UA;

public class BaseTest {
    protected WebDriver driver = CreateDriver.createDriver();

    protected BasePage basePage = new BasePage(driver);
    protected HomePage homePage = new HomePage(driver);
    protected PerforatoryPage perforatoryPage = new PerforatoryPage(driver);
    protected BolgarkiPage bolgarkiPage = new BolgarkiPage(driver);

    @BeforeMethod
    public void openUrl() {
        basePage.open(KULIBIN_COM_UA);
        homePage.clickWebElement(homePage.getUkraineLanguageButton());
        homePage.moveWebElement(homePage.getElectricToolField());
    }

    @AfterMethod
    public void clearCookiesAndLocalStorage() {
        if (CLEAR_COOKIES_AND_STORAGE) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterSuite
    public void close() {
        if (HOLD_BROWSER_OPEN) {
            driver.quit();
        }
    }
}
