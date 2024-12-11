package org.example;

import org.example.dsa.HashMapngGroup1;
import org.example.pages.Home;

import javax.swing.*;

public class Window extends JFrame {

    private final int WINDOW_WIDTH = 1280;
    private final int WINDOW_HEIGHT = 720;

    private HashMapngGroup1<Page, JPanel> pages = new HashMapngGroup1();
    public Page currentPage = Page.Home;


    public Window(){
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("CriticClick");
        setResizable(false);

        addPage(Page.Home, new Home());

        changePage(currentPage);
    }


    public void addPage(Page type, JPanel panel){
        panel.setVisible(false);
        add(panel);
        pages.set(type, panel);
    }



    public void changePage(Page desiredPage){
        for (HashMapngGroup1.Node<Page, JPanel> set : pages.entrySet()){
            if(set.key == desiredPage){
                set.value.setVisible(true);
            }else{
                set.value.setVisible(false);
            }
        }
    }
}
