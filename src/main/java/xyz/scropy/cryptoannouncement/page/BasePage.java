package xyz.scropy.cryptoannouncement.page;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import xyz.scropy.cryptoannouncement.component.BaseComponent;

import java.awt.*;
import java.time.Duration;
import java.util.List;

public abstract class BasePage extends BaseComponent {

    public BasePage(WebDriver driver) {
        super(driver);
    }
}
