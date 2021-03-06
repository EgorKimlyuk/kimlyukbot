import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendSticker;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {
    public String getBotToken() {
        return "586995749:AAF0McfmcwnyYFCtalYL2sRWm9dpSX_FL_M";
    }

    public void onUpdateReceived(final Update update) {
        showProperties(update);

        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
            String stickerId = "CAADBAADcwADFZIyDnZwXi6YL5ujAg";

            String message_text = update.getMessage().getText();

            long chat_id = update.getMessage().getChatId();

            SendMessage message = new SendMessage() // Create a message object object
                    .setChatId(chat_id)
                    .setText("Rodion da best man in da world");


            try {
                sendSticker(new SendSticker().setChatId(chat_id).setSticker(stickerId));
                execute(message); // Sending our message object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    public String getBotUsername() {
        return "kimlyuk_bot";
    }

    public void showProperties(final Update update) {
        try {
            if (update.hasMessage() && update.getMessage().hasText()) {
                System.out.println("id = " + update.getUpdateId() +
                        ", message.text= " + update.getMessage().getText()
                );
            }

            if (update.hasMessage() && update.getMessage().getSticker() != null) {
                System.out.println("Sticker file id = " + update.getMessage().getSticker().getFileId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
