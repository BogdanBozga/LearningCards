package com.gui;
import com.fun.Deck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
//    public static final List<Deck> deckList = new ArrayList<>();
    public static final Map<String, Deck> deckDict = new HashMap<>();
    private static final MainWindow  mainWindow = new MainWindow();
    private static final LearnWindow learnWindow = new LearnWindow();
    private static final EditWindow editWindow = new EditWindow();
    public static final DeckWindow deckWindow = new DeckWindow();
    private static final WelcomeWindow welcomeWindow = new WelcomeWindow();
    public static final DecksList decksList = new DecksList();


    public static void main(String[] args) {
        showMainWindow();
//        showWelcomeWindow();
    }


    public static void showWelcomeWindow(){
        welcomeWindow.setVisibility(true);
    }
    public static void showMainWindow(){

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
        mainWindow.setVisibility(false);
        learnWindow.setVisibility(true);
    }

    public static void showEditWindow(){
        editWindow.setPosition(mainWindow.getPosition());
        mainWindow.setVisibility(false);
        editWindow.setVisibility(true);
    }

    public static void showDeckWindow(){
        deckWindow.setPosition(editWindow.getPosition());
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
