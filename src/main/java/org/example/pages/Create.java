package org.example.pages;
import org.example.CriticWindow;
import org.example.Page;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class Create extends CriticPage implements ActionListener {
    private JLabel banner;
    private JLabel createTitle;
    private CriticWindow window;
    private JLabel emailTitle;
    private JTextField emailField;
    private JLabel privacyNotice;
    private JLabel passwordTitle;
    private JPasswordField passwordField;
    private JButton back;
    private JButton started;

    public Create(CriticWindow window) {
        this.window = window;
        banner = new JLabel(new ImageIcon("src/main/resources/Banner.png"));
        banner.setBounds(835,  0,432,719);

        back = new JButton("Back");
        back.setFont(new Font("Arial", Font.BOLD, 14));
        back.setBounds(150, 430, 260, 50);
        back.setBackground(new Color(229, 225, 218));
        back.setForeground(new Color(121, 87,87));
        back.setBorder(new LineBorder(new Color(121, 87, 87), 2));
        back.addActionListener( this);
        back.setFocusable(false);

        started = new JButton("Get Started");
        started.setFont(new Font("Arial", Font.BOLD, 14));
        started.setBounds(450, 430, 260, 50);
        started.setForeground(Color.WHITE);
        started.setBackground(new Color(121, 87, 87));
        started.addActionListener( this);
        started.setFocusable(false);

        emailTitle = new JLabel("Email");
        emailTitle.setSize(200, 12);
        emailTitle.setLocation(150, 212);
        emailTitle.setFont(new Font("Arial", Font.BOLD, 14));

        emailField = new JTextField(" Enter your email");
        emailField.setLocation(150, 228);
        emailField.setSize(560, 50);
        emailField.setFont(new Font("Arial", Font.PLAIN, 14));
        emailField.setBackground(LIGHT_BEIGE);
        emailField.setBorder(new LineBorder(Color.black));
        emailField.setForeground(Color.GRAY);

        passwordField = new JPasswordField(" Enter your password");
        passwordField.setSize(560, 50);
        passwordField.setLocation(150, 338);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField.setBackground(LIGHT_BEIGE);
        passwordField.setBorder(new LineBorder(Color.black));
        passwordField.setForeground(Color.GRAY);
        passwordField.setEchoChar((char) 0);

        createTitle = new JLabel("Create Account");
        createTitle.setSize(453, 100);
        createTitle.setLocation(260, 120);
        createTitle.setFont(new Font("Arial", Font.BOLD, 40));


        privacyNotice = new JLabel("We'll never share your email and password with anyone else... or is it?");
        privacyNotice.setSize(403, 12);
        privacyNotice.setLocation(150, 282);
        privacyNotice.setFont(new Font("Arial", Font.PLAIN, 12));
        privacyNotice.setForeground(new Color(0x72706D));

        passwordTitle = new JLabel("Password");
        passwordTitle.setSize(150, 12);
        passwordTitle.setLocation(150, 323);
        passwordTitle.setFont(new Font("Arial", Font.BOLD, 14));

        emailField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (emailField.getText().equals(" Enter your email")) {
                    emailField.setText("");
                    emailField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (emailField.getText().isEmpty()) {
                    emailField.setText(" Enter your email");
                    emailField.setForeground(Color.GRAY);
                }
            }
        });

        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(passwordField.getPassword()).equals(" Enter your password")) {
                    passwordField.setText("");
                    passwordField.setEchoChar('*');
                    passwordField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(passwordField.getPassword()).isEmpty()) {
                    passwordField.setEchoChar((char) 0);
                    passwordField.setText(" Enter your password");
                    passwordField.setForeground(Color.GRAY);
                }
            }
        });

        add(banner);
        add(emailField);
        add(passwordField);
        add(emailTitle);
        add(createTitle);
        add(privacyNotice);
        add(passwordTitle);
        add(started);
        add(back);


        // TODO: remove this shit later this is for debugging purposes only
//        addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                window.changePage(Page.Loading);
//            }
//        });

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            window.changePage(Page.MainPage);
        } else if (e.getSource() == started) {
            String email = emailField.getText();
            String password = String.valueOf(passwordField.getPassword());
            // Handle login logic here
            if (email.isEmpty() || password.isEmpty() || email.equals(" Enter your email") || password.equals(" Enter your password")) {

            } else {
                window.changePage(Page.Loading);
            }
        }
    }
}
