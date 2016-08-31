import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.logging.BotLogger;

/**
 * Created by chris on 31/8/16.
 */
public class BotMain {

    public static final String LOGTAG = "QuizHandler";

    public static void main(String[] args) {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new QuizHandler());
        }
        catch (TelegramApiException e) {
            BotLogger.error(LOGTAG, e);
        }
    }
}
