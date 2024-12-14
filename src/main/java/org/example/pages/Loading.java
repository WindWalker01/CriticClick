package org.example.pages;
import org.example.CriticWindow;
import org.example.Page;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Loading extends CriticPage implements ActionListener {
    public JLabel loading;

    public Loading(CriticWindow window) {

        loading  = new JLabel(new ImageIcon("src/main/resources/loading.gif"));
        loading.setBounds(530,  180,200,300);
        add(loading);


        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.changePage(Page.Home);
            }
        });
        timer.setRepeats(false);
        timer.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
