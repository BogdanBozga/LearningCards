package com.gui;

import com.fun.Deck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EditWindow {
    private  static JFrame editFrame;
    private JScrollPane editPanel;

    public EditWindow(){
        editFrame = new JFrame("Learning Cards");
        editFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        editFrame.setLayout(new BorderLayout());
        editFrame.setSize(Standards.width,Standards.height);

//        editPanel = new JScrollPane();



        JButton backButton = new JButton("Back");
        backButton.setFont(Standards.myFont);
        backButton.setSize(25,25);
        backButton.setFocusable(false);
        backButton.addActionListener(e -> Main.showMainWindow());

        JButton newButton = new JButton("New Deck");
        newButton.setFont(Standards.myFont);
        newButton.setSize(25,25);
        newButton.setFocusable(false);
        newButton.addActionListener(e -> this.createNewDeck());

        JButton editSelectedButton = new JButton("Edit Selected");
        editSelectedButton.setFont(Standards.myFont);
        editSelectedButton.setSize(25,25);
        editSelectedButton.setFocusable(false);
        editSelectedButton.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        if(Main.decksList.verifyIfSelected()){
                            Main.deckWindow = new DeckWindow();
                            Main.deckWindow.setName(Main.decksList.getSelectedValue());
                            Main.showDeckWindow();
                        }
                    } });



        JPanel panelSouth = new JPanel();
        JPanel panelNorth = new JPanel();
        JPanel panelWest = new JPanel();
        JPanel panelEast = new JPanel();

        panelSouth.setPreferredSize(new Dimension(1,50));

        panelNorth.setPreferredSize(new Dimension(1,65));
        panelEast.setPreferredSize(new Dimension(65,1));
        panelWest.setPreferredSize(new Dimension(65,1));

        panelSouth.add(newButton);
        panelSouth.add(backButton);
        panelSouth.add(editSelectedButton);

//        editFrame.getContentPane().add(editPanel,BorderLayout.CENTER);
        editFrame.getContentPane().add(panelSouth,BorderLayout.SOUTH);
        editFrame.getContentPane().add(panelNorth,BorderLayout.NORTH);
        editFrame.getContentPane().add(panelEast,BorderLayout.EAST);
        editFrame.getContentPane().add(panelWest,BorderLayout.WEST);




//        DeckInfoGui deck = new DeckInfoGui(text.getText());
//        Main.deckDict.put(text.getText(),new Deck(text.getText()));


//        Main.decksList.addDeck(deck);
//        editFrame.getContentPane().remove(editPanel);
        editPanel = Main.decksList.getList();
        editFrame.getContentPane().add(editPanel,BorderLayout.CENTER);
        refresh();
//        deckCreate.dispose();

    }

    public void setVisibility(boolean visibility){
        editFrame.setVisible(visibility);
    }

    public Point getPosition(){
        return editFrame.getLocation();
    }

    public void setPosition(Point position){
        editFrame.setLocation(position);
    }

    public static JFrame getFrame(){
        return editFrame;
    }
    public  void dispose(){
        editFrame.dispose();
    }

    public boolean isVisible() {
        return editFrame.isVisible();
    }




    public  void createNewDeck(){
        JFrame deckCreate = new JFrame();
        deckCreate.setLayout(new BorderLayout());
        int width = (int)Math.round(Standards.width/1.1);
        int height = (int)Math.round(Standards.height/2.5);
        deckCreate.setSize(width,height);
        deckCreate.setLocation(this.getPosition());
        deckCreate.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        DeckInfoGui deck;
        JTextField text = new JTextField();

        text.setFont(Standards.myFont);
        text.setHorizontalAlignment(JTextField.CENTER);
        JButton saveButton = new JButton("Save");
        saveButton.setFocusable(false);
        saveButton.setSize(25,25);
        saveButton.setFont(Standards.myFont);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (Main.decksList.verifyIfExist(text.getText())) {

                    //warning that the deck with this specific name already exist
                } else {
                    DeckInfoGui deck = new DeckInfoGui(text.getText());
                    Main.deckDict.put(text.getText(),new Deck(text.getText()));


                    Main.decksList.addDeck(deck);
                    editFrame.getContentPane().remove(editPanel);
                    editPanel = Main.decksList.getList();
                    editFrame.getContentPane().add(editPanel,BorderLayout.CENTER);
                    refresh();
                    deckCreate.dispose();
                }
            }
        });



        JButton cancelButton = new JButton("Cancel");
        cancelButton.setFocusable(false);
        cancelButton.setSize(25,25);
        cancelButton.setFont(Standards.myFont);
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deckCreate.dispose();
            }
        });

        JPanel panelSouth = new JPanel();
        JPanel panelNorth = new JPanel();
        JPanel panelWest = new JPanel();
        JPanel panelEast = new JPanel();



        panelSouth.setPreferredSize(new Dimension(1,50));
        panelNorth.setPreferredSize(new Dimension(1,50));
        panelEast.setPreferredSize(new Dimension(50,1));
        panelWest.setPreferredSize(new Dimension(50,1));

        panelSouth.add(saveButton);
        panelSouth.add(cancelButton);

        deckCreate.getContentPane().add(text,BorderLayout.CENTER);
        deckCreate.getContentPane().add(panelSouth,BorderLayout.SOUTH);
        deckCreate.getContentPane().add(panelNorth,BorderLayout.NORTH);
        deckCreate.getContentPane().add(panelEast,BorderLayout.EAST);
        deckCreate.getContentPane().add(panelWest,BorderLayout.WEST);


        deckCreate.setVisible(true);
    }

    public void refresh(){
        editFrame.invalidate();
        editFrame.validate();
        editFrame.repaint();
    }


}
