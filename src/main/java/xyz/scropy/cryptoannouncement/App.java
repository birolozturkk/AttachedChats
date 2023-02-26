package xyz.scropy.cryptoannouncement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ThreadGuard;
import xyz.scropy.cryptoannouncement.page.impl.ChatPage;
import xyz.scropy.cryptoannouncement.page.impl.WelcomePage;

import java.time.Duration;
import java.util.List;

import static java.sql.DriverManager.getDriver;

public class App extends Thread {

    private final WebDriver driver;
    private final WelcomePage welcomePage;
    private final ChatPage chatPage;

    public App(WebDriver driver, WelcomePage welcomePage, ChatPage chatPage) {
        this.welcomePage = welcomePage;
        this.chatPage = chatPage;
        this.driver = driver;
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(80));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
        driver.manage().window().maximize();
    }

    public void selectChatByName(String name) {
        welcomePage.selectChatByName(name);
    }

    public void sendMessage(String message) {
        chatPage.sendMessage(message);
    }

    public List<String> getNewestMessages() {
        return chatPage.getNewestMessages();
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }
}
