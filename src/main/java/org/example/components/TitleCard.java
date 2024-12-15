package org.example.components;

import org.example.CriticWindow;
import org.example.Page;
import org.example.components.primitives.WebImage;
import org.example.data.Movie;
import org.example.data.StateManager;

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

    public TitleCard(Movie movie, CriticWindow window) {
        this.window = window;
        movieData = movie;
        setLayout(null);
        setSize(154,265);
        setBackground(CriticWindow.LIGHT_BEIGE);

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

        if(movie.posterPath != "null"){
            poster = new WebImage("https://image.tmdb.org/t/p/w154" + movie.posterPath);
            poster.setBounds(5, 5, 154, 231);
            add(poster);
        }else{
            JLabel defaultImage = new JLabel(new ImageIcon("src/main/resources/defaultPoster-small.png"));
            defaultImage.setBounds(5, 5, 154, 231);
            add(defaultImage);
        }

        title = new JLabel(movie.title);
        title.setBounds(5 ,236, getWidth(), 16);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setHorizontalTextPosition(SwingConstants.CENTER);

        year = new JLabel(movie.year.substring(0, 4));
        year.setBounds(5 ,252, getWidth(), 16);
        year.setHorizontalAlignment(SwingConstants.CENTER);

        add(title);
        add(year);
    }
}