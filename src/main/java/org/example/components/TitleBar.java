package org.example.components;

import org.example.CriticWindow;
import org.example.Page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TitleBar extends JPanel {

    private JLabel logo;
    private JLabel title;
    private JLabel user;
    public CriticWindow window;


    public TitleBar(CriticWindow window) {
        this.window = window;

        setBackground(new Color(0x756565));
        setLayout(null);
        setSize(new Dimension(1280, 64));

        logo = new JLabel(new ImageIcon("src/main/resources/small-icon.png"));
        logo.setBounds(new Rectangle(26, 0, 64, 64));
        title = new JLabel("CriticClick");
        user = new JLabel(new ImageIcon("src/main/resources/small-Avatar.png"));

        title.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                window.changePage(Page.Home);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                title.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });

        logo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                window.changePage(Page.Home);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                logo.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });


       user.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                window.changePage(Page.Profile);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                user.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });

        title.setBounds(new Rectangle(99, 0, 200, 64));
        title.setFont(new Font("Arial", Font.BOLD, 32));

        user.setBounds(1166, 16, 32, 32);


        add(logo);
        add(title);
        add(user);

        System.out.println(logo.getLocation());

    }

    public void setWindow(CriticWindow window) {
        this.window = window;
    }
}