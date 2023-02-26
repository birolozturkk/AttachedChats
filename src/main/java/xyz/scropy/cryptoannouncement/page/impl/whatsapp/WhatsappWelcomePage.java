package xyz.scropy.cryptoannouncement.page.impl.whatsapp;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import xyz.scropy.cryptoannouncement.page.impl.WelcomePage;

import java.util.Optional;

public class WhatsappWelcomePage extends WelcomePage {

    public WhatsappWelcomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected Optional<WebElement> getTargetChat(String name) {
        By targetChatLocator = By.xpath("//span[@title='" + name + "']");
        try {
            return Optional.of(findElement(targetChatLocator));
        } catch (TimeoutException exception)  {
            return Optional.empty();
        }
    }
}
