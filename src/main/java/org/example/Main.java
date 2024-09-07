package org.example;

import com.google.gson.Gson;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    static Gson gson = new Gson();
    public static void main(String[] args) throws TelegramApiException {

        ArrayList<String> data = DataBase.getInstance().loadData();
        ArrayList<User> users = new ArrayList<>();
        for(String json : data){
            User user = gson.fromJson(json,User.class);
            users.add(user);
            try {
                System.out.println(user.getText());
            }catch (Exception e){

            }
        }

        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(new Bot());
    }
}