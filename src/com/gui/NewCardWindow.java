package com.gui;

import com.fun.Card;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewCardWindow{
    JFrame newCardFrame;
    JPanel newCardPanelInfoRight;
    JPanel newCardPanelInfoLeft;
    JPanel newCardPanelButtons;

    JTextField leftText;
    JTextField rightText;
    JFileChooser fileChooserLeft;
    JFileChooser fileChooserRight;

    NewCardWindow(String parentDeckName){
        newCardFrame = new JFrame("Learning Cards");
        newCardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newCardFrame.setLayout(new GridLayout(3,1));
        newCardFrame.setSize(Standards.width,Standards.height);
        newCardPanelInfoRight= new JPanel(new GridLayout(3,1));
        JTextField nameFieldRight  = new JTextField("Answer");
        nameFieldRight.setFont(Standards.myFont);
        nameFieldRight.setEditable(false);
        newCardPanelInfoRight.add(nameFieldRight);

        rightText = new JTextField();
        rightText.setFont(Standards.myFont);
        rightText.setEditable(true);
        newCardPanelInfoRight.add(rightText);

        fileChooserRight = new JFileChooser();
        newCardPanelInfoRight.add(fileChooserRight);

        newCardPanelInfoLeft = new JPanel(new GridLayout(3,1));
        JTextField nameFieldLeft  = new JTextField("Question");
        nameFieldLeft.setFont(Standards.myFont);
        nameFieldLeft.setEditable(false);
        newCardPanelInfoLeft.add(nameFieldLeft);

        leftText = new JTextField();
        leftText.setFont(Standards.myFont);
        leftText.setEditable(true);
        newCardPanelInfoLeft.add(leftText);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setFont(Standards.myFont);
        cancelButton.setSize(25,25);
        cancelButton.setFocusable(false);
        cancelButton.addActionListener(e -> Main.deckWindow.closeNewCardWindow());

        JButton saveButton = new JButton("Save");
        saveButton.setFont(Standards.myFont);
        saveButton.setSize(25,25);
        saveButton.setFocusable(false);
        saveButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                String leftData = leftText.getText();
                String rightData = rightText.getText();

                Card card = new Card(leftData, rightData);
                Main.connectionDB.insertNewCardInDB(parentDeckName,leftData,rightData);
                Main.deckDict.get(parentDeckName).addCard(card);
                Main.deckWindow.addCard(card);
                Main.deckWindow.updateCardList();
                Main.deckWindow.increaseNumberCards();
                Main.deckWindow.closeNewCardWindow();
            }
        });

        newCardPanelButtons = new JPanel();
        newCardPanelButtons.add(saveButton);
        newCardPanelButtons.add(cancelButton);



        fileChooserLeft = new JFileChooser();
        newCardPanelInfoLeft.add(fileChooserLeft);

        newCardFrame.getContentPane().add(newCardPanelInfoLeft);
        newCardFrame.getContentPane().add(newCardPanelInfoRight);
        newCardFrame.getContentPane().add(newCardPanelButtons);
    }

    public void setVisible(boolean bol){
        newCardFrame.setVisible(bol);
    }

    public void dispose(){
        newCardFrame.dispose();
    }


}
