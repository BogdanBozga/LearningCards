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
    String nameDeck;
    Integer numberCards=0;
    JTextField nameField;
    JTextField numberCardsField;
    NewCardWindow newCardWindow;
    private JScrollPane deckJScrollPanel;
    public List<String> cardsList;
    public JList cardsJList;
    private List<Integer> cardsID;

    public DeckWindow(){
        deckFrame = new JFrame("Learning Cards");
        deckFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        deckFrame.setLayout(new BorderLayout());
        deckFrame.setSize(Standards.width,Standards.height);

        deckJScrollPanel = new JScrollPane();
        nameField = new JTextField();
        numberCardsField = new JTextField();
        cardsList = new ArrayList<>();

        nameField.setEditable(false);
        nameField.setFont(Standards.myFont);
        numberCardsField.setEditable(false);
        numberCardsField.setFont(Standards.myFont);

        JButton backButton = new JButton("Back");
        backButton.setFont(Standards.myFont);
        backButton.setSize(25,25);
        backButton.setFocusable(false);
        backButton.addActionListener(e -> Main.showEditWindow());

        JButton newButton = new JButton("New Card");
        newButton.setFont(Standards.myFont);
        newButton.setSize(25,25);
        newButton.setFocusable(false);
        newButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        newCardWindow = new NewCardWindow(nameDeck);
                        newCardWindow.setVisible(true);
                    }
                });


        JButton removeButton = new JButton("Remove Card");
        removeButton.setFont(Standards.myFont);
        removeButton.setSize(25,25);
        removeButton.setFocusable(false);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(verifyIfSelected()){
                    int cardID = cardsID.get(getSelectedIndex());
                    decreaseNumberCards();
                    cardsList.remove(getSelectedValue());
                    cardsJList=new JList(cardsList.toArray());
                    Main.connectionDB.deleteCard(cardID);
                    updateCardList();
                    update();
                    refresh();
                }
            }
        });

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

        updateCardList();
    }
    public void updateCardList(){
        deckFrame.getContentPane().remove(deckJScrollPanel);
        deckJScrollPanel = new JScrollPane(cardsJList);
        deckFrame.getContentPane().add(deckJScrollPanel,BorderLayout.CENTER);
        refresh();
    }

    public void increaseNumberCards(){
        numberCards++;
        Main.deckDict.get(nameDeck).increaseNumberCards();
        update();
    }


    public void decreaseNumberCards(){
            numberCards--;
            Main.deckDict.get(nameDeck).decreaseNumberCards();
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
        cardsList.add(card.getFrontInfo().getTextInfo()+" --- "+card.getBackInfo().getTextInfo());
        cardsJList=new JList(cardsList.toArray());
        updateCardList();
        refresh();
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
        cardsList = new ArrayList<>();
        updateCardList();
        refresh();

        this.nameDeck=name;
        this.numberCards = Main.deckDict.get(name).getTotalCardsNumber();
        nameField.setText(name);
        numberCardsField.setText(numberCards.toString());
        cardsID = new ArrayList<>();
        for(Card card : Main.deckDict.get(name).getCards()){
            String cardInf = card.getFrontInfo().getTextInfo()+ " --- " + card.getBackInfo().getTextInfo();
            cardsID.add(card.getCardID());
            cardsList.add(cardInf);
        }
        cardsJList = new JList(cardsList.toArray());
        updateCardList();
        refresh();
    }
    public void closeNewCardWindow(){
        newCardWindow.dispose();
    }

    public void refresh(){
        deckFrame.invalidate();
        deckFrame.repaint();
        deckFrame.validate();
    }
    boolean verifyIfSelected(){
        return  !cardsJList.isSelectionEmpty();
    }

    String getSelectedValue(){
        return cardsJList.getSelectedValue().toString();
    }

    int getSelectedIndex(){return  cardsJList.getSelectedIndex();};
}
