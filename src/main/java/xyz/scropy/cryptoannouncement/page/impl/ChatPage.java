package xyz.scropy.cryptoannouncement.page.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import xyz.scropy.cryptoannouncement.component.impl.MessageListComponent;
import xyz.scropy.cryptoannouncement.page.BasePage;

import java.util.List;

public abstract class ChatPage extends BasePage {

    private final MessageListComponent messageListComponent;

    public ChatPage(WebDriver driver, MessageListComponent messageListComponent) {
        super(driver);
        this.messageListComponent = messageListComponent;
    }

    protected abstract By getMessageBoxLocator();
    public void sendMessage(String message) {
        By messageBox = getMessageBoxLocator();
        try {
            type(messageBox, message);
            findElement(messageBox).sendKeys(Keys.ENTER);
        }catch (TimeoutException exception) {
            System.out.println("Element was not found");
        }
    }

    public List<String> getNewestMessages() {
        return messageListComponent.getNewestMessages();
    }
}
