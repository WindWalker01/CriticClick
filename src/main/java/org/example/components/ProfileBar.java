package org.example.components;


import javax.swing.*;
import java.awt.*;

public class ProfileBar extends JPanel {


    private JLabel title;
    private JLabel user;



    public ProfileBar() {
        setBackground(new Color(0x756565));
        setLayout(null);
        setSize(new Dimension(1280, 200));


        title = new JLabel("Juan Dela Cruz");
        user = new JLabel(new ImageIcon("src/main/resources/big-Avatar.png"));

        title.setBounds(new Rectangle(200, 66, 300, 64));
        title.setFont(new Font("Arial", Font.BOLD, 36));

        user.setBounds(10, 0, 200, 200);




        add(title);
        add(user);

    }

}
