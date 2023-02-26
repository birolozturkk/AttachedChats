package xyz.scropy.cryptoannouncement.tasks;

import io.netty.util.Timeout;
import org.openqa.selenium.concurrent.GuardedRunnable;
import xyz.scropy.cryptoannouncement.App;

import java.util.List;
import java.util.TimerTask;

public class DetectNewestMessagesTask extends TimerTask {

    private final App from;
    private final App to;

    public DetectNewestMessagesTask(App from, App to) {
        this.from = from;
        this.to = to;
    }

    private int secondsUntilFinish = 60;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        List<String> newestMessages = from.getNewestMessages();
        newestMessages.forEach(System.out::println);
        --secondsUntilFinish;
    }
}
