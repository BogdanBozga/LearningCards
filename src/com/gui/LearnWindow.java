package com.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LearnWindow {
    private static JFrame learnFrame;
//    private JPanel learnPanel;
    private JScrollPane learnJScrollPane;

    public LearnWindow(){
        learnFrame = new JFrame("Learning Cards");
        learnFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        learnFrame.setLayout(new BorderLayout());
        learnFrame.setSize(Standards.width,Standards.height);



//        learnPanel = new JPanel();


        JButton backButton = new JButton("Back");
        backButton.setFont(Standards.myFont);
        backButton.setSize(25,25);
        backButton.setFocusable(false);
        backButton.addActionListener(e -> Main.showMainWindow());

        JPanel panelSouth = new JPanel();
        JPanel panelNorth = new JPanel();
        JPanel panelWest = new JPanel();
        JPanel panelEast = new JPanel();

        panelSouth.setPreferredSize(new Dimension(1,50));

        panelNorth.setPreferredSize(new Dimension(1,65));
        panelEast.setPreferredSize(new Dimension(65,1));
        panelWest.setPreferredSize(new Dimension(65,1));





        learnJScrollPane = new JScrollPane();

        update();
//        learnFrame.getContentPane().remove(learnJScrollPane);
//        if(Main.decksList != null)
//            learnJScrollPane = Main.decksList.getList();
//        learnFrame.getContentPane().add(learnJScrollPane,BorderLayout.CENTER);
//        refresh();



        JButton learnSelectedButton = new JButton("Learn Selected");
        learnSelectedButton.setFont(Standards.myFont);
        learnSelectedButton.setSize(25,25);
        learnSelectedButton.setFocusable(false);
//        learnSelectedButton.addActionListener(
//                new ActionListener() {
//                    public void actionPerformed(ActionEvent e) {
//                        newCardWindow = new NewCardWindow(name);
//                        newCardWindow.setVisible(true);
//                    }
//                });





        panelSouth.add(backButton);
        panelSouth.add(learnSelectedButton);

        learnFrame.getContentPane().add(learnJScrollPane,BorderLayout.CENTER);
        learnFrame.getContentPane().add(panelSouth,BorderLayout.SOUTH);
        learnFrame.getContentPane().add(panelNorth,BorderLayout.NORTH);
        learnFrame.getContentPane().add(panelEast,BorderLayout.EAST);
        learnFrame.getContentPane().add(panelWest,BorderLayout.WEST);

    }

    public void setVisibility(boolean visibility){
        learnFrame.setVisible(visibility);
    }

    public static JFrame getFrame(){
        return learnFrame;
    }

    public Point getPosition(){
        return learnFrame.getLocation();
    }

    public void setPosition(Point position){
        learnFrame.setLocation(position);
    }
    public  void dispose(){
        learnFrame.dispose();
    }
    public boolean isVisible(){
        return learnFrame.isVisible();
    }

    public void update(){
        if(Main.decksList != null)
            learnJScrollPane = Main.decksList.getList();
        learnFrame.getContentPane().add(learnJScrollPane,BorderLayout.CENTER);
        refresh();
    }

    public void refresh(){
        learnFrame.invalidate();
        learnFrame.validate();
        learnFrame.repaint();
    }
//
//    {
//        public void updateCardList(){
//        deckFrame.getContentPane().remove(deckJScrollPanel);
//        deckJScrollPanel = new JScrollPane(new JList(cardsList.toArray()));
//        deckFrame.getContentPane().add(deckJScrollPanel,BorderLayout.CENTER);
//        refresh();
//    }
    }

