package com.lius.work.view;

import javax.swing.*;
import java.awt.*;

public class AppView {
    private JPanel rootPanel;
    private JList list1;

    public static void main(String[] args) {
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        JFrame frame = new JFrame("AppView");
        frame.setContentPane(new AppView().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
