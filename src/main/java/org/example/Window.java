package org.example;

import org.example.components.TitleCard;
import org.example.dsa.HashMapngGroup1;

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

//        addPage(Page.Home, new TitleCard());
    }


    public void addPage(Page type, JPanel panel){
        pages.set(type, panel);
        add(panel);
    }



    public void changePage(){
        for (HashMapngGroup1.Node<Page, JPanel> set : pages.entrySet()){
            if(set.key == currentPage){
                set.value.setVisible(true);
            }else{
                set.value.setVisible(false);
            }
        }
    }
}
