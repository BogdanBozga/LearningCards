package com.gui;

import com.fun.Card;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class NewCardWindow{
    JFrame newCardFrame;
    JPanel newCardPanelInfoRight;
    JPanel newCardPanelInfoLeft;
    JPanel newCardPanelButtons;

    JTextField leftText;
    JTextField rightText;

    String questionImagePath = "";
    String answerImagePath = "";


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


        JButton fileChooserRight  = new JButton("Chose Answer Image");
        fileChooserRight.setFocusable(false);
        fileChooserRight.setFont(Standards.myFont);
        fileChooserRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser file = new JFileChooser();
                file.setCurrentDirectory(new File(System.getProperty("user.home")));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images","jpg","gif","png");
                file.addChoosableFileFilter(filter);
                int result = file.showSaveDialog(null);
                if(result == JFileChooser.APPROVE_OPTION){
                    File selectedFile = file.getSelectedFile();
                     answerImagePath = selectedFile.getPath();
                    //insert in database
                }
            }
        });
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


        JButton fileChooserLeft  = new JButton("Chose Question Image");
        fileChooserLeft.setFocusable(false);
        fileChooserLeft.setFont(Standards.myFont);
        fileChooserLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser file = new JFileChooser();
                file.setCurrentDirectory(new File(System.getProperty("user.home")));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images","jpg","gif","png");
                file.addChoosableFileFilter(filter);
                int result = file.showSaveDialog(null);
                if(result == JFileChooser.APPROVE_OPTION){
                    File selectedFile = file.getSelectedFile();
                    questionImagePath = selectedFile.getPath();
                }
            }
        });

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

                Card card = new Card(leftData, questionImagePath, rightData, answerImagePath);
                Main.connectionDB.insertNewCardInDB(parentDeckName, leftData, rightData, questionImagePath, answerImagePath);
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
