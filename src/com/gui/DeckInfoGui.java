package com.gui;
import javax.swing.*;
import java.awt.*;

public class DeckInfoGui {
    JFrame frame = new JFrame();
    String name;
    int numberCards;


    DeckInfoGui(){
        frame.setSize((int)(Standards.width),(int)(Standards.height));

        JPanel panelCenter = new JPanel();
        JPanel panelSouth = new JPanel();
        JPanel panelNorth = new JPanel();
        JPanel panelWest = new JPanel();
        JPanel panelEast = new JPanel();

        JButton newCardButton = new JButton("New Card");
        newCardButton.setFont(Standards.myFont);
        newCardButton.setSize(25,25);
        newCardButton.setFocusable(false);
//        newCardButton.addActionListener(e -> this.createNewDeck());




        panelWest.setPreferredSize(new Dimension(65,1));

        JTextField nameField = new JTextField();
        nameField.setText(this.name);
        panelCenter.add(nameField);


        panelSouth.add(newCardButton);
        JTextField numberField = new JTextField();
        numberField.setText(String.valueOf(this.numberCards));
        panelEast.add(numberField);


        frame.getContentPane().add(panelCenter,BorderLayout.CENTER);
        frame.getContentPane().add(panelSouth,BorderLayout.SOUTH);
        frame.getContentPane().add(panelNorth,BorderLayout.NORTH);
        frame.getContentPane().add(panelEast,BorderLayout.EAST);
        frame.getContentPane().add(panelWest,BorderLayout.WEST);
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

    JFrame getFrame(){
        return frame;
    }

    String getName(){
        return this.name;
    }

    String getNameAndNumber(){
        return this.name+" -- "+numberCards;
    }



    public void setVisibility(boolean visibility){
        frame.setVisible(visibility);
    }

    public Point getPosition(){
        return frame.getLocation();
    }

    public void setPosition(Point position){
        frame.setLocation(position);
    }

    public  void dispose(){
        frame.dispose();
    }

}
