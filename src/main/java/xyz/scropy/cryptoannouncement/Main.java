package xyz.scropy.cryptoannouncement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import xyz.scropy.cryptoannouncement.component.impl.telegram.TelegramMessageListComponent;
import xyz.scropy.cryptoannouncement.component.impl.whatsapp.WhatsappMessageListComponent;
import xyz.scropy.cryptoannouncement.page.impl.ChatPage;
import xyz.scropy.cryptoannouncement.page.impl.WelcomePage;
import xyz.scropy.cryptoannouncement.page.impl.telegram.TelegramChatPage;
import xyz.scropy.cryptoannouncement.page.impl.telegram.TelegramWelcomePage;
import xyz.scropy.cryptoannouncement.page.impl.whatsapp.WhatsappChatPage;
import xyz.scropy.cryptoannouncement.page.impl.whatsapp.WhatsappWelcomePage;
import xyz.scropy.cryptoannouncement.tasks.DetectNewestMessagesTask;

import java.util.Timer;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver telegramDriver = new ChromeDriver();
        WebDriver whatsappDriver = new ChromeDriver();

        WelcomePage telegramWelcomePage = new TelegramWelcomePage(telegramDriver);
        ChatPage telegramChatPage = new TelegramChatPage(telegramDriver, new TelegramMessageListComponent(telegramDriver));

        WelcomePage whatsappWelcomePage = new WhatsappWelcomePage(whatsappDriver);
        ChatPage whatsappChatPage = new WhatsappChatPage(whatsappDriver, new WhatsappMessageListComponent(whatsappDriver));

        App telegramBot = new App(telegramDriver, telegramWelcomePage, telegramChatPage);
        App whatsappBot = new App(whatsappDriver, whatsappWelcomePage, whatsappChatPage);

        whatsappBot.navigateTo("https://web.whatsapp.com/");
        whatsappBot.selectChatByName("Person1");

        telegramBot.navigateTo("https://web.telegram.org/k");
        telegramBot.selectChatByName("Person1");

        for (int i = 0; i < 60; i++) {
            Thread.sleep(1000);
            telegramBot.getNewestMessages().forEach(whatsappBot::sendMessage);
        }/*
        Timer detectNewestMessagesTimer = new Timer();
        detectNewestMessagesTimer.schedule(new DetectNewestMessagesTask(telegramBot, whatsappBot), 1000);*/
        telegramDriver.quit();
        whatsappDriver.quit();
    }
}
