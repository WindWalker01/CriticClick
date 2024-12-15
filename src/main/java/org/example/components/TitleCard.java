package org.example.components;

import org.example.CriticWindow;
import org.example.Page;
import org.example.components.primitives.WebImage;
import org.example.data.Movie;
import org.example.data.StateManager;
import org.example.pages.CriticPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TitleCard extends JPanel {

    public WebImage poster;
    public JLabel title;
    public JLabel year;
    private CriticWindow window;
    private Movie movieData;
    CriticPage criticPage;

    public TitleCard(Movie movie, CriticWindow window) {
        this.window = window;
        movieData = movie;
        setLayout(null);
        setSize(154,265);
        setBackground(CriticPage.LIGHT_BEIGE);

        addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                StateManager.currentMoviePoster = movieData;
                window.changePage(Page.Poster);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });

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