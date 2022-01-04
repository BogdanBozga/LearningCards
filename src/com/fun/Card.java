package com.fun;

public class Card {

public CardLearnInfo frontInfo;
public CardLearnInfo backInfo;
public int cardIdD;

    public Card(String infoFront,String infoBack){
        frontInfo = new CardLearnInfo(infoFront);
        backInfo = new CardLearnInfo(infoBack);
    }
    public Card(String infoFront,String infoFrontPhoto,String infoBack,String infoBackPhoto){
        frontInfo = new CardLearnInfo(infoFront,infoFrontPhoto);
        backInfo = new CardLearnInfo(infoBack,infoBackPhoto);
    }


    public CardLearnInfo getFrontInfo(){
        return frontInfo;
    }

    public CardLearnInfo getBackInfo(){
        return backInfo;
    }

    void setID(int id){
        this.cardIdD = id;
    }

    public int getCardID(){
        return cardIdD;
    }
}

