package xyz.scropy.cryptoannouncement.component.impl.whatsapp;

import org.openqa.selenium.WebDriver;
import xyz.scropy.cryptoannouncement.component.impl.MessageListComponent;

import java.util.List;

public class WhatsappMessageListComponent extends MessageListComponent {
    public WhatsappMessageListComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<String> getNewestMessages() {
        return null;
    }
}
