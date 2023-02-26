package xyz.scropy.cryptoannouncement.component.impl.telegram;

import com.google.gson.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.json.Json;
import org.openqa.selenium.support.ui.WebDriverWait;
import xyz.scropy.cryptoannouncement.component.impl.MessageListComponent;

import javax.imageio.stream.ImageInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;
import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TelegramMessageListComponent extends MessageListComponent {

    private long lastReceivedMessage;

    public TelegramMessageListComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<String> getNewestMessages() {
        Stream<WebElement> bubbles = findElements(By.className("bubbles-group")).stream()
                .map(bubblesGroup -> bubblesGroup.findElements(By.className("bubble")))
                .flatMap(Collection::stream)
                .filter(bubbleContent -> isNewMessage(Long.parseLong(bubbleContent.getAttribute("data-timestamp"))));

        List<WebElement> bubbleList = bubbles
                .toList();
        try {
            lastReceivedMessage = Long.parseLong(bubbleList.get(bubbleList.size() - 1).getAttribute("data-timestamp"));
        } catch (ArrayIndexOutOfBoundsException ignored){}

        return bubbleList.stream()
                .map(bubble -> parseMessage(bubble.getAttribute("outerText"))).toList();
    }

    private boolean isNewMessage(long time) {
        return lastReceivedMessage < time;
    }

    private String parseMessage(String message) {
        return message.split("\n")[0];
    }
}
