package pages;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

@Getter
public class HomePage extends BasePage {
    private final Actions actions = new Actions(driver);

    private final By ukraineLanguageButton = By.xpath("//a[text()='Українська']");
    private final By electricToolField = By.xpath("//a[text()='Електроінструмент']");
    private final By bolgarkiField = By.xpath("(//a[contains(text(),'Болгарки')])[1]");
    private final By perforatoryField = By.xpath("(//a[contains(text(),'Перфоратори')])[1]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void clickWebElement(By element) {
        driver.findElement(element).click();
    }

    @Step
    public void moveWebElement(By element) {
        WebElement webElement = driver.findElement(element);
        actions.moveToElement(webElement).perform();
    }
}


