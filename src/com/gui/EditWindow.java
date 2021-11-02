package com.gui;

import javax.swing.*;
import java.awt.*;


public class EditWindow {
    private  static JFrame editFrame;
    private JPanel editPanel;

    public EditWindow(){
        editFrame = new JFrame("Learning Cards");
        editFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        editFrame.setLayout(new BorderLayout());
        editFrame.setSize(Standards.width,Standards.height);

        editPanel = new JPanel();



        JButton backButton = new JButton("Back");
        backButton.setFont(Standards.myFont);
        backButton.setSize(25,25);
        backButton.setFocusable(false);
        backButton.addActionListener(e -> Main.showMainWindow());

        JButton newButton = new JButton("New Deck");
        newButton.setFont(Standards.myFont);
        newButton.setSize(25,25);
        newButton.setFocusable(false);
        //

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

        editFrame.getContentPane().add(editPanel,BorderLayout.CENTER);
        editFrame.getContentPane().add(panelSouth,BorderLayout.SOUTH);
        editFrame.getContentPane().add(panelNorth,BorderLayout.NORTH);
        editFrame.getContentPane().add(panelEast,BorderLayout.EAST);
        editFrame.getContentPane().add(panelWest,BorderLayout.WEST);

    }

    public void setVisibility(boolean visibility){
        editFrame.setVisible(visibility);
    }
    public static JFrame getFrame(){
        return editFrame;
    }

}
