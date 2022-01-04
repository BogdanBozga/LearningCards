package com.gui;

import com.fun.Card;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LearnCardsWindow {
    JFrame learnCardFrame;
    JPanel frontLearnPanel;
    JPanel backLearnPanel;
    JPanel buttonsPanel;
    JTextField frontTextInfo;
    JTextField backTextInfo;
    ImageIcon frontImageInfo;
    ImageIcon backImageInfo;
    JTextField questionJTextField;
    JTextField answerJTextField;
    int currentCardID;


    LearnCardsWindow(){
        learnCardFrame = new JFrame("Learning Cards");
        learnCardFrame.setSize(Standards.width*2,Standards.height*2);
        learnCardFrame.setLayout(new BorderLayout());
        learnCardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        questionJTextField = new JTextField();
        answerJTextField = new JTextField();

        frontLearnPanel = new JPanel();
        backLearnPanel = new JPanel();
        buttonsPanel = new JPanel();

        JButton showAnswerButton = new JButton("Show answer");
        showAnswerButton.setFont(Standards.myFont);
        showAnswerButton.setSize(25,25);
        showAnswerButton.setFocusable(false);
        showAnswerButton.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        backLearnPanel.setVisible(true);
                        Main.connectionDB.increaseReadingCount(currentCardID);
                        showAnswerButton.setVisible(false);
                    } });

        JButton nextButton = new JButton("Next");
        nextButton.setFont(Standards.myFont);
        nextButton.setSize(25,25);
        nextButton.setFocusable(false);
        nextButton.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        Main.learnWindow.startLearning();
                    } });
        JButton doneButton = new JButton("Done");
        doneButton.setFont(Standards.myFont);
        doneButton.setSize(25,25);
        doneButton.setFocusable(false);
        doneButton.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {

                        Main.learnCardWindow.dispose();
                        Main.learnWindow.setVisibility(true);
                    } });

        buttonsPanel.add(showAnswerButton);
        buttonsPanel.add(nextButton);
        buttonsPanel.add(doneButton);
    }


    LearnCardsWindow(Card card){
        this();
        currentCardID = card.getCardID();

        frontTextInfo = new JTextField(card.getFrontInfo().getTextInfo());
        frontTextInfo.setEditable(false);
        frontTextInfo.setFont(Standards.myFont);
        frontImageInfo = new ImageIcon(card.getFrontInfo().getImageInfo());

        backTextInfo = new JTextField(card.getBackInfo().getTextInfo());
        backTextInfo.setEditable(false);
        backTextInfo.setFont(Standards.myFont);
        backImageInfo = new ImageIcon(card.getBackInfo().getImageInfo());

        frontLearnPanel = new JPanel(new GridLayout(1,2));
        JLabel frontImage = new JLabel();
        frontImage.setIcon(frontImageInfo);
        frontLearnPanel.add(frontTextInfo);
        frontLearnPanel.add(frontImage);

        backLearnPanel = new JPanel(new GridLayout(1,2));
        backLearnPanel.add(backTextInfo);
        JLabel leftImage = new JLabel();
        leftImage.setIcon(backImageInfo);
        backLearnPanel.add(leftImage);

        JPanel wrapper  = new JPanel();
        wrapper.setLayout(new GridLayout(2,1));
        wrapper.add(frontLearnPanel);
        backLearnPanel.setVisible(false);
        wrapper.add(backLearnPanel);

        JTextField currentLearn = new JTextField();
        currentLearn.setFont(Standards.myFont);
        currentLearn.setEditable(false);
        currentLearn.setHorizontalAlignment(SwingConstants.CENTER);

        currentLearn.setText(String.valueOf(Main.learnWindow.currentIndex + " of " + Main.learnWindow.lastIndex));
        learnCardFrame.add(currentLearn,BorderLayout.NORTH);
        learnCardFrame.add(wrapper,BorderLayout.CENTER);
//        buttonsPanel.setPreferredSize(new Dimension(Standards.width,15));
        learnCardFrame.add(buttonsPanel,BorderLayout.SOUTH);
    }
    void setVisible(boolean b){
        learnCardFrame.setLocation(Main.learnWindow.getPosition());
        learnCardFrame.setVisible(b);
    }

    void dispose(){
        learnCardFrame.dispose();
    }




//    import java.awt.*;
//import javax.swing.*;
//import java.io.*;
//import java.awt.image.BufferedImage;
//import javax.imageio.ImageIO;
//    public class ImagePanel
//    {
//        ImagePanel()
//        {
//            try
//            {
//                JFrame f = new JFrame("Add an Image to a JPanel");
//                JPanel panel = new JPanel();
//                panel.setBounds(50, 50, 250, 250);
//                BufferedImage img = ImageIO.read(new File("test.png"));
//                JLabel pic = new JLabel(new ImageIcon(img));
//                panel.add(pic);
//                f.add(panel);
//                f.setSize(400, 400);
//                f.setLayout(null);
//                f.setVisible(true);
//            }
//            catch (IOException e) {}
//        }
//        public static void main(String args[])
//        {
//            new ImagePanel();
//        }
//    }
}
