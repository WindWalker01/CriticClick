package org.example.components;

import org.example.CriticWindow;
import org.example.data.Movie;
import org.example.pages.CriticPage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MovieTitleHolder extends JPanel {

    private CriticWindow window;

    public MovieTitleHolder(ArrayList<Movie> movies, int limit, CriticWindow window) {
        this.window = window;
        setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
        setSize(900, 265);
        setPreferredSize(new Dimension(900, 265));

        for (int j = 0; j < limit; j++) {
            TitleCard titleCard = new TitleCard(movies.get(j),window );
            titleCard.setPreferredSize(new Dimension(150, 300));
            add(titleCard);
            setBackground(CriticPage.LIGHT_BEIGE);
        }

    }

    public void updateTitleCards(ArrayList<Movie> movies){
        removeAll();

        for (Movie movie : movies) {
            TitleCard titleCard = new TitleCard(movie, window);
            titleCard.setPreferredSize(new Dimension(150, 300));
            add(titleCard);
            setBackground(CriticPage.LIGHT_BEIGE);
        }

        repaint();
    }

}
