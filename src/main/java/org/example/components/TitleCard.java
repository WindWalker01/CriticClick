package org.example.components;

import org.example.components.primitives.WebImage;

import javax.swing.*;
import java.awt.*;

public class TitleCard extends JPanel {

    public WebImage poster;
    public JLabel title;
    public JLabel year;

    public TitleCard() {
        setLayout(null);

        setSize(154,265);

        poster = new WebImage("https://image.tmdb.org/t/p/w154/yh64qw9mgXBvlaWDi7Q9tpUBAvH.jpg");
        poster.setBounds(5, 5, 154, 231);

        title = new JLabel("Title");
        title.setBounds(5 ,poster.getHeight() + 5, getWidth(), 16);
        title.setBackground(Color.white);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setHorizontalTextPosition(SwingConstants.CENTER);

        year = new JLabel("Year");
        year.setBounds(5 ,252, getWidth(), 16);
        year.setHorizontalAlignment(SwingConstants.CENTER);

        add(poster);
        add(title);
        add(year);
    }


}
