package com.fun;

import com.gui.Main;

import java.util.List;
import java.util.Vector;

import static com.gui.Main.connectionDB;

//import gui.Main;
public class Deck {

    private String name;
    private String ID;
    private List<Card> cards;
    private LearningStats oldStats;
    private int totalCardsNumber;
    private double learnPercentage;
    private int currentIndex = 0;

    public Deck(String name) {
        cards = new Vector<>();
        this.name = name;
        totalCardsNumber = 0;
        learnPercentage = 0.0;
        connectionDB.insertNewDeckInDB(name);

    }

    public Deck(String name, List<Card> cards, int totalCardsNumber) {
//        cards = new Vector<>();

        this.name = name;
        this.cards = cards;
        this.totalCardsNumber = totalCardsNumber;
    }

    void calculateStats(){

    }

    public List<Card> getCards(){
        return this.cards;
    }
    public void addCard(Card card){
        cards.add(card);
    }

    public String getName() {
        return name;
    }

    public void increaseNumberCards(){
        totalCardsNumber++;
        connectionDB.updateCardsNumber(totalCardsNumber,name);
    }

    public void decreaseNumberCards(){
        totalCardsNumber--;
        connectionDB.updateCardsNumber(totalCardsNumber,name);

    }
    public int getTotalCardsNumber() {
        return totalCardsNumber;
    }

    public void calculatePercent(){

    }
    public void calculateProgress() {

    }




}
