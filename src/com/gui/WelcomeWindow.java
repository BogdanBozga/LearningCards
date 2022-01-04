package com.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeWindow {
    public String nameUser;
    private static JFrame welcomeFrame;
    JTextField textField;

    public WelcomeWindow(){
        welcomeFrame = new JFrame("Learning Cards");
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeFrame.setLayout(new BorderLayout());
        welcomeFrame.setSize(Standards.width,Standards.height);




        JButton enterButton = new JButton("Enter");
        JButton exitButton = new JButton("Exit");
        enterButton.setFont(Standards.myFont);
        exitButton.setFont(Standards.myFont);
        enterButton.setFocusable(false);
        exitButton.setFocusable(false);

        enterButton.addActionListener(new ActionListener() {
                                          @Override
                                          public void actionPerformed(ActionEvent e) {
                                              nameUser = textField.getText();
                                              Main.connectionDB.insertUser(nameUser);
                                              Main.showMainWindowFirstTime();

                                          }
                                      });


        exitButton.addActionListener(e -> Main.closeApp());

        JPanel panelSouth = new JPanel();
        JPanel panelCenter = new JPanel();
        JPanel panelNorth = new JPanel();
        JPanel panelWest = new JPanel();
        JPanel panelEast = new JPanel();

        panelSouth.setPreferredSize(new Dimension(1,50));

        panelNorth.setPreferredSize(new Dimension(1,65));
        panelEast.setPreferredSize(new Dimension(65,1));
        panelWest.setPreferredSize(new Dimension(65,1));



////        The next line of code registers a TextDemo object as an action listener for the text field.
//
//                textField.addActionListener(this);
////        The actionPerformed method handles action events from the text field:


        textField = new JTextField(20);
        textField.setFont(Standards.myFont);
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        panelSouth.add(enterButton);
        panelSouth.add(exitButton);
        panelCenter.add(textField);
        welcomeFrame.getContentPane().add(panelCenter,BorderLayout.CENTER);
        welcomeFrame.getContentPane().add(panelSouth,BorderLayout.SOUTH);
        welcomeFrame.getContentPane().add(panelNorth,BorderLayout.NORTH);
        welcomeFrame.getContentPane().add(panelEast,BorderLayout.EAST);
        welcomeFrame.getContentPane().add(panelWest,BorderLayout.WEST);

    }

    public String getUserName(){
        return nameUser;
    }
    public void setVisibility(boolean visibility){
        welcomeFrame.setVisible(visibility);
    }


    public Point getPosition(){
        return welcomeFrame.getLocation();
    }
    public boolean isVisible(){
        return welcomeFrame.isVisible();
    }
}
