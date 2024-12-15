package org.example.components;

import org.example.CriticWindow;
import org.example.Page;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitleBar extends JPanel implements ActionListener {

    private JLabel logo;
    private JLabel title;
    private JLabel user;
    private JButton Home, Profile;
    public CriticWindow window;


    public TitleBar(CriticWindow window) {
        this.window = window;

        setBackground(new Color(0x756565));
        setLayout(null);
        setSize(new Dimension(1280, 64));

        logo = new JLabel(new ImageIcon("src/main/resources/small-icon.png"));
        title = new JLabel("CriticClick");
        user = new JLabel(new ImageIcon("src/main/resources/small-Avatar.png"));

        logo.setBounds(new Rectangle(26, 0, 64, 64));

        title.setBounds(new Rectangle(99, 0, 200, 64));
        title.setFont(new Font("Arial", Font.BOLD, 32));

        user.setBounds(1166, 16, 32, 32);

        Home = new JButton("Poster");
        Home.setBackground(new Color(0x756565));
        Home.setFocusPainted(false);
        Home.setForeground(Color.white);
        Home.setBorder(new LineBorder(new Color(0x756565)));
        Home.setBounds(1000, 17 ,100,30);
        Home.addActionListener(this);


        Profile = new JButton("Profile");
        Profile.setBackground(new Color(0x756565));
        Profile.setFocusPainted(false);
        Profile.setForeground(Color.white);
        Profile.setBorder(new LineBorder(new Color(0x756565)));
        Profile.setBounds(900, 17 ,100,30);
        Profile.addActionListener(this);

        add(Home);
        add(Profile);
        add(logo);
        add(title);
        add(user);

        System.out.println(logo.getLocation());

    }

    public void setWindow(CriticWindow window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == Home){
            window.changePage(Page.Home);
        }
        if(e.getSource() == Profile){
            window.changePage(Page.Profile);
        }
    }
}