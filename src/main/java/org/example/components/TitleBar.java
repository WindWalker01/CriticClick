package org.example.components;

import javax.swing.*;
import java.awt.*;

public class TitleBar extends JPanel {

    private JLabel logo;
    private JLabel title;
    private JLabel user;



    public TitleBar() {
        setBackground(new Color(0x756565));
        setLayout(null);
        setSize(new Dimension(1280, 64));

        logo = new JLabel(new ImageIcon("src/main/resources/small-icon.png"));
        title = new JLabel("CriticClick");
        user = new JLabel(new ImageIcon("src/main/resources/small-Avatar.png"));

        logo.setBounds(new Rectangle(26, 0, 64, 64));

        title.setBounds(new Rectangle(99, 0, 161, 64));
        title.setFont(new Font("Arial", Font.BOLD, 32));

        user.setBounds(1166, 16, 32, 32);

        add(logo);
        add(title);
        add(user);

        System.out.println(logo.getLocation());

    }

}
