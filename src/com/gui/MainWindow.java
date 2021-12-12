package com.gui;

import javax.swing.*;
import java.awt.*;

class MainWindow{
    private static JFrame mainFrame;
    private JPanel mainPanel;

    public MainWindow(){
        mainFrame = new JFrame("Learning Cards");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(Standards.width,Standards.height);
        mainFrame.setLayout(new BorderLayout());

        JPanel panelSouth = new JPanel();
        JPanel panelNorth = new JPanel();
        JPanel panelWest = new JPanel();
        JPanel panelEast = new JPanel();

        panelSouth.setPreferredSize(new Dimension(50,65));
        panelNorth.setPreferredSize(new Dimension(50,65));
        panelEast.setPreferredSize(new Dimension(65,50));
        panelWest.setPreferredSize(new Dimension(65,50));

        mainFrame.getContentPane().add(panelSouth,BorderLayout.SOUTH);
        mainFrame.getContentPane().add(panelNorth,BorderLayout.NORTH);
        mainFrame.getContentPane().add(panelEast,BorderLayout.EAST);
        mainFrame.getContentPane().add(panelWest,BorderLayout.WEST);


        mainPanel = new JPanel(new GridLayout(3,3,10,25));
        JButton learnButton = new JButton("Learn");
        JButton editButton = new JButton("Edit");
        JButton exitButton = new JButton("Exit");
        learnButton.setFont(Standards.myFont);
        editButton.setFont(Standards.myFont);
        exitButton.setFont(Standards.myFont);
        learnButton.setFocusable(false);
        editButton.setFocusable(false);
        exitButton.setFocusable(false);

        learnButton.addActionListener(e -> Main.showLearnWindow());
        editButton.addActionListener(e -> Main.showEditWindow());
        exitButton.addActionListener(e -> Main.closeApp());
        mainPanel.add(learnButton);
        mainPanel.add(editButton);
        mainPanel.add(exitButton);

        mainFrame.getContentPane().add(mainPanel,BorderLayout.CENTER);

    }

    public void setVisibility(boolean visibility){
        mainFrame.setVisible(visibility);
    }
    public static JFrame getFrame(){
        return mainFrame;
    }

    public Point getPosition(){
        return mainFrame.getLocation();
    }

    public void setPosition(Point position){
        mainFrame.setLocation(position);
    }

    public  void dispose(){
        mainFrame.dispose();
    }

    public boolean isVisible(){
        return mainFrame.isVisible();
    }
}
