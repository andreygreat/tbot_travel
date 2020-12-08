package by.resliv.travel.client;

import by.resliv.travel.services.CityService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TelegramBotClient extends TelegramLongPollingBot {

    private CityService cityService;
    @Value("${tboot.tBotUsername}")
    private String tBotUsername;
    @Value("${tboot.tBootToken}")
    private String tBootToken;

    public TelegramBotClient(CityService cityService) {
        this.cityService = cityService;
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            String city = update.getMessage().getText();
            String cityInfo = cityService.getCityInfo(city);
            long chat_id = update.getMessage().getChatId();

            SendMessage message = new SendMessage();
            message.setText(cityInfo);
            message.setChatId(String.valueOf(chat_id));

            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return tBotUsername;
    }

    @Override
    public String getBotToken() {
        return tBootToken;
    }
}
