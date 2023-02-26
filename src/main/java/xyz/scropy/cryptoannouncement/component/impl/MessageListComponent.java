package xyz.scropy.cryptoannouncement.component.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v109.runtime.model.Timestamp;
import xyz.scropy.cryptoannouncement.component.BaseComponent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class MessageListComponent extends BaseComponent {

    private final Map<String, String> messagesById = new HashMap<>();
    public MessageListComponent(WebDriver driver) {
        super(driver);
    }

    public abstract List<String> getNewestMessages();

}
