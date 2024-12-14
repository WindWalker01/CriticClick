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

public class MainPage extends CriticPage implements ActionListener {

    public JButton createButton;
    public JButton signButton;
    public JLabel CriticLogo;
    public JLabel CriticTitle;
    public JLabel CriticSubTitle;
 //   public boolean signButton = false;
 //   public boolean createAcc = false;
    public CriticWindow window;


    public MainPage(CriticWindow window) {
    this.window = window;
        createButton = new JButton("Create Account");
        createButton.setFont(new Font("Arial", Font.BOLD, 14));
        createButton.setBounds(350, 430, 260, 50);
        createButton.setBackground(new Color(229, 225, 218));
        createButton.setForeground(new Color(121, 87,87));
        createButton.setBorder(new LineBorder(new Color(121, 87, 87), 2));
        createButton.addActionListener( this);
        createButton.setFocusable(false);

        signButton = new JButton("Sign In");
        signButton.setFont(new Font("Arial", Font.BOLD, 14));
        signButton.setBounds(650, 430, 260, 50);
        signButton.setForeground(Color.WHITE);
        signButton.setBackground(new Color(121, 87, 87));
        signButton.addActionListener( this);
        signButton.setFocusable(false);

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

        // pang test lang
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                window.changePage(Page.Create);
            }
        });
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createButton) {
            window.changePage(Page.Create);
        }
        if (e.getSource() == signButton) {
            window.changePage(Page.Home);
        }
    }
}
