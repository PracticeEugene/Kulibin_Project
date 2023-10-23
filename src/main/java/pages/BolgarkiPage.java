package pages;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static configuration.Constants.EXPLICIT_WAIT;

@Getter
public class BolgarkiPage extends BasePage {

    private final By catalogBolgarky = By.xpath("//ul[@class='catalog catalog-full js-catalog']");
    private final By bolgarkiListWithCreditIcon = By.xpath("//*[@class='info-wrap__credit-opener']/../../..//*[@class='google_detail_link']");

    public BolgarkiPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void listBolgarokWithCreditIcon(){
        List<String> productNames = new ArrayList<>();
        try {
            for (int page = 1; page <= 3; page++) {
                new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOfElementLocated(catalogBolgarky));
                List<WebElement> elements = driver.findElements(bolgarkiListWithCreditIcon);
                for (WebElement e : elements) {
                    String name = e.getAttribute("title");
                    productNames.add(name);
                }
                driver.findElement(By.linkText(Integer.toString(page + 1))).click();
            }
            productNames.forEach(System.out::println);
        } catch (Exception exception) {
            System.out.println("Bolgarki with credit icon isn't found. " + exception.getMessage());
        }
    }
}
