package com.gui;
import javax.swing.*;
import java.awt.*;

public class DeckInfoGui {
    JFrame frame = new JFrame();
    String name;
    int numberCards;


    DeckInfoGui(){
        frame.setSize((int)(Standards.width*0.90),(int)(Standards.height*0.1));
    }

    DeckInfoGui(String name){
        this();
        this.name = name;
        numberCards = 0;
    }

    DeckInfoGui(String name,int numberCards){
        this();
        this.name = name;
        this.numberCards = numberCards;
    }
}
