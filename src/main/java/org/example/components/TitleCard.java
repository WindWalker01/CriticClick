package org.example.components;

import org.example.CriticWindow;
import org.example.components.primitives.WebImage;
import org.example.data.Movie;
import org.example.pages.CriticPage;

import javax.swing.*;
import java.awt.*;

public class TitleCard extends JPanel {

    public WebImage poster;
    public JLabel title;
    public JLabel year;

    public TitleCard(Movie movie) {
        setLayout(null);
        setSize(154,265);
        setBackground(CriticPage.LIGHT_BEIGE);

        poster = new WebImage("https://image.tmdb.org/t/p/w154" + movie.posterPath);
        poster.setBounds(5, 5, 154, 231);


        title = new JLabel(movie.title);
        title.setBounds(5 ,poster.getHeight() + 5, getWidth(), 16);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setHorizontalTextPosition(SwingConstants.CENTER);

        year = new JLabel(movie.year.substring(0, 4));
        year.setBounds(5 ,252, getWidth(), 16);
        year.setHorizontalAlignment(SwingConstants.CENTER);

        add(poster);
        add(title);
        add(year);
    }


}
