package xyz.scropy.cryptoannouncement.page.impl.telegram;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import xyz.scropy.cryptoannouncement.page.impl.WelcomePage;

import java.util.Optional;

public class TelegramWelcomePage extends WelcomePage {

    public TelegramWelcomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected Optional<WebElement> getTargetChat(String name) {
        By chatListLocator = By.xpath("//*[@id=\"folders-container\"]/div/div[1]/ul");
        try {
            return findElement(chatListLocator)
                    .findElements(By.className("chatlist-chat")).stream()
                    .filter(chatElement -> chatElement.getAttribute("innerText").contains(name))
                    .findFirst();
        } catch (TimeoutException exception) {
            return Optional.empty();
        }
    }
}
