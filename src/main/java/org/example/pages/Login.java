package org.example.pages;

import org.example.CriticWindow;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Login extends CriticPage {

    private JLabel banner;
    private CriticWindow window;
    private JLabel emailTitle;
    private JTextField emailField;
    private JLabel privacyNotice;
    private JLabel passwordTitle;
    private JPasswordField passwordField;
    private JButton backButton;
    private JButton loginButton;

    public Login(CriticWindow window){
        this.window = window;
        banner = new JLabel(new ImageIcon("src/main/resources/Banner.png"));
        banner.setBounds(0,  0,432,719);

        emailTitle = new JLabel("Email");
        emailTitle.setSize(200, 12);
        emailTitle.setLocation(564, 212);
        emailTitle.setFont(new Font("Arial", Font.BOLD, 14));


        emailField = new JTextField();
        emailField.setLocation(564, 228);
        emailField.setSize(520, 50);
        emailField.setFont(new Font("Arial", Font.PLAIN, 14));
        emailField.setBackground(LIGHT_BEIGE);
        emailField.setBorder(new LineBorder(Color.black));

        privacyNotice = new JLabel("We'll never share your email and password with anyone else... or is it?");
        privacyNotice.setSize(403, 12);
        privacyNotice.setLocation(565, 282);
        privacyNotice.setFont(new Font("Arial", Font.PLAIN, 12));
        privacyNotice.setForeground(new Color(0x72706D));

        passwordTitle = new JLabel("Password");
        passwordTitle.setSize(200, 12);
        passwordTitle.setLocation(564, 323);
        passwordTitle.setFont(new Font("Arial", Font.BOLD, 14));

        passwordField = new JPasswordField();
        passwordField.setSize(520, 50);
        passwordField.setLocation(564, 338);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField.setBackground(LIGHT_BEIGE);
        passwordField.setBorder(new LineBorder(Color.black));

        backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.setBounds(576, 408, 240, 50);
        backButton.setBackground(LIGHT_BEIGE);
        backButton.setForeground(new Color(121, 87,87));
        backButton.setBorder(new LineBorder(new Color(121, 87, 87), 2));
        backButton.setFocusable(false);

        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginButton.setBounds(828, 408, 240, 50);
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(new Color(121, 87, 87));
        loginButton.setFocusable(false);


        add(banner);
        add(emailTitle);
        add(emailField);
        add(privacyNotice);
        add(passwordTitle);
        add(passwordField);
        add(loginButton);
        add(backButton);
    }
}
