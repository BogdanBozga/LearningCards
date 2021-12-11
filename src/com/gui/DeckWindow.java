package com.gui;

import com.fun.Card;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class DeckWindow {
    private static JFrame deckFrame;
//    private JPanel deckPanel;
    String name;
    Integer numberCards=0;
    JTextField nameField;
    JTextField numberCardsField;
    NewCardWindow newCardWindow;
    private JScrollPane deckJScrollPanel;
    public List<String> cardsList;

    public DeckWindow(){
        deckFrame = new JFrame("Learning Cards");
        deckFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        deckFrame.setLayout(new BorderLayout());
        deckFrame.setSize(Standards.width,Standards.height);

        deckJScrollPanel = new JScrollPane();
        nameField = new JTextField();
        numberCardsField = new JTextField();

        nameField.setEditable(false);
        nameField.setFont(Standards.myFont);
        numberCardsField.setEditable(false);
        numberCardsField.setFont(Standards.myFont);

        JButton backButton = new JButton("Back");
        backButton.setFont(Standards.myFont);
        backButton.setSize(25,25);
        backButton.setFocusable(false);
        backButton.addActionListener(e -> Main.showMainWindow());

        JButton newButton = new JButton("New Card");
        newButton.setFont(Standards.myFont);
        newButton.setSize(25,25);
        newButton.setFocusable(false);
        newButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        newCardWindow = new NewCardWindow(name);
                        newCardWindow.setVisible(true);
                    }
                });


        JButton removeButton = new JButton("Remove Card");
        removeButton.setFont(Standards.myFont);
        removeButton.setSize(25,25);
        removeButton.setFocusable(false);
//        backButton.addActionListener(e -> Main.showMainWindow());

        JPanel panelSouth = new JPanel();
        JPanel panelNorth = new JPanel();
        JPanel panelWest = new JPanel();
        JPanel panelEast = new JPanel();

        panelSouth.setPreferredSize(new Dimension(1,50));

        panelNorth.setPreferredSize(new Dimension(1,65));
        panelEast.setPreferredSize(new Dimension(65,1));
        panelWest.setPreferredSize(new Dimension(65,1));

        panelSouth.add(newButton);
        panelSouth.add(removeButton);
        panelSouth.add(backButton);

        panelNorth.add(nameField);
        panelNorth.add(numberCardsField);
        deckFrame.getContentPane().add(deckJScrollPanel,BorderLayout.CENTER);
        deckFrame.getContentPane().add(panelSouth,BorderLayout.SOUTH);
        deckFrame.getContentPane().add(panelNorth,BorderLayout.NORTH);
        deckFrame.getContentPane().add(panelEast,BorderLayout.EAST);
        deckFrame.getContentPane().add(panelWest,BorderLayout.WEST);



        deckJScrollPanel = new JScrollPane();
        cardsList = new ArrayList<>();

    }
    public void updateCardList(){
        deckFrame.getContentPane().remove(deckJScrollPanel);
        deckJScrollPanel = new JScrollPane(new JList(cardsList.toArray()));
        deckFrame.getContentPane().add(deckJScrollPanel,BorderLayout.CENTER);
        refresh();
    }

    public void increaseNumberCards(){
        numberCards++;
        Main.deckDict.get(name).increaseNumberCards();
        update();
    }
    public void update(){
        numberCardsField.setText(numberCards.toString());
    }
    public void setVisibility(boolean visibility){
        deckFrame.setVisible(visibility);
    }
    public Point getPosition(){
        return deckFrame.getLocation();
    }

    public void addCard(Card card){
        cardsList.add(card.getFrontInfo()+" --- "+card.getBackInfo());
        updateCardList();
    }

    public void setPosition(Point position) {
        deckFrame.setLocation(position);
    }
    public static JFrame getFrame(){
        return deckFrame;
    }

    public  void dispose(){
        deckFrame.dispose();
    }
    public boolean isVisible(){
        return deckFrame.isVisible();
    }

    public void setName(String name){
        this.name=name;
        this.numberCards = Main.deckDict.get(name).getTotalCardsNumber();
        nameField.setText(name);
        numberCardsField.setText(numberCards.toString());
    }
    public void closeNewCardWindow(){
        newCardWindow.dispose();
    }
    public void refresh(){
        deckFrame.invalidate();
        deckFrame.validate();
        deckFrame.repaint();
    }
}
