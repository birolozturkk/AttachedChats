package xyz.scropy.cryptoannouncement.page.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import xyz.scropy.cryptoannouncement.page.BasePage;

import java.util.Optional;

public abstract class WelcomePage extends BasePage {

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    protected abstract Optional<WebElement> getTargetChat(String name);

    public void selectChatByName(String name) {
        Optional<WebElement> targetChat = getTargetChat(name);
        targetChat.ifPresent(WebElement::click);
    }

}
