package com.gui;

import javax.swing.*;

public class Windows {
    JFrame allFrameCombine;
    Windows(){
        allFrameCombine = new JFrame();
        allFrameCombine.add(LearnWindow.getFrame());
        allFrameCombine.add(MainWindow.getFrame());
        allFrameCombine.add(EditWindow.getFrame());
        allFrameCombine.add(DeckWindow.getFrame());
    }
    static void setVisibility(boolean visibility){
        MainWindow.getFrame().setVisible(visibility);
    }
}
