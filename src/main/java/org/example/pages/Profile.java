package org.example.pages;

import org.example.CriticWindow;
import org.example.Page;
import org.example.components.ProfileBar;
import org.example.components.TitleBar;
import org.example.data.UserData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Profile extends CriticPage implements ActionListener {

    private JButton Logout, Back;
    private JLabel Stats;
    private CriticWindow window;
    private ProfileBar profileBar;

    public Profile(CriticWindow window) {
        this.window = window;

        profileBar = new ProfileBar();
        profileBar.setBounds(0, 100,1500, 200);
        profileBar.setBackground(new Color(144, 129, 129));

        Logout = new JButton("Log Out");
        Logout.setBounds(1100, 180, 76, 35);
        Logout.setFont(new Font("Arial", Font.BOLD, 10));
        Logout.setForeground(Color.WHITE);
        Logout.setBackground(Color.BLACK);
        Logout.setFocusable(false);
        Logout.addActionListener(this);

        Back = new JButton("Back");
        Back.setBounds(1100, 600, 76, 35);
        Back.setFont(new Font("Arial", Font.BOLD, 10));
        Back.setForeground(Color.WHITE);
        Back.setBackground(Color.BLACK);
        Back.setFocusable(false);
        Back.addActionListener(this);

        Stats = new JLabel("<html>You spent 123 minutes watching<br>&nbsp;and rated 123 movies this year.</html>");
        Stats.setForeground(Color.BLACK);
        Stats.setFont(new Font("Arial", Font.BOLD, 50));
        Stats.setBounds(250,200,1000,500);


        add(Stats);
        add(Back);
        add(Logout);
        add(profileBar);
        add(new TitleBar(window));
    }


    @Override
    public void reloadPage() {
        profileBar.title.setText(UserData.currentUser.getUsername() == null ? "" : UserData.currentUser.getUsername().toUpperCase());
        Stats.setText("<html>You spent approximately " +  UserData.currentUser.getMovies().size() * 120 + " minutes watching<br>&nbsp;and rated " + UserData.currentUser.getMovies().size() + " movies this year.</html>");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == Back) {
            window.changePage(Page.Home);
        }else if(e.getSource() == Logout) {
            UserData.allUsers.add(UserData.currentUser);
            UserData.saveUsersToJson(UserData.allUsers);
            window.changePage(Page.MainPage);
        }

    }
}
