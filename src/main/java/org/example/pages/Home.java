package org.example.pages;

import org.example.CriticWindow;
import org.example.Page;
import org.example.components.MovieTitleHolder;
import org.example.components.TitleBar;
import org.example.data.MovieRequest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends CriticPage {
    private final JTextField search;
    public JScrollPane scrollPane;

    public Home(CriticWindow window) {

        JLabel findFilm = new JLabel("FIND A FILM");
        findFilm.setBounds(865,100,100,100);
        findFilm.setFont(new Font("Arial", Font.BOLD, 16));

        search = new JTextField("Search");
        search.setBounds(933, 136, 200, 55);
        search.setPreferredSize(new Dimension(280, 40));
        search.setFont(new Font("Arial", Font.BOLD, 14));
        search.setEditable(true);
        search.setBackground(Color.WHITE);
        search.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                search.selectAll();
            }
        });

        JLabel popularFilms = new JLabel("POPULAR FILMS THIS WEEK");
        popularFilms.setBounds(50,0,300,100);
        popularFilms.setFont(new Font("Arial", Font.BOLD, 15));

        JLabel moreFilms = new JLabel("MORE");
        moreFilms.setBounds(140,0,100,100);
        moreFilms.setFont(new Font("Arial", Font.BOLD, 15));

      MovieTitleHolder popularThisWeek = new MovieTitleHolder(MovieRequest.movies, 5, window);
        popularThisWeek.setPreferredSize(new Dimension(1200, 2000));

        //spacer
        JPanel spacerUp = new JPanel();
        spacerUp.setLayout(null);
        spacerUp.setPreferredSize(new Dimension(1050, 50));
        spacerUp.setBackground(LIGHT_BEIGE);

        JPanel spacerLow = new JPanel();
        spacerLow.setLayout(null);
        spacerLow.setPreferredSize(new Dimension(1050, 80));
        spacerLow.setBackground(LIGHT_BEIGE);

        // upper section
        JPanel up = new JPanel();
        up.setLayout(new BorderLayout());
        up.setPreferredSize(new Dimension(1110, 50));
        up.setBackground(LIGHT_BEIGE);

        JPanel center = new JPanel(new FlowLayout(FlowLayout.CENTER,30,0));
        center.setBackground(LIGHT_BEIGE);
        center.add(findFilm);
        center.add(search);

        up.add(center, BorderLayout.CENTER);

        // lower section
        JPanel low = new JPanel();
        low.setPreferredSize(new Dimension(1050, 25));
        low.setBackground(LIGHT_BEIGE);
        low.setLayout(new BorderLayout());
        low.add(popularFilms, BorderLayout.WEST);
        low.add(moreFilms, BorderLayout.EAST);

        JPanel poster = new JPanel();
        poster.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        poster.setBackground(LIGHT_BEIGE);
        poster.setPreferredSize(new Dimension(1200, 1500));

        poster.add(spacerUp);
        poster.add(up);
        poster.add(spacerLow);
        poster.add(low);
        poster.add(popularThisWeek);

        // Create the JScrollPane

        scrollPane = new JScrollPane(poster);
        scrollPane.setBounds(0, 65, 1270, 720);
        scrollPane.setBackground(LIGHT_BEIGE);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);  // to make scroll faster

        add(new TitleBar(window));
        add(scrollPane);


        // action listeners
        search.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (search.getText().equals("Search")) {
                    search.setText("");  // clear the text when the JTextField is clicked
                }
            }

            public void focusLost(FocusEvent e) {
                if (search.getText().equals("")) {
                    search.setText("Search");  // restore the default text if the JTextField is empty
                }
            }
        });

        moreFilms.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                window.changePage(Page.More);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                moreFilms.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });

        moreFilms.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                window.changePage(Page.More);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                moreFilms.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });
    }
}
