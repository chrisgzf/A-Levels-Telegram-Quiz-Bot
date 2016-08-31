import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.logging.BotLogger;

/**
 * Created by chris on 1/9/16.
 */
public class QuizHandler extends TelegramLongPollingBot {
    public static final String LOGTAG = "[QuizHandler]";

    @Override
    public String getBotUsername() {
        return BotConfig.BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BotConfig.BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        //check if the update has a message
        if(update.hasMessage()){
            Message message = update.getMessage();

            //check if the message has text. it could also contain for example a location ( message.hasLocation() )
            if(message.hasText()){
                handleMessage(message);
            }
        }
    }

    private void handleMessage(Message message) {
        SendMessage reply = new SendMessage();
        BotLogger.info(LOGTAG, message.getFrom().getFirstName() + " " + message.getFrom().getLastName() + ": " + message.getText());

        if (message.getText().toLowerCase().equals("/start") || message.getText().toLowerCase().startsWith("/help")) {
            reply.setText(BotMessages.StartMessage);
        }

        if (message.getText().toLowerCase().startsWith("/about")) {
            reply.setText(BotMessages.AboutMessage);
        }

        if (reply.getText() != null) {
            reply.setChatId(message.getChatId().toString());
            try {
                sendMessage(reply); //at the end, so some magic and send the message ;)
            } catch (TelegramApiException e) {
                //do some error handling
            }
        }
    }
}
