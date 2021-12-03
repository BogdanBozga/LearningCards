package com.gui;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class DecksList {
    JFrame deckListFrame;
    JScrollPane scrollPane;
    JPanel panel;
    List<String> decksList;
    JList decksJList;
    DecksList(){
        deckListFrame = new JFrame();
        scrollPane = new JScrollPane();
        decksList = new ArrayList<>();
    }

    void addDeck(DeckInfoGui newDeck){
        if(verifyIfExist(newDeck.getNameAndNumber())) {
            //deck already exist
        } else{
            decksList.add(newDeck.getNameAndNumber());
            decksJList = new JList(decksList.toArray());
            decksJList.setFont(Standards.myFont);
        }
    }

    void updateScrollPane(){
        panel = new JPanel();
        scrollPane = new JScrollPane(panel);
    }

    boolean verifyIfExist(String name){
        for(String deckName : decksList){
            if(deckName.compareTo(name) == 0){
                return true;
            }
        }
        return false;
    }

    boolean removeDeck(String name){
            for(String deckName : decksList){
                if(deckName.compareTo(name) ==0){
                    decksList.remove(deckName);
                    updateScrollPane();
                    return true;
                }
            }
        return false;
    }

    JScrollPane getList(){
        scrollPane = new JScrollPane(decksJList);
        scrollPane.setFont(Standards.myFont);
        return scrollPane;
    }

    boolean verifyIfSelected(){
       return  !decksJList.isSelectionEmpty();
    }

    String getSelectedValue(){
        return decksJList.getSelectedValue().toString();
    }

}
