package xyz.scropy.cryptoannouncement.page.impl.telegram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import xyz.scropy.cryptoannouncement.component.impl.MessageListComponent;
import xyz.scropy.cryptoannouncement.page.impl.ChatPage;

public class TelegramChatPage extends ChatPage {

    public TelegramChatPage(WebDriver driver, MessageListComponent messageListComponent) {
        super(driver, messageListComponent);
    }

    @Override
    protected By getMessageBoxLocator() {
        return By.xpath("//*[@id=\"column-center\"]/div[1]/div/div[4]/div/div[1]/div/div[8]/div[1]/div[1]");
    }
}
