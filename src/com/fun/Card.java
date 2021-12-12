package com.fun;

public class Card {

public CardLearnInfo frontInfo;
public CardLearnInfo backInfo;
private int learningScore;
private boolean newCard;
private int readCount;

    public Card(String infoFront,String infoBack){
        frontInfo = new CardLearnInfo(infoFront);
        backInfo = new CardLearnInfo(infoBack);
    }
    public Card(String infoFront,String infoFrontPhoto,String infoBack,String infoBackPhoto){
        frontInfo = new CardLearnInfo(infoFront,infoFrontPhoto);
        backInfo = new CardLearnInfo(infoBack,infoBackPhoto);
    }

    public void verifyIfNew(){
    }

    public void increaseReadCount(){
        readCount++;
    }
    public void modifyScore(){

    }

    public CardLearnInfo getFrontInfo(){
        return frontInfo;
    }

    public CardLearnInfo getBackInfo(){
        return backInfo;
    }
}

