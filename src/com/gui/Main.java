package com.gui;

public class Main {
    private static MainWindow  mainWindow = new MainWindow();
    private static LearnWindow learnWindow = new LearnWindow();
    private static EditWindow editWindow = new EditWindow();
    private static DeckWindow deckWindow = new DeckWindow();
    Windows window = new Windows();

    public static void main(String[] args) {

//        Main.showMainWindow();
        Windows.setVisibility(true);
    }


    public static void showMainWindow(){
        mainWindow.setVisibility(true);
        learnWindow.setVisibility(false);
        editWindow.setVisibility(false);
        deckWindow.setVisibility(false);

    }
    public static void showLearnWindow(){
        mainWindow.setVisibility(false);
        learnWindow.setVisibility(true);
        editWindow.setVisibility(false);
        deckWindow.setVisibility(false);
    }
    public static void showEditWindow(){
        mainWindow.setVisibility(false);
        learnWindow.setVisibility(false);
        editWindow.setVisibility(true);
        deckWindow.setVisibility(false);
    }



    public static void showDeckWindow(){
        mainWindow.setVisibility(false);
        learnWindow.setVisibility(false);
        editWindow.setVisibility(false);
        deckWindow.setVisibility(true);
    }


}
