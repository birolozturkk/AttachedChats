package xyz.scropy.cryptoannouncement.page.impl.whatsapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import xyz.scropy.cryptoannouncement.component.impl.MessageListComponent;
import xyz.scropy.cryptoannouncement.page.impl.ChatPage;

public class WhatsappChatPage extends ChatPage {

    public WhatsappChatPage(WebDriver driver, MessageListComponent messageListComponent) {
        super(driver, messageListComponent);
    }

    @Override
    protected By getMessageBoxLocator() {
        return By.className("iq0m558w");
    }
}
