package xyz.scropy.cryptoannouncement.component;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.function.Supplier;

public abstract class BaseComponent {

    private final WebDriver driver;

    public BaseComponent(WebDriver driver) {
        this.driver = driver;
    }
    protected String getURL() {
        return driver.getCurrentUrl();
    }

    protected WebElement findElement(By locator) throws TimeoutException {
        return driver.findElement(locator);
    }

    protected List<WebElement> findElements(By locator) throws TimeoutException {
        return driver.findElements(locator);
    }

    protected void type(By locator, String text) {
        findElement(locator).sendKeys(text);
    }

    protected void click(By locator) {
        findElement(locator).click();
    }

}
