package com.gui;
import com.fun.DbConnection;
import com.fun.Deck;

import java.util.HashMap;
import java.util.Map;

public class Main {
//    public static final List<Deck> deckList = new ArrayList<>();
    public static final DbConnection connectionDB = new DbConnection();
    public static final Map<String, Deck> deckDict = new HashMap<>();
    public static final DecksList decksList = new DecksList();

    private static final MainWindow  mainWindow = new MainWindow();
    private static final LearnWindow learnWindow = new LearnWindow();


    private static final EditWindow editWindow = new EditWindow();
    public static  DeckWindow deckWindow = new DeckWindow();
    private static final WelcomeWindow welcomeWindow = new WelcomeWindow();



    public static void main(String[] args) {
        showMainWindow();
//        showWelcomeWindow();

        connectionDB.initializeDeckDict();
    }


    public static void showWelcomeWindow(){
        welcomeWindow.setVisibility(true);
    }

    public static void showMainWindow(){

        decksList.startOperation();
        if(learnWindow.isVisible()) {
            mainWindow.setPosition(learnWindow.getPosition());
            learnWindow.setVisibility(false);
        }
        else if(editWindow.isVisible()) {
            mainWindow.setPosition(editWindow.getPosition());
            editWindow.setVisibility(false);
        }else if(welcomeWindow.isVisible()){
            mainWindow.setPosition(welcomeWindow.getPosition());
            welcomeWindow.setVisibility(false);
        }else if(deckWindow.isVisible()){
            mainWindow.setPosition(deckWindow.getPosition());
            deckWindow.setVisibility(false);
        }
        mainWindow.setVisibility(true);
    }

    public static void showLearnWindow(){
        learnWindow.setPosition(mainWindow.getPosition());
        learnWindow.update();
        mainWindow.setVisibility(false);
        learnWindow.setVisibility(true);
    }

    public static void showEditWindow(){
        if(mainWindow.isVisible())
            editWindow.setPosition(mainWindow.getPosition());
        else if(deckWindow.isVisible())
            editWindow.setPosition(deckWindow.getPosition());
        deckWindow.setVisibility(false);
        mainWindow.setVisibility(false);
        editWindow.setVisibility(true);

        editWindow.refresh();
    }

    public static void showDeckWindow(){
        deckWindow.setPosition(editWindow.getPosition());
//        mainWindow.setPosition(editWindow.getPosition());
        mainWindow.setVisibility(false);
        learnWindow.setVisibility(false);
        editWindow.setVisibility(false);
        deckWindow.setVisibility(true);
    }

    public static void closeApp(){
//        mainWindow.dispose();
//        learnWindow.dispose();
//        editWindow.dispose();
//        deckWindow.dispose();
        System.exit(0);
    }



}
