package org.example;

import org.example.components.TitleBar;
import org.example.dsa.HashMapngGroup1;
import org.example.pages.*;

import javax.swing.*;
import java.awt.*;

public class CriticWindow extends JFrame {
    //bg color
    public static final Color LIGHT_BEIGE = new Color(229, 225, 218);
    private final int WINDOW_WIDTH = 1280;
    private final int WINDOW_HEIGHT = 720;
    private TitleBar titleBar;

    private HashMapngGroup1<Page, CriticPage> pages = new HashMapngGroup1();

    public CriticWindow(){
        setLayout(null);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("CriticClick");
        setResizable(false);

        titleBar = new TitleBar();
        titleBar.setWindow(this); // Pass CriticWindow reference to TitleBar
        add(titleBar, BorderLayout.NORTH);

        addPage(Page.Home, new Home(this));
        addPage(Page.Create, new Create(this));
        addPage(Page.MainPage, new MainPage(this));
        addPage(Page.Profile, new Profile(this));

        changePage(Page.Home);

    }


    public void addPage(Page type, CriticPage panel){
        pages.set(type, panel);
        panel.setVisible(false);
        add(panel);
    }



    public void changePage(Page desiredPage){
        if(desiredPage == Page.MainPage){
            remove(titleBar);
        }

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
