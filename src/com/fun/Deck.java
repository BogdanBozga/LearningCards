package com.fun;

import java.util.Vector;

public class Deck {

    private String name;
    private Vector<Card> cards;
    private LearningStats oldStats;
    private int totalCardsNumber;
    private double learnPercentage;
    private int currentIndex = 0;

    public Deck(String name) {
        this.name = name;
        totalCardsNumber = 0;
        learnPercentage = 0.0;
    }

    public Deck(String name, Vector<Card> cards, int totalCardsNumber) {
        this.name = name;
        this.cards = cards;
        this.totalCardsNumber = totalCardsNumber;
    }

    void calculateStats(){

    }
    void calculatePercent(){

    }
    void calculateProgress() {

    }




}
