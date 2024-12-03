package org.example;

import org.example.components.CriticPanel;
import org.example.pages.Page;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Window extends JFrame {


    // TODO: Implement our own hashmap and hashing method
    private static HashMap<Page, CriticPanel> pages = new HashMap<Page, CriticPanel>();
    private Page currentPage;


    public Window(){
        setSize(1280, 720);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setTitle("CriticClick");
        setLocationRelativeTo(null);

        currentPage = Page.Main;
        changePage(currentPage);
    }


    //TODO: If the custom hashmap is implement this thing will break so make sure to refactor it
    public static void changePage(Page desiredPage){
       for(Map.Entry<Page, CriticPanel> set : pages.entrySet()){
            if(set.getKey() == desiredPage){
                set.getValue().setVisible(true);
            }else{
                set.getValue().setVisible(false);

            }
       }
    }


}
