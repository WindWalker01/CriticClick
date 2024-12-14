package org.example.pages;

import org.example.CriticWindow;
import org.example.Page;
import org.example.components.MovieTitleHolder;
import org.example.components.TitleBar;
import org.example.components.TitleCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends CriticPage {

    private final JComboBox<String> genreComboBox;
    private final JTextField search;
    public JScrollPane scrollPane;

    public Home(CriticWindow window) {

        TitleCard[] titleCards = new TitleCard[] {
                new TitleCard(),
                new TitleCard(),
                new TitleCard(),
                new TitleCard(),
                new TitleCard(),
                new TitleCard(),
                new TitleCard(),
                new TitleCard(),
                new TitleCard(),
                new TitleCard(),
        };

        JLabel browse = new JLabel("BROWSE BY");
        browse.setBounds(170,100,100,100);
        browse.setFont(new Font("Arial", Font.BOLD, 13));

        String[] genres = { "Select Genre", "Action", "Adventure", "Drama", "Sci-Fi" };
        genreComboBox = new JComboBox<>(genres);
        genreComboBox.setFont(new Font("Arial", Font.BOLD, 10));
        genreComboBox.setBounds(263, 136, 150, 25);
        genreComboBox.setFocusable(false);
        genreComboBox.setBackground(Color.WHITE);
        genreComboBox.addActionListener(e -> {
            String selectedGenre = (String) genreComboBox.getSelectedItem();
            System.out.println("Selected genre: " + selectedGenre);
        });

        JLabel findFilm = new JLabel("SEARCH");
        findFilm.setBounds(865,100,100,100);
        findFilm.setFont(new Font("Arial", Font.BOLD, 13));

        search = new JTextField("Search");
        search.setBounds(933, 136, 150, 25);
        search.setFont(new Font("Arial", Font.BOLD, 10));
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

      MovieTitleHolder popularThisWeek = new MovieTitleHolder(titleCards);
        popularThisWeek.setPreferredSize(new Dimension(1200, 1200));

        // upper section
        JPanel up = new JPanel();
        setLayout(null);
        up.add(browse);
        up.add(genreComboBox);
        up.add(findFilm);
        up.add(search);

        // lower section
        JPanel low = new JPanel();
        setLayout(null);
        low.add(up);
        low.add(popularFilms);
        low.add(moreFilms);

        JPanel poster = new JPanel();
        poster.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        poster.setBackground(CriticWindow.LIGHT_BEIGE);
        poster.setPreferredSize(new Dimension(1200, 1500));

        poster.add(up);
        poster.add(low);
        poster.add(popularThisWeek);


        // Create the JScrollPane

        scrollPane = new JScrollPane(poster);
        scrollPane.setBounds(0, 65, 1270, 1400);
        scrollPane.setBackground(CriticWindow.LIGHT_BEIGE);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);

        add(new TitleBar());
        add(scrollPane);


        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                window.changePage(Page.Create);
            }
        });

        // TODO: remove this shit later this is for debugging purposes only
//        TitleCard titleCard = new TitleCard();
//        titleCard.setLocation(titleCard.getWidth(), 320);
//
//        add(titleCard);
    }
}
