package org.example.pages;

import org.example.CriticWindow;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends CriticPage implements ActionListener {

    public JButton createButton;
    public JButton signButton;
    public JLabel CriticLogo;
    public JLabel CriticTitle;
    public JLabel CriticSubTitle;
    public boolean signIn = false;
    public boolean createAcc = false;



    public MainPage(CriticWindow window) {

        signButton = new JButton("Sign in");
        signButton.setFont(new Font("Arial", Font.BOLD, 14));
        signButton.setBounds(350, 430, 260, 50);
        signButton.setBackground(new Color(229, 225, 218));
        signButton.setForeground(new Color(121, 87,87));
        signButton.setBorder(new LineBorder(new Color(121, 87, 87), 2));
        signButton.addActionListener( this);

        createButton = new JButton("Create Account");
        createButton.setFont(new Font("Arial", Font.BOLD, 14));
        createButton.setBounds(650, 430, 260, 50);
        createButton.setForeground(Color.WHITE);
        createButton.setBackground(new Color(121, 87, 87));
        createButton.addActionListener( this);

        CriticLogo = new JLabel(new ImageIcon("src/main/resources/CRITIC_CLICK_logo.png"));
        CriticLogo.setBounds(530,  10,200,300);

        CriticTitle = new JLabel("Welcome to CriticClick");
        CriticTitle.setFont(new Font("Sans Serif", Font.BOLD, 50));
        CriticTitle.setForeground(Color.BLACK);
        CriticTitle.setBounds(360, 210, 1000, 200);

        CriticSubTitle = new JLabel("Start your journey with personalized movie picks, based on your ratings and favorite genres!");
        CriticSubTitle.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        CriticSubTitle.setForeground(Color.BLACK);
        CriticSubTitle.setBounds(260, 280, 1000, 200);

        add(CriticLogo);
        add(CriticTitle);
        add(CriticSubTitle);
        add(createButton);
        add(signButton);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == signButton){
//            signIn = true;
//            System.out.println("login "+signIn);
//        }
//        if (e.getSource() == createButton){
//            createAcc = true;
//            System.out.println("create "+createAcc);
//        }
    }
}
