package org.example;

import com.google.gson.Gson;
import org.checkerframework.checker.units.qual.A;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;

public class Bot extends TelegramLongPollingBot {


    static Gson gson = new Gson();
    Long chatID;

    @Override
    public String getBotUsername() {
        return "epicbotbotbot";
    }

    @Override
    public String getBotToken() {
        return "7285834935:AAGJHLTUXgAdQUkY9TUcXF4ECjZ4DMhWnKU";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()){
            Message message = update.getMessage();
            chatID = message.getChatId();
            String text = message.getText();
            IDB dataBase = DataBase.getInstance();

            User user = new User(chatID,text);
            String json = gson.toJson(user);
            if (user.getText().equals("/start")){
                return;
            }
            dataBase.saveStringData(json);
        }

    }



    public void sendText(Long who, String what){
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString()) //Who are we sending a message to
                .text(what).build();    //Message content
        try {
            execute(sm);                        //Actually sending the message
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);      //Any error will be printed here
        }
    }

}
