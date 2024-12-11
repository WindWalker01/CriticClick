package org.example.pages;

import org.example.CriticWindow;
import org.example.Page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Create extends CriticPage {

    public Create(CriticWindow window) {
        setBackground(new Color(0x6495ED));


        // TODO: remove this shit later this is for debugging purposes only
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                window.changePage(Page.Home);
            }
        });

    }
}
