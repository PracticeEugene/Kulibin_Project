package pages;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static configuration.Constants.EXPLICIT_WAIT;

@Getter
public class PerforatoryPage extends BasePage {

    private final By lastPagePerforatory = By.xpath("(//li[@data-page]/a)[last()]");
    private final By catalogPerforatory = By.xpath("//ul[@class='catalog catalog-full js-catalog']");
    private final By oldPricePerforatory = By.xpath("//span[@class='old-price']");

    public PerforatoryPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public WebElement perforatorDiscount() {
        WebElement element = null;
        int numberLastPage = Integer.parseInt(driver.findElement(getLastPagePerforatory()).getText());
        try {
            for (int page = 1; page <= numberLastPage; page++) {
                new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOfElementLocated(getCatalogPerforatory()));
                element = driver.findElement(getOldPricePerforatory());
                if (element != null) {
                    break;
                } else {
                    driver.findElement(By.linkText(Integer.toString(page + 1))).click();
                }
            }
        } catch (Exception exception) {
            System.out.println("No discounted tool found." + exception.getMessage());
        }
        return element;
    }
}
