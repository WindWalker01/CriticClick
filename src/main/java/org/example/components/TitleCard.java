package org.example.components;

import org.example.components.primitives.WebImage;

import javax.swing.*;
import java.awt.*;

public class TitleCard extends JPanel {

    public WebImage poster;
    public JLabel title;
    public JLabel year;

    public TitleCard() {
        FlowLayout layout = new FlowLayout();
        setLayout(layout);

        // this is by no means no magic numbers
        // I measured this in figma
        setSize(new Dimension(154, 265));

        poster = new WebImage("https://image.tmdb.org/t/p/w154/yh64qw9mgXBvlaWDi7Q9tpUBAvH.jpg");

        title = new JLabel("Title");
        title.setSize(154, getHeight());
        title.setBackground(Color.red);
        year = new JLabel("Year");
        year.setSize(154, getHeight());
        year.setBackground(Color.yellow);


        add(poster);
        add(title);
        add(year);
    }


}
