package org.example;

import javax.swing.*;

public class Window extends JFrame {

    private final int WINDOW_WIDTH = 1280;
    private final int WINDOW_HEIGHT = 720;

    public Window(){
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("CriticClick");
    }
}
