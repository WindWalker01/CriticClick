package org.example;

import org.example.dsa.HashMapngGroup1;
import org.example.pages.Create;
import org.example.pages.CriticPage;
import org.example.pages.Home;
import org.example.pages.LogPage;

import javax.swing.*;

public class CriticWindow extends JFrame {

    private final int WINDOW_WIDTH = 1280;
    private final int WINDOW_HEIGHT = 720;

    private HashMapngGroup1<Page, CriticPage> pages = new HashMapngGroup1();

    public CriticWindow(){
        setLayout(null);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("CriticClick");
        setResizable(false);

        addPage(Page.Home, new Home(this));
        addPage(Page.Create, new Create(this));
        addPage(Page.LogPage, new LogPage(this));

        changePage(Page.LogPage);




    }


    public void addPage(Page type, CriticPage panel){
        pages.set(type, panel);
        panel.setVisible(false);
        add(panel);
    }



    public void changePage(Page desiredPage){
        for (HashMapngGroup1.Node<Page, CriticPage> set : pages.entrySet()){
            if(set.key == desiredPage){
                set.value.setVisible(true);
                System.out.println("hello");
            }else{
                set.value.setVisible(false);
            }
        }
    }
}
