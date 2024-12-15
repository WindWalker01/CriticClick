package org.example.pages;

import org.example.CriticWindow;
import org.example.Page;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Login extends CriticPage implements ActionListener {
    private JLabel banner;
    private CriticWindow window;
    private JLabel emailTitle;
    private JTextField emailField;
    private JLabel privacyNotice;
    private JLabel passwordTitle;
    private JPasswordField passwordField;
    private JButton backButton;
    private JButton loginButton;

    public Login(CriticWindow window) {
        this.window = window;

        banner = new JLabel(new ImageIcon("src/main/resources/Banner.png"));
        banner.setBounds(0, 0, 432, 719);

        emailTitle = new JLabel("Email");
        emailTitle.setSize(200, 12);
        emailTitle.setLocation(564, 212);
        emailTitle.setFont(new Font("Arial", Font.BOLD, 14));

        emailField = new JTextField("Enter your email");
        emailField.setLocation(564, 228);
        emailField.setSize(520, 50);
        emailField.setFont(new Font("Arial", Font.PLAIN, 14));
        emailField.setBackground(LIGHT_BEIGE);
        emailField.setBorder(new LineBorder(Color.black));
        emailField.setForeground(Color.GRAY);

        // Add focus listener for placeholder functionality in emailField
        emailField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (emailField.getText().equals("Enter your email")) {
                    emailField.setText("");
                    emailField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (emailField.getText().isEmpty()) {
                    emailField.setText("Enter your email");
                    emailField.setForeground(Color.GRAY);
                }
            }
        });

        privacyNotice = new JLabel("We'll never share your email and password with anyone else... or is it?");
        privacyNotice.setSize(403, 12);
        privacyNotice.setLocation(565, 282);
        privacyNotice.setFont(new Font("Arial", Font.PLAIN, 12));
        privacyNotice.setForeground(new Color(0x72706D));

        passwordTitle = new JLabel("Password");
        passwordTitle.setSize(200, 12);
        passwordTitle.setLocation(564, 323);
        passwordTitle.setFont(new Font("Arial", Font.BOLD, 14));

        passwordField = new JPasswordField("Enter your password");
        passwordField.setSize(520, 50);
        passwordField.setLocation(564, 338);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField.setBackground(LIGHT_BEIGE);
        passwordField.setBorder(new LineBorder(Color.black));
        passwordField.setForeground(Color.GRAY);
        passwordField.setEchoChar((char) 0);

        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(passwordField.getPassword()).equals("Enter your password")) {
                    passwordField.setText("");
                    passwordField.setEchoChar('*');
                    passwordField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(passwordField.getPassword()).isEmpty()) {
                    passwordField.setEchoChar((char) 0);
                    passwordField.setText("Enter your password");
                    passwordField.setForeground(Color.GRAY);
                }
            }
        });

        backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.setBounds(576, 408, 240, 50);
        backButton.setBackground(LIGHT_BEIGE);
        backButton.setForeground(new Color(121, 87, 87));
        backButton.setBorder(new LineBorder(new Color(121, 87, 87), 2));
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginButton.setBounds(828, 408, 240, 50);
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(new Color(121, 87, 87));
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        add(banner);
        add(emailTitle);
        add(emailField);
        add(privacyNotice);
        add(passwordTitle);
        add(passwordField);
        add(loginButton);
        add(backButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            window.changePage(Page.MainPage);
        } else if (e.getSource() == loginButton) {
            String email = emailField.getText();
            String password = String.valueOf(passwordField.getPassword());
            // Handle login logic here
            if (email.isEmpty() || password.isEmpty() || email.equals("Enter your email") || password.equals("Enter your password")) {

            } else {
               window.changePage(Page.Loading);
            }
        }
    }
}
