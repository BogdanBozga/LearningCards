package com.fun;

import java.util.List;
import java.util.Vector;

public class Deck {

    private String name;
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
    }

    public Deck(String name, Vector<Card> cards, int totalCardsNumber) {
        cards = new Vector<>();

        this.name = name;
        this.cards = cards;
        this.totalCardsNumber = totalCardsNumber;
    }

    void calculateStats(){

    }

    public void addCard(Card card){
        cards.add(card);
    }

    public String getName() {
        return name;
    }

    public void increaseNumberCards(){
        totalCardsNumber++;
    }

    public int getTotalCardsNumber() {
        return totalCardsNumber;
    }

    public void calculatePercent(){

    }
    public void calculateProgress() {

    }




}
